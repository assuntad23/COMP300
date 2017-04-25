package stringmatching;

public class Tester {

	public static void main(String[] args) {
		NaiveStringMatcher nm = new NaiveStringMatcher("canal");
		System.out.println("Match at " + nm.match("amanaplanacanalpanama"));
		
	}

}
