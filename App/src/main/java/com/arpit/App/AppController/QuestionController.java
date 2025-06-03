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

import com.arpit.App.service.QuestionService;
import com.arpit.model.DropDownVO;
import com.arpit.model.Question;

@CrossOrigin(origins = "http://localhost:3000")
@RestController
@RequestMapping("question")
public class QuestionController {
	
	@Autowired
	private QuestionService questionService;
	
	
	@GetMapping("allQuestions")
	public List<Question> getAllQuestions()
	{
		return questionService.getAllQuestions();
	}
	
	@GetMapping("allQuestionsByJPA")
	public ResponseEntity<List<Question>> getAllQuestionsByJpa()
	{
		
		List<Question> questions = questionService.getAllQuestionsByJPA();
		return new ResponseEntity<>(questions, HttpStatus.OK);
	}
	
	@GetMapping("allQuestionsByJPAByCategory")
	public ResponseEntity<List<Question>> getAllQuestionsByJPAByCategory(@RequestParam String category)
	{
		List<Question> questions = questionService.getAllQuestionsByJPAByCategory(category);
		return new ResponseEntity<>(questions, HttpStatus.OK);
	}
	
	@PostMapping("addQuestionJPA")
	public ResponseEntity<String> addQuestionByJPA(@RequestBody Question question)
	{
		String responseBody = "";
		try {
			responseBody = questionService.addQuestion(question);
		}
		catch(Exception e)
		{
			responseBody = "Exception occurd";
			return new ResponseEntity<>(responseBody, HttpStatus.BAD_GATEWAY);
		}
		
		
		return new ResponseEntity<>(responseBody, HttpStatus.CREATED);
	}
	
	@GetMapping("getCategory")
	public ResponseEntity<?> getCategory()
	{
		List<DropDownVO> distinctCategory = questionService.getCategory();
		return new ResponseEntity<>(distinctCategory,HttpStatus.OK);
	}

	
	
	@GetMapping("getDifficultyLevel")
	public ResponseEntity<?> getDifficultyLevel()
	{
		List<DropDownVO> difficultyLevel = questionService.getDifficultyLevel();
		return new ResponseEntity<>(difficultyLevel,HttpStatus.OK);
	}

}
