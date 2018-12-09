package tech.maret.syskapi.domain;

public class CreateRate {
	
	boolean rate; 
	long idUser;
	long idPlace;
	
	public CreateRate() {

	}

	/**
	 * @param rate
	 * @param idUser
	 * @param idPlace
	 */
	public CreateRate(boolean rate, long idUser, long idPlace) {
		this.rate = rate;
		this.idUser = idUser;
		this.idPlace = idPlace;
	}

	/**
	 * @return the rate
	 */
	public boolean isRate() {
		return rate;
	}

	/**
	 * @param rate the rate to set
	 */
	public void setRate(boolean rate) {
		this.rate = rate;
	}

	/**
	 * @return the idUser
	 */
	public long getIdUser() {
		return idUser;
	}

	/**
	 * @param idUser the idUser to set
	 */
	public void setIdUser(long idUser) {
		this.idUser = idUser;
	}

	/**
	 * @return the idPlace
	 */
	public long getIdPlace() {
		return idPlace;
	}

	/**
	 * @param idPlace the idPlace to set
	 */
	public void setIdPlace(long idPlace) {
		this.idPlace = idPlace;
	}
	
	
	
}
