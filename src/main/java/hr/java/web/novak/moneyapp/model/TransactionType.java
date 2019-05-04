package hr.java.web.novak.moneyapp.model;

import lombok.*;

import javax.persistence.Entity;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
@Entity
public class TransactionType extends BaseEntity {

    private String name;

}
