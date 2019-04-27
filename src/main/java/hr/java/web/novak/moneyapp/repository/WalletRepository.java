package hr.java.web.novak.moneyapp.repository;

import hr.java.web.novak.moneyapp.model.Wallet;

import java.util.Collection;

public interface WalletRepository extends CrudRepository<Wallet, Long> {
    Collection<Wallet> findAllByUserId(Long userId);
}
