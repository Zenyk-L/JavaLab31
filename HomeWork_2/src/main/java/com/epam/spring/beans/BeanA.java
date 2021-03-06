package com.epam.spring.beans;

import org.springframework.beans.factory.DisposableBean;
import org.springframework.beans.factory.InitializingBean;

public class BeanA extends DefaultBean implements InitializingBean, DisposableBean {

    public BeanA(String name, int value) {
        super(name, value);
    }

    @Override
    public void afterPropertiesSet() {
        System.out.println("Inside " + name + " method InitializingBean.afterPropertiesSet()");
    }

    @Override
    public void destroy() {
        System.out.println("Inside " + name + " method DisposableBean.destroy()");
    }

}
