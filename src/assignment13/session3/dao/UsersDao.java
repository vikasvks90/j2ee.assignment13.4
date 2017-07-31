package assignment13.session3.dao;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.ResultSetExtractor;

import assignment13.session3.bean.Users;

public class UsersDao {  
	private JdbcTemplate jdbcTemplate;  
	  
	public void setJdbcTemplate(JdbcTemplate jdbcTemplate) {  
	    this.jdbcTemplate = jdbcTemplate;  
	}  
  
	public List<Users> getAllUsers(){  
		return jdbcTemplate.query("select * from users",new ResultSetExtractor<List<Users>>(){  
	
		@Override
		public List<Users> extractData(ResultSet rs) throws SQLException, DataAccessException {
			List<Users> list=new ArrayList<Users>();  
	        while(rs.next()){  
	        Users users = new Users();  
	        users.setUserId(rs.getString(1));  
	        users.setUserName(rs.getString(2));  
	        users.setAddress(rs.getString(3)); 
	        users.setPassword(rs.getString(4));
	        list.add(users);  
	        }  
	        return list;
		}  
	    });  
	  }  
}  