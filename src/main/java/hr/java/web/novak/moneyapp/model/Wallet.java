package hr.java.web.novak.moneyapp.model;

import lombok.Data;

import java.util.HashSet;
import java.util.Set;

@Data
public class Wallet extends BaseEntity {
    private String name;
    private WalletType walletType;
    private Set<Expense> expenses = new HashSet<>();
}
