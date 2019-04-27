package hr.java.web.novak.moneyapp.service.springdata;

import hr.java.web.novak.moneyapp.model.Wallet;
import hr.java.web.novak.moneyapp.repository.WalletRepository;
import hr.java.web.novak.moneyapp.service.WalletService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.Set;

@Service
public class WalletServiceImpl implements WalletService {

    private final WalletRepository walletRepository;

    @Autowired
    public WalletServiceImpl(WalletRepository walletRepository) {
        this.walletRepository = walletRepository;
    }

    @Override
    public Set<Wallet> findAllByUserId(Long userId) {
        return new HashSet<>(walletRepository.findAllByUserId(userId));
    }

    @Override
    public Set<Wallet> findAll() {
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
