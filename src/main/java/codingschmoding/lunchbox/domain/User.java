package codingschmoding.lunchbox.domain;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonView;

@Entity
public class User {
	
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@JsonView(View.UserFilter.class)
	private long userId;
	
	private String userName;
	private String paswordHash;
	private String role;
	
	@OneToMany
	@JsonIgnore
	private List<User> users;
	
	public User() {
		
	}
	
	public User(String userName) {
		this.userName = userName;
	}
	
	public User(String userName, String paswordHash, String role) {
		super();
		this.userName = userName;
		this.paswordHash = paswordHash;
		this.role = role;
	}

	public long getUserId() {
		return userId;
	}

	public void setUserId(long userId) {
		this.userId = userId;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getPaswordHash() {
		return paswordHash;
	}

	public void setPaswordHash(String paswordHash) {
		this.paswordHash = paswordHash;
	}

	public String getRole() {
		return role;
	}

	public void setRole(String role) {
		this.role = role;
	}

	public List<User> getUsers() {
		return users;
	}

	public void setUsers(List<User> users) {
		this.users = users;
	}
	
	
	
	
}
