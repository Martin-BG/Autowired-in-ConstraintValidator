package com.example.validation.demo;

import com.example.validation.config.AppConfig;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import javax.validation.ConstraintViolation;
import javax.validation.Validator;
import java.util.Set;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = {AppConfig.class, DemoComponent.class})
public class DemoTest {

    @Autowired
    private Validator validator;

    @Test
    public void validateDemoObject_withValidName_validationSucceeds() {
        DemoObject demoObject = new DemoObject("name");

        Set<ConstraintViolation<DemoObject>> constraintViolations = validator.validate(demoObject);

        Assert.assertTrue(constraintViolations.isEmpty());
    }

    @Test
    public void validateDemoObject_withEmptyName_validationFails() {
        DemoObject demoObject = new DemoObject("");

        Set<ConstraintViolation<DemoObject>> constraintViolations = validator.validate(demoObject);

        Assert.assertFalse(constraintViolations.isEmpty());
    }

    @Test(expected = RuntimeException.class)
    public void validateDemoObject_withNullName_throws() {
        DemoObject demoObject = new DemoObject(null);

        validator.validate(demoObject);
    }
}