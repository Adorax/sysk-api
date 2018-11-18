package tech.maret.syskapi.domain;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

@Entity
public class Category {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id", nullable = false, updatable = false)
	long idCategory;
	@Column(name = "categoryName", nullable = false)
	String categoryName;
	
	@OneToMany(cascade = CascadeType.ALL, mappedBy = "category")
	List<PlaceCategory> placeCategory;
	
	/**
	 * construct
	 */
	public Category() {
	}
	
	/**
	 * @param typePlaceName
	 */
	public Category(String categoryName) {
		this.categoryName = categoryName;
	}

	/**
	 * @return the idCategory
	 */
	public long getIdCategory() {
		return idCategory;
	}

	/**
	 * @param idCategory the idCategory to set
	 */
	public void setIdCategory(long idCategory) {
		this.idCategory = idCategory;
	}

	/**
	 * @return the categoryName
	 */
	public String getCategoryName() {
		return categoryName;
	}

	/**
	 * @param categoryName the categoryName to set
	 */
	public void setCategoryName(String categoryName) {
		this.categoryName = categoryName;
	}

	/**
	 * @return the placeCategory
	 */
	public List<PlaceCategory> getPlaceCategory() {
		return placeCategory;
	}

	/**
	 * @param placeCategory the placeCategory to set
	 */
	public void setPlaceCategory(List<PlaceCategory> placeCategory) {
		this.placeCategory = placeCategory;
	}


	
	
}
