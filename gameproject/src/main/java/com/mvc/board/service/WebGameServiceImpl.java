package com.mvc.board.service;

import java.security.NoSuchAlgorithmException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpSession;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.mvc.board.dao.WebGameDao;
import com.mvc.board.dto.InformationDto;
import com.mvc.board.dto.WebGameDataListDto;

@Repository("WebGameService")
public class WebGameServiceImpl implements WebGameService {

	@Autowired
	private SqlSession sqlSession;

	@Override
	public Map<String, Object> getBoardList(int first, int second) throws Exception {

		WebGameDao dao = sqlSession.getMapper(WebGameDao.class);
		ArrayList<WebGameDataListDto> list = dao.list(first, second);
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("list", list);

		return map;
	}

	@Override
	public boolean login(InformationDto dto, HttpSession session) throws NoSuchAlgorithmException {

		WebGameDao dao = sqlSession.getMapper(WebGameDao.class);
		InformationDto informationDto = dao.info(dto);

		session.setAttribute("id", informationDto.getId());
		session.setAttribute("password", informationDto.getPassword());

		return true;

	}

	@Override
	public void sign_up(InformationDto dto, HttpSession session) throws NoSuchAlgorithmException {

		WebGameDao dao = sqlSession.getMapper(WebGameDao.class);
		dao.sign_up(dto);
		session.setAttribute("id", dto.getId());
		session.setAttribute("password", dto.getPassword());

	}

	@Override
	public void logout(HttpSession session) {
		session.invalidate();

	}

	@Override
	public int count() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public InformationDto info(InformationDto dto) {
		WebGameDao dao = sqlSession.getMapper(WebGameDao.class);
		InformationDto dto2 = dao.info(dto);
		
		return dto2;
		
	}

	

}
