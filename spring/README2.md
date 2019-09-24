# 1. Spring源码分析准备
 * 编写测试代码
 ```java
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
 ```

# 2. 了解spring
  + Spring 框架中的核心组件只有三个：Core、Context 和 Beans。它们构建起了整个 Spring 的骨骼架构。

  + 如果将Spring比作一场舞台剧，那么**Beans就是演员**，**Core就是演出的主要工具**,
    **Context就是演出的舞台**。

  ## 2.1 BeanDefinition  
  
  ![BeanDefinition](https://github.com/wanglei949758173/study/tree/master/spring/images/GenericBeanDefinition.png)
  ![BeanDefinition](https://github.com/wanglei949758173/study/blob/master/spring/images/my-LoadBeanDefinitionClassDiagram.png)

  
  Bean 的定义就是完整的描述了在 Spring 的配置文件中你定义的 <bean/> 节点中所有的信息，包括各种子节点。当 Spring 成功解析你定义的一个 <bean/> 节点后，在 Spring 的内部就被转化成 BeanDefinition 对象。以后所有的操作都是对这个对象完成的。

  ## 2.2 BeanFactory
  
  ![BeanFactory](https://github.com/wanglei949758173/study/tree/master/spring/images/BeanFactory.png)
  
  BeanFactory 有三个子类：`ListableBeanFactory`、`HierarchicalBeanFactory` 和 `AutowireCapableBeanFactory`。从上图中可以发现最终的默认实现类是 `DefaultListableBeanFactory`，实现了所有的接口。`ListableBeanFactory` 接口表示这些 Bean 是可列表的(即这个Bean工厂具有保存和生产多个Bean的功能)，而 `HierarchicalBeanFactory` 表示层级工厂(即当前工厂可以存在父工厂)。`AutowireCapableBeanFactory` 表示此工厂具有自动装配的功能。
# 3. BeanDefinition加载过程的分析
  * 类图

  ![LoadBeanDefinitionClassDiagram](https://github.com/wanglei949758173/study/blob/master/spring/images/LoadBeanDefinitionClassDiagram.png)

  * 时序图

  ![LoadBeanDefinitionClassDiagram](https://github.com/wanglei949758173/study/blob/master/spring/images/LoadBeanDefinitionSequenceDiagram.png)

  * 流程分析
    1. 将资源文件`resource`进行`encode`;

    2. 用文档加载器`DocumentLoader`加载资源,返回`Document`;
    3. 使用`BeanDefinitionDocumentReader`读取`Document`;
    4. 预处理xml;
    5. 解析xml,解析xml的工作交给`BeanDefinitionParserDelegate`;
    6. 对xml进行后置处理;
    7. 使用`BeanDefinitionReaderUtils`向容器中注册`BeanDefinition`。

  * 自己的设计
    + 类图

      ![my-LoadBeanDefinitionClassDiagram](https://github.com/wanglei949758173/study/blob/master/spring/images/my-LoadBeanDefinitionClassDiagram.png)

   +  时序图

      ![my-LoadBeanDefinitionClassDiagram](https://github.com/wanglei949758173/study/blob/master/spring/images/my-LoadBeanDefinitionSequenceDiagram.png)
   * **总结** <br />
      不足之处: <br/>
        1. spring的设计遵循了**单一职能原则**。(spring将在资源`resource`中加载`Document`的过程交给了
            `DocumentLoader`来完成,spring将Bean定义的解析工作交给了`BeanDefinitionParserDelegate`,spring将给容器中注册Bean定义的工作交由`BeanDefinitionReaderUtils`)

        2. spring处理`Document`时巧妙的运用了**模板方法模式**。(处理`Document`时先调用了`preProcessXml`,然后调用`processXml`对文档进行了处理,最后调用`postProcessXml`进行后置
        处理。)
