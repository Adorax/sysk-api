package tech.maret.syskapi.domain;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.CascadeType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;


@Entity
public class Country {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	long idCountry;
	String nameCountry;
	
	@OneToMany(cascade = CascadeType.ALL, mappedBy = "country")
	List<City> cities;
	
	public Country() {
	}

	public Country(String nameCountry) {
		this.nameCountry = nameCountry;
	}

	public long getIdCountry() {
		return idCountry;
	}

	public void setIdCountry(long idCountry) {
		this.idCountry = idCountry;
	}

	public String getNameCountry() {
		return nameCountry;
	}

	public void setNameCountry(String nameCountry) {
		this.nameCountry = nameCountry;
	}

	public List<City> getCities() {
		return cities;
	}

	public void setCities(List<City> cities) {
		this.cities = cities;
	}

	@Override
	public String toString() {
		return nameCountry;
	}
	
	
}





	

	
	