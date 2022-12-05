package io.wonjin.timer;

import io.wonjin.timer.scheduler.ReportScheduler;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class TimerApplication {
    public static void main(String[] args) {
        ReportScheduler.init();
        SpringApplication.run(TimerApplication.class, args);
    }
}
