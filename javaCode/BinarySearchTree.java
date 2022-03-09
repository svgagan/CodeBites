package javaCode;

import java.util.*;

/* Binary Search Tree Implementation in Java*/
class BinarySearchTree{

	class BNode{
		private int key;
		private BNode leftNode, rightNode;
		
		public BNode(int item){
			this.key = item;
			this.leftNode=this.rightNode=null;
		}
	}
	
	public static BNode root;
	public BinarySearchTree(int item){
		root = insertNode(item, null); //Inserting root element
	}
	
	//BST Insert New Node into Tree
	public BNode insertNode(int key,BNode root){
		if(root == null){
			return root = new BNode(key);
		}
		if(key < root.key){
			root.leftNode = insertNode(key,root.leftNode);	//Key value Smaller to parent node
		}else{ 
			root.rightNode = insertNode(key,root.rightNode); //Key value Greater or Equal to parent node
		}
		return root;
	}
	
	//BST In-Order Traversals (Prints Sorted Elements)
	public void inorderTraversal(BNode root){
		if(root != null){
			inorderTraversal(root.leftNode);
			System.out.println(root.key);
			inorderTraversal(root.rightNode);
		}
	}
	
	//BST Pre-Order Traversals
	public void preorderTraversal(BNode root){
		if(root != null){
			System.out.println(root.key);
			preorderTraversal(root.leftNode);
			preorderTraversal(root.rightNode);
		}
	}
	
	//BST Post-Order Traversals
	public void postorderTraversal(BNode root){
		if(root != null){
			postorderTraversal(root.leftNode);
			postorderTraversal(root.rightNode);
			System.out.println(root.key);
		}
	}
	
	//BST Searching Key
	public void searchBST(BNode root, int search){
		if(root == null){
			System.out.println(search+"-key is NOT present in BST");
		}else if(root.key == search){
			System.out.println(search+"-key is present in BST");
		}else if(search < root.key){
			searchBST(root.leftNode, search);
		}else{
			searchBST(root.rightNode, search);
		}
	}
	
	public static void main(String[] args){
		Scanner scan = new Scanner(System.in);
		System.out.println("Enter Root Key Of The Tree: ");
		BinarySearchTree bsTree = new BinarySearchTree(scan.nextInt());
		while(true){
			System.out.println("Select Operations to be performed:");
			System.out.println("0-Exit, 1:Insert, 2:In-Order, 3:Pre-Order, 4:Post-Order, 5:Search");
			int operation = scan.nextInt();
			switch(operation){
				case 1: System.out.println("Enter Next-Key to be inserted into tree: ");
						int key = scan.nextInt();
					    bsTree.insertNode(key, root);
						break;
				case 2: System.out.println("In-Order Traversal of Tree is: ");
						bsTree.inorderTraversal(root);
						break;
				case 3: System.out.println("Pre-Order Traversal of Tree is: ");
						bsTree.preorderTraversal(root);
						break;
				case 4: System.out.println("Post-Order Traversal of Tree is: ");
						bsTree.postorderTraversal(root);
						break;
				case 5: System.out.println("Enter Key to be searched in BSTree: ");
						bsTree.searchBST(root,scan.nextInt());
						break;
				default: System.out.println("BST says Bye.,"); break;
			}
			if(operation == 0){
				break;
			}
		}
	}
}