package hr.java.web.novak.moneyapp.controller;

import hr.java.web.novak.moneyapp.model.Transaction;
import hr.java.web.novak.moneyapp.model.User;
import hr.java.web.novak.moneyapp.service.TransactionService;
import hr.java.web.novak.moneyapp.service.WalletService;
import lombok.extern.slf4j.Slf4j;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.annotation.Secured;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.Errors;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@Slf4j
@RequestMapping("/transaction")
@Controller
public class TransactionController {

    private final WalletService walletService;
    private final TransactionService trxService;
    private final ModelMapper modelMapper;

    @Autowired
    public TransactionController(WalletService walletService, TransactionService transactionService, ModelMapper modelMapper) {
        this.trxService = transactionService;
        this.walletService = walletService;
        this.modelMapper = modelMapper;
    }

    @GetMapping("/new")
    @Secured({"ROLE_ADMIN", "ROLE_USER"})
    public String transactionForm(Model model) {
        User user = (User) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        model.addAttribute("transaction", new Transaction());
        //TODO: get only categories for expenses
        model.addAttribute("trxTypes", trxService.getAllTrxTypes());
        model.addAttribute("trxCategories", trxService.getAllTrxCategories());
        model.addAttribute("wallets", walletService.findAllByUserId(user.getId()));
        return "transaction/transactionForm";
    }


    @PostMapping("/new")
    @Secured({"ROLE_ADMIN", "ROLE_USER"})
    public String processTransaction(Model model,
                                     @Validated Transaction transaction,
                                     Errors errors) {
        log.info("Procesuiram transakciju: " + transaction);

        //TODO: implement error handling
        if (errors.hasErrors()) {
            User user = (User) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
            log.info("Trošak ima grešaka. Prekida se slanje");
            model.addAttribute("transaction", transaction);
            model.addAttribute("trxTypes", trxService.getAllTrxTypes());
            model.addAttribute("trxCategories", trxService.getAllTrxCategories());
            model.addAttribute("wallets", walletService.findAllByUserId(user.getId()));
            return "/transaction/transactionForm";
        }
        trxService.save(transaction);
        return "redirect:/transaction/" + transaction.getId();
    }

    @GetMapping("/{trxId}")
    public String transactionDetails(@PathVariable Long trxId, Model model) {
        Optional<Transaction> trx = trxService.findById(trxId);
        trx.ifPresent(transaction -> model.addAttribute("transaction", transaction));
        //TODO: handle if no item found
        return "transaction/transactionDetails";
    }

    @GetMapping
    public String transactionList(@RequestParam(value = "query", required = false) String name,
                                  Model model) {
        List<Transaction> transactions;
        User user = (User) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        if (name != null && !name.isEmpty()) {
            transactions = trxService.searchByName(user.getId(), name);
        } else {
            transactions = trxService.findAllByWallets(user.getId());
        }

        model.addAttribute("transactions", transactions);
        model.addAttribute("total", trxService.getTotalforTransactions(transactions));
        return "transaction/transactionList";
    }
}
