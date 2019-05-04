package hr.java.web.novak.moneyapp.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
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
    @JoinColumn(name="trx_type_id")
    private TransactionType transactionType;

    @ManyToOne
    @JoinColumn(name="trx_category_id")
    private TransactionCategory transactionCategory;

    @ManyToOne
    @JoinColumn(name = "wallet_id")
    private Wallet wallet;
}
