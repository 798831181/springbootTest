package com.sqc.springboot.service;

import com.sqc.springboot.pojo.Category;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.Arrays;
import java.util.List;

@Service
public class CategoryService {
    @Autowired
    private RestTemplate restTemplate;
    @Autowired
    private DiscoveryClient discoveryClient;
    public List<Category> queryAll(){
        List<ServiceInstance> instances = discoveryClient.getInstances("book-server");
        ServiceInstance instance = instances.get(0);
        String baseUrl = "http://" + instance.getHost() + ":" + instance.getPort() + "category/";

        Category[] categories = restTemplate.getForObject(baseUrl + "findAll", Category[].class);
        List<Category> categoryList = Arrays.asList(categories);
        return categoryList;
    }
}
