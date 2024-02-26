package br.edu.unipe.pos.api.validator;

import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;

public class NameValidator implements ConstraintValidator<NameValidation, String>{

  private String message;
  
  @Override
  public void initialize(NameValidation constraintAnnotation) {
      message = constraintAnnotation.message();
  }

  @Override
  public boolean isValid(String name, ConstraintValidatorContext constraintValidatorContext) {
    if(name.contains("Flamengo") || name.contains("Palmeiras") || name.contains("Fluminense") || name.contains("Botafogo")) {
      constraintValidatorContext.disableDefaultConstraintViolation();
      constraintValidatorContext
              .buildConstraintViolationWithTemplate(message + name)//
              .addConstraintViolation();
      return false;
    }
    return true;
  }
  
}
