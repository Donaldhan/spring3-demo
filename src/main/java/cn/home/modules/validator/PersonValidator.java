package cn.home.modules.validator;

import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;

import cn.home.modules.validator.entity.Person;

/**
 * @author donald
 * 2017年11月27日
 * 下午9:40:14
 */
public class PersonValidator implements Validator {

	/**
	 * This Validator validates *just* Person instances
	 */
	public boolean supports(Class clazz) {
		return Person.class.equals(clazz);
	}

	public void validate(Object obj, Errors e) {
		ValidationUtils.rejectIfEmpty(e, "name", "name.empty");
		Person p = (Person) obj;
		if (p.getAge() < 0) {
			e.rejectValue("age", "negativevalue");
		} else if (p.getAge() > 110) {
			e.rejectValue("age", "too.darn.old");
		}
	}

}
