package hr.java.web.novak.moneyapp.repository.hibernate;

import hr.java.web.novak.moneyapp.model.ExpenseType;
import hr.java.web.novak.moneyapp.repository.ExpenseTypeRepository;
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
public class HibernateExpenseTypeRepository implements ExpenseTypeRepository {

    private final EntityManager em;

    @Autowired
    public HibernateExpenseTypeRepository(EntityManager em) {
        this.em = em;
    }

    @Override
    public List<ExpenseType> findAll() {
        CriteriaBuilder builder = em.getCriteriaBuilder();
        CriteriaQuery<ExpenseType> criteria = builder.createQuery(ExpenseType.class);
        Root<ExpenseType> root = criteria.from(ExpenseType.class);
        CriteriaQuery<ExpenseType> all = criteria.select(root);
        TypedQuery<ExpenseType> result = em.createQuery(all);
        return result.getResultList();
    }

    @Override
    public ExpenseType findById(Long aLong) {
        return null;
    }

    @Override
    public ExpenseType save(ExpenseType object) {
        return null;
    }

    @Override
    public void delete(ExpenseType object) {

    }

    @Override
    public void deleteById(Long aLong) {

    }
}
