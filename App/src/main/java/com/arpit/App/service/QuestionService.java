package com.arpit.App.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.arpit.App.Dao.QuestionDao;
import com.arpit.App.Dao.QuestionInterface;
import com.arpit.model.Question;

@Service
public class QuestionService {

	@Autowired
	private QuestionDao questionDao;
	
	@Autowired
	private QuestionInterface questionInterface;
	
	public List<Question> getAllQuestions()
	{
		return questionDao.getAllStudents();
	}
	
	public List<Question> getAllQuestionsByJPA()
	{
		List<Question> result = questionInterface.findAll();
		return result;
	}
	
	public List<Question> getAllQuestionsByJPAByCategory(String category)
	{
		List<Question> result = questionInterface.findByCategory(category);
		return result;
	}

	public String addQuestion(Question question) {
		try {
			questionInterface.save(question);
			return "save successfully!!";
		}
		catch(Exception e)
		{
			System.out.println("exception occured"+e);
		}
		
		return "some error occured";
	}
}
