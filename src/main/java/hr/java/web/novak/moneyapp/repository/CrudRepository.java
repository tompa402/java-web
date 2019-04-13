package hr.java.web.novak.moneyapp.repository;

import java.util.List;
import java.util.Set;

public interface CrudRepository<T, ID> {

    List<T> findAll();

    T findById(ID id);

    T save(T object);

    void delete(T object);

    void deleteById(ID id);
}
