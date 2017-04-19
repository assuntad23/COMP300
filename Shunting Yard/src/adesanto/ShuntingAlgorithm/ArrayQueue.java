package adesanto.ShuntingAlgorithm;

import java.util.Iterator;

public class ArrayQueue<Item> implements Queue<Item> {
	
	private int size;
	private Item[] data; 
	private int head = 0;
	
	
	@SuppressWarnings("unchecked")
	public ArrayQueue(){
		data = (Item[]) new Object[1];
		
	}
	
	private void resize(int length){
		int index = head;
		
		@SuppressWarnings("unchecked")
		Item[] temp = (Item[]) new Object[length];
		
		for (int i = 0; i<size; i++){
			temp[i] = data[index ++];
			index%= data.length;
		}
		data = temp;
		head = 0;
	}
	
	@Override
	public Iterator<Item> iterator() {
		Iterator<Item> iterator = new Iterator<Item>(){

			int n = 0;
			
			@Override
			public boolean hasNext() {
				return n < size;
			}

			@Override
			public Item next() {
				Item item = data[n+head];
				n = (n+1) % data.length;
				
				return item;
			}
			
		};
		
		return iterator;
	}

	@Override
	public void enqueue(Item item) {
		if (size == data.length){
			resize(data.length*2);
		}
		data[(head+size)% data.length] = item;
		size++;
	}

	@Override
	public Item dequeue() {
		if (size <= (data.length/4)){
			resize(data.length/2);
		}
		if (isEmpty())
			throw new EmptyStructureException();
		
		Item item = data[head];
		data[head] = null;
		head = (head + 1)% data.length;
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

	public static void main(String[] args) {
		Queue<String> queue = new ArrayQueue<>();
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