package com.sqc.springboot.controller;

import com.sqc.springboot.domain.City;
import com.sqc.springboot.dubbo.CityDubboConsumerService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author 孙启超
 */
@RestController
@RequestMapping(value = "/city")
@Slf4j
public class CityController {
    @Autowired
    private CityDubboConsumerService cityDubboConsumerService;
    /**
     * 根据id 删除city
     * @param id
     * @return
     */
    @RequestMapping("/delete")
    public long deleteCityById(long id){
        log.info("dubbo[] Consumer[] CityController[] deleteCityById[]");
        return cityDubboConsumerService.deleteCityById(id);
    }
    /**
     * 根据id 查询city
     * @param id
     * @return
     */
    @GetMapping("/find")
    public City findCityById(long id){
        log.info("dubbo[] Consumer[] CityController[] find[] id: {}", id);
        return cityDubboConsumerService.findCityById(id);
    }
}
