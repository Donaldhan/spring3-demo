package cn.home.modules.beans.service.impl;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import cn.home.modules.beans.service.FooService;

public class FooServiceImpl implements FooService {
	private static final Logger log = LoggerFactory.getLogger(FooServiceImpl.class);
	private String name;
	
	public FooServiceImpl(String name) {
		super();
		this.name = name;
	}

	@Override
	public void doStuff(int times) {
		log.info("start {} times",times);
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
	
	
}
