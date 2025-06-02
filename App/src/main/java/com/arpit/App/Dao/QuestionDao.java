package com.arpit.App.Dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.sql.DataSource;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.hibernate.query.NativeQuery;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.arpit.model.Question;

@Repository	
public class QuestionDao {

	
	
	@Autowired
    private SessionFactory sessionFactory;
	
	
	public List<Question> getAllStudents() {
		// getting error session is not creating
		Session session = sessionFactory.getCurrentSession();
        String sql = "SELECT * FROM question";
        NativeQuery<Question> query = session.createNativeQuery(sql, Question.class);
        return query.getResultList();
	}

}
