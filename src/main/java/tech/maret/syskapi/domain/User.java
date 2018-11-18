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
public class User {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id", nullable = false, updatable = false)
	long idUser;
	@Column(name = "username", nullable = false, unique = true)
	String username;
	@Column(name = "email", nullable = false, unique = true)
	String email;
	@Column(name = "password", nullable = false)
	String passwordHash;
	
	@OneToMany(cascade = CascadeType.ALL, mappedBy = "user")
	List<Rate> rates;

	/**
	 * 
	 */
	public User() {
	}

	/**
	 * @param username
	 * @param email
	 * @param passwordHash
	 * @param role
	 */
	public User(String username, String email, String passwordHash) {
		this.username = username;
		this.email = email;
		this.passwordHash = BCrypt.hashpw(passwordHash, BCrypt.gensalt(10));
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
	 * @return the rates
	 */
	public List<Rate> getRates() {
		return rates;
	}

	/**
	 * @param rates the rates to set
	 */
	public void setRates(List<Rate> rates) {
		this.rates = rates;
	}

	/**
	 * @return the email
	 */
	public String getEmail() {
		return email;
	}

	/**
	 * @param email the email to set
	 */
	public void setEmail(String email) {
		this.email = email;
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
	
	/**
	 * Set password already hash
	 * @param passwordHash the passwordHash to set
	 */
	public void setPasswordWithoutHash(String passwordHash) {
		this.passwordHash = passwordHash;
	}
	
}
