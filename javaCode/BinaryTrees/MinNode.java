package javaCode.BinaryTrees;

public class MinNode {

    public int findMinInTree(Node<Integer> root){
        if(root == null){
            return Integer.MAX_VALUE;
        }
        int leftVal = Math.min(root.data, findMinInTree(root.left));
        int rightVal = Math.min(root.data, findMinInTree(root.right));
        return Math.min(leftVal, rightVal);
    }

    public int findMaxInTree(Node<Integer> root){
        if(root == null){
            return Integer.MIN_VALUE;
        }
        int leftVal = Math.max(root.data, findMaxInTree(root.left));
        int rightVal = Math.max(root.data, findMaxInTree(root.right));
        return Math.max(leftVal, rightVal);
    }

    public static void main(String[] args) {
        MinNode minNode = new MinNode();

        Node<Integer> a = new Node<>(3);
        Node<Integer> b = new Node<>(11);
        Node<Integer> c = new Node<>(4);
        Node<Integer> d = new Node<>(4);
        Node<Integer> e = new Node<>(2);
        Node<Integer> f = new Node<>(1);

        a.left = b;
        a.right = c;
        b.left = d;
        b.right = e;
        c.right = f;

        System.out.println("findMinInTree");
        System.out.println(minNode.findMinInTree(a));

        System.out.println("findMinInTree");
        System.out.println(minNode.findMaxInTree(a));
    }
}
