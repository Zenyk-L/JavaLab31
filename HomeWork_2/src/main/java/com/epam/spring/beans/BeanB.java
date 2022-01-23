package com.epam.spring.beans;

public class BeanB extends DefaultBean {

    public BeanB(String name, int value) {
        super(name, value);
    }

    private void customInitMethod() {
        System.out.println("Inside " + name + " customInitMethod()");
    }

    private void newCustomInitMethod() {
        System.out.println("Inside " + name + " newCustomInitMethod()");
    }

    private void customDestroyMethod() {
        System.out.println("Inside " + name + " customDestroyMethod()");
    }

}
