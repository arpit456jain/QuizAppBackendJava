package com.arpit.model;

import java.util.List;

import lombok.Data;

@Data
public class QuizVO {

	private String quizTitle;
	private List<QuestionVO> questions;
	
	
	public String getQuizTitle() {
		return quizTitle;
	}
	public void setQuizTitle(String quizTitle) {
		this.quizTitle = quizTitle;
	}
	public List<QuestionVO> getQuestions() {
		return questions;
	}
	public void setQuestions(List<QuestionVO> questions) {
		this.questions = questions;
	}
}
