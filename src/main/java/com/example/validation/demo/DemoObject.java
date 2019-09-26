package com.example.validation.demo;

public class DemoObject {

    @DemoAnnotation(beanClass = DemoComponent.class, message = "Cannot be empty")
    private final String name;

    public DemoObject(String name) {
        this.name = name;
    }

    public String getName() {
        return this.name;
    }
}
