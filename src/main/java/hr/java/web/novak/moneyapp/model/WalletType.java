package hr.java.web.novak.moneyapp.model;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.Entity;
import javax.validation.constraints.NotEmpty;

@Getter
@Setter
@NoArgsConstructor
@ToString
@Entity
public class WalletType extends BaseEntity {

    @NotEmpty
    private String name;
}
