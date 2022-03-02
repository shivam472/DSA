public class DoublyLinkedList {
    NodeDL head;
    NodeDL tail;

    public void insert(int data) {
        NodeDL newNode = new NodeDL(data);

        if(head == null) {
            head = newNode;
            tail = newNode;
        }

        else {
            newNode.prev = tail;
            tail.next = newNode;
            tail = newNode;
        }
        System.out.println(data + " inserted into the linked list");
    }

    public void insertAt(int index, int data) {
        NodeDL newNode = new NodeDL(data);
        
        if(head == null) {
            throw new Error("LinkedList index out of bounds");
        }
        if(index == 0) {
            newNode.next = head;
            head.prev = newNode;
            head = newNode;
        }
        else {
            NodeDL tempNode = head;
            int count = 0;
            
            while(count != index) {
                if(tempNode == null) throw new Error("LinkedList index out of bounds");
                tempNode = tempNode.next;
                count++;
            }
    
            newNode.next = tempNode;
            tempNode.prev.next = newNode;
            newNode.prev = tempNode.prev;
            tempNode.prev = newNode;
        }
        System.out.println(data + " added at index " + index);
    }

    public void deleteAt(int index) {
        if(head == null) {
            throw new Error("LinkedList index out of bounds");
        }
        if(index == 0) {
            head = head.next;
            head.prev = null;
        }
        
        else {
            NodeDL tempNode = head.next;
            int count = 1;
            
            while(count != index) {
                if(tempNode == null) throw new Error("LinkedList index out of bounds");
                tempNode = tempNode.next;
                count++;
            }
    
            tempNode.prev.next = tempNode.next;
            tempNode.next = tempNode.prev;
        }
        System.out.println("element deleted at index " + index);
    }

    public void print() {
        System.out.print("Linked List: ");
        if(head == null) {
            System.out.println("List is empty");
            return;
        }
        NodeDL tempNode = head;
        while(tempNode != null) {
            System.out.print(tempNode.data + " ");
            tempNode = tempNode.next;
        }
        System.out.println();
    }

    public static void main(String[] args) {
        DoublyLinkedList l1 = new DoublyLinkedList();
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
