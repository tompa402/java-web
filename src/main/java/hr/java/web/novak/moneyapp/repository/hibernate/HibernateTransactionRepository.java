package hr.java.web.novak.moneyapp.repository.hibernate;

import hr.java.web.novak.moneyapp.model.Transaction;
import hr.java.web.novak.moneyapp.repository.TransactionRepository;
import org.hibernate.Session;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.transaction.Transactional;
import java.util.List;

@Primary
@Transactional
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
        Session session = em.unwrap(Session.class);
        return session.get(Transaction.class, aLong);
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
//        Session session = em.unwrap(Session.class);
        Transaction trx = new Transaction();
        trx.setId(aLong);
//        session.delete(trx);

        em.remove(em.contains(trx) ? trx : em.merge(trx));
    }

    @Override
    public Transaction update(Transaction transaction) {
        Session session = em.unwrap(Session.class);
        session.update(transaction);
        return transaction;
    }
}
