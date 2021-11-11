package kr.co.hyewon.interceptor;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.context.annotation.Lazy;
import org.springframework.web.servlet.HandlerInterceptor;

import kr.co.hyewon.beans.UserBean;

public class CheckLoginInterceptor implements HandlerInterceptor{

	@Resource(name = "loginUserBean")
	@Lazy
	private UserBean loginUserBean;
	
	@Override
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler)
			throws Exception {
		
		if(loginUserBean.isUserLogin() == false) { //로그인되지 않았을 시
			String contextPath = request.getContextPath();
			response.sendRedirect(contextPath + "/user/not_login");  //not_logfin 페이지로 이동
			//preHandle에서 false이면 다음단계로 가지 않고 끝난다. 
			return false;
		}
		
		//로그인 되었을 시 contoller로 이동
		return true; 
	}
}
