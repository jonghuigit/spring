package springbook.user.dao;

public class MessageDAO {
	private ConnectionMaker connectionMaker; 

	public MessageDAO() {
		connectionMaker = new NConnectionMaker();
	}
	
	public MessageDAO(ConnectionMaker useConnectionMaker) {
		this.connectionMaker = useConnectionMaker;
	}
}
