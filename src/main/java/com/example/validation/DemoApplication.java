package com.example.validation;

import com.example.validation.demo.DemoObject;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;

import javax.validation.ConstraintViolation;
import javax.validation.Validator;
import java.util.Set;

@SpringBootApplication
public class DemoApplication {

    public static void main(String[] args) {
        ConfigurableApplicationContext context = SpringApplication.run(DemoApplication.class, args);

        Validator validator = context.getBean(Validator.class);

        DemoObject validObject = new DemoObject("name");
        DemoObject invalidObject = new DemoObject("");

        Set<ConstraintViolation<DemoObject>> violationsEmpty = validator.validate(validObject);
        Set<ConstraintViolation<DemoObject>> violationsNotEmpty = validator.validate(invalidObject);
    }
}
