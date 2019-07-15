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

## 1.3 “创建一个Bean工厂,加载xml中的Bean”示例及源码分析
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
  * DefaultListableBeanFactory源码分析
    ```java
    public DefaultListableBeanFactory() {
  		super();
  	}

    // DefaultListableBeanFactory父类 抽象的具有自动装配功能的工厂
    public AbstractAutowireCapableBeanFactory() {
  		super();
      // 忽略给定的自动装配依赖接口。
  		ignoreDependencyInterface(BeanNameAware.class);
  		ignoreDependencyInterface(BeanFactoryAware.class);
  		ignoreDependencyInterface(BeanClassLoaderAware.class);
  	}

    // AbstractAutowireCapableBeanFactory的父类抽象Bean工厂
    public AbstractBeanFactory() {
	  }
    ```
  * Resource源码分析
    ```java
    // 构造方法完成了ClassPathResource中成员变量path和classLoader的赋值
    public ClassPathResource(String path) {
  		this(path, (ClassLoader) null);
  	}

    public ClassPathResource(String path, ClassLoader classLoader) {
  		Assert.notNull(path, "Path must not be null");
  		String pathToUse = StringUtils.cleanPath(path);
  		if (pathToUse.startsWith("/")) {
  			pathToUse = pathToUse.substring(1);
  		}
  		this.path = pathToUse;
  		this.classLoader = (classLoader != null ? classLoader : ClassUtils.getDefaultClassLoader());
  	}

    // 获取类加载器,实际上使用线程上下文类加载器
    public static ClassLoader getDefaultClassLoader() {
  		ClassLoader cl = null;
  		try {
  			cl = Thread.currentThread().getContextClassLoader();
  		}
  		catch (Throwable ex) {
  			// Cannot access thread context ClassLoader - falling back...
  		}
  		if (cl == null) {
  			// No thread context class loader -> use class loader of this class.
  			cl = ClassUtils.class.getClassLoader();
  			if (cl == null) {
  				// getClassLoader() returning null indicates the bootstrap ClassLoader
  				try {
  					cl = ClassLoader.getSystemClassLoader();
  				}
  				catch (Throwable ex) {
  					// Cannot access system ClassLoader - oh well, maybe the caller can live with null...
  				}
  			}
  		}
  		return cl;
  	}
    ```
  * XmlBeanDefinitionReader源码分析
    ```java
    // 传入一个Bean工厂,将BeanDefinition加载进这个工厂
    public XmlBeanDefinitionReader(BeanDefinitionRegistry registry) {
  		super(registry);
  	}

    // XmlBeanDefinitionReader的父类
    protected AbstractBeanDefinitionReader(BeanDefinitionRegistry registry) {
  		Assert.notNull(registry, "BeanDefinitionRegistry must not be null");
      // 为成员变量工厂赋值
  		this.registry = registry;

  		// Determine ResourceLoader to use.
  		if (this.registry instanceof ResourceLoader) {
  			this.resourceLoader = (ResourceLoader) this.registry;
  		}
  		else {
  			this.resourceLoader = new PathMatchingResourcePatternResolver();
  		}

  		// Inherit Environment if possible
      // 如果课程,继承一个环境
  		if (this.registry instanceof EnvironmentCapable) {
  			this.environment = ((EnvironmentCapable) this.registry).getEnvironment();
  		}
  		else {
  			this.environment = new StandardEnvironment();
  		}
  	}
    ```
  * `reader.loadBeanDefinitions(resource)`源码分析
    ```java
    @Override
  	public int loadBeanDefinitions(Resource resource) throws BeanDefinitionStoreException {
      // EncodedResource实际上只进行资源编码集的设定,没有干其他的事
  		return loadBeanDefinitions(new EncodedResource(resource));
  	}

    public int loadBeanDefinitions(EncodedResource encodedResource) throws BeanDefinitionStoreException {
  		Assert.notNull(encodedResource, "EncodedResource must not be null");
  		if (logger.isInfoEnabled()) {
  			logger.info("Loading XML bean definitions from " + encodedResource);
  		}

      // 从ThreadLocal中获取资源
  		Set<EncodedResource> currentResources = this.resourcesCurrentlyBeingLoaded.get();
  		if (currentResources == null) {
  			currentResources = new HashSet<EncodedResource>(4);
  			this.resourcesCurrentlyBeingLoaded.set(currentResources);
  		}
  		if (!currentResources.add(encodedResource)) {
  			throw new BeanDefinitionStoreException(
  					"Detected cyclic loading of " + encodedResource + " - check your import definitions!");
  		}

  		try {
  			InputStream inputStream = encodedResource.getResource().getInputStream();
  			try {
  				InputSource inputSource = new InputSource(inputStream);
  				if (encodedResource.getEncoding() != null) {
  					inputSource.setEncoding(encodedResource.getEncoding());
  				}
          // 加载BeanDefinitions
  				return doLoadBeanDefinitions(inputSource, encodedResource.getResource());
  			}
  			finally {
  				inputStream.close();
  			}
  		}
  		catch (IOException ex) {
  			throw new BeanDefinitionStoreException(
  					"IOException parsing XML document from " + encodedResource.getResource(), ex);
  		}
  		finally {
  			currentResources.remove(encodedResource);
  			if (currentResources.isEmpty()) {
  				this.resourcesCurrentlyBeingLoaded.remove();
  			}
  		}
  	}

    protected int doLoadBeanDefinitions(InputSource inputSource, Resource resource)
			throws BeanDefinitionStoreException {
  		try {
        // 加载文档
  			Document doc = doLoadDocument(inputSource, resource);

        // 注册BeanDefinitions
  			return registerBeanDefinitions(doc, resource);
  		}
  		catch (BeanDefinitionStoreException ex) {
  			throw ex;
  		}
  		catch (SAXParseException ex) {
  			throw new XmlBeanDefinitionStoreException(resource.getDescription(),
  					"Line " + ex.getLineNumber() + " in XML document from " + resource + " is invalid", ex);
  		}
  		catch (SAXException ex) {
  			throw new XmlBeanDefinitionStoreException(resource.getDescription(),
  					"XML document from " + resource + " is invalid", ex);
  		}
  		catch (ParserConfigurationException ex) {
  			throw new BeanDefinitionStoreException(resource.getDescription(),
  					"Parser configuration exception parsing XML from " + resource, ex);
  		}
  		catch (IOException ex) {
  			throw new BeanDefinitionStoreException(resource.getDescription(),
  					"IOException parsing XML document from " + resource, ex);
  		}
  		catch (Throwable ex) {
  			throw new BeanDefinitionStoreException(resource.getDescription(),
  					"Unexpected exception parsing XML document from " + resource, ex);
  		}
  	}

    // 加载文档
    protected Document doLoadDocument(InputSource inputSource, Resource resource) throws Exception {
      // private DocumentLoader documentLoader = new DefaultDocumentLoader();
  		return this.documentLoader.loadDocument(inputSource, getEntityResolver(), this.errorHandler,
  				getValidationModeForResource(resource), isNamespaceAware());
  	}

    // 注册BeanDefinitions
    public int registerBeanDefinitions(Document doc, Resource resource) throws BeanDefinitionStoreException {
  		BeanDefinitionDocumentReader documentReader = createBeanDefinitionDocumentReader();
  		int countBefore = getRegistry().getBeanDefinitionCount();
  		documentReader.registerBeanDefinitions(doc, createReaderContext(resource));
      // 新注册的Bean = 总数 - 之前的数量
  		return getRegistry().getBeanDefinitionCount() - countBefore;
  	}
    ```
