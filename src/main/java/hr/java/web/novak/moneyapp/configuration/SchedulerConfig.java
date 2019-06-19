package hr.java.web.novak.moneyapp.configuration;

import hr.java.web.novak.moneyapp.model.Transaction;
import hr.java.web.novak.moneyapp.quartz.TransactionPrintJob;
import org.quartz.*;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class SchedulerConfig {

    @Bean
    public JobDetail trxPrintJob(){
        return JobBuilder.newJob(TransactionPrintJob.class).withIdentity("transactionPrintJob").storeDurably().build();
    }

    @Bean
    public Trigger trxPrintJobTrigger(){
        SimpleScheduleBuilder builder = SimpleScheduleBuilder.simpleSchedule()
                .withIntervalInSeconds(5).repeatForever();

        return TriggerBuilder.newTrigger().forJob(trxPrintJob())
                .withIdentity("trxPrintTrigger").withSchedule(builder).build();
    }
}
