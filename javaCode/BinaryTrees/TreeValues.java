package javaCode.BinaryTrees;

import java.util.LinkedList;
import java.util.Queue;

public class TreeValues {

    public boolean findTargetNodeUsingDepthFirst(Node<Character> root, Character target){
        if(root == null)
            return false;

        if(root.data == target)
            return true;

        return findTargetNodeUsingDepthFirst(root.left, target) || findTargetNodeUsingDepthFirst(root.right, target);
    }

    public boolean findTargetNodeUsingBreadthFirst(Node<Character> root, Character target){
        if(root == null)
            return false;

        Queue<Node<Character>> nodeQueue = new LinkedList<>();
        nodeQueue.add(root);
        while (!nodeQueue.isEmpty()){
            Node<Character> currentNode = nodeQueue.poll();
            if(currentNode.data == target)
                return true;

            if(currentNode.left != null)
                nodeQueue.add(currentNode.left);

            if(currentNode.right != null)
                nodeQueue.add(currentNode.right);
        }

        return false;
    }

    public static void main(String[] args){
        TreeValues treeTraversal = new TreeValues();

        Node<Character> root = new Node<>('A');
        root.left = new Node<>('B');
        root.right = new Node<>('C');
        root.left.left = new Node<>('D');
        root.left.right = new Node<>('E');
        root.right.left = null;
        root.right.right = new Node<>('F');

        System.out.println("findTargetNodeUsingDepthFirst");
        System.out.println(treeTraversal.findTargetNodeUsingDepthFirst(root, 'E'));
        System.out.println(treeTraversal.findTargetNodeUsingDepthFirst(null, 'E'));

        System.out.println("\nfindTargetNodeUsingBreadthFirst");
        System.out.println(treeTraversal.findTargetNodeUsingBreadthFirst(root, 'E'));
        System.out.println(treeTraversal.findTargetNodeUsingBreadthFirst(null, 'E'));

    }
}
