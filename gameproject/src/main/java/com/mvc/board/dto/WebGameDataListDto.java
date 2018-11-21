package com.mvc.board.dto;

import java.sql.Date;

public class WebGameDataListDto extends PagingDto{

	
	
	int index_Id; //인덱스 
	int webgame_Rank; //랭크
	String webgame_Id; //게임아아디
	int webgame_Total; //점수
	Date webgame_Date; //날짜



	public int getIndex_Id() {
		return index_Id;
	}

	public void setIndex_Id(int index_Id) {
		this.index_Id = index_Id;
	}
	
	public int getWebgame_Rank() {
		return webgame_Rank;
	}

	public void setWebgame_Rank(int webgame_Rank) {
		this.webgame_Rank = webgame_Rank;
	}

	public String getWebgame_Id() {
		return webgame_Id;
	}

	public void setWebgame_Id(String webgame_Id) {
		this.webgame_Id = webgame_Id;
	}

	public int getWebgame_Total() {
		return webgame_Total;
	}

	public void setWebgame_Total(int webgame_Total) {
		this.webgame_Total = webgame_Total;
	}

	public Date getWebgame_Date() {
		return webgame_Date;
	}

	public void setWebgame_Date(Date webgame_date) {
		this.webgame_Date = webgame_Date;
	}

}
