package cn.home.config.modules.validator;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import org.springframework.validation.BindingResult;
import org.springframework.validation.DataBinder;

import cn.home.modules.beanwrapper.entity.Foo;

public class TestValidator {

	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
	}

	@AfterClass
	public static void tearDownAfterClass() throws Exception {
	}

	@Before
	public void setUp() throws Exception {
	}

	@After
	public void tearDown() throws Exception {
	}

	@Test
	public void test() {
		Foo target = new Foo();
		DataBinder binder = new DataBinder(target);
		binder.setValidator(new FooValidator());

		// bind to the target object
//		binder.bind(propertyValues);

		// validate the target object
		binder.validate();

		// get BindingResult that includes any validation errors
		BindingResult results = binder.getBindingResult();
	}

}
