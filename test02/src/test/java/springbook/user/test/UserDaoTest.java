package springbook.user.test;

import java.sql.SQLException;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.GenericXmlApplicationContext;

import springbook.user.dao.UserDAO5;
import springbook.user.domain.UserVO;

// Annotation 붙인 후 설정 정보를 XML을 이용하는 방법
// 1. xml(이 방법 선택) 2.Annotation 3. Java Class
public class UserDaoTest {
	public static void main(String[] args) throws ClassNotFoundException, SQLException {

		ApplicationContext context = new GenericXmlApplicationContext("application.xml");	
//		UserDAO4 dao = context.getBean("userDao", UserDAO4.class);	// 객체 정보 검색(DL: Dependency Lookup)
		UserDAO5 dao = context.getBean("userDao" /* xml의 bean id 태그 값과 일치해야함*/, UserDAO5.class);	// 객체 정보 검색(DL: Dependency Lookup)
	
		
		UserVO user = new UserVO();
		user.setId("gildong");
		user.setName("홍길동");
		user.setPassword("456");
		dao.add(user);
		
		System.out.println(user.getId() + " 등록 성공");	// dao Class의 add() 테스트
		
		UserVO user2 = dao.get(user.getId());
		System.out.println(user2.getId());		// DAO  Class의 get() 테스트
		System.out.println(user2.getName());		// DAO  Class의 get() 테스트
		System.out.println(user2.getPassword());	// DAO  Class의 get() 테스트
	}
}
