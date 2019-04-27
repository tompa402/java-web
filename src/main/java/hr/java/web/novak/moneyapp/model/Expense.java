package hr.java.web.novak.moneyapp.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.validation.Valid;
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
public class Expense extends BaseEntity {

    @NotEmpty(message = "Niste unjeli naziv troška")
    @Size(min = 4, max = 25, message = "Naziv troška treba imati između 4 i 25 znakova")
    private String name;

    @NotNull(message = "Niste unjeli naziv iznos")
    @DecimalMin(value = "0.1")
    private BigDecimal amount;

    private String description;

    @Valid
    @NotNull(message = "Niste odabrali vrstu toška")
    @ManyToOne
    @JoinColumn(name = "expense_type_id")
    private ExpenseType expenseType;

    @NotNull(message = "Niste odabrali novčanik")
    @ManyToOne
    @JoinColumn(name = "wallet_id")
    private Wallet wallet;
}
