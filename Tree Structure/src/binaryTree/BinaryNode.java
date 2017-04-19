package binaryTree;

public class BinaryNode<Item>{

	private Item item;
	private BinaryNode<Item> left;
	private BinaryNode<Item> right;
	public BinaryNode(Item item) {
		this.item = item;
	}
	public BinaryNode(Item item, BinaryNode<Item> left, BinaryNode<Item> right) {
		this.item = item;
		this.right = right;
		this.left = left;
	}

	public Item getItem() {
		return item;
	}

	public void setItem(Item item) {
		this.item = item;
	}

	public BinaryNode<Item> getLeft() {
		return left;
	}

	public void setLeft(BinaryNode<Item> left) {
		this.left = left;
	}

	public BinaryNode<Item> getRight() {
		return right;
	}

	public void setRight(BinaryNode<Item> right) {
		this.right = right;
	}
	
	public boolean isLeaf(){
		return (left == null) && (right == null);
	}
	
	public String toStringInOrder(){
		StringBuffer result = new StringBuffer();
		if (left != null){
			result.append(left.toStringInOrder());
		}
		
		result.append(item);
		
		if (right != null){
			result.append(right.toStringInOrder());
		}
		
		return result.toString();
	}
	
	public String toStringLevelOrder(){
		StringBuffer result = new StringBuffer();
		Queue<BinaryNode<Item>> queue = new ArrayQueue<>();
		
		queue.enqueue(this);
		while (! queue.isEmpty()){	
			BinaryNode<Item> node = queue.dequeue();
			result.append(node.getItem());
			if (node.left != null){
				queue.enqueue(node.left);		
			} 
			if (node.right!= null){
				queue.enqueue(node.right);
			}
		}
		
		return result.toString();
	}
	
	public String toStringDepthSearch(){
		StringBuffer result = new StringBuffer();
		Stack<BinaryNode<Item>> stack = new ArrayStack<>();
		
		stack.push(this);
		while(! stack.isEmpty()){
			BinaryNode<Item> node = stack.pop();
			result.append(node.getItem());
			if (node.right!= null){
				stack.push(node.right);
			}
			if (node.left != null){
				stack.push(node.left);		
			} 
			
		}
		
		return result.toString();
	}
	
	public static void main(String[] args) {
		BinaryNode<String> a = new BinaryNode<String>("a");
		BinaryNode<String> b = new BinaryNode<String>("b");
		BinaryNode<String> c = new BinaryNode<String>("c");
		BinaryNode<String> d = new BinaryNode<String>("d");
		BinaryNode<String> e = new BinaryNode<String>("e");
		BinaryNode<String> f = new BinaryNode<String>("f");
		BinaryNode<String> g = new BinaryNode<String>("g");
		a.setLeft(b);
		a.setRight(c);
		b.setLeft(d);
		b.setRight(e);
		c.setLeft(f);
		c.setRight(g);
		System.out.println(a.toStringInOrder());
		System.out.println(a.toStringLevelOrder());
		System.out.println(a.toStringDepthSearch());
	}

}

//Pre Order VLR
//In Order LVR
//Post Order LRV
