package com.eq.epharma.common.validation;

public interface Validation<T> {

    ValidationMessage validate(T t);
}
