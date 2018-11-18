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
public class Place {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id", nullable = false, updatable = false)
	long idPlace;
	@Column(name = "namePlace", nullable = false)
	String namePlace;
	@Column(name = "address", nullable = false)
	String address;
	@Column(name = "description", nullable = false, columnDefinition = "TEXT")
	String description;
	@ManyToOne
	@JsonIgnore
	@JoinColumn(name="idCity", nullable = false)
	City city;
	@OneToMany(cascade = CascadeType.ALL, mappedBy = "place")
	List<PlaceCategory> placeCategory;
	@OneToMany(cascade = CascadeType.ALL, mappedBy = "place")
	List<Pic> pics;
	@OneToMany(cascade = CascadeType.ALL, mappedBy = "place")
	List<Rate> rates;
	
	public Place() {
	}

	public Place(String namePlace, String address, String description, City city, List<PlaceCategory> placeCategory) {
		this.namePlace = namePlace;
		this.address = address;
		this.description = description;
		this.city = city;
		this.placeCategory = placeCategory;
	}

	public long getIdPlace() {
		return idPlace;
	}

	public void setIdPlace(long idPlace) {
		this.idPlace = idPlace;
	}

	public String getNamePlace() {
		return namePlace;
	}

	public void setNamePlace(String namePlace) {
		this.namePlace = namePlace;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public City getCity() {
		return city;
	}

	public void setCity(City city) {
		this.city = city;
	}

	public List<PlaceCategory> getTypePlace() {
		return placeCategory;
	}

	public void setTypePlace(List<PlaceCategory> placeCategory) {
		this.placeCategory = placeCategory;
	}

	public List<Pic> getPics() {
		return pics;
	}

	public void setPics(List<Pic> pics) {
		this.pics = pics;
	}

	public List<Rate> getRates() {
		return rates;
	}

	public void setRates(List<Rate> rates) {
		this.rates = rates;
	}
	
	
}
