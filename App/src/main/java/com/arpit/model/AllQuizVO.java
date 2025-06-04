package com.arpit.model;

import lombok.Data;

@Data
public class AllQuizVO {

	private Integer id;
	private String title;
	private String category;
	private Integer no_of_questions;
	
	
	public AllQuizVO()
	{
		
	}
	
	public AllQuizVO(Integer id, String title, String category, Integer no_of_questions) {
		super();
		this.id = id;
		this.title = title;
		this.category = category;
		this.no_of_questions = no_of_questions;
	}
	
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getCategory() {
		return category;
	}
	public void setCategory(String category) {
		this.category = category;
	}
	public Integer getNo_of_questions() {
		return no_of_questions;
	}
	public void setNo_of_questions(Integer no_of_questions) {
		this.no_of_questions = no_of_questions;
	}
}
