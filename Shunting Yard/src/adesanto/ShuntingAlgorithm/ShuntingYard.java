package adesanto.ShuntingAlgorithm;

public class ShuntingYard {

	public static Queue<String> reversePolish(String expr) {

		ArrayStack<String> operatorsStack = new ArrayStack<>();
		ArrayQueue<String> finalQueue = new ArrayQueue<>();

		String[] tokens = expr.split("[\\s]+");

		for (String token : tokens) {
			if (token.matches("[0-9]+")) {
				finalQueue.enqueue(token);
			} else if ((token.matches("\\("))) {
				operatorsStack.push(token);
			} else {
				if (operatorsStack.isEmpty()) {
					operatorsStack.push(token);
				} else {
					if (token.matches("\\*|/") && operatorsStack.peek().matches("-|\\+|\\(")) {
						operatorsStack.push(token);
					} else if (token.matches("-|\\+") && operatorsStack.peek().matches("\\(")) {
						operatorsStack.push(token);
					} else if (token.matches("\\^")) {
						operatorsStack.push(token);
					} else if (token.matches("\\)")) {
						while (!operatorsStack.peek().equals("(")) {
							finalQueue.enqueue(operatorsStack.pop());
						}
						operatorsStack.pop();
					} else {
						finalQueue.enqueue(operatorsStack.pop());
						operatorsStack.push(token);
					}
				}
			}
		}

		while (!(operatorsStack.isEmpty())) {
			finalQueue.enqueue(operatorsStack.pop());
		}

		return finalQueue;
	}

	private static double compute(double top, double bottom, String operand) {
		double answer = 0;

		if (operand.equals("*"))
			answer = bottom * top;
		else if (operand.equals("/"))
			answer = bottom / top;
		else if (operand.equals("-"))
			answer = bottom - top;
		else if (operand.equals("+"))
			answer = bottom + top;
		else if (operand.equals("^"))
			answer = Math.pow(bottom, top);

		return answer;
	}

	public static Double evaluate(Queue<String> expr) {
		ArrayStack<Double> evaluateStack = new ArrayStack<>();

		while (!expr.isEmpty()) {
			String token = expr.dequeue();
			if (token.matches("[0-9]+")) {
				evaluateStack.push(Double.valueOf(token));
			} else {
				evaluateStack.push(compute(evaluateStack.pop(), evaluateStack.pop(), token));
			}
		}

		return evaluateStack.pop();
	}

	public static void main(String[] args) {

		// String input = INPUT.nextLine();
		String expr = "3 + 4 * 2 / ( 1 - 5 ) ^ 2 ^ 3";
		Queue<String> q = reversePolish(expr);
		for (String token : q)
			System.out.print(token + " ");
		System.out.println("\nThe result is " + evaluate(q));
	}

}