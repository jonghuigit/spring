package springbook.user.dao;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class DaoFactory {	// 설정 정보(: 어떤 객체를 생성해야 하는지 스프링 컨테이너에게 자료를 제공)를 제공할 목적 - 스프링 관점
	@Bean
	public UserDAO4 userDao() {
		return new UserDAO4(nConnectionMaker());
	}
	
	@Bean
	public AccountDAO accountDao() {
		return new AccountDAO(dConnectionMaker());
	}
	
	@Bean
	public MessageDAO messageDao() {
		return new MessageDAO(dConnectionMaker());
	}
	
	
	@Bean
	public ConnectionMaker nConnectionMaker() {
		return new NConnectionMaker();
	}
	@Bean
	public ConnectionMaker dConnectionMaker() {
		return new DConnectionMaker();
	}
	
}
