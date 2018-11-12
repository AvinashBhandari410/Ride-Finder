package controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.servlet.ModelAndView;

import model.RegistrationModel;
import service.RegistrationManager;
import service.RidesManager;

@Controller
@RequestMapping("/registration")
public class RegistrationController {

	// Service RegistrationManager has been auto-wired so an object can create.
	@Autowired
	RegistrationManager registrationManager;
	@Autowired
	RidesManager rideManager;

	@RequestMapping(value = "/register", method = RequestMethod.POST)
	public ModelAndView register(@ModelAttribute RegistrationModel registration) {
	
		System.out.println(registration.toString());
		String existEmail=registration.getEmail();
		int existUserID = rideManager.getUserID(existEmail);
		ModelAndView model = new ModelAndView();
		if (existUserID == 0) {
			int userID = registrationManager.Register(registration);
			
			if (userID > 0) {
				model.addObject("message", "success");
				model.setViewName("login");
			} else {
				model.addObject("message", "fail");
				model.setViewName("registration");
			}
		}
		else {
			model.addObject("message", "exist");
			model.setViewName("registration");
		}

		model.addObject("loginModel", new RegistrationModel());

		return model;
	}

	@RequestMapping(value = "/register", method = RequestMethod.GET)
	public String register(Model model)
	{

		model.addAttribute("RegistrationModel", new RegistrationModel());
		return "registration";
	}
	
	@RequestMapping(value = "/logout", method = RequestMethod.GET)
	public ModelAndView logout(HttpServletRequest request) {
		request.getSession().invalidate();
		ModelAndView model = new ModelAndView("login", "loginModel", new RegistrationModel());
		model.addObject("message", "logout");
		return model;
	}
}