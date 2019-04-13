package hr.java.web.novak.moneyapp.model;

import lombok.Data;
import lombok.EqualsAndHashCode;

import javax.validation.constraints.DecimalMin;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.math.BigDecimal;
import java.time.LocalDateTime;

@Data
@EqualsAndHashCode(callSuper=true)
public class Expense extends BaseEntity {

    @NotEmpty(message = "Niste unjeli naziv troška")
    @Size(min = 4, max = 25, message = "Naziv troška treba imati između 4 i 25 znakova")
    private String name;

    @NotNull(message = "Niste unjeli naziv iznos")
    @DecimalMin(value = "0.1")
    private BigDecimal amount;

    private String description;

    @NotNull(message = "Niste odabrali vrstu toška")
    private ExpenseType expenseType;

    private LocalDateTime created;

    private Long walletId;
}
