package cn.home.modules.aop;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

/**
 * @author donald
 * 2017年11月29日
 * 下午1:11:20
 */
@Aspect
@Component
public class NotVeryUsefulAspect {
	
	@Pointcut("execution(* transfer(..))")// the pointcut expression
	private void anyOldTransfer() {
	}// the pointcut signature
}
