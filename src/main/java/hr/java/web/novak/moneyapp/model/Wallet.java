package hr.java.web.novak.moneyapp.model;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

@Getter
@Setter
@NoArgsConstructor
@Entity
@ToString
public class Wallet extends BaseEntity {

    @NotEmpty(message = "Niste unjeli naziv novčanika")
    private String name;

    @NotNull(message = "Niste odabrali vrstu novčanika")
    @Enumerated(EnumType.STRING)
    @Column(name = "wallet_type")
    private WalletType walletType;

//    @OneToMany(mappedBy="wallet", fetch= FetchType.EAGER)
//    private List<Expense> expenses = new ArrayList<>();
}
