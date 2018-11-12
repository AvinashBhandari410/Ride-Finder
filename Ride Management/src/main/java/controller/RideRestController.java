package controller;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import model.RideModel;
import service.RidesManager;

@RestController
@RequestMapping("/riderest")
public class RideRestController {
	
	@Autowired
	RidesManager ridesManager;
	private List<RideModel> list;
	
	
	
	@GetMapping(value = "/getRide")
	public Response getResource(@RequestParam(value="rideID", defaultValue="rideID") int rideID) {
		List<RideModel> ride=ridesManager.getRideData(rideID);
		Response response = new Response("Done", ride);
		return response;
	}
}
