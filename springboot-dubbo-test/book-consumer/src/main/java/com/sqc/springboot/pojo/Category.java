package com.sqc.springboot.pojo;

import lombok.Data;

@Data
public class Category {
    private long id;
    private String name;
    private String parentId;
    private String sort;
    private boolean isParent;
}
