package com.apptad.crud.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.apptad.crud.model.Register;
import com.apptad.crud.repository.RegisterRepository;
@Service
public class ServiceSearch {
@Autowired
	RegisterRepository registerRepository;
	public List<Register> SearchById(int id) {
		// TODO Auto-generated method stub
		return registerRepository.searchById(id);
	}

}
