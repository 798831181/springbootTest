package com.sqc.springboot.config;

import com.dangdang.ddframe.job.reg.zookeeper.ZookeeperConfiguration;
import com.dangdang.ddframe.job.reg.zookeeper.ZookeeperRegistryCenter;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
@ConfigurationProperties(prefix = "elasticjob")
public class ElasticJobConfig {
    private String serverLists;
    private String nameSpace;

    /**
     * 配置zookeeper
     * @return
     */
    @Bean
    public ZookeeperConfiguration zookeeperConfiguration(){
        return new ZookeeperConfiguration(serverLists,nameSpace);
    }
    @Bean
    public ZookeeperRegistryCenter zookeeperRegistryCenter(ZookeeperConfiguration zookeeperConfiguration){
        return new ZookeeperRegistryCenter(zookeeperConfiguration);
    }



}
