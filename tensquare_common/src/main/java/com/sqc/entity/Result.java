package com.sqc.entity;

import lombok.Data;

/**
 * 返回结果
 * @author SQC
 */
@Data
public class Result {
    private boolean flag;
    private Integer code;
    private String message;
    private Object data;
}
