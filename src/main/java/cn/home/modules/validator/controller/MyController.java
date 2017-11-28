package cn.home.modules.validator.controller;

import javax.validation.Valid;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.RequestMapping;

import cn.home.config.modules.validator.FooValidator;
import cn.home.modules.beanwrapper.entity.Foo;

@Controller
public class MyController {
	@InitBinder
	protected void initBinder(WebDataBinder binder) {
		binder.setValidator(new FooValidator());
	}

	@RequestMapping("/foo")
	public void processFoo(@Valid Foo foo) {
		/* ... */
	}
}
