import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

class Node {
    int data;
    Node left;
    Node right;

    Node(int data) {
        this.data = data;
        right = left = null;
    }
}

public class BinaryTree {
    Scanner sc = new Scanner(System.in);

    public static void main(String[] args) {
        BinaryTree bt = new BinaryTree();
        Node root = bt.createTree();
        System.out.println("InOrder traversal: ");
        bt.inOrder(root);
        System.out.println();
        System.out.println("PreOrder traversal: ");
        bt.preOrder(root);
        System.out.println();
        System.out.println("PostOrder traversal: ");
        bt.postOrder(root);
        System.out.println();
        System.out.println("LevelOrder traversal: ");
        bt.levelOrder(root);
        System.out.println();
        System.out.println("Height of the tree: " + bt.height(root));
        System.out.println("Maximum: " + bt.maximum(root));
        System.out.println("Minimum: " + bt.minimum(root));

    }

    public Node createTree() {
        Node root = null;
        System.out.println("Enter data: ");
        int data = sc.nextInt();

        if(data == -1) return null;

        root = new Node(data);

        System.out.println("Enter left for " + data);
        root.left = createTree();

        System.out.println("Enter right for " + data);
        root.right = createTree();

        return root;
    }

    // Tree traversal
    public void inOrder(Node root) {
        if(root == null) return;

        inOrder(root.left);
        System.out.print(root.data + " ");
        inOrder(root.right);
    }

    public void preOrder(Node root) {
        if(root == null) return;

        System.out.print(root.data + " ");
        preOrder(root.left);
        preOrder(root.right);
    }

    public void postOrder(Node root) {
        if(root == null) return;

        postOrder(root.left);
        postOrder(root.right);
        System.out.print(root.data + " ");
    }

    /*
     // time complexity for this approach -> O(n^2)
    public void levelOrder(Node root) {
        if(root == null) return;

        for(int i = 0;  i <= height(root); i++) {
            printCurrentLevel(root, i);
        }
    } 

    // function to print each level
    private void printCurrentLevel(Node root, int level) {
        if(root == null) return;

        if(level == 1) {
            System.out.print(root.data + " ");
        }
        else {
            printCurrentLevel(root.left, level-1);
            printCurrentLevel(root.right, level-1);
        }
    }
    */

    // this approach takes linear time - O(n)
    public void levelOrder(Node root) {
        if(root == null) return;

        Queue<Node> q = new LinkedList<>();
        q.offer(root);
        q.offer(null); // for printing each level in a new line
        
        while(!q.isEmpty()) {
            Node curr = q.poll();

            //for printing each level in a new line
            if(curr == null) {
                if(q.isEmpty()) return;

                q.offer(null);
                System.out.println();
                continue;
            }

            System.out.print(curr.data + " ");

            if(curr.left != null) {
                q.offer(curr.left);
            }

            if(curr.right != null) {
                q.offer(curr.right);
            }
        }
    }

    // height of a binary tree
    public int height(Node root) {
        if(root == null) return 0;

        return Math.max(height(root.left), height(root.right)) + 1;
    }

    // size of a binary tree -> total number of nodes
    public int size(Node root) {
        if(root == null) return 0;
        
        return size(root.left) + size(root.right) + 1;
    }

    // maximum in a binary tree
    public int maximum(Node root) {
        if(root == null) return Integer.MIN_VALUE;

        return Math.max(root.data, Math.max(maximum(root.left), maximum(root.right)));
    }

    // minimum in a binary tree
    public int minimum(Node root) {
        if(root == null) return Integer.MAX_VALUE;

        return Math.min(root.data, Math.min(minimum(root.left), minimum(root.right)));
    }
    
}
