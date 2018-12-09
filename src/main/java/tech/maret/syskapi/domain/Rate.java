package tech.maret.syskapi.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
public class Rate {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "id", nullable = false, updatable = false)
	long idRate;
	@ManyToOne
	@JsonIgnore
	@JoinColumn(name="idPlace")
	Place place;
	@ManyToOne
	@JsonIgnore
	@JoinColumn(name="idUser")
	User user;
	@Column(name = "likePlace", nullable = false)
	boolean likePlace;
	
	
	/**
	 * @return the idRate
	 */
	public long getIdRate() {
		return idRate;
	}

	/**
	 * @param idRate the idRate to set
	 */
	public void setIdRate(long idRate) {
		this.idRate = idRate;
	}

	/**
	 * 
	 */
	public Rate() {
	}

	/**
	 * Create a rate
	 * 		like true if thumb up and false if thumb down
	 */
	public Rate(Place place, User user, boolean likePlace) {
		this.place = place;
		this.user = user;
		this.likePlace = likePlace;
	}

	/**
	 * @return the place
	 */
	public Place getPlace() {
		return place;
	}

	/**
	 * @param place the place to set
	 */
	public void setPlace(Place place) {
		this.place = place;
	}

	/**
	 * @return the user
	 */
	public User getUser() {
		return user;
	}

	/**
	 * @param user the user to set
	 */
	public void setUser(User user) {
		this.user = user;
	}

	/**
	 * @return the like
	 */
	public boolean isLike() {
		return likePlace;
	}

	/**
	 * @param like the like to set
	 */
	public void setLike(boolean likePlace) {
		this.likePlace = likePlace;
	}
	
	
	
}
