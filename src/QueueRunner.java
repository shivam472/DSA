public class QueueRunner {
    public static void main(String[] args) {
        Queue q = new Queue();
        q.enqueue(5);
        q.enqueue(10);
        q.enqueue(15);
        q.enqueue(20);
        System.out.println("Front Element: " + q.peek());
        q.print();
        System.out.println("Element dequeued from the queue: " + q.dequeue());
        System.out.println("Front Element: " + q.peek());
        q.print();
        if(q.contains(15)) {
            System.out.println("element is present in the queue");
        }
        else {
            System.out.println("element is not present in the queue");
        }
        System.out.println("Queue size: " + q.size());
    }
}
