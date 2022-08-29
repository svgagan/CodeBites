package javaCode.BinaryTrees;

import java.util.*;

public class TreeTraversal {

    public List<Character> recursiveDepthFirstTraverse(Node<Character> root, List<Character> depthList){
        if(root != null) {
            depthList.add(root.data);
            recursiveDepthFirstTraverse(root.left, depthList);
            recursiveDepthFirstTraverse(root.right, depthList);
        }
        return depthList;
    }

    public List<Character> depthFirstTraverse(Node<Character> root){
        List<Character> list = new ArrayList<>();
        Stack<Node<Character>> nodeStack = new Stack<>();
        if(root == null) {
            return list;
        }

        nodeStack.push(root);
        while(!nodeStack.empty()) {
            Node<Character> current = nodeStack.pop();
            list.add(current.data);
             if(current.right != null)
                 nodeStack.push(current.right);

             if(current.left != null)
                 nodeStack.push(current.left);

        }
        return list;
    }

    public List<Character> breadthFirstTraverse(Node<Character> root){
        List<Character> list = new ArrayList<>();
        Queue<Node<Character>> nodeQueue = new LinkedList<>();
        if(root == null)
            return list;

        nodeQueue.add(root);
        while (!nodeQueue.isEmpty()){
            Node<Character> currentNode = nodeQueue.poll();
            list.add(currentNode.data);

            if(currentNode.left != null)
                nodeQueue.add(currentNode.left);

            if(currentNode.right != null)
                nodeQueue.add(currentNode.right);
        }

        return list;
    }

    public static void main(String[] args){
        TreeTraversal treeTraversal = new TreeTraversal();

        Node<Character> root = new Node<>('A');
        root.left = new Node<>('B');
        root.right = new Node<>('C');
        root.left.left = new Node<>('D');
        root.left.right = new Node<>('E');
        root.right.left = null;
        root.right.right = new Node<>('F');

        System.out.println("depthFirstTraverse");
        System.out.println(treeTraversal.depthFirstTraverse(root));
        System.out.println(treeTraversal.depthFirstTraverse(null));

        System.out.println("recursiveDepthFirstTraverse");
        List<Character> depthList = new ArrayList<>();
        System.out.println(treeTraversal.recursiveDepthFirstTraverse(root, depthList));
        System.out.println(treeTraversal.depthFirstTraverse(null));

        System.out.println("\nbreadthFirstTraverse");
        System.out.println(treeTraversal.breadthFirstTraverse(root));
        System.out.println(treeTraversal.breadthFirstTraverse(null));

    }
}
