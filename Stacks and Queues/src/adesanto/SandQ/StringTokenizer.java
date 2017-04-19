package adesanto.SandQ;

public class StringTokenizer {

	public static void main(String[] args) {
		
		String expr = "( 1 + ( ( 2 + 3 ) * ( 4 * 5 ) ) )";
		
		String[] tokens = expr.split("\\s");
		
		for (String token: tokens){
			System.out.println(token);
		}
		
		//[0-9]; with a + at least one; with a * - Kleene Closure 
		//Kleene Closure null is included.
		//space [//s]+
		//system.match"[0-9]*[\.]*[0-9]*"
		}
}