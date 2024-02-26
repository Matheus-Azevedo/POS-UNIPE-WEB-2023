package br.edu.unipe.pos.api.validator;

import java.lang.annotation.Documented;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.Target;

import jakarta.validation.Constraint;


@Target( { ElementType.FIELD, ElementType.PARAMETER })
@Retention(java.lang.annotation.RetentionPolicy.RUNTIME)
@Documented
@Constraint(validatedBy = NameValidator.class)
public @interface NameValidation {
  String message() default "Nome inválido, não pertence ao dominio matheus.br";
  Class<?>[] groups() default {};
  Class<? extends jakarta.validation.Payload>[] payload() default {};
  
}
