package com.dbserver.desafioRastaurante.service.validation;

import java.util.ArrayList;
import java.util.List;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

import org.springframework.beans.factory.annotation.Autowired;

import com.dbserver.desafioRastaurante.dto.VotoDTO;
import com.dbserver.desafioRastaurante.repository.VotoRepository;
import com.dbserver.desafioRastaurante.resource.exception.FieldMessage;
import com.dbserver.desafioRastaurante.util.Validator;

public class VotoInsertValidation implements ConstraintValidator<VotoInsert, VotoDTO> {

	@Autowired
	private VotoRepository votoRepository;
	
	@Override
	public void initialize(VotoInsert ann) {
	}

	@Override
	public boolean isValid(VotoDTO votoDTO, ConstraintValidatorContext context) {

			
		
		
		return false;
	}

}
	