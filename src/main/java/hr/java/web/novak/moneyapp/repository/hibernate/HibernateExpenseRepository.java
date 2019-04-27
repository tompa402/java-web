package hr.java.web.novak.moneyapp.repository.hibernate;

import hr.java.web.novak.moneyapp.model.Expense;
import hr.java.web.novak.moneyapp.repository.ExpenseRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.transaction.Transactional;
import java.util.List;

@Primary
@Transactional
@Repository
public class HibernateExpenseRepository implements ExpenseRepository {

    private final EntityManager em;

    @Autowired
    public HibernateExpenseRepository(EntityManager em) {
        this.em = em;
    }

    @Override
    public List<Expense> findAllByWalletId(Long walletId) {
        return null;
    }

    @Override
    public List<Expense> findAll() {
        return null;
    }

    @Override
    public Expense findById(Long aLong) {
        return null;
    }

    @Override
    public Expense save(Expense object) {
        em.persist(object);
        return object;
    }

    @Override
    public void delete(Expense object) {

    }

    @Override
    public void deleteById(Long aLong) {

    }
}
