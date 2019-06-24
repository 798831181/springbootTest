package com.sqc.springboot.service;

import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

@Component
public class ScheduledService {
    @Scheduled(cron = "0/5 * * * * *")
    public String scheduled(){
        return "定时任务0";
    }

}
