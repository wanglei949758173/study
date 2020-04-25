/*      
 * 模块编号  
 * 功能描述 
 * 文件名 ProxyFacotry.java 
 * 作者 王磊 
 * 编写日期 2020年04月25日 
 */
package test.pattern.structure.proxy.dynamicproxy;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

public class ProxyFacotry {
	/**
	 * 目标对象
	 */
	private Object target;

	public ProxyFacotry(Object target) {
		this.target = target;
	}

	public Object getProxyInstance() {
		Class<? extends Object> targetClass = target.getClass();
		return Proxy.newProxyInstance(targetClass.getClassLoader(), targetClass.getInterfaces(),
				new InvocationHandler() {
					@Override
					public Object invoke(Object proxy, Method method, Object[] args)
							throws Throwable {
						System.out.println("执行前........");
						Object returnValue = method.invoke(target, args);
						System.out.println("执行后........");
						return returnValue;
					}
				});
	}
}
