package com.sqc.springboot.dubbo.impl;

import com.alibaba.dubbo.config.annotation.Service;
import com.sqc.springboot.dao.CityDao;
import com.sqc.springboot.domain.City;
import com.sqc.springboot.dubbo.CityService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CachePut;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.ValueOperations;
import org.springframework.transaction.annotation.Transactional;

import java.util.concurrent.TimeUnit;

/**
 * 城市业务逻辑实现类
 * <p>
 * Created by bysocket on 07/02/2017.
 */
@Service(version = "1.0.0")
public class CityServiceImpl implements CityService {

    private static final Logger LOGGER = LoggerFactory.getLogger(CityServiceImpl.class);

    @Autowired
    private CityDao cityDao;

    @Autowired
    private RedisTemplate redisTemplate;

    /**
     * 获取城市逻辑：
     * 如果缓存存在，从缓存中获取城市信息
     * 如果缓存不存在，从 DB 中获取城市信息，然后插入缓存
     */
    @Override
    public City findCityById(Long id) {
        // 从缓存中获取城市信息
        String key = "city_" + id;
        ValueOperations<String, City> operations = redisTemplate.opsForValue();

        // 缓存存在
        boolean hasKey = redisTemplate.hasKey(key);
        LOGGER.info("dubbo[] server[] cityServiceImpl[] findCityById[] hasKEY: " + hasKey);
        if (hasKey) {
            City city = operations.get(key);
            LOGGER.info("CityServiceImpl.findCityById() : 从缓存中获取了城市 >> " + city.toString());
            return city;
        }

        // 从 DB 中获取城市信息
        City city = cityDao.findById(id);

        // 插入缓存
        operations.set(key, city, 10, TimeUnit.SECONDS);
        LOGGER.info("CityServiceImpl.findCityById() : 城市插入缓存 >> " + city.toString());

        return city;
    }

    @Override
    @Cacheable(value = "cache")
    @Transactional(noRollbackFor = {IllegalArgumentException.class})
    public City findCityByName(String name) {
        LOGGER.info("dubbo[] server[] CityServiceImpl[] findCityByName[] name: " + name);

        City city = cityDao.findByName(name);
        if (name.length() > 5){
            throw new IllegalArgumentException("the name is too long...");
        }
        return city;
    }

    @Override
    public Long saveCity(City city) {
        return cityDao.saveCity(city);
    }

    /**
     * 更新城市逻辑：
     * 如果缓存存在，删除
     * 如果缓存不存在，不操作
     */
    @Override
    public Long updateCity(City city) {
        Long ret = cityDao.updateCity(city);
        // 缓存存在，删除缓存
        String key = "city_" + city.getId();
        boolean hasKey = redisTemplate.hasKey(key);
        if (hasKey) {
            redisTemplate.delete(key);
            LOGGER.info("CityServiceImpl.updateCity() : 从缓存中删除城市 >> " + city.toString());
        }
        return ret;
    }

    @Override
    @CachePut(value = "cache")
    public Long updateCity2(City city) {
        return cityDao.updateCity2(city);
    }


    @Override
    public Long deleteCity(Long id) {

        Long ret = cityDao.deleteCity(id);

        // 缓存存在，删除缓存
        String key = "city_" + id;
        boolean hasKey = redisTemplate.hasKey(key);
        if (hasKey) {
            redisTemplate.delete(key);

            LOGGER.info("CityServiceImpl.deleteCity() : 从缓存中删除城市 ID >> " + id);
        }
        return ret;
    }

}