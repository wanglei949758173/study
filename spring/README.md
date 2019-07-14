# 1. IOC
## 1.1 BeanFactory
  * **定义:** 访问spring容器的根接口
  * **获取Bean的步骤**
    1. 在当前容器中寻找Bean;
    2. 如果当前的容器是分层容器(父子容器)，如果Bean没有在当前容器中找到，还会在父
       容器中寻找该Bean。
  * **Bean的生命周期**
    1. BeanNameAware's setBeanName (设置Bean名称)
    2. BeanClassLoaderAware's setBeanClassLoader  (设置Bean的类加载器)
    3. BeanFactoryAware's setBeanFactory (设置Bean的工厂容器)
    4. EnvironmentAware's setEnvironment (设置环境)
    5. EmbeddedValueResolverAware's setEmbeddedValueResolver (设置内嵌的值解析器)
    6. ResourceLoaderAware's setResourceLoader(only applicable when running in an     application context) (设置资源加载器)
    7. ApplicationEventPublisherAware's setApplicationEventPublisher(only applicable when running in an application context) (设置事件发布器)
    8. MessageSourceAware's setMessageSource(only applicable when running in an application context) (设置消息资源)
    9. ApplicationContextAware's setApplicationContext(only applicable when running in an application context) (设置应用上下文)
    10. ServletContextAware's setServletContext(only applicable when running in a web application context) (设置Servlet上下文)
    11. postProcessBeforeInitialization methods of BeanPostProcessors (Bean初始化前调用)
    12. InitializingBean's afterPropertiesSet (属性设置完后调用)
    13. a custom init-method definition (调用自定义的初始化方法)
    14. postProcessAfterInitialization methods of BeanPostProcessors (Bean初始化后调用)
  * **Bean销毁的生命周期**
    1. postProcessBeforeDestruction methods of DestructionAwareBeanPostProcessors
      (调用销毁通知后置处理器的postProcessBeforeDestruction()方法)
    2. DisposableBean's destroy (调用Bean的destroy()方法)
    3. a custom destroy-method definition (调用自定义的销毁方法)

## 1.2 FactoryBean
  * **说明:** FactoryBean是一个**创建Bean**的**工厂Bean**，FactoryBean本身也是一个Bean，
    但其本身也是一个工厂,FactoryBean的作用是提供某个类型的Bean,**即调用FactoryBean的getBean()返回的是一个Bean，而不是FactoryBean的实例。**
  * `&`的说明
    ```java
    // 假设myJndiObject是一个FactoryBean
    getBean("myJndiObject"); // 此调用返回的是myJndiObject创建的Bean
    getBean("&myJndiObject"); // 此调用返回的是myJndiObject本身,即FactoryBean本身
    ```

## 1.3 DefaultListableBeanFactory
  * 创建Bean工厂,加载XML的示例
  ```java
  public static void main(String[] args) {
		// 定义spring配置文件
		// <bean name="person" class="study.spring.Person"></bean>

		// 创建工厂
		DefaultListableBeanFactory beanFactory = new DefaultListableBeanFactory();

		// 创建resource
		ClassPathResource resource = new ClassPathResource("testDefaultListableBeanFactory.xml");

		// 创建Reader
		XmlBeanDefinitionReader reader = new XmlBeanDefinitionReader(beanFactory);

		// 从resource加载BeanDefinition
		reader.loadBeanDefinitions(resource);

		// 获取Bean
		Person person = beanFactory.getBean(Person.class);
		System.out.println(person);
	}
  ```
