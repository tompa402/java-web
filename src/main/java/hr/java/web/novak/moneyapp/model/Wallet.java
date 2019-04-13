package hr.java.web.novak.moneyapp.model;

import lombok.Data;
import lombok.EqualsAndHashCode;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Data
@EqualsAndHashCode(callSuper=true)
public class Wallet extends BaseEntity {
    private String name;
    private WalletType walletType;
    private List<Expense> expenses = new ArrayList<>();
    private LocalDateTime created;
}
