package cn.home.modules.aop;

import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Aspect;

@Aspect
public class AfterReturningExample {
	@AfterReturning("com.xyz.myapp.SystemArchitecture.dataAccessOperation()")
	public void doAccessCheck() {
		// ...
	}

	@AfterReturning(pointcut = "com.xyz.myapp.SystemArchitecture.dataAccessOperation()", returning = "retVal")
	public void doAccessCheck(Object retVal) {
		// ...
	}

	@AfterThrowing("com.xyz.myapp.SystemArchitecture.dataAccessOperation()")
	public void doRecoveryActions() {
		// ...
	}

	/*
	 * @AfterThrowing(pointcut =
	 * "com.xyz.myapp.SystemArchitecture.dataAccessOperation()" , throwing =
	 * "ex") public void doRecoveryActions(DataAccessException ex) { // ... }
	 */
	@After("com.xyz.myapp.SystemArchitecture.dataAccessOperation()")
	public void doReleaseLock() {
		// ...
	}
}
