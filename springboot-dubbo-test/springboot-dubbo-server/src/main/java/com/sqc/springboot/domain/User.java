package com.sqc.springboot.domain;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import java.io.Serializable;

/**
 * 用户实体类
 *
 * @author 孙启超
 * <p>
 * Created by bysocket on 21/07/2017.
 */
@Data
@Entity
public class User implements Serializable {

    @Id
    @GeneratedValue
    private Long id;
    private String name;
    @NotNull(message = "年龄不能为空")
    @Min(value = 0, message = "age不能小于0")
    @Max(value = 300, message = "age不能大于300")
    private Integer age;
    @NotEmpty(message = "出生日期不能为空")
    private String birthday;


}
