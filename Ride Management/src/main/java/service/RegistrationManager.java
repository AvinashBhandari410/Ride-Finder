package service;

import java.util.List;

import model.RegistrationModel;
import model.RideModel;
import model.RideStates;

public interface RegistrationManager {

	//Method to save data into db.
	public int Register(RegistrationModel regModel);
	
	//Method to save data into db.
	public List<RegistrationModel> Login(RegistrationModel loginModel);
}
