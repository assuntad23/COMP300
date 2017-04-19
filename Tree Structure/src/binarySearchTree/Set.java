package binarySearchTree;

public interface Set<Item> {
	
	/**
	 * Add an item to the set - avoid duplicates
	 */
	public Set<Item> add(Item target);
	
	/**
	 * Returns true if the set contains target
	 */
	public boolean contains(Item target);
	
	/**
	 * Remove target from set
	 */
	public void remove(Item target);
	
	/**
	 * Return the number of elements in this set
	 */
	public int size();

}
