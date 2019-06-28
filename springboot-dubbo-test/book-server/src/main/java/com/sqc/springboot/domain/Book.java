package com.sqc.springboot.domain;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import java.io.Serializable;

/**
 * Book 实体类
 *
 * Created by bysocket on 30/09/2017.
 */
@Entity
@Data
public class Book implements Serializable {

    /**
     * 编号
     */
    @Id
    @GeneratedValue
    private Long id;

    /**
     * 书名
     */
    private String name;

    /**
     * 作者
     */
    private String writer;

    /**
     * 简介
     */
    private String introduction;

}
