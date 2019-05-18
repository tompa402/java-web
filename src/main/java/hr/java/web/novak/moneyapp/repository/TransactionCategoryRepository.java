package hr.java.web.novak.moneyapp.repository;

import hr.java.web.novak.moneyapp.model.TransactionCategory;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TransactionCategoryRepository extends JpaRepository<TransactionCategory, Long> {

}
