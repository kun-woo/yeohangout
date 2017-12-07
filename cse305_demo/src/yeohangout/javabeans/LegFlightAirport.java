package yeohangout.javabeans;

public class LegFlightAirport {
	private Leg leg;
	private Airport depAirport;
	private Airport arrAirport;
	private Flight flight;
	private Fare fare;
	private int transfer;
	
	public LegFlightAirport(Leg leg, Airport depAirport, Airport arrAirport, Flight flight) {
		this.leg = leg;
		this.depAirport = depAirport;
		this.arrAirport = arrAirport;
		this.flight = flight;
	}
	
	public LegFlightAirport(Leg leg) {
		this.leg = leg;
	}
	public Leg getLeg() {
		return leg;
	}

	public void setLeg(Leg leg) {
		this.leg = leg;
	}

	public Airport getDepAirport() {
		return depAirport;
	}

	public void setDepAirport(Airport depAirport) {
		this.depAirport = depAirport;
	}

	public Airport getArrAirport() {
		return arrAirport;
	}

	public void setArrAirport(Airport arrAirport) {
		this.arrAirport = arrAirport;
	}

	public Flight getFlight() {
		return flight;
	}

	public void setFlight(Flight flight) {
		this.flight = flight;
	}
	
	
	public int getTransfer() {
		return transfer;
	}
	
	public void setTransfer(int transfer) {
		this.transfer = transfer;
	}
	
	public void setFare(Fare fare) {
		this.fare = fare;
	}
	
	public Fare getFare() {
		return fare;
	}

	
}
