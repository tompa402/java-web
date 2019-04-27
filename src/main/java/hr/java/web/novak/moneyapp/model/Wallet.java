package hr.java.web.novak.moneyapp.model;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.*;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import java.util.HashSet;
import java.util.Set;

@Getter
@Setter
@NoArgsConstructor
@ToString(exclude = "expenses")
@Entity
public class Wallet extends BaseEntity {

    @NotEmpty(message = "Niste unjeli naziv novčanika")
    private String name;

    @NotNull(message = "Niste odabrali vrstu novčanika")
    @ManyToOne
    @JoinColumn(name = "wallet_type_id")
    private WalletType walletType;

    @OneToMany(cascade = CascadeType.ALL, mappedBy = "wallet")
    private Set<Expense> expenses = new HashSet<>();
}
