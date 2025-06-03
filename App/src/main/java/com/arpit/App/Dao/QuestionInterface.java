package com.arpit.App.Dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.arpit.model.Question;
 

@Repository	
public interface QuestionInterface extends JpaRepository<Question,Integer>	{

	List<Question> findByCategory(String category);

	@Query(value = "select * from question where category=:category and difficulty_level = :difficulty order by RANDOM() limit :noOfQuestion" ,nativeQuery = true)
	List<Question> findRandomQuestionByCategoryAndDifficuly(String category, int noOfQuestion,String difficulty);

	@Query(value = "select distinct(category)  from question " ,nativeQuery = true)
	List<String> getAllDistinctCategory();

	@Query(value = "select distinct(difficulty_level )  from question" ,nativeQuery = true)
	List<String> getDifficultyLevel();
}
