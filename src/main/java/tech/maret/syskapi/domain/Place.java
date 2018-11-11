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
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "id", nullable = false, updatable = false)
	long idPlace;
	String namePlace;
	String address;
	String description;
	@ManyToOne
	@JsonIgnore
	@JoinColumn(name="idCity")
	City city;
	@ManyToOne
	@JsonIgnore
	@JoinColumn(name="idPlace")
	TypePlace typePlace;
	@OneToMany(cascade = CascadeType.ALL, mappedBy = "place")
	List<Pic> pics;
	@OneToMany(cascade = CascadeType.ALL, mappedBy = "place")
	List<Rate> rates;
	
	public Place() {
	}

	public Place(String namePlace, String address, String description, City city, TypePlace typePlace) {
		this.namePlace = namePlace;
		this.address = address;
		this.description = description;
		this.city = city;
		this.typePlace = typePlace;
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

	public TypePlace getTypePlace() {
		return typePlace;
	}

	public void setTypePlace(TypePlace typePlace) {
		this.typePlace = typePlace;
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
