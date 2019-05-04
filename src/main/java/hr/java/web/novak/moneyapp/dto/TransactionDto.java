package hr.java.web.novak.moneyapp.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.math.BigDecimal;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class TransactionDto {

    private Long id;
    private Long transactionCategoryId;
    private String transactionCategoryName;
    private Long transactionTypeId;
    private String transactionTypeName;
    private Long walletId;
    private String name;
    private BigDecimal amount;
    private String description;
}
