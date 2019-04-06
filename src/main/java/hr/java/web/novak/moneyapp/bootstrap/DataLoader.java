package hr.java.web.novak.moneyapp.bootstrap;

import hr.java.web.novak.moneyapp.model.Expense;
import hr.java.web.novak.moneyapp.model.ExpenseType;
import hr.java.web.novak.moneyapp.service.ExpenseService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.math.BigDecimal;
import java.math.BigInteger;

@Slf4j
@Component
public class DataLoader implements CommandLineRunner {

    private final ExpenseService expenseService;

    @Autowired
    public DataLoader(ExpenseService expenseService) {
        this.expenseService = expenseService;
    }

    @Override
    public void run(String... args) throws Exception {
        int count = expenseService.findAll().size();

        if (count == 0) {
            loadData();
        }
    }

    private void loadData() {
        log.info("Loading data...");

        Expense expenseOne = new Expense();
        expenseOne.setName("Burek");
        expenseOne.setAmount(new BigDecimal(BigInteger.TEN));
        expenseOne.setDescription("I'm hungry.");
        expenseOne.setExpenseType(ExpenseType.FOOD);

        expenseService.save(expenseOne);

        Expense expenseTwo = new Expense();
        expenseTwo.setName("Coke");
        expenseTwo.setAmount(new BigDecimal(BigInteger.TWO));
        expenseTwo.setDescription("I'm thirsty.");
        expenseTwo.setExpenseType(ExpenseType.DRINK);

        expenseService.save(expenseTwo);

        log.info("Expenses loaded...");
    }
}
