package io.wonjin.timer.config;

import io.wonjin.timer.job.AmericanoBrewJob;
import org.quartz.*;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class AmericanoBrewJobConfig extends CoffeeBrewJobConfig {

    @Override
    public JobDataMap jobDataMap() {
        JobDataMap jobDataMap = new JobDataMap();
        jobDataMap.put("coffeeName", "americano");

        return new JobDataMap();
    }

    @Bean
    @Override
    public JobDetail jobDetail() {
        return JobBuilder.newJob(AmericanoBrewJob.class)
                .withIdentity("americano-brew-job", "coffee-job-group")
                .setJobData(jobDataMap())
                .storeDurably(true)
                .build();
    }

    @Bean
    @Override
    public Trigger trigger() {
        return TriggerBuilder.newTrigger()
                .withIdentity("americano-brew-trigger", "coffee-trigger-group")
                .startNow()
                .withSchedule(SimpleScheduleBuilder.repeatMinutelyForever(1))
                .forJob("americano-brew-job")
                .build();
    }
}
