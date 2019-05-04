package hr.java.web.novak.moneyapp.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.validation.constraints.DecimalMin;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.math.BigDecimal;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class Transaction extends BaseEntity {


    //TODO: add validation beans
    private String name;

    private BigDecimal amount;

    private String description;

    @ManyToOne
    private TransactionType transactionType;

    @ManyToOne
    private TransactionCategory transactionCategory;

    @ManyToOne
    @JoinColumn(name = "wallet_id")
    private Wallet wallet;
}
