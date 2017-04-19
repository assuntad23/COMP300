package adesanto.linkedStructure;
//called a singly linked list

import java.util.Iterator;

import adesanto.SandQ.EmptyStructureException;
import adesanto.SandQ.Stack;

public class LinkedStack <Item> implements Stack<Item> {

	private class Node{
		Item item;
		Node next;
	}
	
	private Node top;
	private int size;
	
	@Override
	public Iterator<Item> iterator() {
		
		Iterator<Item> iterator = new Iterator<Item>() {

			Node node = top;
			
			@Override
			public boolean hasNext() {
				return node != null;
			}

			@Override
			public Item next() {
				Item item = node.item;
				node = node.next;
				return item;
			}
			
		};
		
		return iterator;
	}

	@Override
	public Item peek() {
		if (isEmpty())
			throw new EmptyStructureException();
		return top.item;
	}

	@Override
	public void push(Item item) {
		Node temp = top;
		top = new Node();
		top.item = item;
		top.next = temp;
	}

	@Override
	public Item pop() {
		if (isEmpty())
			throw new EmptyStructureException();
		
		Item item = top.item;
		top = top.next;
		return item;
	}

	@Override
	public boolean isEmpty() {
		return size == 0;
	}
	
	public static void main(String[] args) {
		Stack<String> stack = new LinkedStack<>();
		stack.push("It was");
		stack.push("the best of");
		stack.push("Times");
		stack.push("It was");
		stack.push("the worst of");
		stack.push("Times");
		for (String s : stack)
			System.out.println(s);
	}

}
