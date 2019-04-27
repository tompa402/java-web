package hr.java.web.novak.moneyapp.service.springdata;

import hr.java.web.novak.moneyapp.model.Expense;
import hr.java.web.novak.moneyapp.repository.ExpenseRepository;
import hr.java.web.novak.moneyapp.service.ExpenseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.Set;

@Primary
@Service
public class ExpenseServiceImpl implements ExpenseService {

    private final ExpenseRepository expenseRepository;

    @Autowired
    public ExpenseServiceImpl(ExpenseRepository expenseRepository) {
        this.expenseRepository = expenseRepository;
    }

    @Override
    public Set<Expense> findAll() {
        return null;
    }

    @Override
    public Expense findById(Long aLong) {
        return null;
    }

    @Override
    @Transactional
    public Expense save(Expense object) {
        return expenseRepository.save(object);
    }

    @Override
    public void delete(Expense object) {

    }

    @Override
    public void deleteById(Long aLong) {

    }
}
