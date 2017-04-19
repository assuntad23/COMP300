/**
 * 
 */
package binaryTree;

import java.util.Iterator;

/**
 * @author adesanto
 *
 */
public class ArrayStack <Item> implements Stack <Item> {
	
	private Item[] data;
	private int size = 0;
	
	@SuppressWarnings("unchecked")
	public ArrayStack(){
		data = (Item[]) new Object[1];
		size = 0;
	}
	
	private boolean isFull(){
		return size == data.length;
	}
	
	@Override
	public boolean isEmpty(){
		return size ==0;
	}
	
	private void resize(int length){
		@SuppressWarnings("unchecked")
		Item[] temp = (Item[]) new Object[length];
		
		for (int i = 0; i < size; i++){
			temp[i] = data[i];
		}
		data = temp;
	}
	
	@Override
	public Item peek() {
		if (isEmpty())
			throw new EmptyStructureException();
		return data[size-1];
	}

	@Override
	public void push(Item item) {
		if (isFull())
			resize(data.length*2);
		data[size++] = item;
	}

	@Override
	public Item pop() {
		if (isEmpty())
			throw new EmptyStructureException();
		if (size <= data.length/4)
			resize(data.length/2);
		Item item = data[size-1];
		data[--size] = null;
		return item;
	}
	

	@Override
	public Iterator<Item> iterator() {
		Iterator<Item> iterator = new Iterator<Item>(){

			private int index = size;
			
			@Override
			public boolean hasNext() {
				return index > 0;
			}

			@Override
			public Item next() {
				return data[--index];
			}
			
		};
		return iterator;
	}
	public static void main(String[] args) {
		Stack<String> stack = new ArrayStack<>();
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
