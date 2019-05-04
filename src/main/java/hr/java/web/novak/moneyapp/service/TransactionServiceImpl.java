package hr.java.web.novak.moneyapp.service;

import hr.java.web.novak.moneyapp.model.Transaction;
import hr.java.web.novak.moneyapp.repository.mapper.TransactionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Set;

@Service
public class TransactionServiceImpl implements TransactionService{

    private final TransactionRepository transactionRepository;

    @Autowired
    public TransactionServiceImpl(TransactionRepository transactionRepository) {
        this.transactionRepository = transactionRepository;
    }

    @Override
    public Set<Transaction> findAll() {
        return null;
    }

    @Override
    public Transaction findById(Long aLong) {
        return null;
    }

    @Override
    public Transaction save(Transaction object) {
        return transactionRepository.save(object);
    }

    @Override
    public void delete(Transaction object) {

    }

    @Override
    public void deleteById(Long aLong) {

    }
}
