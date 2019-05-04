package hr.java.web.novak.moneyapp.service;

import hr.java.web.novak.moneyapp.model.Transaction;
import org.springframework.stereotype.Service;

import java.util.Set;

@Service
public class TransactionServiceImpl implements TransactionService{

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
        return null;
    }

    @Override
    public void delete(Transaction object) {

    }

    @Override
    public void deleteById(Long aLong) {

    }
}
