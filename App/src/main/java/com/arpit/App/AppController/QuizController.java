package com.arpit.App.AppController;

import java.util.List;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.arpit.App.service.QuizService;
import com.arpit.model.AllQuizVO;
import com.arpit.model.QuizVO;
import com.arpit.model.ResponseVO;

@CrossOrigin(origins = "http://localhost:3000")
@RestController
@RequestMapping("quiz")
public class QuizController {

	@Autowired
	QuizService quizService;
	
	@PostMapping("create")
	public ResponseEntity<String> create(@RequestParam String difficulty,@RequestParam String category,@RequestParam int noOfQuestion,@RequestParam String title)
	{
		String responseBody = quizService.createQuiz(category,noOfQuestion,title,difficulty);
		return new ResponseEntity<String>(responseBody,HttpStatus.CREATED);
	}
	
	@GetMapping("getAllQuiz")
	public ResponseEntity<List<AllQuizVO>> getAllQuiz()
	{
		
		List<AllQuizVO> allQuiz = quizService.getAllQuiz();
		return new ResponseEntity<List<AllQuizVO>>(allQuiz,HttpStatus.OK);
	}
	
	@GetMapping("getQuizById")
	public ResponseEntity<QuizVO> getQuizById(@RequestParam int quizID)
	{
		
		QuizVO quiz = quizService.getQuizById(quizID);
		return new ResponseEntity<QuizVO>(quiz,HttpStatus.OK);
	}
	
	@PostMapping("getResult")
	public String getResult(@RequestParam int quizID ,@RequestBody List<ResponseVO> response)
	{
		int score = quizService.calculateResult(quizID,response);
		String result = "fail";
		if(score>4)
			result = "pass";
		return result;
	}
	
	
}
