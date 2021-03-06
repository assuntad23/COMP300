package adesanto.SandQ;

public interface Stack <Item> extends Iterable <Item> {
	
	public Item peek();
	public void push(Item item);
	public Item pop();
	public boolean isEmpty();

}
