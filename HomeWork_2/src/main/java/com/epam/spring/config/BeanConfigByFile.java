package com.epam.spring.config;

import com.epam.spring.beans.*;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.*;

@Configuration
@PropertySource("classpath:application.properties")
public class BeanConfigByFile {

    @Value("${beanB.name}")
    private String beanBName;
    @Value("${beanB.value}")
    private int beanBValue;

    @Value("${beanC.name}")
    private String beanCName;
    @Value("${beanC.value}")
    private int beanCValue;

    @Value("${beanD.name}")
    private String beanDName;
    @Value("${beanD.value}")
    private int beanDValue;

    @Bean(initMethod = "customInitMethod", destroyMethod = "customDestroyMethod")
    public BeanD beanD(){
        return new BeanD(beanDName, beanDValue);
    }

    @Bean(initMethod = "customInitMethod", destroyMethod = "customDestroyMethod")
    @DependsOn(value = {"beanD"})
    public BeanB beanB(){
        return new BeanB(beanBName, beanBValue);
    }

    @Bean(initMethod = "customInitMethod", destroyMethod = "customDestroyMethod")
    @DependsOn(value = {"beanB"})
    public BeanC beanC(){
        return new BeanC(beanCName, beanCValue);
    }

}
