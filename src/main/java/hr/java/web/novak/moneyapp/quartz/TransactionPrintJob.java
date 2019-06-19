package hr.java.web.novak.moneyapp.quartz;

import hr.java.web.novak.moneyapp.model.Transaction;
import hr.java.web.novak.moneyapp.model.TransactionCategory;
import hr.java.web.novak.moneyapp.service.TransactionService;
import lombok.extern.slf4j.Slf4j;
import org.quartz.JobExecutionContext;
import org.quartz.JobExecutionException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.quartz.QuartzJobBean;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

@Slf4j
public class TransactionPrintJob extends QuartzJobBean {

    private TransactionService service;

    @Autowired
    public TransactionPrintJob(TransactionService service) {
        this.service = service;
    }

    @Override
    protected void executeInternal(JobExecutionContext context) throws JobExecutionException {
        List<Transaction> transactions = service.findAll();

        printTransactions(transactions);
    }

    private void printTransactions(List<Transaction> transactions){
        List<TransactionCategory> categories = service.getAllTrxCategories();
        System.out.println("\n\t\tSUM\t\t\tMIN\t\t\tMAX");
        categories.forEach(cat -> {
            List<Transaction> filteredTrx = getAllTrxForCategory(transactions, cat);
            BigDecimal sum = filteredTrx.stream().map(Transaction::getAmount).reduce(BigDecimal.ZERO, BigDecimal::add).setScale(2, RoundingMode.HALF_UP);
            BigDecimal min = filteredTrx.stream().map(Transaction::getAmount).min(Comparator.naturalOrder()).orElse(BigDecimal.ZERO).setScale(2, RoundingMode.HALF_UP);
            BigDecimal max = filteredTrx.stream().map(Transaction::getAmount).max(Comparator.naturalOrder()).orElse(BigDecimal.ZERO).setScale(2, RoundingMode.HALF_UP);

            System.out.println(cat.getName() + "\t" + sum + "\t\t" + min + "\t\t" + max);
        });

    }


    private List<Transaction> getAllTrxForCategory(List<Transaction> transactions, TransactionCategory cat){
        return transactions.stream()
                .filter(trx -> trx.getTransactionCategory().getName().equals(cat.getName()))
                .collect(Collectors.toList());
    }
}
