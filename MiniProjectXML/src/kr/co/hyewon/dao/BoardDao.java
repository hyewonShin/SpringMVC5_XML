package kr.co.hyewon.dao;

import java.util.List;

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
	
	public String getBoardInfoName(int board_info_idx) {
		return sqlsessionTemplate.selectOne("board.getBoardInfoName", board_info_idx);
	}
	
	public List<ContentBean> getContentList(int board_info_idx) {
		return sqlsessionTemplate.selectList("board.getContentList", board_info_idx);
	}
	
	public 	ContentBean getContentInfo(int content_idx) {
		return sqlsessionTemplate.selectOne("board.getContentInfo", content_idx);
	}
}
