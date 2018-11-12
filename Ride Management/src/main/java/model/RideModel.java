package model;

import java.sql.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "AvailableRides")
public class RideModel {
	@Id
	@Column(name = "RideID", unique = true, nullable = false)
	@GeneratedValue(strategy = GenerationType.SEQUENCE)
	private int rideID;

	@Column(name = "Source")
	private String source;

	@Column(name = "destination")
	private String destination;

	@Column(name = "RideTitle")
	private String rideTitle;

	@Column(name = "RideDescription")
	private String rideDescription;

	@Column(name = "VehicleName")
	private String vehicleName;

	@Column(name = "RideDate")
	private String rideDate;

	@Column(name = "IsRideAvailble")
	private boolean isRideAvailble;

	@Column(name = "UserID")
	private int userID;

	@Column(name = "PhoneNumber")
	private String phoneNumber;

	public String getContact() {
		return phoneNumber;
	}

	public void setContact(String contactNumber) {
		this.phoneNumber = contactNumber;
	}

	public void setRideID(int rideID) {
		this.rideID = rideID;
	}

	public int getRideID() {
		return rideID;
	}

	public int getUserID() {
		return userID;
	}

	public void setUserID(int userid) {
		this.userID = userid;
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

	public boolean getRideAvailble() {
		return isRideAvailble;
	}

	public void setRideAvailble(boolean isRideAvailble) {
		this.isRideAvailble = isRideAvailble;
	}

}
