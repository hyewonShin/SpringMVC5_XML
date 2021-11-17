package kr.co.hyewon.dao;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import kr.co.hyewon.beans.ContentBean;

@Repository
public class BoardDao {

	@Autowired
	private SqlSessionTemplate sqlsessionTemplate;
	
	public void addContentInfo(ContentBean writeContentBean) {
		sqlsessionTemplate.insert("board.addContentInfo", writeContentBean);
	}
}
