/*      
 * 模块编号  
 * 功能描述 
 * 文件名 LogAspect.java 
 * 作者 王磊 
 * 编写日期 2020年07月05日 
 */
package study.aop.aspect;

import java.util.Arrays;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;

@Aspect // 此注解标识此类是一个切面类
public class LogAspect {
	@Before("execution(public int study.aop.service.MathCalculator.*(..))")
	public void logBefore(JoinPoint joinPoint) {
		String methodName = joinPoint.getSignature().getName();
		Object[] args = joinPoint.getArgs();
		System.out.printf("before,方法=%s,参数=%s\n", methodName, Arrays.toString(args));
	};

	// 抽取公共的切入点表达式
	// 本类可以使用
	// 其他类也可以使用
	@Pointcut("execution(public int study.aop.service.MathCalculator.*(..))")
	public void pointCut() {
	};

	@After("pointCut()")
	public void logAfter(JoinPoint joinPoint) {
		String methodName = joinPoint.getSignature().getName();
		Object[] args = joinPoint.getArgs();
		System.out.printf("after,方法=%s,参数=%s\n", methodName, Arrays.toString(args));
	}

	@AfterReturning(value = "study.aop.aspect.LogAspect.pointCut()", returning = "retVal")
	public void logAfterReturn(JoinPoint joinPoint, Object retVal) {
		String methodName = joinPoint.getSignature().getName();
		System.out.printf("afterReturn,方法=%s,返回值=%s\n", methodName, retVal.toString());
	}

	@AfterThrowing(value = "pointCut()", throwing = "exception")
	public void logAfterThrowing(JoinPoint joinPoint, Exception exception) {
		String methodName = joinPoint.getSignature().getName();
		System.out.printf("afterThrowing,方法=%s,异常=%s\n", methodName, exception.toString());
	}
}
