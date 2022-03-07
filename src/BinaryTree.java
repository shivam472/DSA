import java.util.ArrayList;
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

// using linked list
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
        bt.search(root);
        bt.printLeftView(root);
        bt.printRightView(root);
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

    // level order search -> more efficient
    public void search(Node root) {
        System.out.println("Enter the element which you want to search for: ");
        int ele = sc.nextInt();

        if(root == null) {
            System.out.println("Element not found");
            return;
        }

        Queue<Node> q = new LinkedList<>();

        q.add(root);

        while(!q.isEmpty()) {
            Node curr = q.poll();

            if(curr.data == ele) {
                System.out.println("Element found");
                return;
            }

            if(curr.left != null) {
                q.add(curr.left);
            }
            if(curr.right != null) {
                q.add(curr.right);
            }
        }
        System.out.println("Element not found");
        return;
    }

    // height of a binary tree
    // find the height of the left subtree
    // find the height of the right subtree
    // find the maximum of both
    // add 1 to get the height of the whole tree
    public int height(Node root) {
        if(root == null) return 0;

        return Math.max(height(root.left), height(root.right)) + 1;
    }

    // size of a binary tree -> total number of nodes
    // find the size of the left subtree
    // find the size of the right subtree
    // add 1 to it to get the size of the whole tree
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

    // left view of a binary tree
    // time complexity -> O(n)
    public void printLeftView(Node root) {
        // take an array
        ArrayList<Node> list = new ArrayList<>();

        printLeftViewUtil(root, list, 0);

        System.out.println("Left view of Binary tree: ");
        for(Node curr : list) {
            System.out.print(curr.data + " ");
        }
        System.out.println();
    }

    private void printLeftViewUtil(Node root, ArrayList<Node> list, int level) {
        if(root == null) return;

        // if list size is equat to 0 that means no item has been
        // inserted into the list
        if(list.size() == level) {
            list.add(root);
        }

        // add the node to the array if and only if
        // the array at that level(index) is null
        if(list.get(level) == null) {
            list.add(root);
        }

        // if the array at the next level is null and
        // the root has a left child then
        // the left child will be added first
        // so that we can get the left view 
        printLeftViewUtil(root.left, list, level+1);

        printLeftViewUtil(root.right, list, level+1);
    }

    // right view of a binary tree
    // time complexity -> O(n)
    public void printRightView(Node root) {
        // take an array
        ArrayList<Node> list = new ArrayList<>();

        printRightViewUtil(root, list, 0);

        System.out.println("Right view of a binary tree: ");
        for(Node curr : list) {
            System.out.print(curr.data + " ");
        }
        System.out.println();
    }

    private void printRightViewUtil(Node root, ArrayList<Node> list, int level) {
        if(root == null) return;

        // if list size is equat to 0 that means no item has been
        // inserted into the list
        if(list.size() == level) {
            list.add(root);
        }

        // add the node to the list if and only if
        // the array at that level(index) is null
        if(list.get(level) == null) {
            list.add(root);
        }

        // if the array at the next level is null and
        // the root has a right child then
        // the right child will be added first
        // so that we can get the right view 
        printRightViewUtil(root.right, list, level+1);

        printRightViewUtil(root.left, list, level+1);
    }
    
}
