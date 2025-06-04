package com.arpit.model;

import java.util.List;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToMany;
import lombok.Data;

@Entity
@Data
public class Quiz {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	private String title;
	private String category;
	private Integer no_of_questions;
	

	@ManyToMany
	private List<Question> questions;

	



	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Quiz()
	{
		
	}
	
	public Quiz(String title, String category, Integer no_of_questions, List<Question> questions) {
		super();
		this.title = title;
		this.category = category;
		this.no_of_questions = no_of_questions;
		this.questions = questions;
	}
	
	
	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public List<Question> getQuestions() {
		return questions;
	}

	public void setQuestions(List<Question> questions) {
		this.questions = questions;
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
