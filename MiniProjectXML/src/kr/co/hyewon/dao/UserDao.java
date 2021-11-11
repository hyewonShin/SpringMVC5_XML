package kr.co.hyewon.dao;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import kr.co.hyewon.beans.UserBean;

@Repository
public class UserDao {
	
	@Autowired
	private SqlSessionTemplate sqlsessionTemplate;
	

	public String checkUserIdExist(String user_id) {
		return sqlsessionTemplate.selectOne("user.checkUserIdExist", user_id);
	}
	
	public void addUserInfo(UserBean joinUserBean) {
		sqlsessionTemplate.insert("user.addUserInfo", joinUserBean);
	}
	
	public UserBean getLoginUserInfo(UserBean tempLoginUserBean) {
		return sqlsessionTemplate.selectOne("user.getLoginUserInfo", tempLoginUserBean);
	}
}
