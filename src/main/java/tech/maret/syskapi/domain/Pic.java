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
public class Pic {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "id", nullable = false, updatable = false)
	long idPic;
	String linkPic;
	boolean isBanner;
	@ManyToOne
	@JsonIgnore
	@JoinColumn(name="idPlace")
	Place place;

	public Pic() {
	}

	public Pic(String linkPic, boolean isBanner, Place place) {
		this.linkPic = linkPic;
		this.isBanner = isBanner;
		this.place = place;
	}
	
	/**
	 * @return the idPic
	 */
	public long getIdPic() {
		return idPic;
	}


	/**
	 * @param idPic the idPic to set
	 */
	public void setIdPic(long idPic) {
		this.idPic = idPic;
	}


	/**
	 * @return the linkPic
	 */
	public String getLinkPic() {
		return linkPic;
	}


	/**
	 * @param linkPic the linkPic to set
	 */
	public void setLinkPic(String linkPic) {
		this.linkPic = linkPic;
	}


	/**
	 * @return the isBanner
	 */
	public boolean isBanner() {
		return isBanner;
	}


	/**
	 * @param isBanner the isBanner to set
	 */
	public void setBanner(boolean isBanner) {
		this.isBanner = isBanner;
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

	
	
}
