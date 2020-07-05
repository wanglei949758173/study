package study.ioc;

import java.util.Arrays;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.core.env.ConfigurableEnvironment;

import study.ioc.config.MainConfigOfProfile;

public class IOCProfileTest {
	public static void main(String[] args) {
		AnnotationConfigApplicationContext applicationContext =
				new AnnotationConfigApplicationContext();
		ConfigurableEnvironment environment = applicationContext.getEnvironment();
		// 设置当前环境
		environment.setActiveProfiles("product");
		applicationContext.register(MainConfigOfProfile.class);
		applicationContext.refresh();

		// 获取所有的bean
		String[] beanDefinitionNames = applicationContext.getBeanDefinitionNames();
		Arrays.stream(beanDefinitionNames).forEach(beanDefinitionName -> {
			System.out.println(beanDefinitionName);
		});

		applicationContext.close();
	}
}
