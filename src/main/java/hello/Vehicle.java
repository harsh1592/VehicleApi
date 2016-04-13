package hello;

/**
 *
 * @author harsh patil
 */
public class Vehicle {

	public String type;
	public int VIN;
	public String brand;
	public String color;
	public String engine_type;
	public int price;
	public int year;

	public Vehicle() {

	}

	public Vehicle(String type, int VIN, String brand, String color, String engine_type, int price, int year) {
		super();
		this.type = type;
		this.VIN = VIN;
		this.brand = brand;
		this.color = color;
		this.engine_type = engine_type;
		this.price = price;
		this.year = year;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public int getVIN() {
		return VIN;
	}

	public void setVIN(int vIN) {
		VIN = vIN;
	}

	public String getBrand() {
		return brand;
	}

	public void setBrand(String brand) {
		this.brand = brand;
	}

	public String getColor() {
		return color;
	}

	public void setColor(String color) {
		this.color = color;
	}

	public String getEngine_type() {
		return engine_type;
	}

	public void setEngine_type(String engine_type) {
		this.engine_type = engine_type;
	}

	public int getPrice() {
		return price;
	}

	public void setPrice(int price) {
		this.price = price;
	}

	public int getYear() {
		return year;
	}

	public void setYear(int year) {
		this.year = year;
	}

}
