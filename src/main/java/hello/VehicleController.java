package hello;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

import org.json.JSONArray;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;

/**
 *
 * @author harsh patil
 */

@RestController
public class VehicleController {
	
	// gets the list of vehicle with price less than the queried price
	@RequestMapping("/getVehicle")
	public JSONArray getVehicle(@RequestParam(value = "price") int price) {
		System.out.println("inside");
		DataBaseHandler dbh = new DataBaseHandler();
		JSONArray jsonArray = new JSONArray(dbh.GET(price));
		return jsonArray;
	}

	// gets the avg cost of vehicles based on type and sorted
	@RequestMapping("/getAvgCostByType")
	public JsonNode getAvgCostByType() {
		DataBaseHandler dbh = new DataBaseHandler();
		ObjectMapper mapper = new ObjectMapper();
		Map<String, AvgCost> map = new HashMap<>();
		for (final AvgCost data: dbh.GET("0"))
		    map.put(data.getTerm(), data);
		JsonNode json = mapper.valueToTree(map);
		return json;
	}
	// gets the avg cost of vehicles based on brand and sorted
	@RequestMapping("/getAvgCostByBrand")
	public JsonNode getAvgCostByBrand() {
		DataBaseHandler dbh = new DataBaseHandler();
		ObjectMapper mapper = new ObjectMapper();
		Map<String, AvgCost> map = new HashMap<>();
		for (final AvgCost data: dbh.GET("1"))
		    map.put(data.getTerm(), data);
		JsonNode json = mapper.valueToTree(map);
		return json;
	}
	// gets the avg cost of vehicles based on engine and sorted
	@RequestMapping("/getAvgCostByEngine")
	public JsonNode getAvgCostByEngine() {
		DataBaseHandler dbh = new DataBaseHandler();
		ObjectMapper mapper = new ObjectMapper();
		Map<String, AvgCost> map = new HashMap<>();
		for (final AvgCost data: dbh.GET("2"))
		    map.put(data.getTerm(), data);
		JsonNode json = mapper.valueToTree(map);
		return json;
	}
	// gets the avg cost of vehicles based on color and sorted
	@RequestMapping("/getAvgCostByColor")
	public JsonNode getAvgCostByColor() {
		DataBaseHandler dbh = new DataBaseHandler();
		ObjectMapper mapper = new ObjectMapper();
		Map<String, AvgCost> map = new HashMap<>();
		for (final AvgCost data: dbh.GET("3"))
		    map.put(data.getTerm(), data);
		JsonNode json = mapper.valueToTree(map);
		return json;
	}
}