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
    
}
