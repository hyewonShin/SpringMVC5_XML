package kr.co.hyewon.interceptor;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Lazy;
import org.springframework.web.servlet.HandlerInterceptor;

import kr.co.hyewon.beans.ContentBean;
import kr.co.hyewon.beans.UserBean;
import kr.co.hyewon.service.BoardService;

public class CheckWriterInterceptor implements HandlerInterceptor{
	
	@Resource(name = "loginUserBean")
	@Lazy
	private UserBean loginUserBean;
	
	@Autowired
	private BoardService boardService;
	
	
	
	@Override
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler)
			throws Exception {
		
		// content_idx 값을 추출한다.
		String str1 = request.getParameter("content_idx");
		
		// String을 int로 바꿔준다.
		int content_idx = Integer.parseInt(str1);
		
		// 현재 게시글 정보 가져오기
		ContentBean currentContentBean = boardService.getContentInfo(content_idx);
		
		if(currentContentBean.getContent_writer_idx() != loginUserBean.getUser_idx()) {
			String contextPath = request.getContextPath();
			response.sendRedirect(contextPath + "/board/not_writer");
			return false; // if문이 거짓이라면 다음 단계로 넘어간다. 
		}

		return true;
		
	}
}
