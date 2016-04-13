package hello;

import java.util.ArrayList;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author harsh patil
 */

@RestController
public class VehicleController {
	
	// gets the list of vehicle with price less than the queried price
	@RequestMapping("/getVehicle")
	public ArrayList<String> getVehicle(@RequestParam(value = "price") int price) {
		System.out.println("inside");
		DataBaseHandler dbh = new DataBaseHandler();
		return dbh.GET(price);
	}

	// gets the avg cost of vehicles based on type and sorted
	@RequestMapping("/getAvgCostByType")
	public ArrayList<AvgCost> getAvgCostByType() {
		DataBaseHandler dbh = new DataBaseHandler();
		return dbh.GET("0");
	}
	// gets the avg cost of vehicles based on brand and sorted
	@RequestMapping("/getAvgCostByBrand")
	public ArrayList<AvgCost> getAvgCostByBrand() {
		DataBaseHandler dbh = new DataBaseHandler();
		return dbh.GET("1");
	}
	// gets the avg cost of vehicles based on engine and sorted
	@RequestMapping("/getAvgCostByEngine")
	public ArrayList<AvgCost> getAvgCostByEngine() {
		DataBaseHandler dbh = new DataBaseHandler();
		return dbh.GET("2");
	}
	// gets the avg cost of vehicles based on color and sorted
	@RequestMapping("/getAvgCostByColor")
	public ArrayList<AvgCost> getAvgCostByColor() {
		DataBaseHandler dbh = new DataBaseHandler();
		return dbh.GET("3");
	}
}