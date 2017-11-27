package cn.home.modules.beanwrapper.entity;

import java.util.Map;

public class Foo {
	private Map<String, Float> accounts;
	private int age;

	public Map<String, Float> getAccounts() {
		return accounts;
	}

	public void setAccounts(Map<String, Float> accounts) {
		this.accounts = accounts;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

}
