package com.sqc.springboot.domain;

import lombok.Data;

@Data
public class Category {
    private long id;
    private String name;
    private String parentId;
    private String sort;
    private boolean isParent;
}
