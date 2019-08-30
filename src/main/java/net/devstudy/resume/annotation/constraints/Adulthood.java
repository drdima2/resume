package net.devstudy.resume.annotation.constraints;

import javax.validation.Constraint;
import javax.validation.Payload;
import java.lang.annotation.Documented;
import java.lang.annotation.Retention;
import static java.lang.annotation.RetentionPolicy.RUNTIME;
import java.lang.annotation.Target;
import java.lang.reflect.Method;

import static java.lang.annotation.ElementType.*;

@Target({METHOD,FIELD,ANNOTATION_TYPE, CONSTRUCTOR, PARAMETER})
@Retention(RUNTIME)
@Documented
@Constraint(validatedBy = {})
public @interface Adulthood {

    String message() default "Adulthood";

    int adulthoodAge() default 18;

    Class<? extends Payload>[] payload() default {};

    Class<?>[] groups() default {};

}
