package hr.java.web.novak.moneyapp.repository.mapper;

import hr.java.web.novak.moneyapp.model.Expense;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

public class ExpenseRowMapper implements RowMapper {

    @Override
    public Object mapRow(ResultSet rs, int rowNum) throws SQLException {
        Expense expense = new Expense();
        expense.setId(rs.getLong("id"));
        expense.setName(rs.getString("name"));
        expense.setDescription(rs.getString("description"));
        //expense.setExpenseType(ExpenseType.values()(rs.getInt("expense_type_id"));
        expense.setCreated(rs.getTimestamp("created").toLocalDateTime());

        return expense;
    }
}
