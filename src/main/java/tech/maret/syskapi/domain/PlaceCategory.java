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

@Entity
public class PlaceCategory {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "id", nullable = false, updatable = false)
	long idPlaceCategory;
	@ManyToOne
	@JsonIgnore
	@JoinColumn(name="idPlace", nullable = false)
	Place place;
	@ManyToOne
	@JsonIgnore
	@JoinColumn(name="idCategory", nullable = false)
	Category category;


	/**
	 * construct
	 */
	public PlaceCategory() {
	}
	
	/**
	 * @param typePlaceName
	 */
	public PlaceCategory(Place place, Category category) {
		this.place = place;
		this.category = category;
	}

	/**
	 * @return the idPlaceCategory
	 */
	public long getIdPlaceCategory() {
		return idPlaceCategory;
	}

	/**
	 * @param idPlaceCategory the idPlaceCategory to set
	 */
	public void setIdPlaceCategory(long idPlaceCategory) {
		this.idPlaceCategory = idPlaceCategory;
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
	 * @return the category
	 */
	public Category getCategory() {
		return category;
	}

	/**
	 * @param category the category to set
	 */
	public void setCategory(Category category) {
		this.category = category;
	}

	
	
	
}
