/**
 * 
 */
package binarySearchTree;

import binaryTree.EmptyStructureException;

/**
 * @author adesanto
 *
 */
public class BinarySearchTree<Item extends Comparable<Item>> implements Parent<Item>, Set<Item> {

	/* Root node*/
	protected BinaryNode<Item> root;

	private int count; 

	/* zero argument contsturctor*/
	public BinarySearchTree(){
		root = null;
	}

	@Override
	public BinarySearchTree<Item> add(Item target) {
		Parent<Item> parent = this;

		BinaryNode<Item> node = root;

		int comparison = 0;

		while(node !=null){
			comparison = target.compareTo(node.getItem());
			if (comparison < 0){
				parent = node;
				node = node.getLeft();
			} else if (comparison == 0)
				return this;
			if (comparison > 0){
				parent = node;
				node = node.getRight();
			}
		}
		parent.setChild(comparison, new BinaryNode<Item>(target));
		count += 1;
		return this;
	}

	@Override
	public boolean contains(Item target) {
		BinaryNode<Item> node = root;

		while(node !=null){
			int comparison = target.compareTo(node.getItem());
			if (comparison < 0){
				node = node.getLeft();
			} else if (comparison == 0)
				return true;
			if (comparison > 0){
				node = node.getRight();
			}
		}

		return false;
	}

	@Override
	public void remove(Item target) {
		Parent<Item> parent = this;
		BinaryNode<Item> node = root;
		int direction = 0;
		if (root == null)
			throw new EmptyStructureException();
		while (node != null){
			int comparison = target.compareTo(node.getItem());

			if (comparison < 0){
				parent = node;
				node = node.getLeft();
			} else if (comparison == 0){
				spliceOut(node, parent, direction);
				count --;
				return;
			} else if (comparison > 0){
				parent = node;
				node = node.getRight();
			}
			direction = comparison;
		}

	}

	protected void spliceOut(BinaryNode<Item> node, Parent<Item> parent, int direction){
		if (node.getLeft() == null){
			parent.setChild(direction, node.getRight());
		} else if (node.getRight() == null){
			parent.setChild(direction, node.getLeft());
		} else { 
			node.setItem(removeLeftmost(node.getRight(), node));
		}
	}



	private Item removeLeftmost(BinaryNode<Item> node, BinaryNode<Item> parent) {

		int direction = 1;

		while(node.getLeft() != null){
			parent = node;
			direction = -1;
			node = node.getLeft();
		}

		Item result = node.getItem();
		spliceOut(node, parent, direction);
		return result;
	}

	@Override
	public int size() {
		return getTreeSize(root);
	}
	
	private int getTreeSize(BinaryNode<Item> node){
		if (node == null)
			return 0;
		return 1 + getTreeSize(node.getLeft()) + getTreeSize(node.getRight());
	}

	@Override
	public BinaryNode<Item> getChild(int direction) {
		return root;
	}

	@Override
	public void setChild(int direction, BinaryNode<Item> child) {
		root = child;
	}

	public String toStringInOrder(){
		if (root == null)
			throw new EmptyStructureException();
		return root.toStringInOrder();
	}

	public String toStringLevelOrder(){
		if (root == null)
			throw new EmptyStructureException();
		return root.toStringLevelOrder();
	}

	public int getDepth() {
		return getDepthHelper(root);   
	}

	private int getDepthHelper(BinaryNode<Item> node){
		if (root == null)
			return 0;
		int rightDepth = 1;
		int leftDepth = 1;
		if (node.getLeft() != null){
			leftDepth = 1 + getDepthHelper(node.getLeft());
		} 
		if (node.getRight() != null){
			rightDepth = 1 + getDepthHelper(node.getRight());
		}
			
		if (leftDepth > rightDepth){
			return leftDepth;
		} else 
			return rightDepth;
	}
}
