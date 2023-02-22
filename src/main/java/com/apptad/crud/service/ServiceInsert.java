package com.apptad.crud.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.apptad.crud.model.Register;
import com.apptad.crud.repository.RegisterRepository;
@Service
public class ServiceInsert {
	@Autowired
	RegisterRepository registerReapository;
	
	public String Insert(Register registerModel) {
		return registerReapository.insert(registerModel);
		}
}
