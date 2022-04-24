package com.market.api.util;

import java.util.ArrayList;
import java.util.List;
import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

/**
 * implements of EnumValidator.
 *
 * @author Samuel Stalschus
 */
public class EnumValidatorImpl implements ConstraintValidator<EnumValidator, String> {

  /**
   * The Value list.
   */
  List<String> valueList = null;

  @Override
  public boolean isValid(String value, ConstraintValidatorContext context) {
    return valueList.contains(value.toUpperCase());
  }

  @Override
  public void initialize(EnumValidator constraintAnnotation) {
    valueList = new ArrayList<String>();
    Class<? extends Enum<?>> enumClass = constraintAnnotation.enumClazz();

    @SuppressWarnings("rawtypes")
    Enum[] enumValArr = enumClass.getEnumConstants();

    for (@SuppressWarnings("rawtypes") Enum enumVal : enumValArr) {
      valueList.add(enumVal.toString()
          .toUpperCase());
    }
  }

}

