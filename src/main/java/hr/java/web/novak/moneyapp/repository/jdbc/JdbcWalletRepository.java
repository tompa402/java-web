package hr.java.web.novak.moneyapp.repository.jdbc;

import hr.java.web.novak.moneyapp.model.Wallet;
import hr.java.web.novak.moneyapp.repository.WalletRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.simple.SimpleJdbcInsert;
import org.springframework.stereotype.Repository;

import java.util.Collection;
import java.util.List;

@Repository
public class JdbcWalletRepository implements WalletRepository {

    private final JdbcTemplate jdbc;
    private final SimpleJdbcInsert walletInserter;

    @Autowired
    public JdbcWalletRepository(JdbcTemplate jdbc) {
        this.jdbc = jdbc;
        this.walletInserter = new SimpleJdbcInsert(jdbc)
                .withTableName("wallet")
                .usingGeneratedKeyColumns("id");
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

    @Override
    public Collection<Wallet> findAllByUserId(Long userName) {
        Long userId = jdbc.queryForObject("SELECT id FROM users WHERE username = ?", Long.class, userName);
        //return jdbc.queryForObject("SELECT * FROM wallet WHERE user_id = ?", new BeanPropertyRowMapper<>(Wallet.class), userId);
        return null;
    }
}
