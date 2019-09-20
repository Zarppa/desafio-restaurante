package com.dbserver.desafioRastaurante.service.validation;

import java.util.ArrayList;
import java.util.List;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

import org.springframework.beans.factory.annotation.Autowired;

import com.dbserver.desafioRastaurante.dto.ProfissionalDTO;
import com.dbserver.desafioRastaurante.repository.VotoRepository;
import com.dbserver.desafioRastaurante.resource.exception.FieldMessage;
import com.dbserver.desafioRastaurante.util.Validator;

public class ProfissionalInsertValidator implements ConstraintValidator<ProfissionaIInsert, ProfissionalDTO> {

	@Override
	public void initialize(ProfissionaIInsert ann) {
	}

	@Override
	public boolean isValid(ProfissionalDTO profissionalDTO, ConstraintValidatorContext context) {		
		
		List<FieldMessage> list = new ArrayList<>();
		
		if(! Validator.has(profissionalDTO.getId())){
			list.add(new FieldMessage("id", "Não informado"));			
		}
		
		for (FieldMessage e : list) {
			context.disableDefaultConstraintViolation();
			context.buildConstraintViolationWithTemplate(e.getMessage()).addPropertyNode(e.getFieldName())
					.addConstraintViolation();
		}
		return list.isEmpty();
	}
}
		
	