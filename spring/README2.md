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

# 2. BeanDefinition加载过程的分析
  * 类图

  ![LoadBeanDefinitionClassDiagram](https://github.com/wanglei949758173/study/blob/master/spring/images/LoadBeanDefinitionClassDiagram.png)

  * 时序图

  ![LoadBeanDefinitionClassDiagram](https://github.com/wanglei949758173/study/blob/master/spring/images/LoadBeanDefinitionClassDiagram.png)

  * 流程分析
    1. 将资源文件`resource`进行`encode`;
    2. 用文档加载器`DocumentLoader`加载资源,返回`Document`;
    3. 使用`BeanDefinitionDocumentReader`读取`Document`;
    4. 预处理xml;
    5. 解析xml,解析xml的工作交给`BeanDefinitionParserDelegate`;
    6. 对xml进行后置处理;
    7. 使用`BeanDefinitionReaderUtils`向容器中注册`BeanDefinition`。

Spring 框架中的核心组件只有三个：Core、Context 和 Beans。它们构建起了整个 Spring 的骨骼架构。

如果将Spring比作一场舞台剧，那么**Beans就是演员**，**Core就是演出的主要工具**,**Context就是演出的舞台**。
# 1. Core

## 1.1 Bean的定义

## 1.2 Bean的创建

## 1.3 Bean的解析

# 2. Context
# 3. Beans
