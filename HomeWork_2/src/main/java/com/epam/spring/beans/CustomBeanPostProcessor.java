package com.epam.spring.beans;

import com.epam.spring.validator.MyValidator;
import org.springframework.beans.BeansException;
import org.springframework.beans.factory.config.BeanPostProcessor;
import org.springframework.stereotype.Component;

@Component
public class CustomBeanPostProcessor implements BeanPostProcessor {
    @Override
    public Object postProcessBeforeInitialization(Object bean, String beanName) throws BeansException {
        if (bean instanceof MyValidator){
            ((MyValidator) bean).validate();
        }
        return bean;
    }
}
