package com.epam.spring.beans;

import com.epam.spring.validator.MyValidator;

public class DefaultBean implements MyValidator  {

    protected String name;

    protected int value;

    public DefaultBean(String name, int value) {
        this.name = name;
        this.value = value;
    }

    @Override
    public String toString() {
        return
                getClass().getSimpleName() +
                " {name='" + name + '\'' +
                ", value=" + value +
                '}';
    }


    @Override
    public void validate() {
        if ( name != null && !name.isEmpty() && value >= 0 ){
            System.out.println("Bean " + name +" is valid");
        } else{
            System.out.print("Bean " + getClass().getSimpleName() + " not valid. ");
            if (value < 0) {
                System.out.print(getClass().getSimpleName() + ".value < 0. ");
            }
            if ( name == null || name.isEmpty()) {
                System.out.print(getClass().getSimpleName() + ".name not set.");
            }
            System.out.println();
        }
    }
}
