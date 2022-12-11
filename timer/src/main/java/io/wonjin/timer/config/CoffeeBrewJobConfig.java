package io.wonjin.timer.config;

import org.quartz.JobDataMap;
import org.quartz.JobDetail;
import org.quartz.Trigger;

public abstract class CoffeeBrewJobConfig {
    public abstract JobDataMap jobDataMap();
    public abstract JobDetail jobDetail();
    public abstract Trigger trigger();
}
