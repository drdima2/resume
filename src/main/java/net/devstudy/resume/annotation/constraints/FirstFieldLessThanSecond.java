package net.devstudy.resume.annotation.constraints;

import javax.validation.Payload;

public @interface FirstFieldLessThanSecond {
    String message() default "FieldMatch";

    Class <?>[] groups() default {};
    Class<? extends Payload>[] payload() default {};
    String first();
    String second();
}
