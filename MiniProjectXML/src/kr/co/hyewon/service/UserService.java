package kr.co.hyewon.service;

import javax.annotation.Resource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Service;

import kr.co.hyewon.beans.UserBean;
import kr.co.hyewon.dao.UserDao;

@Service
public class UserService {

	@Autowired
	private UserDao userDao;

	@Resource(name = "loginUserBean")
	@Lazy
	private UserBean loginUserBean;

	public boolean checkUserIdExist(String user_id) {

		String user_name = userDao.checkUserIdExist(user_id);

		if(user_name == null) {
			return true;
		} else {
			return false;
		}
	}

	public void addUserInfo(UserBean joinUserBean) {
		userDao.addUserInfo(joinUserBean);
	}

	// 로그인 처리(로그인 성공시, 정보 가져오기)
	public void getLoginUserInfo(UserBean tempLoginUserBean) {

		UserBean tempLoginUserBean2 = userDao.getLoginUserInfo(tempLoginUserBean);

		if(tempLoginUserBean2 != null) { //로그인 성공시
			loginUserBean.setUser_idx(tempLoginUserBean2.getUser_idx());
			loginUserBean.setUser_name(tempLoginUserBean2.getUser_name());
			loginUserBean.setUserLogin(true); //로그인 되있는것 (false는 로그인 안되있는 것)
		}
	}

}
