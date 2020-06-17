/*      
 * 模块编号  
 * 功能描述 
 * 文件名 CustomImportBeandefinitionRegister.java 
 * 作者 王磊 
 * 编写日期 2020年06月17日 
 */
package study.ioc.importer;

import org.springframework.beans.factory.support.BeanDefinitionRegistry;
import org.springframework.beans.factory.support.RootBeanDefinition;
import org.springframework.context.annotation.ImportBeanDefinitionRegistrar;
import org.springframework.core.type.AnnotationMetadata;

import study.ioc.bean.Yellow;

public class CustomImportBeandefinitionRegister implements ImportBeanDefinitionRegistrar{

	@Override
	public void registerBeanDefinitions(AnnotationMetadata importingClassMetadata,
			BeanDefinitionRegistry registry) {
		boolean containsRed = registry.containsBeanDefinition("study.ioc.bean.Red");
		if (containsRed) {
			registry.registerBeanDefinition("yellow", new RootBeanDefinition(Yellow.class));
		}
	}

}
