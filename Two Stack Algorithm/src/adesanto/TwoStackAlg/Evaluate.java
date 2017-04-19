package adesanto.TwoStackAlg;

public class Evaluate {
	
	public static double evaluate(String expr){
		
		ArrayStack<Double> operands = new ArrayStack<>();
		ArrayStack<String> operators = new ArrayStack<>();
	
		String[] tokens = expr.split("[\\s]+");
		
		for (String token: tokens){
			if (token.matches("[0-9]+")){
				operands.push(Double.valueOf(token));
			} else if (token.matches("\\*"))
				operators.push(token);
			else if (token.matches("-"))
				operators.push(token);
			else if (token.matches("\\+"))
				operators.push(token);
			else if (token.matches("/"))
				operators.push(token);
			else if (token.matches("sqrt"))
				operators.push(token);
			else if (token.matches("\\)")){
				if (operators.peek().equals("sqrt"))
					operands.push(computeSqRt(operands.pop(), operators.pop()));
				else 
					operands.push(compute(operands.pop(), operands.pop(), operators.pop()));
			}
		}
		
		return operands.pop();
	}
	
	private static double compute(double top, double bottom, String operand){
		double answer = 0;
		
		if (operand.equals("*"))
			answer = bottom * top;
		else if (operand.equals("/"))
			answer = bottom / top;
		else if (operand.equals("-"))
			answer = bottom - top;
		else if (operand.equals("+"))
			answer = bottom + top;
			
		return answer;
	}
	
	private static double computeSqRt(double top, String operand){
		double answer = 0;
		
		if (operand.equals("sqrt"))
			answer = Math.sqrt(top);
		
		return answer;
	}
	
	
	public static void main(String[] args){
		
		String expr = "( 1 + ( ( 2 + 3 ) * ( 4 * 5 ) ) )";
		String expr2 = "( sqrt ( 16 ) + 2 )";
		String expr3 = "( 4 / 2 )";

	    System.out.println(evaluate(expr));
	    System.out.println(evaluate(expr2));
	    System.out.println(evaluate(expr3));
	}
}