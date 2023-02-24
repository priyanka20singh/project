package com.apptad.crud.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;

import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.apptad.crud.model.Register;
import com.apptad.crud.service.ServiceDelete;
import com.apptad.crud.service.ServiceInsert;
import com.apptad.crud.service.ServiceSearch;
import com.apptad.crud.service.ServiceUpdate;

@Controller
public class CrudController {
	@Autowired
	ServiceInsert insertservice;
	@GetMapping(value="/")
	public String index() {
		return "welcome";
	}
	
	@PostMapping(value="/insert")
	public String insert(@ModelAttribute Register registerModel) {
		System.out.println(registerModel.toString());
		return insertservice.Insert(registerModel);
	}	
//	@RequestMapping(value="/",method =RequestMethod.GET)
//	public String index() {
//		return "welcome";
//	}

//	@Autowired
//	ServiceInsert insertservice;
//	@PostMapping(value = "/insert")
//	public String Insert(@RequestBody Register registerModel) {
//		return insertservice.Insert(registerModel);
//	}

	@Autowired
	ServiceUpdate serviceupdate;

	@PutMapping(value = "/update")
	public String Update(@RequestBody Register registerModel) {
		return serviceupdate.Update(registerModel);
	}

	@Autowired
	ServiceDelete servicedelete;

	@DeleteMapping(value = "/delete")
	public String Delete(@RequestBody Register registerModel) {
		return servicedelete.Delete(registerModel);
	}

	@Autowired
	ServiceSearch serviceSearch;
	@GetMapping(value = "/searching")
	public List<Register> searchservice1(@RequestParam int id) {
		return serviceSearch.SearchById(id);
	}

}
