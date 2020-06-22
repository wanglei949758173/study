/*      
 * 模块编号  
 * 功能描述 
 * 文件名 MainConfig.java 
 * 作者 王磊 
 * 编写日期 2020年06月14日 
 */
package study.ioc.config;

import org.springframework.beans.factory.config.ConfigurableBeanFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Conditional;
import org.springframework.context.annotation.ComponentScan.Filter;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.FilterType;
import org.springframework.context.annotation.Import;
import org.springframework.context.annotation.Lazy;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;

import study.ioc.bean.BillGates;
import study.ioc.bean.Color;
import study.ioc.bean.DogFactoryBean;
import study.ioc.bean.LinusBenedictTorvalds;
import study.ioc.bean.Person;
import study.ioc.condition.LinuxCondition;
import study.ioc.condition.WindowsCondition;
import study.ioc.importer.CustomImportBeandefinitionRegister;
import study.ioc.importer.CustomImportSelector;

@Configuration
@ComponentScan(value = "study.ioc",
		includeFilters = { @Filter(type = FilterType.ANNOTATION, classes = { Controller.class }), },
		useDefaultFilters = false)
@Import({ Color.class, CustomImportSelector.class, CustomImportBeandefinitionRegister.class })
public class MainConfig {
	@Lazy
	// @Scope(ConfigurableBeanFactory.SCOPE_PROTOTYPE)
	@Bean
	public Person person() {
		Person person = new Person();
		person.setName("spring bean");
		person.setAge(20);
		person.setNickName("豆子");
		return person;
	}

	@Conditional({ WindowsCondition.class })
	@Scope(ConfigurableBeanFactory.SCOPE_SINGLETON)
	@Bean
	public BillGates gates() {
		return new BillGates();
	}

	@Conditional({ LinuxCondition.class })
	@Bean
	public LinusBenedictTorvalds linus() {
		return new LinusBenedictTorvalds();
	}

	@Bean
	public DogFactoryBean dogFactoryBean() {
		return new DogFactoryBean();
	}
}
