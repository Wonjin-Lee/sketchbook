package io.wonjin.timer.scheduler;

import io.wonjin.timer.job.ReportJob;
import org.quartz.*;
import org.quartz.impl.StdSchedulerFactory;

import java.util.HashSet;
import java.util.Set;

public class ReportScheduler {
    public static void init() {
        SchedulerFactory schedulerFactory = new StdSchedulerFactory();
        try {
            Scheduler scheduler = schedulerFactory.getScheduler();

            JobDataMap jobDataMap = new JobDataMap();
            jobDataMap.put("item1", "chicken");
            jobDataMap.put("item2", "pizza");

            JobDetail jobDetail = JobBuilder.newJob(ReportJob.class)
                    .withIdentity("reportJob1", "group")
                    .setJobData(jobDataMap)
                    .build();

            SimpleTrigger simpleTrigger = TriggerBuilder.newTrigger()
                    .withIdentity("reportTrigger", "group2")
                    .startNow()
                    .withSchedule(SimpleScheduleBuilder.repeatMinutelyForever(1))
                    .forJob("reportJob")
                    .build();

            Set<Trigger> triggerSet = new HashSet<>();
            triggerSet.add(simpleTrigger);

            scheduler.scheduleJob(jobDetail, triggerSet, true);
            scheduler.start();
        } catch (SchedulerException e) {
            throw new RuntimeException(e);
        }
    }
}
