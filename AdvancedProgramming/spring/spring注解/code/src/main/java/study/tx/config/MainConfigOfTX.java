/*      
 * 模块编号  
 * 功能描述 
 * 文件名 MainConfigOfTX.java  
 * 作者 王磊 
 * 编写日期 2020年7月13日    
 */
package study.tx.config;

import javax.sql.DataSource;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import com.mchange.v2.c3p0.ComboPooledDataSource;

@Configuration
@EnableTransactionManagement
public class MainConfigOfTX {
	// 数据源
	@Bean
	public DataSource dataSource() throws Exception {
		ComboPooledDataSource dataSource = new ComboPooledDataSource();
		dataSource.setUser("root");
		dataSource.setPassword("1234");
		dataSource.setDriverClass("");
		dataSource.setJdbcUrl("");
		return dataSource;
	}
}
