package hr.java.web.novak.moneyapp.repository.jdbc;

import hr.java.web.novak.moneyapp.model.Wallet;
import hr.java.web.novak.moneyapp.repository.WalletRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.simple.SimpleJdbcInsert;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Set;

@Repository
public class JdbcWalletRepository implements WalletRepository {

    private final JdbcTemplate jdbcTemplate;
    private final SimpleJdbcInsert walletInserter;

    @Autowired
    public JdbcWalletRepository(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
        this.walletInserter = new SimpleJdbcInsert(jdbcTemplate)
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
}
