package model;

public class RideRegistrationModel {
	private String email;

	private int rideID;

	private String source;

	private String destination;

	private String rideTitle;

	private String rideDescription;

	private String vehicleName;

	private String rideDate;
	
	private String phoneNumber;

	public String getContact() {
		return phoneNumber;
	}

	public void setContact(String contactNumber) {
		this.phoneNumber = contactNumber;
	}


	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public int getRideID() {
		return rideID;
	}

	public void setRideID(int rideID) {
		this.rideID = rideID;
	}

	public String getSource() {
		return source;
	}

	public void setSource(String source) {
		this.source = source;
	}

	public String getDestination() {
		return destination;
	}

	public void setDestination(String destination) {
		this.destination = destination;
	}

	public String getRideTitle() {
		return rideTitle;
	}

	public void setRideTitle(String rideTitle) {
		this.rideTitle = rideTitle;
	}

	public String getRideDescription() {
		return rideDescription;
	}

	public void setRideDescription(String rideDescription) {
		this.rideDescription = rideDescription;
	}

	public String getVehicleName() {
		return vehicleName;
	}

	public void setVehicleName(String vehicleName) {
		this.vehicleName = vehicleName;
	}

	public String getRideDate() {
		return rideDate;
	}

	public void setRideDate(String rideDate) {
		this.rideDate = rideDate;
	}

}
