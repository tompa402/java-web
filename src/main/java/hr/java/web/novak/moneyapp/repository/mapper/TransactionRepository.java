package hr.java.web.novak.moneyapp.repository.mapper;

import hr.java.web.novak.moneyapp.model.Transaction;
import hr.java.web.novak.moneyapp.repository.CrudRepository;

public interface TransactionRepository extends CrudRepository<Transaction, Long> {
}
