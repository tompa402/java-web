package hr.java.web.novak.moneyapp.controller;

import hr.java.web.novak.moneyapp.model.Expense;
import hr.java.web.novak.moneyapp.model.ExpenseType;
import hr.java.web.novak.moneyapp.model.Wallet;
import hr.java.web.novak.moneyapp.repository.ExpenseRepository;
import hr.java.web.novak.moneyapp.repository.WalletRepository;
import hr.java.web.novak.moneyapp.service.ExpenseService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.annotation.Secured;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.Errors;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.bind.support.SessionStatus;
import org.springframework.web.servlet.ModelAndView;

import java.math.BigDecimal;

@Slf4j
@RequestMapping("/expense")
@SessionAttributes({"expenseTypes", "wallet"})
@Controller
public class ExpenseController {

    private final ExpenseService expenseService;
    private final WalletRepository walletRepository;
    private final ExpenseRepository expenseRepository;

    @Autowired
    public ExpenseController(ExpenseService expenseService, WalletRepository walletRepository, ExpenseRepository expenseRepository) {
        this.expenseService = expenseService;
        this.walletRepository = walletRepository;
        this.expenseRepository = expenseRepository;
    }

    @ModelAttribute("expenseTypes")
    public ExpenseType[] setExpenseType() {
        log.info("Expense types loaded into session...");
        return ExpenseType.values();
    }

    @ModelAttribute("wallet")
    public Wallet setWallet() {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        Wallet wallet = walletRepository.findByUserId(authentication.getName());
        wallet.setExpenses(expenseRepository.findAllByWalletId(wallet.getId()));
        log.info("Wallet Loaded into session...");
        return wallet;
    }

    @GetMapping
    public String expensesList(Model model, @ModelAttribute("wallet") Wallet wallet) {
        model.addAttribute("expenses", wallet.getExpenses());
        BigDecimal total = wallet.getExpenses()
                .stream()
                .map(Expense::getAmount)
                .reduce(BigDecimal.ZERO, BigDecimal::add);
        model.addAttribute("total", total);
        return "expense/index";
    }

    @GetMapping("/new")
    @Secured({"ROLE_ADMIN", "ROLE_USER"})
    public String newExpense(Model model) {
        model.addAttribute("expense", new Expense());
        model.addAttribute("expenseTypes", ExpenseType.values());
        return "expense/newExpense";
    }

    @Secured({"ROLE_ADMIN", "ROLE_USER"})
    @PostMapping("/new")
    public ModelAndView processExpense(@Validated Expense expense,
                                       Errors errors,
                                       @ModelAttribute("expenseTypes") ExpenseType expenseType,
                                       @ModelAttribute("wallet") Wallet wallet) {
//        expenseService.save(expense);
        log.info("Procesuiram trošak: " + expense);
        if (errors.hasErrors()) {
            log.info("Trošak ima grešaka. Prekida se slanje");
            ModelAndView mav = new ModelAndView("expense/newExpense");
            mav.addObject(expense);
            mav.addObject(expenseType);
            return mav;
        }

        expense.setWalletId(wallet.getId());
        wallet.getExpenses().add(expenseRepository.save(expense));
        ModelAndView mav = new ModelAndView("expense/details");
        mav.addObject(expense);
        return mav;
    }

    @GetMapping("/view")
    public String singleExpense() {
        return "details";
    }

    @Secured({"ROLE_ADMIN"})
    @GetMapping("/resetWallet")
    public String resetWallet(SessionStatus status) {
        status.setComplete();
        return "redirect:/expense/new";
    }


}
