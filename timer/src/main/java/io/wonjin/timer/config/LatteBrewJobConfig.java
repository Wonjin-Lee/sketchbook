package io.wonjin.timer.config;

import io.wonjin.timer.job.LatteBrewJob;
import org.quartz.*;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class LatteBrewJobConfig extends CoffeeBrewJobConfig {

    @Override
    public JobDataMap jobDataMap() {
        JobDataMap jobDataMap = new JobDataMap();
        jobDataMap.put("coffeeName", "latte");

        return new JobDataMap();
    }

    @Bean("latteJobDetail")
    @Override
    public JobDetail jobDetail() {
        return JobBuilder.newJob(LatteBrewJob.class)
                .withIdentity("latte-brew-job", "coffee-job-group")
                .setJobData(jobDataMap())
                .storeDurably(true)
                .build();
    }

    @Bean("latteJobTrigger")
    @Override
    public Trigger trigger() {
        return TriggerBuilder.newTrigger()
                .withIdentity("latte-brew-trigger", "coffee-trigger-group")
                .startNow()
                .withSchedule(SimpleScheduleBuilder.repeatMinutelyForever(2))
                .forJob("latte-brew-job")
                .build();
    }
}
