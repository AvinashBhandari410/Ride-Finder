package service;

import java.util.List;

import model.RideModel;
import model.RideRegistrationModel;
import model.RideStates;

public interface RidesManager {

	// Method to save data into database.
	public int RidePost(RideModel rideModel);

	// Method to get all the records from database.
	public List<RideRegistrationModel> GetAllAvailableRides(String todaysDate, String username, String searchRide);

	public List<RideRegistrationModel> GetMyPostingRides(String todaysDate, String username, String searchRide);

	// get all the states list
	public List<RideStates> getStateList();

	public int getUserID(String username);

	public List<RideModel> getRideData(int rideIDParam);

	public int updateRide(RideModel rideModel);
}
