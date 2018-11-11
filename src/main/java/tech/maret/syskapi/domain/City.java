package tech.maret.syskapi.domain;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
public class City {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	long idCity;
	String nameCity;
	@ManyToOne
	@JsonIgnore
	@JoinColumn(name="idCountry")
	Country country;
	@OneToMany(cascade = CascadeType.ALL, mappedBy = "city")
	List<Place> places;
	
	public City() {
	}

	public City(String nameCity, Country country) {
		this.nameCity = nameCity;
		this.country = country;
	}

	public long getIdCity() {
		return idCity;
	}

	public void setIdCity(long idCity) {
		this.idCity = idCity;
	}

	public String getNameCity() {
		return nameCity;
	}

	public void setNameCity(String nameCity) {
		this.nameCity = nameCity;
	}

	public Country getCountry() {
		return country;
	}

	public void setCountry(Country country) {
		this.country = country;
	}

	public List<Place> getPlaces() {
		return places;
	}

	public void setPlaces(List<Place> places) {
		this.places = places;
	}

	@Override
	public String toString() {
		return nameCity + ", " + country;
	}
	
	
	
	
}
