package com.arpit.App.Dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.arpit.model.Quiz;

public interface QuizDao extends JpaRepository<Quiz,Integer>{

}
