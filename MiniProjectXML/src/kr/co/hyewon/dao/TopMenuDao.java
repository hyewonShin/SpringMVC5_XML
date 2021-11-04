package kr.co.hyewon.dao;

import java.util.List;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import kr.co.hyewon.beans.BoardInfoBean;
import kr.co.hyewon.controller.BoardController;

//기능상 @component와 동일하지만 역할을 명시한다.
//DAO 역할을 하는 클래스는 @Repository를 사용한다.
@Repository  
public class TopMenuDao {

//	@Autowired
//	private TopMenuMapper topMenuMapper;
	
//XML에서는 Mapper 파일을 interface나 class로 만들지 않기 때문에 위와같이 mapper을 주입받지 못한다.
//그래서 servlet-context에서 사용했던 SqlSessionTemplate를  주입받아 쿼리문을 실행하면 된다.
	
	@Autowired
	private SqlSessionTemplate sqlSessionTemplate;
	
	public List<BoardInfoBean> getTopMenuList(){
		List<BoardInfoBean> topMenuList = sqlSessionTemplate.selectList("topmenu.get_topmenu_list");
		return topMenuList;
	}
}




