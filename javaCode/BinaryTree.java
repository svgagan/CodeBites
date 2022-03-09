package javaCode;

// Java program to find sum of all left leaves
class Node {
	int data;
	Node left, right;

	Node(int item){
		data = item;
		left = right = null;
	}
}

class BinaryTree {
	public static Node root;

	// A utility function to check if a given node is leaf or not
	boolean isLeaf(Node node) {
		if (node == null)
			return false;
		if (node.left == null && node.right == null)
			return true;
		return false;
	}

	// This function returns sum of all left leaves in a given binary tree
	int leftLeavesSum(Node node){
		// Initialize result
		int res = 0;

		// Update result if root is not NULL
		if (node != null){
			// If left of root is NULL, then add key of
			// left child
			if (isLeaf(node.left))
				res += node.left.data;
			else // Else recur for left child of root
				res += leftLeavesSum(node.left);

			// Recur for right child of root and update res
			res += leftLeavesSum(node.right);
		}
		// return result
		return res;
	}
	
	// This function returns sum of leaves in a given binary tree
	int sumOfNodes(Node node){
		// Initialize result
		int res = 0;
		if (node != null){
			return node.data + sumOfNodes(node.left) + sumOfNodes(node.right);
		}
		return res;
	}

	// Driver program
	public static void main(String args[]){
		BinaryTree tree = new BinaryTree();
		tree.root = new Node(20);//root
		tree.root.left = new Node(9);//left
		tree.root.right = new Node(49);//right
		tree.root.left.right = new Node(12);
		tree.root.left.left = new Node(5);
		tree.root.right.left = new Node(23);
		tree.root.right.right = new Node(52);
		tree.root.left.right.right = new Node(15);
		tree.root.right.right.left = new Node(50);
		System.out.println("The sum of leaves is " +tree.leftLeavesSum(tree.root));
		System.out.println("The sum of all nodes is " +tree.sumOfNodes(tree.root));
	}
}

