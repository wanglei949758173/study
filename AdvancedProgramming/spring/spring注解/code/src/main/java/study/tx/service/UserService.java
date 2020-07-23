/*      
 * 模块编号  
 * 功能描述 
 * 文件名 UserService.java 
 * 作者 王磊 
 * 编写日期 2020年07月22日 
 */
package study.tx.service;

import java.util.Random;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import study.tx.dao.UserDao;

@Service
public class UserService {
	@Autowired
	private UserDao userDao;

	@Transactional
	public void saveUser() {
		int nextInt = new Random().nextInt(50);
		String name = "张三" + nextInt;
		userDao.saveUser(name, nextInt);

		nextInt = 10 / 0;
		System.out.println("插入成功");
	}
}
