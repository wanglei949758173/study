package study.spring;

import org.springframework.beans.factory.support.DefaultListableBeanFactory;
import org.springframework.beans.factory.xml.XmlBeanDefinitionReader;
import org.springframework.core.io.ClassPathResource;

import java.util.Map;

/**
 * 测试DefaultListableBeanFactory
 *
 * @author Administrator
 */
public class TestDefaultListableBeanFactory {
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

        // 打印调用堆栈
        Map<Thread, StackTraceElement[]> allStackTraces = Thread.getAllStackTraces();
        StackTraceElement[] stackTraceElements = allStackTraces.get(Thread.currentThread());
        for (StackTraceElement s : stackTraceElements) {
            System.out.println("------------------------" + s.getClassName() + "$" + s.getMethodName());
        }

        // 获取Bean
        Person person = beanFactory.getBean(Person.class);
        System.out.println(person);
    }


}
