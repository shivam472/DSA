public class SinglyLinkedList {
    NodeSL head;
    NodeSL tail;

    public void insert(int data) {
        NodeSL newNode = new NodeSL(data);
        newNode.next = null;
        if(head == null) { 
            head = newNode;
            tail = newNode;
        }
        
        // if we don't take the tail node
        // else {
        //     NodeSL tempNode = head;
        //     while(tempNode.next != null) {
        //         tempNode = tempNode.next;
        //     }
        //     tempNode.next = newNode;
        // }

        // if we keep a tail poiter then insertion at end becomes easier
        else {
            tail.next = newNode;
            tail = newNode;
        }
        System.out.println(data + " inserted into the linked list");
    }

    public void insertAt(int index, int data) {
        NodeSL newNode = new NodeSL(data);
        newNode.next = null;
        
        if(head == null) {
            throw new Error("LinkedList index out of bounds");
        }
        if(index == 0) {
            newNode.next = head;
            head = newNode;
        }
        else {
            NodeSL tempNode = head;
            NodeSL prevNode = null;
            int count = 0;
            
            while(count != index) {
                if(tempNode == null) throw new Error("LinkedList index out of bounds");
                prevNode = tempNode;
                tempNode = tempNode.next;
                count++;
            }
            
            prevNode.next = newNode;
            newNode.next = tempNode;
            
        }
        System.out.println(data + " added at index " + index);
    }

    public void deleteAt(int index) {
        if(head == null) {
            throw new Error("LinkedList index out of bounds");
        }
        if(index == 0) {
            head = head.next;
        }
        else {
            int count = 1;
            NodeSL tempNode = head;
            NodeSL prevNode = head.next;
            
            while(count != index) {
                if(tempNode == null) throw new Error("LinkedList index out of bounds");
                prevNode = tempNode;
                tempNode = tempNode.next;
                count++;
            }
            prevNode.next = tempNode.next;
        }
        System.out.println("element deleted at index " + index);
    }

    public void print() {
        System.out.print("Linked List: ");
        if(head == null) {
            System.out.println("List is empty");
            return;
        }
        NodeSL tempNode = head;
        while(tempNode != null) {
            System.out.print(tempNode.data + " ");
            tempNode = tempNode.next;
        }
        System.out.println();
    }

    public static void main(String[] args) {
        SinglyLinkedList l1 = new SinglyLinkedList();
        l1.insert(2);
        l1.insert(4);
        l1.insert(6);
        l1.insert(8);
        l1.insert(10);
        l1.print();
        l1.insertAt(0, 0);
        l1.print();
        l1.insertAt(5, 12);
        l1.print();
        l1.deleteAt(0);
        l1.print();
        l1.deleteAt(5);
        l1.print();
    }
}
