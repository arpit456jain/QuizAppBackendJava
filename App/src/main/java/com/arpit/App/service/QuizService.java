package com.arpit.App.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.arpit.App.Dao.QuizDao;
import com.arpit.model.Question;
import com.arpit.model.QuestionVO;
import com.arpit.model.Quiz;
import com.arpit.model.QuizVO;
import com.arpit.model.ResponseVO;
import com.arpit.App.Dao.QuestionInterface;

@Service
public class QuizService {

	@Autowired
	private QuizDao quizdao;
	@Autowired
	private QuestionInterface questionInterface;
	
	public String createQuiz(String category, int noOfQuestion, String title) {
		
		List<Question> questions = questionInterface.findRandomQuestionByCategory(category,noOfQuestion);
		if(questions.isEmpty())
			return "No Question found with this category";
		Quiz quiz = new Quiz(title,questions);
		quizdao.save(quiz);
		return "success";
	}

	public QuizVO getQuiz(int quizID) {
		Optional<Quiz> optionalQuiz = quizdao.findById(quizID);
	    QuizVO quiz= new QuizVO();
	    quiz.setQuizTitle(optionalQuiz.get().getTitle());
	    List<QuestionVO> questionForQuz = new ArrayList<QuestionVO>();
	    for(Question q : optionalQuiz.get().getQuestions())
	    {
	    	QuestionVO questionVo = new QuestionVO(q.getId(),q.getQuestionTitle(),q.getOption1(),q.getOption2(),q.getOption3(),q.getOption4());
	    	questionForQuz.add(questionVo);
	    }
	    quiz.setQuestions(questionForQuz);
	    return quiz;
	}

	public int calculateResult(int quizID, List<ResponseVO> response) {
		Optional<Quiz> optionalQuiz = quizdao.findById(quizID);
		int score = 0;
		for(ResponseVO responseItem : response)
		{
			int responseID = responseItem.getQuestionId();
			String responseValue = responseItem.getResponse();
			for(Question q : optionalQuiz.get().getQuestions())
		    {
		    	if(q.getId() == responseID && responseValue.equalsIgnoreCase(q.getAnswer()))
		    	{
		    		score++;
		    	}
		    	
		    }
		}
		
		return score;
	}
	

}
