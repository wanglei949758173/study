/*      
 * 模块编号  
 * 功能描述 
 * 文件名 DogFactoryBean.java 
 * 作者 王磊 
 * 编写日期 2020年06月22日 
 */
package study.ioc.bean;

import org.springframework.beans.factory.FactoryBean;

public class DogFactoryBean implements FactoryBean<Dog>{

	@Override
	public Dog getObject() throws Exception {
		return new Dog();
	}

	@Override
	public Class<?> getObjectType() {
		return Dog.class;
	}

	@Override
	public boolean isSingleton() {
		return true;
	}

}
