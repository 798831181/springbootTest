package com.sqc.springboot.dubbo;


import com.alibaba.dubbo.config.annotation.Reference;
import com.sqc.springboot.domain.City;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

/**
 * 城市 Dubbo 服务消费者
 * @author bysocket
 * @date 28/02/2017
 */
@Component
@Slf4j
public class CityDubboConsumerService {
    @Reference(version = "1.0.0")
    private CityService cityService;

    /**
     * 根据id 查询city
     * @param id
     * @return
     */
    public City findCityById(long id){
        log.info("dubbo[] client[] cityDubboConsumerService[] findCityById[] id: {}",id);
        return cityService.findCityById(id);
    }

    /**
     * 根据id 删除city
     * @param id
     * @return
     */
    public long deleteCityById(long id){
        log.info("dubbo[] client[] cityDubboConsumerService[] findCityById[] id: {}",id);
        return cityService.deleteCity(id);
    }
}
