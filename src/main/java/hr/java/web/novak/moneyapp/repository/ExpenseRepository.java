package hr.java.web.novak.moneyapp.repository;

import hr.java.web.novak.moneyapp.model.Expense;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ExpenseRepository extends JpaRepository<Expense, Long> {
}
