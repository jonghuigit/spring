package springbook.user.domain;

import java.io.Serializable;

/**
 * @author Jeong Jonghui
 * @category UserVO
 */
public class UserVO implements Serializable{
	private String id;
	private String name;
	private String password;
	
	// 기본 생성자
	public UserVO() {
		
	}

	// Source > Generate Constructor using Fields
	public UserVO(String id, String name, String password) {
		super();
		this.id = id;
		this.name = name;
		this.password = password;
	}

	// Source > Generate Getters and Setters
	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	
	// Source > Generate hashCode() and equals()
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		result = prime * result + ((password == null) ? 0 : password.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		UserVO other = (UserVO) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		if (password == null) {
			if (other.password != null)
				return false;
		} else if (!password.equals(other.password))
			return false;
		return true;
	}

	// Source > Generate toString()
	@Override
	public String toString() {
		return "User [id=" + id + ", name=" + name + ", password=" + password + "]";
	}
	
	
}
