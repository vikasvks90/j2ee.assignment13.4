package assignment13.session3.app;

import java.util.List;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import assignment13.session3.bean.Users;
import assignment13.session3.dao.UsersDao;

public class TestUsers {
	private static ApplicationContext ctx;

	public static void main( String[] args ){
    	ctx = new ClassPathXmlApplicationContext("spring.xml");

    	UsersDao dao=(UsersDao)ctx.getBean("usersDao");  
        List<Users> list=dao.getAllUsers();  
              
        for(Users user:list)  
            System.out.println(user);  
              
        }  
}
