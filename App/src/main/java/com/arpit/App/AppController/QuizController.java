package com.arpit.App.AppController;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.arpit.App.service.QuizService;
import com.arpit.model.Quiz;
import com.arpit.model.QuizVO;
import com.arpit.model.ResponseVO;

@RestController
@RequestMapping("quiz")
public class QuizController {

	@Autowired
	QuizService quizService;
	
	@PostMapping("create")
	public ResponseEntity<String> create(@RequestParam String category,@RequestParam int noOfQuestion,@RequestParam String title)
	{
		String responseBody = quizService.createQuiz(category,noOfQuestion,title);
		return new ResponseEntity<String>(responseBody,HttpStatus.CREATED);
	}
	
	@GetMapping("getQuiz")
	public ResponseEntity<QuizVO> getQuiz(@RequestParam int quizID)
	{
		
		QuizVO quiz = quizService.getQuiz(quizID);
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
