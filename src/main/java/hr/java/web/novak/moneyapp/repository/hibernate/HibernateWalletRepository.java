package hr.java.web.novak.moneyapp.repository.hibernate;

import hr.java.web.novak.moneyapp.model.User;
import hr.java.web.novak.moneyapp.model.Wallet;
import hr.java.web.novak.moneyapp.repository.WalletRepository;
import org.hibernate.Session;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.Query;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
import java.util.Collection;
import java.util.List;

@Primary
@Repository
public class HibernateWalletRepository implements WalletRepository {

    private final EntityManager em;

    @Autowired
    public HibernateWalletRepository(EntityManager em) {
        this.em = em;
    }

    @Override
    public Collection<Wallet> findAllByUserId(Long userId) {
        String hql = "from Wallet where user.id =:userId";
        Query query = ((Session)em.getDelegate()).createQuery(hql).setParameter("userId", userId);
        return query.getResultList();
    }

    @Override
    public List<Wallet> findAll() {
        return null;
    }

    @Override
    public Wallet findById(Long aLong) {
        return null;
    }

    @Override
    public Wallet save(Wallet object) {
        return null;
    }

    @Override
    public void delete(Wallet object) {

    }

    @Override
    public void deleteById(Long aLong) {

    }
}
