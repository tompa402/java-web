package hr.java.web.novak.moneyapp.repository;

import hr.java.web.novak.moneyapp.model.Wallet;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface WalletRepository extends JpaRepository<Wallet, Long> {

    List<Wallet> findByUserId(Long userId);
}
