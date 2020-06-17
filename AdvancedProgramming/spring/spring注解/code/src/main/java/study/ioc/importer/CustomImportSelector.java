/*      
 * 模块编号  
 * 功能描述 
 * 文件名 CustomImportSelector.java 
 * 作者 王磊 
 * 编写日期 2020年06月17日 
 */
package study.ioc.importer;

import org.springframework.context.annotation.ImportSelector;
import org.springframework.core.type.AnnotationMetadata;

public class CustomImportSelector implements ImportSelector{

	@Override
	public String[] selectImports(AnnotationMetadata importingClassMetadata) {
		return new String[] {"study.ioc.bean.Red"};
	}

}
