package hr.java.web.novak.moneyapp.repository;

import hr.java.web.novak.moneyapp.model.Transaction;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface TransactionRepository extends JpaRepository<Transaction, Long> {

    List<Transaction> findAllByWalletIdInAndNameLike(List<Long> wallets, String name);
    List<Transaction> findAllByWalletIdIn(List<Long> wallets);
}
