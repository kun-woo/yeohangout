package yeohangout.mysql;

import java.util.ArrayList;

import yeohangout.javabeans.LegFlightAirport;

public class SingletonForMulticity {
	
	private static SingletonForMulticity singletonForMulticity=null;
	private static int count = 0;
	private static boolean valid = false;
	
	private static ArrayList<LegFlightAirport> firstLegs = null;  
	private static ArrayList<LegFlightAirport> secondLegs = null;  
	private static ArrayList<LegFlightAirport> thirdLegs = null;  
	
	private static LegFlightAirport firstLeg = null;
	private static LegFlightAirport secondLeg = null;
	private static LegFlightAirport thirdLeg = null;
	
	private SingletonForMulticity() {
		
	}
	
	public static SingletonForMulticity getSingletonForMulticity() {
		if(singletonForMulticity==null) {
			return new SingletonForMulticity();
		}
		
		return singletonForMulticity;
	}
	
	public static void increaseCount() {
		count++;
	}
	
	public static int getCount() {
		return count;
	}
	
	public static void clearSingleton() {
		singletonForMulticity = null;
		count  = 0;
		firstLegs = null;
		secondLegs = null;
		thirdLegs = null;
	}
	
	public static void setFirstLegs(ArrayList<LegFlightAirport> fl) {
		firstLegs = fl;
	}

	public static void setSecondLegs(ArrayList<LegFlightAirport> se) {
		secondLegs = se;
	}

	public static void setThirdLegs(ArrayList<LegFlightAirport> th) {
		thirdLegs = th;
	}

	public static ArrayList<LegFlightAirport> getFirstLegs() {
		return firstLegs;
	}

	public static ArrayList<LegFlightAirport> getSecondLegs() {
		return secondLegs;
	}

	public static ArrayList<LegFlightAirport> getThirdLegs() {
		return thirdLegs;
	}
	
	
	public static boolean isValid() {
		return valid;
	}
	
	public static void setValid(boolean v) {
		valid = v;
	}

	public static LegFlightAirport getFirstLeg() {
		return firstLeg;
	}

	public static void setFirstLeg(LegFlightAirport firstLeg) {
		SingletonForMulticity.firstLeg = firstLeg;
	}

	public static LegFlightAirport getSecondLeg() {
		return secondLeg;
	}

	public static void setSecondLeg(LegFlightAirport secondLeg) {
		SingletonForMulticity.secondLeg = secondLeg;
	}

	public static LegFlightAirport getThirdLeg() {
		return thirdLeg;
	}

	public static void setThirdLeg(LegFlightAirport thirdLeg) {
		SingletonForMulticity.thirdLeg = thirdLeg;
	}
	
	
	
	
	
}
