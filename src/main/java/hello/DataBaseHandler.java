package hello;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author patil
 */
/**
 * @author patil
 *
 */
public class DataBaseHandler {

	public ArrayList<Vehicle> vehicleList;

	/**
	 * Constructor to retrieve records from csv file
	 */
	public DataBaseHandler() {
		vehicleList = new ArrayList<Vehicle>();
		try {
			Scanner src = new Scanner(new File("Vehicles.csv"));
			src.nextLine();
			while (src.hasNext()) {
				String line = src.nextLine();				
				line.replace("/s", "");
				String[] tokens = line.split(",");

				// new vehicle object
				Vehicle v = new Vehicle();
				v.setType(tokens[0]);
				v.setVIN(Integer.parseInt(tokens[1]));
				v.setBrand(tokens[2]);
				v.setColor(tokens[3]);
				v.setEngine_type(tokens[4]);
				v.setPrice(Integer.parseInt(tokens[5]));
				v.setYear(Integer.parseInt(tokens[6]));

				// add vehicle object to the list
				vehicleList.add(v);
			}
			src.close();
		} catch (FileNotFoundException ex) {
			Logger.getLogger(DataBaseHandler.class.getName()).log(Level.SEVERE, null, ex);
		}
	}

	
	/**
	 * Get the list of vehicles by price
	 * 
	 * @param 	inputPrice
	 * @return 	responseList
	 */
	public ArrayList<String> GET(int inputPrice) {
		ArrayList<String> responseList = new ArrayList<>();
		for (Vehicle v : vehicleList) {
			if (v.price <= inputPrice) {
				responseList.add(v.getBrand());
			}
		}
		return responseList;
	}

	/**
	 * Get method to retrieve the average cost of vehicles based on query
	 * 
	 * @param 	query
	 * @return	responseList
	 */
	public ArrayList<AvgCost> GET(String query) {
		ArrayList<AvgCost> tempList = new ArrayList<>();
		if (query.equals("0")) {
			for (Vehicle v : vehicleList)
				tempList.add(new AvgCost(v.getType(), v.getPrice()));

		} else if (query.equals("1")) {
			for (Vehicle v : vehicleList)
				tempList.add(new AvgCost(v.getBrand(), v.getPrice()));
		} else if (query.equals("2")) {
			for (Vehicle v : vehicleList)
				tempList.add(new AvgCost(v.getEngine_type(), v.getPrice()));
		} else {
			for (Vehicle v : vehicleList)
				tempList.add(new AvgCost(v.getColor(), v.getPrice()));
		}
		ArrayList<AvgCost> responseList = getAverage(tempList);

		// sort the average list 
		Collections.sort(responseList);
		return responseList; // return the sorted list
	}

	/**
	 * Method to get the average of each type of vehicle
	 * 
	 * @param responseList
	 * @return
	 */
	private ArrayList<AvgCost> getAverage(ArrayList<AvgCost> responseList) {
		// TODO Auto-generated method stub
		ArrayList<AvgCost> avgList = new ArrayList<>();
		HashMap<String, ArrayList<Double>> hm = new HashMap<String, ArrayList<Double>>();

		// insert each items in a hashmap
		for (AvgCost item : responseList) {
			// create a new entry if not present
			if (!hm.containsKey(item.getTerm())) {
				ArrayList<Double> newList = new ArrayList<>();
				newList.add(item.getCost());
				hm.put(item.getTerm(), newList);
			} else {	// add the cost of new item to already existing list
				ArrayList<Double> temp = hm.get(item.getTerm());
				temp.add(item.getCost());
				hm.put(item.getTerm(), temp);
			}
		}
		
		// iterate over the hashmap and calculate the average of respective list
		Iterator it = hm.entrySet().iterator();
		while (it.hasNext()) {
			Map.Entry pair = (Map.Entry) it.next();
			ArrayList<Double> temp = (ArrayList<Double>) pair.getValue();
			Double sum = 0.0;
			for (Double i : temp) {
				sum += i;
			}
			double average = sum.doubleValue() / temp.size();
			avgList.add(new AvgCost(pair.getKey().toString(), average));
		}
		return avgList;
	}
}
