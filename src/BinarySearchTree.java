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

    public Node deleteNode(Node root, int key) {
        if(root == null) {
            return null;
        }

        // if key is in the left side of the tree
        // repeat the process for the left side of the tree
        // find the key, delete it and return the root of the modified subtree
        if(key < root.data) {
            root.left = deleteNode(root.left, key);
        }

        // if key is in the right side of the tree
        // repeat the process for the right side of the tree
        // find the key, delete it and return the root of the modified subtree
        else if(key > root.data) {
            root.right = deleteNode(root.right, key);
        }

        // if the current node has the key
        else {
            System.out.println(root.data + " deleted from the tree");

            // if the current node has no left child then return the right child
            if(root.left == null) {
                return root.right;
            }
            // else if the current node has no right child then return the left child
            else if(root.right == null) {
                return root.left;
            }

            // if the current node has both a left and a right child then
            // find the minimum value from the right subtree
            // replace the current node with the minimum value
            // delete the minimum value node in the right subtree
            else {
                root.data = findMinValue(root.right);
                root.right = deleteNode(root.right, root.data);
            }
        }

        return root;
    }
    
    public int findMinValue(Node root) {
        Node curr = root;

        // the minimum value is always present at the leaf node of the left subtree.
        while(curr.left != null) {
            curr = curr.left;
        }

        return curr.data; 
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
        bst.deleteNode(root, 3);
        bst.levelOrder(root);
    }
}
