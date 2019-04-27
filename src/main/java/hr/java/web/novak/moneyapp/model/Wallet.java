package hr.java.web.novak.moneyapp.model;

import lombok.Data;
import lombok.EqualsAndHashCode;

import javax.persistence.Entity;
import javax.persistence.OneToMany;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Data
@EqualsAndHashCode(callSuper = true)
@Entity
public class Wallet extends BaseEntity {
    private String name;
    private WalletType walletType;

    @OneToMany(mappedBy="wallet")
    private List<Expense> expenses = new ArrayList<>();
}
