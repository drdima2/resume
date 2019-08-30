package net.devstudy.resume.annotation.constraints;

import net.devstudy.resume.validator.EnglishLanguageConstraintValidator;

import javax.validation.Constraint;
import javax.validation.Payload;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.lang.annotation.Documented;
import java.lang.annotation.Retention;
import java.lang.annotation.Target;

import static java.lang.annotation.ElementType.*;
import static java.lang.annotation.RetentionPolicy.RUNTIME;


@Target({METHOD,FIELD,ANNOTATION_TYPE, CONSTRUCTOR, PARAMETER})
@Retention(RUNTIME)
@Documented
@Constraint(validatedBy = {})
@Size(min=8)
@NotNull


public @interface PasswordStrength {

    String message() default "PasswordStrench";
    Class<? extends Payload>[] payload() default {};
    Class<?>[] groups() default {};
}

