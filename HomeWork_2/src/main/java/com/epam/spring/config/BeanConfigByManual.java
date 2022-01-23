package com.epam.spring.config;

import com.epam.spring.beans.*;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.*;

@Configuration
@Import(BeanConfigByFile.class)
public class BeanConfigByManual {

    @Value("beanA")
    private String beanAName;
    @Value("10")
    private int beanAValue;

//    @Value("beanE")
    private String beanEName;
    @Value("50")
    private int beanEValue;

    @Value("beanF")
    private String beanFName;
    @Value("60")
    private int beanFValue;

    @Bean
    public BeanA beanA(){
        return new BeanA(beanAName, beanAValue);
    }

    @Bean
    public BeanE beanE(){
        return new BeanE(beanEName,beanEValue);
    }

    @Bean
    @Lazy
    public BeanF beanF(){
        return new BeanF(beanFName, beanFValue);
    }

}
