package com.mvc.board.dao;

import java.util.ArrayList;

import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Repository;

import com.mvc.board.dto.InformationDto;
import com.mvc.board.dto.WebGameDataListDto;


@Repository
public interface WebGameDao {

	public ArrayList<WebGameDataListDto> list(int off, int noOfRecords);

	public boolean login(InformationDto dto, HttpSession session);

	public int count();
	
	public void sign_up(InformationDto dto);
	
	public InformationDto info(InformationDto dto);

}
