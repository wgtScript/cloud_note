package note.test;

import java.util.List;
import java.util.Map;

import org.junit.Before;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import note.dao.JoinNoteDao;

public class TestJoinDao {
	ApplicationContext ac;
		@Before
		public void init() {
			ac = new ClassPathXmlApplicationContext("spring-web.xml");
		}
		@Test
		public void testList(){
			JoinNoteDao dao=ac.getBean("joinNoteDao",JoinNoteDao.class);
			//System.out.println(dao);
			String userId="39295a3d-cc9b-42b4-b206-a2e7fab7e77c";
			List<Map<String,Object>> list=dao.findNotesByUserId(userId);
			
			for(Map<String,Object> map:list){
				System.out.println(map.get("title"));
			}
			System.out.println(11111);
		}
}
