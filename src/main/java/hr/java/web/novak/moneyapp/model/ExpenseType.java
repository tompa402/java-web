package hr.java.web.novak.moneyapp.model;

import lombok.Data;

import javax.persistence.Entity;

@Data
@Entity
public class ExpenseType extends BaseEntity{
    private String name;
}
