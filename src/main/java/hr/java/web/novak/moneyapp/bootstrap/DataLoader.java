package hr.java.web.novak.moneyapp.bootstrap;

import hr.java.web.novak.moneyapp.repository.UserRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Slf4j
@Component
public class DataLoader implements CommandLineRunner {

    private final UserRepository userRepository;


    @Autowired
    public DataLoader(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public void run(String... args) throws Exception {
//        User user = userRepository.findByUsername("admin");
//        System.out.println("test");
//        int count = expenseService.findAll().size();
//
//        if (count == 0) {
//            loadData();
//        }
    }

    private void loadData() {
//        log.info("Loading data...");
//
//        Expense expenseOne = new Expense();
//        expenseOne.setName("Burek");
//        expenseOne.setAmount(new BigDecimal(BigInteger.TEN));
//        expenseOne.setDescription("I'm hungry.");
//        expenseOne.setExpenseType(ExpenseType.FOOD);
//
//        expenseService.save(expenseOne);
//
//        Expense expenseTwo = new Expense();
//        expenseTwo.setName("Coke");
//        expenseTwo.setAmount(new BigDecimal(BigInteger.TWO));
//        expenseTwo.setDescription("I'm thirsty.");
//        expenseTwo.setExpenseType(ExpenseType.DRINK);
//
//        expenseService.save(expenseTwo);
//
//        log.info("Expenses loaded...");
    }
}
