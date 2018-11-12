package service;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import DataAccessObject.RidesDAO;
import model.RideModel;
import model.RideRegistrationModel;
import model.RideStates;

@Service
@Transactional
public class RidesManagerImpl implements RidesManager {

	@Autowired
	RidesDAO ridesDAO;

	// Method to save data into db.
	@Override
	public int RidePost(RideModel rideModel) {

		return ridesDAO.RidePost(rideModel);

	}

	// Method to log into GoMules.
	@Override
	// Method to get all the records from database.
	public List<RideRegistrationModel> GetAllAvailableRides(String todaysDate, String username, String searchRide) {

		return ridesDAO.GetAllAvailableRides(todaysDate, username, searchRide);
	}

	public List<RideStates> getStateList() {
		return ridesDAO.getStateList();
	}

	public int getUserID(String username) {
		return ridesDAO.getUserID(username);
	}

	public List<RideModel> getRideData(int rideIDParam) {
		return ridesDAO.getRideData(rideIDParam);
	}

	public int updateRide(RideModel rideModel) {
		return ridesDAO.updateRide(rideModel);
	}

	public List<RideRegistrationModel> GetMyPostingRides(String todaysDate, String username, String searchRide) {
		return ridesDAO.GetMyPostingRides(todaysDate, username, searchRide);
	}

}
