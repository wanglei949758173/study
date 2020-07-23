/*      
 * 模块编号  
 * 功能描述 
 * 文件名 UserDao.java 
 * 作者 王磊 
 * 编写日期 2020年07月22日 
 */
package study.tx.dao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

@Repository
public class UserDao {
	@Autowired
	private JdbcTemplate jdbcTemplate;

	public void saveUser(String name, int age) {
		String sql = "INSERT INTO `t_user`(name,age) VALUES(?,?)";
		jdbcTemplate.update(sql, name, age);
	}
}
