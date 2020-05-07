package com.qa.exceptions;


import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

import javax.persistence.EntityNotFoundException;

@ResponseStatus(code = HttpStatus.NOT_FOUND, reason = "The ingredient doesn't exist")
public class IngredientsNotFoundException extends EntityNotFoundException {
}