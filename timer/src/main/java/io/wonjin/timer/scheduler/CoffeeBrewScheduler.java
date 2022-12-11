package io.wonjin.timer.scheduler;

import io.wonjin.timer.config.CoffeeBrewJobConfig;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.quartz.Scheduler;
import org.quartz.SchedulerException;
import org.quartz.SchedulerFactory;
import org.quartz.impl.StdSchedulerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.util.List;

@Slf4j
@RequiredArgsConstructor
@Component
public class CoffeeBrewScheduler implements CommandLineRunner {

    private final List<CoffeeBrewJobConfig> coffeeBrewJobConfigs;

    @Override
    public void run(String... args) throws Exception {
        SchedulerFactory schedulerFactory = new StdSchedulerFactory();

        try {
            Scheduler scheduler = schedulerFactory.getScheduler();

            for (CoffeeBrewJobConfig coffeeBrewJobConfig : coffeeBrewJobConfigs) {
                log.info("JobDataMap : {}", coffeeBrewJobConfig.jobDataMap().toString());
                log.info("JobDetail : {}", coffeeBrewJobConfig.jobDetail().toString());
                log.info("Trigger : {}", coffeeBrewJobConfig.trigger().toString());

                scheduler.scheduleJob(coffeeBrewJobConfig.jobDetail(), coffeeBrewJobConfig.trigger());
            }

            scheduler.start();
        } catch (SchedulerException e) {
            throw new RuntimeException(e);
        }
    }
}
