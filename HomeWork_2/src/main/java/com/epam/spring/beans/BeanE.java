package com.epam.spring.beans;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;

public class BeanE extends DefaultBean  {

    public BeanE(String name, int value) {
        super(name, value);
    }

    @PostConstruct
    public void postConstruct(){
        System.out.println("Inside " + name + " method postConstruct()");
    }

    @PreDestroy
    public void preDestroy(){
        System.out.println("Inside " + name + " method preDestroy()");
    }

}
