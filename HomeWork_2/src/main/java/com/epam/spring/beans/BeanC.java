package com.epam.spring.beans;

public class BeanC extends DefaultBean{

    public BeanC(String name, int value) {
        super(name, value);
    }

    private void customInitMethod() {
        System.out.println("Inside " + name + " customInitMethod()");
    }

    private void customDestroyMethod() {
        System.out.println("Inside " + name + " customDestroyMethod()");
    }

}
