package hr.java.web.novak.moneyapp.model;

import lombok.Data;

import java.math.BigDecimal;

@Data
public class Expense extends BaseEntity {

    private String name;
    private BigDecimal amount;
    private ExpenseType expenseType;
}
