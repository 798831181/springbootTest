package com.sqc.springboot.dubbo.impl;

import com.alibaba.dubbo.config.annotation.Service;
import com.sqc.springboot.domain.City;
import com.sqc.springboot.dubbo.CityDubboService;

/**
 * 城市业务 Dubbo 服务层实现层
 */
// 注册为 Dubbo 服务
@Service(version = "1.0.0")
public class CityDubboServiceImpl implements CityDubboService {

    public City findCityByName(String cityName) {
        return new City(1L,2L,"温岭","是我的故乡");
    }
}
