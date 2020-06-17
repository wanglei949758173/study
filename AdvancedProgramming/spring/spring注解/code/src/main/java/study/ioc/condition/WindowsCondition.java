/*      
 * 模块编号  
 * 功能描述 
 * 文件名 WindowsCondition.java 
 * 作者 王磊 
 * 编写日期 2020年06月17日 
 */
package study.ioc.condition;

import org.springframework.context.annotation.Condition;
import org.springframework.context.annotation.ConditionContext;
import org.springframework.core.env.Environment;
import org.springframework.core.type.AnnotatedTypeMetadata;

public class WindowsCondition implements Condition {

	@Override
	public boolean matches(ConditionContext context, AnnotatedTypeMetadata metadata) {
		Environment environment = context.getEnvironment();
		String osName = environment.getProperty("os.name");
		if (osName.toLowerCase().contains("windows")) {
			return true;
		} else {
			return false;
		}
	}

}
