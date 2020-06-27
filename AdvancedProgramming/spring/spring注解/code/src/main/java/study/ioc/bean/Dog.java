/*      
 * 模块编号  
 * 功能描述 
 * 文件名 Dog.java 
 * 作者 王磊 
 * 编写日期 2020年06月22日 
 */
package study.ioc.bean;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.BeanNameAware;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.context.EmbeddedValueResolverAware;
import org.springframework.util.StringValueResolver;

public class Dog implements ApplicationContextAware, EmbeddedValueResolverAware, BeanNameAware {

	@Override
	public void setBeanName(String name) {
		System.out.println("bean name is " + name);
	}

	@Override
	public void setEmbeddedValueResolver(StringValueResolver resolver) {
		String expression = "#{3 * 4}";
		System.out.println(expression + " = " + resolver.resolveStringValue(expression));
		System.out.println("os.name = " + resolver.resolveStringValue("${os.name}"));
	}

	@Override
	public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {
		System.out.println("applicationContext=" + applicationContext);
	}

}
