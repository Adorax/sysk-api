package tech.maret.syskapi.domain;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

@Entity
public class User {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	long idUser;
	String username;
	
	@OneToMany(cascade = CascadeType.ALL, mappedBy = "user")
	List<Rate> rates;

	/**
	 * 
	 */
	public User() {
	}

	/**
	 * @param username
	 */
	public User(String username) {
		this.username = username;
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
	
	
}
