package com.example.validation.demo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;
import java.lang.reflect.Method;
import java.util.logging.Logger;

public class DemoValidator implements ConstraintValidator<DemoAnnotation, String> {

    private static final Logger LOGGER = Logger.getLogger(DemoValidator.class.getName());

    private final ApplicationContext applicationContext;

    private Object bean;

    @Autowired
    public DemoValidator(ApplicationContext applicationContext) {
        this.applicationContext = applicationContext;
    }

    @Override
    public void initialize(DemoAnnotation constraint) {
        Class<?> beanClass = constraint.beanClass();
        bean = applicationContext.getBean(beanClass);

        LOGGER.info(() -> {
            final StringBuilder sb = new StringBuilder("Inside DemoValidator#initialize method")
                    .append(System.lineSeparator());
            sb.append("Application context bean: ").append(applicationContext).append(System.lineSeparator());
            sb.append("Loaded from context bean: ").append(bean).append(System.lineSeparator());
            return sb.toString();
        });
    }

    @Override
    public boolean isValid(String obj, ConstraintValidatorContext context) {
        LOGGER.info(() -> {
            final StringBuilder sb = new StringBuilder("Inside DemoValidator#isValid method")
                    .append(System.lineSeparator());
            sb.append(bean.getClass().getCanonicalName()).append(" methods:").append(System.lineSeparator());
            for (Method method : bean.getClass().getDeclaredMethods()) {
                sb.append(" - ").append(method.getName()).append(System.lineSeparator());
            }
            return sb.toString();
        });

        return !obj.isEmpty();
    }
}
