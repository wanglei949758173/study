/*      
 * 模块编号  
 * 功能描述 
 * 文件名 MyBeanPostProcessor.java 
 * 作者 王磊 
 * 编写日期 2020年06月24日 
 */
package study.ioc.bean;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.config.BeanPostProcessor;

public class MyBeanPostProcessor implements BeanPostProcessor {

	// construct
	// postProcessBeforeInitialization
	// init
	// postProcessAfterInitialization
	// preDestory
	// destory
	@Override
	public Object postProcessBeforeInitialization(Object bean, String beanName)
			throws BeansException {
		System.out.println("postProcessBeforeInitialization =>" + beanName);
		return bean;
	}

	@Override
	public Object postProcessAfterInitialization(Object bean, String beanName)
			throws BeansException {
		System.out.println("postProcessAfterInitialization =>" + beanName);
		return bean;
	}

}
