package hr.java.web.novak.moneyapp.service.map;

import hr.java.web.novak.moneyapp.model.Expense;
import hr.java.web.novak.moneyapp.service.ExpenseService;

import java.util.Set;

public class ExpenseMapService extends AbstractMapService<Expense, Long> implements ExpenseService {

    @Override
    public Set<Expense> findAll() {
        return super.findAll();
    }

    @Override
    public Expense findById(Long id) {
        return super.findById(id);
    }

    @Override
    public Expense save(Expense object) {
        return super.save(object);
    }

    @Override
    public void delete(Expense object) {
        super.delete(object);
    }

    @Override
    public void deleteById(Long id) {
        super.deleteById(id);
    }
}
