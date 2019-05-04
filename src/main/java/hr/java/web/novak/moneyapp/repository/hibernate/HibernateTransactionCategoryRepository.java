package hr.java.web.novak.moneyapp.repository.hibernate;

import hr.java.web.novak.moneyapp.model.ExpenseType;
import hr.java.web.novak.moneyapp.model.TransactionCategory;
import hr.java.web.novak.moneyapp.repository.TransactionCategoryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
import javax.transaction.Transactional;
import java.util.List;

@Transactional
@Repository
public class HibernateTransactionCategoryRepository implements TransactionCategoryRepository {

    private final EntityManager em;

    @Autowired
    public HibernateTransactionCategoryRepository(EntityManager em) {
        this.em = em;
    }

    @Override
    public List<TransactionCategory> findAll() {
        CriteriaBuilder builder = em.getCriteriaBuilder();
        CriteriaQuery<TransactionCategory> criteria = builder.createQuery(TransactionCategory.class);
        Root<TransactionCategory> root = criteria.from(TransactionCategory.class);
        CriteriaQuery<TransactionCategory> all = criteria.select(root);
        TypedQuery<TransactionCategory> result = em.createQuery(all);
        return result.getResultList();
    }

    @Override
    public TransactionCategory findById(Long aLong) {
        return null;
    }

    @Override
    public TransactionCategory save(TransactionCategory object) {
        return null;
    }

    @Override
    public void delete(TransactionCategory object) {

    }

    @Override
    public void deleteById(Long aLong) {

    }
}
