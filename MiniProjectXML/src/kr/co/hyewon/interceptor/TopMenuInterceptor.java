package kr.co.hyewon.interceptor;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.servlet.HandlerInterceptor;

import kr.co.hyewon.beans.BoardInfoBean;
import kr.co.hyewon.service.TopMenuService;

public class TopMenuInterceptor implements HandlerInterceptor{

	
	@Autowired
	private TopMenuService topMenuService;
	//XML에서는 interceptor 파일에서 service 클래스가 자동주입 가능하다.
	
	
	@Override
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler)
			throws Exception {
		// TODO Auto-generated method stub
		List<BoardInfoBean> topMenuList = topMenuService.getTopMenuList();
		request.setAttribute("topMenuList", topMenuList);
		
		return true;
	}
}
  