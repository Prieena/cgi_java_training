package com.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.ResultSetExtractor;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import com.bean.User;

@Repository
public class LoginDao {
	
	@Autowired
	JdbcTemplate jdbcTemplate;

	public int addUser(User user) {
		try {
			return jdbcTemplate.update("insert into login values(?,?,?)", user.getEmailId(),user.getPassword(),user.getTypeOfUser());
		} catch (Exception e) {
			System.err.println(e);
			return 0;
		}
	}
	
	public int getUsers(User user) {
		try {
			return jdbcTemplate.update("insert into login values(?,?,?)", user.getEmailId(),user.getPassword(),user.getTypeOfUser());
		} catch (Exception e) {
			System.err.println(e);
			return 0;
		}
	}
	
	public List<User> retrieveAllUsers() {
		try {
		//return jdbcTemplate.query("select * from product",new MyResultSetExtracter());
			return jdbcTemplate.query("select * from login", new MyRowMapper());
		} catch (Exception e) {
			System.err.println(e);
			return null;
		}
	}
}

class MyResultSetExtracter implements ResultSetExtractor<User>{
@Override
public User extractData(ResultSet rs) throws SQLException, DataAccessException {
	// TODO Auto-generated method stub
	return null;
}
}

// global while loop 
class MyRowMapper implements RowMapper<User>{
	@Override
	public User mapRow(ResultSet rs, int rowNum) throws SQLException {
		User user = new User();
		user.setEmailId(rs.getString(1));
		user.setPassword(rs.getString(2));
		user.setTypeOfUser(rs.getString(3));
		return user;
	}
}
