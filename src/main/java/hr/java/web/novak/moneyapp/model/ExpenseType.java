package hr.java.web.novak.moneyapp.model;

import lombok.Data;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.OneToMany;
import java.util.ArrayList;
import java.util.List;

public enum ExpenseType {
    FOOD, DRINK, BILL, OTHER
}
