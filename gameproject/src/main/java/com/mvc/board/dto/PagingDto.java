package com.mvc.board.dto;

public class PagingDto {

	int maxPost;			//페이지당 표시될 게시물 최대 갯수 및 현재 게시물 갯수
	int firstPageNo;		//첫번째 페이지 번호
	int prevPageNo;			//이전 페이지 번호
	int startPageNo;		//시작 페이지 
	int currentPageNo;		//현재 페이지 번호
	int endPageNo;			//끝 페이지 번호
	int nextPageNo;			//다음 페이지 번호
	int finalPageNo;		//마지막 페이지 번호
	int numberOfRecords;	//전체 레코드 수
	int sizeOfPage;			//보여지는 페이지 갯수(1,2,3,4,5)
	int reset;				//처음 페이지로 이동
	int end;				//마지막 페이지로 이동
	
	public PagingDto() {
		
	}
	
	public PagingDto(int currentPageNo, int maxpost) {
		this.currentPageNo = currentPageNo;
		this.sizeOfPage = 5;
		this.maxPost = (maxPost != 0) ? maxPost : 5; //게시물 최대 갯수가 0개가 아니라면 현재 게시물 갯수(maxPost)이고, 만약 게시물수가 0개라면 5
		}

	public int getMaxPost() {
		return maxPost;
	}

	public void setMaxPost(int maxPost) {
		this.maxPost = maxPost;
	}

	public int getFirstPageNo() {
		return firstPageNo;
	}

	public void setFirstPageNo(int firstPageNo) {
		this.firstPageNo = firstPageNo;
	}

	public int getPrevPageNo() {
		return prevPageNo;
	}

	public void setPrevPageNo(int prevPageNo) {
		this.prevPageNo = prevPageNo;
	}

	public int getStartPageNo() {
		return startPageNo;
	}

	public void setStartPageNo(int startPageNo) {
		this.startPageNo = startPageNo;
	}

	public int getCurrentPageNo() {
		return currentPageNo;
	}

	public void setCurrentPageNo(int currentPageNo) {
		this.currentPageNo = currentPageNo;
	}

	public int getEndPageNo() {
		return endPageNo;
	}

	public void setEndPageNo(int endPageNo) {
		this.endPageNo = endPageNo;
	}

	public int getNextPageNo() {
		return nextPageNo;
	}

	public void setNextPageNo(int nextPageNo) {
		this.nextPageNo = nextPageNo;
	}

	public int getFinalPageNo() {
		return finalPageNo;
	}

	public void setFinalPageNo(int finalPageNo) {
		this.finalPageNo = finalPageNo;
	}

	public int getNumberOfRecords() {
		return numberOfRecords;
	}

	public void setNumberOfRecords(int numberOfRecords) {
		this.numberOfRecords = numberOfRecords;
	}

	public int getSizeOfPage() {
		return sizeOfPage;
	}

	public void setSizeOfPage(int sizeOfPage) {
		this.sizeOfPage = sizeOfPage;
	}
	
	
	public int getReset() {
		return reset;
	}

	public void setReset(int reset) {
		this.reset = reset;
	}

	public int getEnd() {
		return end;
	}

	public void setEnd(int end) {
		this.end = end;
	}

	public void makePaging() {
		if(numberOfRecords == 0)
		return;
		
		if(currentPageNo == 0)
			setCurrentPageNo(1);
		
		if(maxPost == 0)
			setMaxPost(5);
		
		int finalPage = (numberOfRecords + (maxPost - 1)) / maxPost;
		
		setEnd(finalPage);
		
		if(currentPageNo > finalPage)
			setCurrentPageNo(finalPage);
		
		if(currentPageNo < 0)
			currentPageNo = 1;
		
		boolean isNowFirst = currentPageNo == 1 ? true : false;
		boolean isNowFinal = currentPageNo == finalPage ? true : false;
		
		int startPage = ((currentPageNo - 1) / sizeOfPage) * sizeOfPage + 1;	
		int endPage = startPage + sizeOfPage - 1;
		
		if(endPage > finalPage)
			endPage = finalPage;
		
		setFirstPageNo(1);
		
		if(!isNowFirst)
			setPrevPageNo(((startPage - 1) < 1 ? 1 : (startPage -1)));
		
		setStartPageNo(startPage);
		setEndPageNo(endPage);
		
		if(!isNowFinal)
			setNextPageNo(((endPage + 1 > finalPage ? finalPage : (endPage + 1))));
		
		setFinalPageNo(finalPage);
		
	}
	
	
	
	
}
