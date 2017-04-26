package stringmatching;

public class Tester {

	public static void main(String[] args) {
		
		String test = "amanaplanacanalpanama";
		NaiveStringMatcher nm = new NaiveStringMatcher("canal");
		System.out.println("Match using Naive: " + nm.match(test));
		
		RabinKarpStringMatcher rk = new RabinKarpStringMatcher("plan");
		System.out.println("Match using RabinKarp: " + rk.match(test));
		
	}

}
