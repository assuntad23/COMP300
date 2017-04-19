package adesanto.linkedStructure;

import java.util.Iterator;

import adesanto.SandQ.EmptyStructureException;
import adesanto.SandQ.Queue;

public class LinkedQueue<Item> implements Queue<Item> {
	
	private int size = 0;
	private Node head = null;
	private Node tail;
	private class Node{
		Item item;
		Node next;
	}


	
	@Override
	public Iterator<Item> iterator() {
		Iterator<Item> iterator = new Iterator<Item>(){

			Node node = head;
			
			@Override
			public boolean hasNext() {
				return node !=null;
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
	public void enqueue(Item item) {
		Node node = new Node();
		node.item = item;
		node.next = null;
		
		if (head == null){
			head = node;
			tail = head;
			return;
		}
		
		tail.next = node;
		tail = node;
		size++;
	}

	@Override
	public Item dequeue() {
		if (isEmpty()){
			throw new EmptyStructureException();
		}
		
		Item item = head.item;
		head = head.next;
		size--;
		return item;
	}

	@Override
	public boolean isEmpty() {
		return size == 0;
	}

	@Override
	public int size() {
		return size;
	}
	
	@Override
	public String toString() {
		StringBuffer buffer = new StringBuffer();
		for (Item item: this){
			buffer.append(item + " ");
		}
		return buffer.toString();
	}

	public static void main(String[] args) {
		Queue<String> queue = new LinkedQueue<>();
		queue.enqueue("It was");
		queue.enqueue("the best of");
		queue.enqueue("times;");
		queue.enqueue("It was");
		queue.enqueue("the worst of");
		queue.enqueue("times.");
		System.out.println("Dequeue: " + queue.dequeue());
		System.out.println("Queue contents: ");
		for (String s: queue){
			System.out.println(s);
		}
		
	}

}
