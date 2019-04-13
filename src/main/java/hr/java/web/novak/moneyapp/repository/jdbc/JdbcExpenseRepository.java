package hr.java.web.novak.moneyapp.repository.jdbc;

import hr.java.web.novak.moneyapp.model.Expense;
import hr.java.web.novak.moneyapp.repository.ExpenseRepository;
import hr.java.web.novak.moneyapp.repository.mapper.ExpenseRowMapper;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.simple.SimpleJdbcInsert;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Set;

@Repository
public class JdbcExpenseRepository implements ExpenseRepository {

    private static final String TABLE = "EXPENSE";
    private static final String COLUMNS = "NAME, AMOUNT, DESCRIPTION";
    private static final String RETURN_COLUMNS = "ID, NAME, AMOUNT, DESCRIPTION, CREATED";

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
        return jdbc.query("SELECT ID, NAME, DESCRIPTION, CREATED FROM expense", new ExpenseRowMapper());
    }

    @Override
    public Expense findById(Long id) {
        return (Expense)jdbc.queryForObject("SELECT ID, NAME, DESCRIPTION, CREATED FROM expense WHERE id = ?", new ExpenseRowMapper(), id);
    }

    @Override
    public Expense save(Expense object) {
        return null;
    }

    @Override
    public void delete(Expense object) {

    }

    @Override
    public void deleteById(Long aLong) {

    }
}
