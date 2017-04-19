package binarySearchTree;

import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		BinarySearchTree<String> bst = new BinarySearchTree<>();
		Scanner kbd = new Scanner(System.in);
		System.out.println("Enter a string - ");
		String input = kbd.nextLine();
		
		String [] data = input.split("\\s+");
		
		for (String s: data){
			bst.add(s);
		}
		
		//print stringOrder, levelOrder, size, & depth
		
		System.out.println(bst.toStringInOrder());
		System.out.println(bst.toStringLevelOrder());
		System.out.println(bst.size());
		System.out.println(bst.getDepth());
		
		//remove code
		String more = kbd.nextLine();
		
		String [] moredata = more.split("\\s+");

		for (String s: moredata){
			bst.remove(s);
		}
	
		//print stringOrder, levelOrder, size, & depth
		System.out.println(bst.toStringInOrder());
		System.out.println(bst.toStringLevelOrder());
		System.out.println(bst.size());
		System.out.println(bst.getDepth());
		
		kbd.close();
		
	}

}
