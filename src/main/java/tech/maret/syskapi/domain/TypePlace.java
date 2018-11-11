package tech.maret.syskapi.domain;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

@Entity
public class TypePlace {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	long idTypePlace;
	String typePlaceName;
	
	@OneToMany(cascade = CascadeType.ALL, mappedBy = "typePlace")
	List<Place> places;

	/**
	 * construct
	 */
	public TypePlace() {
	}
	
	/**
	 * @param typePlaceName
	 */
	public TypePlace(String typePlaceName) {
		this.typePlaceName = typePlaceName;
	}

	/**
	 * @return the idTypePlace
	 */
	public long getIdTypePlace() {
		return idTypePlace;
	}

	/**
	 * @param idTypePlace the idTypePlace to set
	 */
	public void setIdTypePlace(long idTypePlace) {
		this.idTypePlace = idTypePlace;
	}

	/**
	 * @return the typePlaceName
	 */
	public String getTypePlaceName() {
		return typePlaceName;
	}

	/**
	 * @param typePlaceName the typePlaceName to set
	 */
	public void setTypePlaceName(String typePlaceName) {
		this.typePlaceName = typePlaceName;
	}

	/**
	 * @return the places
	 */
	public List<Place> getPlaces() {
		return places;
	}

	/**
	 * @param places the places to set
	 */
	public void setPlaces(List<Place> places) {
		this.places = places;
	}
	
	
}
