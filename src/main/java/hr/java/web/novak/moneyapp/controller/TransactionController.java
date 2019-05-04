package hr.java.web.novak.moneyapp.controller;

import hr.java.web.novak.moneyapp.dto.TransactionDto;
import hr.java.web.novak.moneyapp.model.Expense;
import hr.java.web.novak.moneyapp.model.ExpenseType;
import hr.java.web.novak.moneyapp.model.Transaction;
import hr.java.web.novak.moneyapp.model.User;
import hr.java.web.novak.moneyapp.service.TransactionCategoryService;
import hr.java.web.novak.moneyapp.service.TransactionService;
import hr.java.web.novak.moneyapp.service.WalletService;
import lombok.extern.slf4j.Slf4j;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.annotation.Secured;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.Errors;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.math.BigDecimal;
import java.util.Collection;

@Slf4j
@RequestMapping("/transaction")
@Controller
public class TransactionController {

    private final WalletService walletService;
    private final TransactionService trxService;
    private final TransactionCategoryService trxCategoryService;
    private final ModelMapper modelMapper;

    @Autowired
    public TransactionController(WalletService walletService, TransactionService transactionService, TransactionCategoryService transactionCategoryService, ModelMapper modelMapper) {
        this.trxService = transactionService;
        this.trxCategoryService = transactionCategoryService;
        this.walletService = walletService;
        this.modelMapper = modelMapper;
    }

    @GetMapping("/new")
    @Secured({"ROLE_ADMIN", "ROLE_USER"})
    public String transactionForm(Model model) {
        User user = (User) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        model.addAttribute("transaction", new TransactionDto());
        //TODO: get only categories for expenses
        model.addAttribute("trxCategories", trxCategoryService.findAll());
        model.addAttribute("wallets", walletService.findAllByUserId(user.getId()));
        return "transaction/transactionForm";
    }


    @PostMapping("/new")
    @Secured({"ROLE_ADMIN", "ROLE_USER"})
    public String processTransaction(Model model,
                                     @Validated TransactionDto transactionDto,
                                     Errors errors) {
        log.info("Procesuiram transakciju: " + transactionDto);

        //TODO: implement error handling
        if (errors.hasErrors()) {
            User user = (User) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
            log.info("Trošak ima grešaka. Prekida se slanje");
            model.addAttribute("transaction", transactionDto);
            model.addAttribute("trxCategories", walletService.findAllByUserId(user.getId()));
            model.addAttribute("wallets", walletService.findAllByUserId(user.getId()));
            return "/transaction/transactionForm";
        }
        Transaction trx = modelMapper.map(transactionDto, Transaction.class);
        trxService.save(trx);
        //TODO: redirect to details form
        //model.addAttribute("transaction", trx);
        return "redirect:/transaction/transactionForm";
    }

    @GetMapping
    public String transactionList(Model model) {
        User user = (User) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        model.addAttribute("expenses", user.getWallets().iterator().next().getTransactions());
//        BigDecimal total = user.getWallets().iterator().next().getTransactions()
//                .stream()
//                .map(Expense::getAmount)
//                .reduce(BigDecimal.ZERO, BigDecimal::add);
        BigDecimal total = BigDecimal.ZERO;
        model.addAttribute("total", total);

        return "expense/index";
    }
}
