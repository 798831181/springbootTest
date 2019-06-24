package com.sqc.springboot.dubbo;


import com.alibaba.dubbo.config.annotation.Reference;
import com.sqc.springboot.domain.City;

import org.springframework.stereotype.Component;

/**
 * 城市 Dubbo 服务消费者
 *
 * Created by bysocket on 28/02/2017.
 */
@Component
public class CityDubboConsumerService {

    @Reference(version = "1.0.0")
    CityDubboService cityDubboService;

    public String printCity() {
        String cityName="test1";
        City city = cityDubboService.findCityByName(cityName);
        System.out.println(city.toString());
        return city.toString();
    }
}
