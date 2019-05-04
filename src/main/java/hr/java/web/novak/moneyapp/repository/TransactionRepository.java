package hr.java.web.novak.moneyapp.repository;

import hr.java.web.novak.moneyapp.model.Transaction;
import hr.java.web.novak.moneyapp.repository.CrudRepository;

public interface TransactionRepository extends CrudRepository<Transaction, Long> {

    Transaction update(Transaction transaction);
}
