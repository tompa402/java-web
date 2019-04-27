package hr.java.web.novak.moneyapp.model;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.Entity;

@Getter
@Setter
@NoArgsConstructor
@Entity
public class Wallet extends BaseEntity {

    private String name;

//    @Enumerated(EnumType.STRING)
//    @Column(name = "wallet_type")
//    private WalletType walletType;

//    @OneToMany(mappedBy="wallet", fetch= FetchType.EAGER)
//    private List<Expense> expenses = new ArrayList<>();
}
