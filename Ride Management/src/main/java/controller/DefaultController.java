package controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.servlet.ModelAndView;

import DataAccessObject.RegistrationDAO;
import DataAccessObject.RegistrationDAOImpl;
import model.RegistrationModel;
import model.RideModel;
import service.RegistrationManager;

// Deleted index.jsp page and now this controller taking care of the first request .
// No RequestMapping used on Controller.
// Used on the action.
@Controller
public class DefaultController {

	@Autowired
	RegistrationManager registrationManager;
	

	@RequestMapping(value = "/", method = RequestMethod.GET)
	public ModelAndView index() {

		return new ModelAndView("login", "loginModel", new RegistrationModel());
	}

	@RequestMapping(value = "/", method = RequestMethod.POST)
	@ModelAttribute("username")
	public ModelAndView login(HttpServletRequest request, @ModelAttribute RegistrationModel loginModel) {
		List<RegistrationModel> logindetails = registrationManager.Login(loginModel);

		ModelAndView model = new ModelAndView();
		if (logindetails.size() > 0) {
			request.getSession().setAttribute("username", loginModel.getEmail());
			model.addObject("loginDetails", logindetails);
			return new ModelAndView("redirect:" + "ride/availableRides", "searchRide", "none");
		} else {

			model.addObject("loginModel", new RegistrationModel());
			model.addObject("loginFailed", true);
			model.setViewName("login");
		}
		return model;
	}

}
