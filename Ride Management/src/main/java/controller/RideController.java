package controller;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Date;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;
import java.util.Map;

import javax.persistence.Convert;

import org.codehaus.jackson.map.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.SessionAttribute;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.servlet.ModelAndView;

import model.RegistrationModel;
import model.RideModel;
import model.RideRegistrationModel;
import service.RidesManager;

@Controller
@SessionAttributes("username")
@RequestMapping("/ride")
public class RideController {

	@Autowired
	RidesManager ridesManager;

	@RequestMapping(value = "/newpost", method = RequestMethod.POST)
	public ModelAndView newpost(@SessionAttribute("username") String username, @ModelAttribute RideModel ridePojo,
			@RequestParam("rideID") int rideID, @RequestParam("vehicleName") String vehicleName,
			@RequestParam("phoneNumber") String phoneNumber, @RequestParam("rideDate") String rideDate) {
		
		ModelAndView model = new ModelAndView();
		ridePojo.setRideAvailble(true);
		int userID = ridesManager.getUserID(username);

		int result = 0;
		if (userID > 0) {
			ridePojo.setUserID(userID);
			phoneNumber = phoneNumber.replace("(", "").replace(")", "").replace(" ", "").replace("-", "");
			if (rideID == 0) {
				// if employee id is 0 then creating the
				ridePojo.setContact(phoneNumber);
				result = ridesManager.RidePost(ridePojo);
				if (result > 0) {
					model.addObject("message", "success");
				} else {
					model.addObject("message", "fail");
				}
			} else {
				ridePojo.setRideID(rideID);
				ridePojo.setVehicleName(vehicleName);
				ridePojo.setContact(phoneNumber);
				ridePojo.setRideDate(rideDate);
				result = ridesManager.updateRide(ridePojo);
				if (result > 0) {
					return new ModelAndView("redirect:/ride/myRidePostings?searchRide=none");
					// model.setViewName("ridePostings");
				}
			}
		}
		else
		{
			model.addObject("message", "fail");
		}
		model.setViewName("postaRide");
		model.addObject("rideModel", new RideModel());
		return model;
	}

	@RequestMapping(value = "/newpost", method = RequestMethod.GET)
	public String newpost(Model model) {
		model.addAttribute("RideModel", new RideModel());
		return "postaRide";
	}

	@RequestMapping(value = "/availableRides", method = RequestMethod.GET)
	public String availableRides(@RequestParam("searchRide") String searchRide,
			@SessionAttribute("username") String username, Model model) {
		// what else and better we can use instead of this Model?
		System.out.println("searchRide: " + searchRide);
		String date = new SimpleDateFormat("yyyy-MM-dd").format(new Date());
		if (searchRide.equals("")) {
			searchRide = "none";
		}

		List<RideRegistrationModel> allRides = ridesManager.GetAllAvailableRides(date, username,
				searchRide.trim().toLowerCase());
		model.addAttribute("allRides", allRides);
		return "availablePostings";
	}

	@RequestMapping(value = "/myRidePostings", method = RequestMethod.GET)
	public String myRidePostings(@RequestParam("searchRide") String searchRide,
			@SessionAttribute("username") String username, Model model) {
		// what else and better we can use instead of this Model?
		System.out.println("searchRide: " + searchRide);
		String date = new SimpleDateFormat("yyyy-MM-dd").format(new Date());
		if (searchRide.equals("")) {
			searchRide = "none";
		}
		List<RideRegistrationModel> allRides = ridesManager.GetMyPostingRides(date, username,
				searchRide.trim().toLowerCase());
		model.addAttribute("allRides", allRides);
		return "ridePostings";
	}

	@RequestMapping(value = "/getRide/{rideID}", method = RequestMethod.GET)

	public @ResponseBody List<RideModel> welcome(@PathVariable("rideID") int rideID) throws Exception {
		List<RideModel> ride = ridesManager.getRideData(rideID);
		return ride;
	}
}