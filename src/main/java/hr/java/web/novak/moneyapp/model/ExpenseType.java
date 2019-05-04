package hr.java.web.novak.moneyapp.model;

import lombok.*;

import javax.persistence.Entity;
import javax.validation.constraints.NotEmpty;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
@Entity
public class ExpenseType extends BaseEntity {

    @NotEmpty
    private String name;
}
