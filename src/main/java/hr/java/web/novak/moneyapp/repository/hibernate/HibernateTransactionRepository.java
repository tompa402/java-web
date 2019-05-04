package hr.java.web.novak.moneyapp.repository.hibernate;

import hr.java.web.novak.moneyapp.model.Transaction;
import hr.java.web.novak.moneyapp.repository.mapper.TransactionRepository;
import org.hibernate.Session;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import java.util.List;

@Repository
public class HibernateTransactionRepository implements TransactionRepository {

    private final EntityManager em;

    @Autowired
    public HibernateTransactionRepository(EntityManager em) {
        this.em = em;
    }

    @Override
    public List<Transaction> findAll() {
        return null;
    }

    @Override
    public Transaction findById(Long aLong) {
        return null;
    }

    @Override
    public Transaction save(Transaction object) {
        Session session = em.unwrap(Session.class);
        session.save(object);
        return object;
    }

    @Override
    public void delete(Transaction object) {

    }

    @Override
    public void deleteById(Long aLong) {

    }
}
