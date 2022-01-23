package com.epam.spring.beans;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.config.BeanFactoryPostProcessor;
import org.springframework.beans.factory.config.ConfigurableListableBeanFactory;
import org.springframework.stereotype.Component;

@Component
public class MyBeanFactoryPostProcessor implements BeanFactoryPostProcessor {
    @Override
    public void postProcessBeanFactory(ConfigurableListableBeanFactory configurableListableBeanFactory) throws BeansException {
        System.out.println("Inside MyBeanFactoryPostProcessor:");
        System.out.println("beanB default init method name: " + configurableListableBeanFactory.getBeanDefinition("beanB").getInitMethodName());
        configurableListableBeanFactory.getBeanDefinition("beanB").setInitMethodName("newCustomInitMethod");
        System.out.println("beanB changed init method name: " + configurableListableBeanFactory.getBeanDefinition("beanB").getInitMethodName());
    }
}
