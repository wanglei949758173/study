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
