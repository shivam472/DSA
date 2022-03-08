import java.util.Queue;
import java.util.LinkedList;

/*
class Node {
    int data;
    Node left;
    Node right;
    
    Node(int data) {
        this.data = data;
    }
}
*/

public class BinarySearchTree {

    /*
    // recursive approach
    // time complexity: 
    // average case: O(log n)
    // worst case: O(n)
    // space complexity: O(h)
    // where 'h' is the height of the tree
    public Node insert(Node root, int key) {
        if(root == null) {
            return new Node(key);
        }

        if(key < root.data) {
            root.left = insert(root.left, key);
        }
        else if(key > root.data) {
            root.right = insert(root.right, key);
        }

        return root;
    }
    */

    // iterative approach
    // time complexity: 
    // average case: O(log n)
    // worst case: O(n)
    // space complexity: O(1)
    public Node insert(Node root, int key) {
        if(root == null) {
            return new Node(key);
        }

        Node newNode = new Node(key);
        Node curr = root;
        Node currParent = null;
        
        while(curr != null) {
            currParent = curr;
            if(key < curr.data)
                curr = curr.left;
            else
                curr = curr.right;
        }

        if(key < currParent.data)
            currParent.left = newNode;

        else
            currParent.right = newNode;
        
        return root;
    }

    public void search(Node root, int key) {
        if(root == null) {
            System.out.println("key: " + key + " not found");
            return;
        }

        Node curr = root;
        while(curr != null) {
            if(key == curr.data) {
                System.out.println("key: " + key + " found");
                return;
            }
            else if(key < curr.data) 
                curr = curr.left;
            else
                curr = curr.right;
        }

        System.out.println("key: " + key + " not found");
    }
    
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

    public static void main(String[] args) {
        BinarySearchTree bst = new BinarySearchTree();
        Node root = bst.insert(null, 8);
        bst.insert(root, 10);
        bst.insert(root, 3);
        bst.insert(root, 1);
        bst.insert(root, 6);
        bst.insert(root, 14);
        bst.insert(root, 4);
        bst.insert(root, 7);
        bst.insert(root, 13);
        bst.levelOrder(root);
        System.out.println();
        bst.search(root, 13);
        bst.search(root, 20);
    }
}
