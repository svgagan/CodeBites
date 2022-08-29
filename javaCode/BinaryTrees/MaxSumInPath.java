package javaCode.BinaryTrees;

/**
 *
 *     3
 *    / \
 *   11  4
 *   / \  \
 *  4  2   1
 *
 *
 *
 * */
public class MaxSumInPath {

    public int findMaxSumPath(Node<Integer> root){
        if(root == null)
            return Integer.MIN_VALUE;

        // If it's a leaf node then return its value.
        if(root.left == null && root.right == null)
            return root.data;

        int leftSum = findMaxSumPath(root.left);
        int rightSum = findMaxSumPath(root.right);

        return root.data + Math.max(leftSum, rightSum);
    }

    public static void main(String[] args) {
        MaxSumInPath maxSumInPath = new MaxSumInPath();

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

        System.out.println("findMaxSumPath");
        System.out.println(maxSumInPath.findMaxSumPath(a));
        System.out.println(maxSumInPath.findMaxSumPath(b));
    }
}
