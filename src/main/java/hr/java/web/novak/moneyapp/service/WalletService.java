package hr.java.web.novak.moneyapp.service;

import hr.java.web.novak.moneyapp.model.Wallet;

import java.util.Set;

public interface WalletService extends CrudService<Wallet, Long> {
    Set<Wallet> findAllByUserId(Long userId);
}
