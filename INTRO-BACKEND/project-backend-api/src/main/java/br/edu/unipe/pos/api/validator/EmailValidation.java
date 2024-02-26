package br.edu.unipe.pos.api.validator;

import java.lang.annotation.Documented;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.Target;


import jakarta.validation.Constraint;
import jakarta.validation.Payload;

@Target( { ElementType.FIELD, ElementType.PARAMETER })
@Retention(java.lang.annotation.RetentionPolicy.RUNTIME)
@Documented
@Constraint(validatedBy = EmailValidator.class)
public @interface EmailValidation {
  String message() default "Email inválido, não pertence ao dominio matheus.br";
  Class<?>[] groups() default {};
  Class<? extends Payload>[] payload() default {};
}
