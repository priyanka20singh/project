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
public String insert(Register registerModel) {
	String sql="INSERT into Register(firstname, lastname, address ,contact, email) VALUES (:firstname, :lastname, :address, :contact, :email)";
	MapSqlParameterSource paramap=new MapSqlParameterSource();
	paramap.addValue("id",registerModel.getId());
	paramap.addValue("firstname",registerModel.getFirstname());
	System.out.println(registerModel.getFirstname());
	paramap.addValue("lastname",registerModel.getLastname());
	paramap.addValue("address",registerModel.getAddress());
	paramap.addValue("contact",registerModel.getContact());
	paramap.addValue("email",registerModel.getEmail());
	
	int i=namedParameterJdbcTemplate.update(sql, paramap);
	if(i==1)		
	return "index";
	else
	return "not inserted";
}

public String update(Register registerModel) {
	String sql ="UPDATE Register SET "
			+ "firstname=:firstname where id=:id";
	
	MapSqlParameterSource paramap = new MapSqlParameterSource();
	paramap.addValue("id",registerModel.getId());
	paramap.addValue("firstname",registerModel.getFirstname());
	int i=namedParameterJdbcTemplate.update(sql, paramap);
	 if(i==1)
		 return "Record Updated";
	 else
		 return "Record cannot be Updated";
}

public String delete(Register registerModel) {
String sql="Delete from Register where id=:id ";
	MapSqlParameterSource paramap=new MapSqlParameterSource();
	paramap.addValue("id",registerModel.getId());
	int i=namedParameterJdbcTemplate.update(sql, paramap);
	 if(i==1)
		 return "Record Deleted";
	 else
		 return "Record cannot be Deleted";
}

	public List<Register> searchById(int id) {
		String sql ="Select * from Register where id=:id";
		Map<String, Object> paramap=new HashMap<>();
		paramap.put("id", id);
			 return namedParameterJdbcTemplate.query(sql, paramap, BeanPropertyRowMapper.newInstance(Register.class));
	}

}
