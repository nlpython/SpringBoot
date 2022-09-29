package com.yruns.config;

import com.yruns.quart.MyQuart;
import org.hibernate.validator.cfg.context.CrossParameterConstraintMappingContext;
import org.quartz.*;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.Set;

/**
 * QuartConfig
 */
@Configuration
public class QuartConfig {

    @Bean
    public JobDetail jobDetail() {
        // 绑定具体的工作
        return JobBuilder.newJob(MyQuart.class)
                .storeDurably()
                .build();
    }

    @Bean
    public Trigger trigger() {
        CronScheduleBuilder cronScheduleBuilder = CronScheduleBuilder.cronSchedule("0,15,30,45 * * * * ?");
        // 绑定具体的工作明细
        return TriggerBuilder.newTrigger()
                .forJob(jobDetail())
                .withSchedule(cronScheduleBuilder)
                .build();
    }
}
