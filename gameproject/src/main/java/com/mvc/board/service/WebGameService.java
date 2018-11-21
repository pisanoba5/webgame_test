package com.mvc.board.service;

import java.security.NoSuchAlgorithmException;
import java.util.Map;

import javax.servlet.http.HttpSession;

import com.mvc.board.dto.InformationDto;
import com.mvc.board.dto.WebGameDataListDto;

public interface WebGameService {
	
	Map<String, Object> getBoardList(int first, int second) throws Exception;
	
	public int count();
	
	public boolean login(InformationDto dto, HttpSession session) throws NoSuchAlgorithmException;
	
	public void sign_up(InformationDto dto, HttpSession session) throws NoSuchAlgorithmException;
	
	public void logout(HttpSession session);
	
	public InformationDto info(InformationDto dto);

}