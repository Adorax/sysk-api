package tech.maret.syskapi.domain;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

import com.fasterxml.jackson.annotation.JsonIgnore;

public class PlaceObj {


	Place place;
	String nameCity;
	City city;
	List<Category> category;

	
	public PlaceObj() {
	}


	/**
	 * @param place
	 * @param nameCity
	 * @param city
	 * @param category
	 */
	public PlaceObj(Place place, String nameCity, City city, List<Category> category) {
		this.place = place;
		this.nameCity = nameCity;
		this.city = city;
		this.category = category;
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
	 * @return the nameCity
	 */
	public String getNameCity() {
		return nameCity;
	}


	/**
	 * @param nameCity the nameCity to set
	 */
	public void setNameCity(String nameCity) {
		this.nameCity = nameCity;
	}


	/**
	 * @return the city
	 */
	public City getCity() {
		return city;
	}


	/**
	 * @param city the city to set
	 */
	public void setCity(City city) {
		this.city = city;
	}


	/**
	 * @return the category
	 */
	public List<Category> getCategory() {
		return category;
	}


	/**
	 * @param category the category to set
	 */
	public void setCategory(List<Category> category) {
		this.category = category;
	}

	
	
}
