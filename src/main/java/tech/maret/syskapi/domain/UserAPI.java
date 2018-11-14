package tech.maret.syskapi.domain;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

import org.springframework.security.crypto.bcrypt.BCrypt;

@Entity
public class UserAPI {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id", nullable = false, updatable = false)
	long idUser;
	@Column(name = "username", nullable = false, unique = true)
	String username;
	@Column(name = "password", nullable = false)
	String passwordHash;
	@Column(name = "role", nullable = false)
	String role;

	/**
	 * 
	 */
	public UserAPI() {
	}

	/**
	 * @param username
	 * @param passwordHash
	 * @param role
	 */
	public UserAPI(String username, String passwordHash, String role) {
		this.username = username;
		this.passwordHash = BCrypt.hashpw(passwordHash, BCrypt.gensalt(10));		
		this.role = role;
	}

	/**
	 * @return the idUser
	 */
	public long getIdUser() {
		return idUser;
	}

	/**
	 * @param idUser the idUser to set
	 */
	public void setIdUser(long idUser) {
		this.idUser = idUser;
	}

	/**
	 * @return the username
	 */
	public String getUsername() {
		return username;
	}

	/**
	 * @param username the username to set
	 */
	public void setUsername(String username) {
		this.username = username;
	}

	/**
	 * @return the passwordHash
	 */
	public String getPasswordHash() {
		return passwordHash;
	}

	/**
	 * @param passwordHash the passwordHash to set
	 */
	public void setPasswordHash(String passwordHash) {
		this.passwordHash = BCrypt.hashpw(passwordHash, BCrypt.gensalt(10));
	}
	
	public void setPasswordWithoutHash(String passwordHash) {
		this.passwordHash = passwordHash;
	}

	/**
	 * @return the role
	 */
	public String getRole() {
		return role;
	}

	/**
	 * @param role the role to set
	 */
	public void setRole(String role) {
		this.role = role;
	}
	
	
}
