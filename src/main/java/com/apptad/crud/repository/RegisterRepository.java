package com.apptad.crud.repository;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.stereotype.Repository;
import com.apptad.crud.model.Register;

@Repository
public class RegisterRepository {
	@Autowired
	NamedParameterJdbcTemplate namedParameterJdbcTemplate;

	// insert
	public String insert(Register registerModel) {
		String sql = "INSERT into Register(firstname, lastname, address ,contact, email) VALUES (:firstname, :lastname, :address, :contact, :email)";
		MapSqlParameterSource paramap = new MapSqlParameterSource();
		paramap.addValue("id", registerModel.getId());
		paramap.addValue("firstname", registerModel.getFirstname());
		System.out.println(registerModel.getFirstname());
		paramap.addValue("lastname", registerModel.getLastname());
		paramap.addValue("address", registerModel.getAddress());
		paramap.addValue("contact", registerModel.getContact());
		paramap.addValue("email", registerModel.getEmail());

		// email validation
		String q = registerModel.getEmail();
		String regex1 = "^[a-zA-Z0-9+_.-]+@[a-zA-Z0-9.-]+.com";
		boolean result1 = q.matches(regex1);

		// contact validation
		long p = registerModel.getContact();
		String p1 = String.valueOf(p);
		String regex = "[6789][0-9]{9}";
		boolean result = p1.matches(regex);
		if (result && result1) {
			System.out.println("valid number");
			int i = namedParameterJdbcTemplate.update(sql, paramap);
			if (i == 1)
				return "Record inserted Succefully";
			else
				return "Record cannot be inserted";
		} else
			return "not a valid number ";

	}

	// update
	public String update(Register registerModel) {
		String sql = "UPDATE Register SET " + "firstname=:firstname where id=:id";

		MapSqlParameterSource paramap = new MapSqlParameterSource();
		paramap.addValue("id", registerModel.getId());
		paramap.addValue("firstname", registerModel.getFirstname());
		int i = namedParameterJdbcTemplate.update(sql, paramap);
		if (i == 1)
			return "Record Updated";
		else
			return "Record cannot be Updated";
	}

	// delete
	public String delete(Register registerModel) {
		String sql = "Delete from Register where id=:id ";
		MapSqlParameterSource paramap = new MapSqlParameterSource();
		paramap.addValue("id", registerModel.getId());
		int i = namedParameterJdbcTemplate.update(sql, paramap);
		if (i == 1)
			return "Record Deleted";
		else
			return "Record cannot be Deleted";
	}

	// search by id
	public List<Register> searchById(int id) {
		String sql = "Select * from Register where id=:id";
		Map<String, Object> paramap = new HashMap<>();
		paramap.put("id", id);
		return namedParameterJdbcTemplate.query(sql, paramap, BeanPropertyRowMapper.newInstance(Register.class));
	}

}
