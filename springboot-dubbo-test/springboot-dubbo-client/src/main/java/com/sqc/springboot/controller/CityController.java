package com.sqc.springboot.controller;

import com.sqc.springboot.dubbo.CityDubboConsumerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/city")
public class CityController {
   @Autowired
    private CityDubboConsumerService cityDubboConsumerService;
   @RequestMapping("/printCity")
    public String printCity(){
        return cityDubboConsumerService.printCity();
    }
}
