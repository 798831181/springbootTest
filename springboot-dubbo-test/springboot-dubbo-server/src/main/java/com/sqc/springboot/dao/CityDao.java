package com.sqc.springboot.dao;

import com.sqc.springboot.domain.City;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * 城市 DAO 接口类
 *
 * Created by bysocket on 07/02/2017.
 */
public interface CityDao {

    /**
     * 获取城市信息列表
     *
     * @return
     */
    List<City> findAllCity();

    /**
     * 根据城市 ID，获取城市信息
     *
     * @param id
     * @return
     */
    City findById(@Param("id") Long id);
    City findByName(@Param("name") String name);

    Long saveCity(City city);

    Long updateCity(City city);
    Long updateCity2(City city);

    Long deleteCity(Long id);

}
