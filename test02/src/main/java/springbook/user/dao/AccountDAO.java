package springbook.user.dao;

public class AccountDAO {
	private ConnectionMaker connectionMaker; 

	public AccountDAO() {
		connectionMaker = new NConnectionMaker();
	}
	
	public AccountDAO(ConnectionMaker useConnectionMaker) {
		this.connectionMaker = useConnectionMaker;
	}
}
