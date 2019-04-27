package hr.java.web.novak.moneyapp.service;

import hr.java.web.novak.moneyapp.model.User;

public interface UserService extends CrudService<User, Long> {
    User findByUsername(String username);
}
