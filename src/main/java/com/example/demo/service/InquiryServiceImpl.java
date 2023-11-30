package com.example.demo.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.example.demo.entity.Inquiry;
import com.example.demo.repository.InquiryDao;

@Service
public class InquiryServiceImpl implements InquiryService {

	private final InquiryDao dao;
	
	public InquiryServiceImpl(InquiryDao dao) {
		this.dao = dao;
	}
	
	@Override
	public void save(Inquiry inquiry) {
		dao.insertInquiry(inquiry);
	}

	@Override
	public void update(Inquiry inquiry) {
		var count = dao.updateInquiry(inquiry);
		
		if(count == 0) {
			throw new InquiryNotFoundException("can't find the same ID");
		}
	}
	
	@Override
	public List<Inquiry> getAll() {
		
		List<Inquiry> list = dao.getAll();
		if(list.isEmpty()) {
			throw new InquiryNotFoundException("No inquiry");
		}
		return list;
	}

}