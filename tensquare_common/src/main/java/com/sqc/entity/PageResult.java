package com.sqc.entity;

import lombok.Data;

import java.util.List;

/**
 * 返回分页结果
 * @author SQC
 */
@Data
public class PageResult<T> {
    private  long total;
    private List<T> rows;
}
