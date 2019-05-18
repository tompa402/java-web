package hr.java.web.novak.moneyapp.api;

import hr.java.web.novak.moneyapp.dto.TransactionDto;
import hr.java.web.novak.moneyapp.model.Transaction;
import hr.java.web.novak.moneyapp.model.User;
import hr.java.web.novak.moneyapp.model.Wallet;
import hr.java.web.novak.moneyapp.service.TransactionService;
import hr.java.web.novak.moneyapp.service.WalletService;
import org.modelmapper.ModelMapper;
import org.modelmapper.TypeToken;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.*;

import javax.transaction.Transactional;
import java.util.List;
import java.util.Optional;
import java.util.Set;

@RestController
@RequestMapping(path="/api/expense", produces="application/json")
@CrossOrigin
public class RestTransactionController {

    private final TransactionService transactionService;
    private final ModelMapper modelMapper;
    private final WalletService walletService;

    @Autowired
    public RestTransactionController(TransactionService transactionService, ModelMapper modelMapper, WalletService walletService) {
        this.transactionService = transactionService;
        this.modelMapper = modelMapper;
        this.walletService = walletService;
    }

    @Transactional
    @GetMapping
    public Set<TransactionDto> findAll() {
        transactionService.findAll();
        User user = (User) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        List<Wallet> wallets = walletService.findAllByUserId(user.getId());
        Set<Transaction> transactions = wallets.iterator().next().getTransactions();

        java.lang.reflect.Type targetListType = new TypeToken<Set<TransactionDto>>() {}.getType();

        return modelMapper.map(transactions, targetListType);
}

    @GetMapping("/{id}")
    public ResponseEntity findOne(@PathVariable Long id) {
        Optional<Transaction> transaction = transactionService.findById(id);
        if(transaction.isPresent()) {
            TransactionDto trxDto = modelMapper.map(transaction, TransactionDto.class);
            return new ResponseEntity<>(trxDto, HttpStatus.OK);
        } else {
            return new ResponseEntity(null, HttpStatus.NOT_FOUND);
        }
    }

    @ResponseStatus(HttpStatus.CREATED)
    @PostMapping(consumes="application/json")
    public TransactionDto save(@RequestBody TransactionDto trxDto) {
        // za implementirati
        Transaction trx = modelMapper.map(trxDto, Transaction.class);
        transactionService.save(trx);
        return modelMapper.map(trx, TransactionDto.class);
    }

    @PutMapping
    public TransactionDto update(@RequestBody TransactionDto trxDto) {
        // za implementirati
        Transaction trx = modelMapper.map(trxDto, Transaction.class);
        transactionService.save(trx);
        return modelMapper.map(trx, TransactionDto.class);
    }

    @ResponseStatus(HttpStatus.NO_CONTENT)
    @DeleteMapping("/{id}")
    public void delete(@PathVariable Long id) {
        transactionService.deleteById(id);
    }
}
