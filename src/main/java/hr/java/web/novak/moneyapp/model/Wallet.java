package hr.java.web.novak.moneyapp.model;

import lombok.Data;
import lombok.EqualsAndHashCode;

import javax.persistence.*;
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

    @Enumerated(EnumType.STRING)
    @Column(name = "wallet_type")
    private WalletType walletType;

    @OneToMany(mappedBy="wallet", fetch= FetchType.EAGER)
    private List<Expense> expenses = new ArrayList<>();

    @ManyToOne
    @JoinColumn(name="user_id")
    private User user;
}
