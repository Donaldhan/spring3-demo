package cn.home.modules.aop;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;

@Aspect
public class BeforeExample {
	@Before("com.xyz.myapp.SystemArchitecture.dataAccessOperation()")
	public void doAccessCheck() {
		// ...
	}

	@Before("execution(* com.xyz.myapp.dao.*.*(..))")
	public void doAccessCheck1() {
		// ...
	}
}
