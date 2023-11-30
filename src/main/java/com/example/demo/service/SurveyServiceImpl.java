package com.example.demo.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.example.demo.entity.Survey;
import com.example.demo.repository.SurveyDao;

@Service
public class SurveyServiceImpl implements SurveyService{

	private final SurveyDao dao;
	
	SurveyServiceImpl(SurveyDao dao){
		this.dao = dao;
	}
	
	@Override
	public void save(Survey survey) {
		dao.insertSurvey(survey);
	}

	@Override
	public List<Survey> getAll() {
		var list = dao.getAll();
		
		if(list.isEmpty()) {
			throw new InquiryNotFoundException("SQL error");
		}
		
		return list;
	}

}