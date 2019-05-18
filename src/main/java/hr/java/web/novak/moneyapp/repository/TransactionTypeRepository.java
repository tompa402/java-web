package hr.java.web.novak.moneyapp.repository;

import hr.java.web.novak.moneyapp.model.TransactionType;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TransactionTypeRepository extends JpaRepository<TransactionType, Long> {
}
