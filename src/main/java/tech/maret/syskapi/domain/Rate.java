package tech.maret.syskapi.domain;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
public class Rate {
	
	@Id
	@ManyToOne
	@JsonIgnore
	@JoinColumn(name="idPlace")
	Place place;
	@Id
	@ManyToOne
	@JsonIgnore
	@JoinColumn(name="idUser")
	User user;
	boolean like;
	
	
	/**
	 * 
	 */
	public Rate() {
	}

	/**
	 * Create a rate
	 * 		like true if thumb up and false if thumb down
	 */
	public Rate(Place place, User user, boolean like) {
		this.place = place;
		this.user = user;
		this.like = like;
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
		return like;
	}

	/**
	 * @param like the like to set
	 */
	public void setLike(boolean like) {
		this.like = like;
	}
	
	
	
}
