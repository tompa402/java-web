package hr.java.web.novak.moneyapp.model;

import lombok.Data;
import lombok.EqualsAndHashCode;

import java.time.LocalDateTime;
import java.util.HashSet;
import java.util.Set;

@Data
@EqualsAndHashCode(callSuper=true)
public class Wallet extends BaseEntity {
    private String name;
    private WalletType walletType;
    private Set<Expense> expenses = new HashSet<>();
    private LocalDateTime created;
}
