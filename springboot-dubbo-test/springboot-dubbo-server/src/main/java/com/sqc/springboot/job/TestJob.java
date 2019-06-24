package com.sqc.springboot.job;

import com.dangdang.ddframe.job.api.ShardingContext;
import com.dangdang.ddframe.job.api.simple.SimpleJob;
import org.springframework.stereotype.Component;

@Component
public class TestJob implements SimpleJob {
    @Override
    public void execute(ShardingContext shardingContext) {
        firstJob();
    }
    public void firstJob(){
        System.out.println("This is my first job...");
    }
}
