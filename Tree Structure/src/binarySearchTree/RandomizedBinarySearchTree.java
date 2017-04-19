package binarySearchTree;

public class RandomizedBinarySearchTree<E extends Comparable<E>> extends BinarySearchTree<E> {
	
	public static boolean bernoulli(double p){
		if (p > 1.0)
			p = 1.0;
		return Math.random() < p;
	}
	
	public BinaryNode<E> rotateLeft(BinaryNode<E> node){
		//involves node and its right child
		BinaryNode<E> v = node.getRight(); // get right child of the node		
		node.setRight(v.getLeft()); // the nodes right sub tree becomes the child's left sub tree
		v.setLeft(node);
		return v;
	}
	
	public BinaryNode<E> rotateRight(BinaryNode<E> node){
		//involves node and its left child
		BinaryNode<E> v = node.getLeft(); //get left child of the node
		node.setLeft(v.getRight()); // the nodes left sub tree becomes the child's right sub tree
		v.setRight(node);
		return v;
	}
	
	private BinaryNode<E> addRoot (BinaryNode<E> node, E target){
		if (node == null){
			return new BinaryNode<E>(target);
		}
		int comparison = target.compareTo(node.getItem());
		if (comparison < 0){
			node.setLeft(addRoot(node.getRight(), target));
			node = rotateRight(node);
		} else if (comparison > 0){
			node.setRight(addRoot(node.getLeft(), target));
			node = rotateLeft(node);
		}
		
		return node;
	}
	
	@Override
	public BinarySearchTree<E> add(E target) {
		BinaryNode<E> node = root;
		//toss the coin
		double n = 1.0/(this.size() + 1.0);
		if(bernoulli(n)){
			root = addRoot(node, target);
		} else {
			super.add(target);
		}
		return this;
	}

}
