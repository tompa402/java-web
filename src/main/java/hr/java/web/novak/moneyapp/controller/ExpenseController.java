package hr.java.web.novak.moneyapp.controller;

import hr.java.web.novak.moneyapp.model.Expense;
import hr.java.web.novak.moneyapp.model.ExpenseType;
import hr.java.web.novak.moneyapp.model.User;
import hr.java.web.novak.moneyapp.model.Wallet;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.annotation.Secured;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.Errors;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.bind.support.SessionStatus;

import java.util.Collection;

@Slf4j
@RequestMapping("/expense")
@SessionAttributes({"expenseTypes", "wallet"})
@Controller
public class ExpenseController {

//    private final ExpenseTypeService expenseTypeService;
//    private final ExpenseService expenseService;
//    private final WalletService walletService;
//
//    @Autowired
//    public ExpenseController(ExpenseTypeService expenseTypeService, ExpenseService expenseService, WalletService walletService) {
//        this.expenseTypeService = expenseTypeService;
//        this.expenseService = expenseService;
//        this.walletService = walletService;
//    }
//
//    @ModelAttribute("expenseTypes")
//    public Collection<ExpenseType> setExpenseType() {
//        log.info("Expense types loaded into session...");
//        return expenseTypeService.findAll();
//    }
//
//    @ModelAttribute("wallet")
//    public Wallet setWallet() {
////        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
////        Wallet wallet = walletRepository.findAllByUserId(authentication.getName());
////        wallet.setExpenses(expenseRepository.findAllByWalletId(wallet.getId()));
////        log.info("Wallet Loaded into session...");
//        return null;
//    }
//
//    @GetMapping
//    public String expensesList(Model model, @ModelAttribute("wallet") Wallet wallet) {
////        User user = (User) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
////        model.addAttribute("expenses", user.getWallet().iterator().next().getExpenses());
////        BigDecimal total = user.getWallet().iterator().next().getExpenses()
////                .stream()
////                .map(Expense::getAmount)
////                .reduce(BigDecimal.ZERO, BigDecimal::add);
////        model.addAttribute("total", total);
//
//        return "expense/index";
//    }
//
//    @GetMapping("/new")
//    @Secured({"ROLE_ADMIN", "ROLE_USER"})
//    public String expenseForm(Model model,
//                              @ModelAttribute("expenseTypes") Collection<ExpenseType> expenseTypes) {
//        User user = (User) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
//        model.addAttribute("expense", new Expense());
//        model.addAttribute("expenseTypes", expenseTypes);
//        model.addAttribute("wallets", walletService.findAllByUserId(user.getId()));
//        return "expense/expenseForm";
//    }
//
//    @Secured({"ROLE_ADMIN", "ROLE_USER"})
//    @PostMapping("/new")
//    public String processExpense(Model model,
//                                 @Validated Expense expense,
//                                 BindingResult bindingResult,
//                                 Errors errors,
//                                 @ModelAttribute("expenseTypes") Collection<ExpenseType> expenseTypes) {
//        log.info("Procesuiram trošak: " + expense);
//        if (errors.hasErrors()) {
//            User user = (User) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
//            log.info("Trošak ima grešaka. Prekida se slanje");
//            model.addAttribute("expense", expense);
//            model.addAttribute("expenseTypes", expenseTypes);
//            model.addAttribute("wallets", walletService.findAllByUserId(user.getId()));
//            return "/expense/expenseForm";
//        }
//
//        expenseService.save(expense);
//        model.addAttribute("expense", expense);
//        return "expense/details";
//    }
//
//    @GetMapping("/view")
//    public String singleExpense() {
//        return "details";
//    }
//
//    @Secured({"ROLE_ADMIN"})
//    @GetMapping("/resetWallet")
//    public String resetWallet(SessionStatus status) {
//        status.setComplete();
//        return "redirect:/expense/new";
//    }


}
