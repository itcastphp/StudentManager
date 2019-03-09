package com.qfedu.domain;

import java.util.List;

public class Page {
	private Integer startPage;
	private Integer prevPage;
	private Integer thisPage;
	private Integer nextPage;
	private Integer endPage;
	
	private Integer totalCount;
	private List<Student> students;
	public Integer getStartPage() {
		return startPage;
	}
	public void setStartPage(Integer startPage) {
		this.startPage = startPage;
	}
	public Integer getPrevPage() {
		return prevPage;
	}
	public void setPrevPage(Integer prevPage) {
		this.prevPage = prevPage;
	}
	public Integer getThisPage() {
		return thisPage;
	}
	public void setThisPage(Integer thisPage) {
		this.thisPage = thisPage;
	}
	public Integer getNextPage() {
		return nextPage;
	}
	public void setNextPage(Integer nextPage) {
		this.nextPage = nextPage;
	}
	public Integer getEndPage() {
		if(totalCount%3==0) {
			return totalCount/3;
		}
		return totalCount/3+1;
	}
	public void setEndPage(Integer endPage) {
		this.endPage = endPage;
	}
	public Integer getTotalCount() {
		return totalCount;
	}
	public void setTotalCount(Integer totalCount) {
		this.totalCount = totalCount;
	}
	public List<Student> getStudents() {
		return students;
	}
	public void setStudents(List<Student> students) {
		this.students = students;
	}
	
	
}
