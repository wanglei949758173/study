/*      
 * 模块编号  
 * 功能描述 
 * 文件名 MainConfigOfProfile.java 
 * 作者 王磊 
 * 编写日期 2020年06月29日 
 */
package study.ioc.config;

import javax.sql.DataSource;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

import com.mchange.v2.c3p0.ComboPooledDataSource;

@Configuration
public class MainConfigOfProfile {
	@Bean
	@Profile("test")
	public DataSource testDataSource() throws Exception {
		ComboPooledDataSource dataSource = new ComboPooledDataSource();
		return dataSource;
	}
	
	@Bean
	@Profile("dev")
	public DataSource devDataSource() throws Exception {
		ComboPooledDataSource dataSource = new ComboPooledDataSource();
		return dataSource;
	}
	
	@Bean
	@Profile("product")
	public DataSource productDataSource() throws Exception {
		ComboPooledDataSource dataSource = new ComboPooledDataSource();
		return dataSource;
	}
}
