package cn.home.modules.validator.service.impl;

import javax.validation.Validator;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
@Service
public class ValidatorService {
	@Autowired
	private Validator validator;
}
