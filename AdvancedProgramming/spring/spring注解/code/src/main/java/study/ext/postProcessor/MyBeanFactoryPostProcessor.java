/*      
 * 模块编号  
 * 功能描述 
 * 文件名 MyBeanFactoryPostProcessor.java 
 * 作者 王磊 
 * 编写日期 2020年07月26日 
 */
package study.ext.postProcessor;

import java.util.Arrays;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.config.BeanFactoryPostProcessor;
import org.springframework.beans.factory.config.ConfigurableListableBeanFactory;
import org.springframework.stereotype.Component;

@Component
public class MyBeanFactoryPostProcessor implements BeanFactoryPostProcessor {

	// 执行时机：在BeanFactory标准初始化之后调用(BeanDefinition已经被加载，但Bean实例还未被创建)
	@Override
	public void postProcessBeanFactory(ConfigurableListableBeanFactory beanFactory)
			throws BeansException {
		String[] beanDefinitionNames = beanFactory.getBeanDefinitionNames();
		System.out.println(Arrays.toString(beanDefinitionNames));
	}
}
