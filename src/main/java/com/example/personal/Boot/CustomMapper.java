package com.example.personal.Boot;

import org.springframework.beans.factory.annotation.Value;

import java.lang.annotation.*;

@Documented
@Inherited
@Retention(RetentionPolicy.RUNTIME)
@Target({ ElementType.TYPE, ElementType.METHOD, ElementType.FIELD, ElementType.PARAMETER, ElementType.CONSTRUCTOR })
public @interface CustomMapper {
    // Interface Mapper
}