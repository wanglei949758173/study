/*      
 * 模块编号  
 * 功能描述 
 * 文件名 ProxyFactory.java 
 * 作者 王磊 
 * 编写日期 2020年04月25日 
 */
package test.pattern.structure.proxy.cglib;

import java.lang.reflect.Method;

import net.sf.cglib.proxy.Enhancer;
import net.sf.cglib.proxy.MethodInterceptor;
import net.sf.cglib.proxy.MethodProxy;

/**
 * 使用cglib实现代理
 * 
 * @version 1.0.0.0
 * @author 王磊
 */
public class ProxyFactory implements MethodInterceptor{
	/**
	 * 目标对象
	 */
	private Object target;

	public ProxyFactory(Object target) {
		this.target = target;
	}

	public Object getProxyInstance() {
		Enhancer enhancer = new Enhancer();
		enhancer.setSuperclass(target.getClass());
		enhancer.setCallback(this);
		return enhancer.create();
	}

	@Override
	public Object intercept(Object proxy, Method method, Object[] args, MethodProxy methodProxy)
			throws Throwable {
		System.out.println("执行前...");
		Object returnValue = method.invoke(target, args);
		System.out.println("执行后...");
		return returnValue;
	}
}
