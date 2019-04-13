package hr.java.web.novak.moneyapp.repository.jdbc;

import hr.java.web.novak.moneyapp.model.Expense;
import hr.java.web.novak.moneyapp.repository.ExpenseRepository;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.simple.SimpleJdbcInsert;
import org.springframework.stereotype.Repository;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Repository
public class JdbcExpenseRepository implements ExpenseRepository {

    private final JdbcTemplate jdbc;
    private final SimpleJdbcInsert expenseInserter;

    public JdbcExpenseRepository(JdbcTemplate jdbc) {
        this.jdbc = jdbc;
        this.expenseInserter = new SimpleJdbcInsert(jdbc)
                .withTableName("expense")
                .usingGeneratedKeyColumns("id");
    }


    @Override
    public List<Expense> findAll() {
        return null;
    }

    @Override
    public Expense findById(Long id) {
        return null;
    }

    @Override
    public Expense save(Expense object) {
        Map<String, Object> values = new HashMap<>();
        values.put("name", object.getName());
        values.put("description", object.getDescription());
        values.put("amount", object.getAmount());
        values.put("expense_type", object.getExpenseType().toString());
        values.put("wallet_id", object.getWalletId());
        object.setId(expenseInserter.executeAndReturnKey(values).longValue());
        return object;
    }

    @Override
    public void delete(Expense object) {

    }

    @Override
    public void deleteById(Long aLong) {

    }

    @Override
    public List<Expense> findAllByWalletId(Long walletId) {
        return jdbc.query("SELECT * FROM expense WHERE wallet_id = ?", new BeanPropertyRowMapper<>(Expense.class), walletId);
    }
}
