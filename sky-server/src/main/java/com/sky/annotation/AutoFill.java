package com.sky.annotation;

import com.sky.enumeration.OperationType;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * 自定义注解类,用于标识某个方法需要进行功能字段自动填充处理
 * @author 李晓辉
 * @date 2024-07-31 11:02:27
 */
@Target(ElementType.METHOD)
@Retention(RetentionPolicy.RUNTIME)
public @interface AutoFill {

    //数据库操作类型INSERT,UPDATE
    OperationType value();
}
