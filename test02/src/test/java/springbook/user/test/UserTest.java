package springbook.user.test;

import java.sql.SQLException;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import springbook.user.dao.DaoFactory;
import springbook.user.dao.UserDAO4;
import springbook.user.domain.UserVO;

public class UserTest {

	public static void main(String[] args) throws ClassNotFoundException, SQLException {
//		UserDAO dao = new UserDAO();
//		UserDAO2 dao = new UserDAO2();
//		UserDAO3 dao = new NUserDAO();
//		UserDAO4 dao = new UserDAO4();	// 기본(N사의 오라클 기반 연결)
//		UserDAO4 dao = new UserDAO4(new NConnectionMaker());	// 생성자를 통해 DB 정보 주입
//		UserDAO4 dao = new DaoFactory().userDao();	// 팩토리 - Annotation 붙이기 전
		
		// Annotation 붙인 후 설정 정보를 Java Class를 이용하는 방법
		// 1. xml 2.Annotation 3. Java Class(이 방법 선택)
		ApplicationContext context = new AnnotationConfigApplicationContext(DaoFactory.class);	
		UserDAO4 dao = context.getBean("userDao", UserDAO4.class);	// 객체 정보 검색(DL: Dependency Lookup)

		
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

