package kr.co.hyewon.dao;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class UserDao {
	
	@Autowired
	private SqlSessionTemplate sqlsessionTemplate;
	
	public String checkUserIdExist(String user_id) {
		return sqlsessionTemplate.selectOne("user.checkUserIdExist", user_id);
	}
}
