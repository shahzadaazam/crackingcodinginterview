public class Queue {

    private static class Node {

        private Object data;
        private Node next;

        public Node(Object data) {
            this.data = data;
        }
    }

    private Node tail;  //For adding elements
    private Node head;  //For removing elements

    public Queue(Object data) {
        Node n = new Node(data);
        tail = n;
        head = n;
    }

    public Queue() {
    }

    public void push(Object data) {
        Node n = new Node(data);
        if (tail != null) {
            tail.next = n;
        }
        tail = n;
        if (head == null) {
            head = n;
        }
    }

    public Object pop() {
        if (head != null) {
            Object data = head.data;
            head = head.next;
            return data;
        }
        return null;
    }

    public void printQueue() {
        Node n = head;
        while (n != null) {
            System.out.print(n.data + " -> ");
            n = n.next;
        }
        System.out.println();
    }

    public boolean isEmpty() {
        return head == null;
    }

}
