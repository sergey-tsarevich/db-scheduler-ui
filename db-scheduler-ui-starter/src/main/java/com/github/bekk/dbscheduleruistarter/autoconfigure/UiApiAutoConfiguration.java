package com.github.bekk.dbscheduleruistarter.autoconfigure;

import com.github.bekk.dbscheduleruiapi.controller.TaskController;
import com.github.bekk.dbscheduleruiapi.controller.UIController;
import com.github.bekk.dbscheduleruiapi.service.TaskLogic;
import com.github.kagkarlsson.scheduler.Scheduler;
import org.springframework.boot.autoconfigure.AutoConfiguration;
import org.springframework.boot.autoconfigure.condition.ConditionalOnMissingBean;
import org.springframework.context.annotation.Bean;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import javax.sql.DataSource;

@AutoConfiguration
public class UiApiAutoConfiguration {
    private static final Logger logger = LoggerFactory.getLogger(UiApiAutoConfiguration.class);
    public UiApiAutoConfiguration(){
        logger.info("UiApiAutoConfiguration created");
    }


    @Bean
    @ConditionalOnMissingBean
    public TaskLogic taskLogic(Scheduler scheduler, DataSource dataSource){
        return new TaskLogic(scheduler, dataSource);
    }

    @Bean
    @ConditionalOnMissingBean
    public TaskController taskController(TaskLogic taskLogic){
        return new TaskController(taskLogic);
    }

    @Bean
    @ConditionalOnMissingBean
    public UIController uiController() {
        return new UIController();
    }
}