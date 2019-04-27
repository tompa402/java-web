package hr.java.web.novak.moneyapp.repository;

import hr.java.web.novak.moneyapp.model.User;

public interface UserRepository extends CrudRepository<User, Long> {
    User findByUsername(String username);
}
