package note.test;

import org.junit.Before;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.web.servlet.view.InternalResourceViewResolver;

import note.dao.UserDao;
import note.entity.User;

public class TestUser {
	ApplicationContext ac;
//InternalResourceViewResolver
	@Before
	public void init() {
		ac = new ClassPathXmlApplicationContext("spring-web.xml");
	}

	@Test
	public void test() {
		UserDao dao = ac.getBean("userDao", UserDao.class);
		System.out.println(dao);
		User u=dao.findUserByName("wgt");
		System.out.println(u);
	
	}
}
