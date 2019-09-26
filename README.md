# Bean Autowire in ConstraintValidator (Spring Boot)

In reply to [Injecting Spring Dependencies into ConstrantValidator](https://stackoverflow.com/questions/58088188/injecting-spring-dependencies-into-constrantvalidator/58126094#58126094) question at Stack Overflow.
___

Minimum configuration for autowiring in ConstraintValidator to work:
```java
@Configuration
public class AppConfig {

    @Bean
    public Validator defaultValidator() {
        return new LocalValidatorFactoryBean();
    }
}
``` 
Additional information:
* [Spring - Creating Custom Validation Constraint Annotation](https://www.logicbig.com/tutorials/spring-framework/spring-core/creating-custom-validation-constraints.html)
* [All You Need To Know About Bean Validation With Spring Boot](https://reflectoring.io/bean-validation-with-spring-boot/)
* [Bean Validator utilizing Spring Expression Language (SpEL)](https://github.com/jirutka/validator-spring) - Alternative of using custom ConstraintValidators by Jakub Jirutka