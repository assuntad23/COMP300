package binarySearchTree;

public interface Parent<Item> {
	
	/**
	 * Return left child if direction is negative and right child if direction is positive
	 */
	public BinaryNode<Item> getChild(int direction);
	
	/**
	 * Sets given node as left child or right child based on the value of direction, direction < 0  left child, direction > 0 right child
	 */
	public void setChild(int direction, BinaryNode<Item> child);
	
	
}
