package hello;

public class AvgCost implements Comparable<AvgCost> {
	private String term;
	private double cost;

	public AvgCost(String term, double cost) {
		super();
		this.term = term;
		this.cost = cost;
	}

	public String getTerm() {
		return term;
	}

	public double getCost() {
		return cost;
	}

	@Override
	public int compareTo(AvgCost o) {
		// TODO Auto-generated method stub
		return Double.compare(this.cost, o.getCost());
	}
}
