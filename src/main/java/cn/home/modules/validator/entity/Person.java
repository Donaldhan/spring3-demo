package cn.home.modules.validator.entity;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

/**
 * @author donald 2017年11月27日 下午9:40:19
 */
public class Person {
	@NotNull
	@Size(max = 64)
	private String name;
	@Min(0)
	private int age;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}
}
