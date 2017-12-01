package yeohangout.javabeans;

public class IncludeAndLeg {
	private Includes include;
	private Leg leg;
	
	public IncludeAndLeg(Includes include, Leg leg) {
		this.include = include;
		this.leg = leg;
	}

	public Includes getInclude() {
		return include;
	}

	public void setInclude(Includes include) {
		this.include = include;
	}

	public Leg getLeg() {
		return leg;
	}

	public void setLeg(Leg leg) {
		this.leg = leg;
	}
	
}
