package hr.java.web.novak.moneyapp.service;

import hr.java.web.novak.moneyapp.model.Transaction;
import hr.java.web.novak.moneyapp.model.TransactionCategory;
import hr.java.web.novak.moneyapp.model.TransactionType;
import hr.java.web.novak.moneyapp.model.Wallet;
import hr.java.web.novak.moneyapp.repository.TransactionCategoryRepository;
import hr.java.web.novak.moneyapp.repository.TransactionRepository;
import hr.java.web.novak.moneyapp.repository.TransactionTypeRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Slf4j
@Service
public class TransactionService {

    private final TransactionRepository trxRepository;
    private final TransactionCategoryRepository trxCatRepository;
    private final TransactionTypeRepository tryTypeRepository;

    private final WalletService walletService;

    @Autowired
    public TransactionService(TransactionRepository trxRepository,
                              TransactionCategoryRepository trxCatRepository,
                              TransactionTypeRepository tryTypeRepository,
                              WalletService walletService) {
        this.trxRepository = trxRepository;
        this.trxCatRepository = trxCatRepository;
        this.tryTypeRepository = tryTypeRepository;
        this.walletService = walletService;
    }

    public List<TransactionCategory> getAllTrxCategories() {
        return trxCatRepository.findAll();
    }

    public List<TransactionType> getAllTrxTypes() {
        return tryTypeRepository.findAll();
    }

    public void save(Transaction transaction) {
        trxRepository.save(transaction);
    }

    public List<Transaction> findAll() {
        return trxRepository.findAll();
    }

    public Optional<Transaction> findById(Long trxId) {
        return trxRepository.findById(trxId);
    }

    public void deleteById(Long trxId) {
        trxRepository.deleteById(trxId);
    }

    public void updateTransaction(Transaction transaction) {
        trxRepository.save(transaction);
    }

    public List<Transaction> searchByName(Long userId, String name) {
        List<Wallet> wallets = walletService.findAllByUserId(userId);
        List<Long> ids = wallets.stream()
                .map(Wallet::getId).collect(Collectors.toList());
        return trxRepository.findAllByWalletIdInAndNameLike(ids, name);
    }

    public List<Transaction> findAllByWallets(Long userId) {
        List<Wallet> wallets = walletService.findAllByUserId(userId);
        List<Long> ids = wallets.stream()
                .map(Wallet::getId).collect(Collectors.toList());
        return trxRepository.findAllByWalletIdIn(ids);
    }

    //TODO: this only calculate total (added amount, while we have income also)
    public BigDecimal getTotalforTransactions(List<Transaction> transactions) {
        return transactions
                .stream()
                .map(Transaction::getAmount)
                .reduce(BigDecimal.ZERO, BigDecimal::add);
    }
}
