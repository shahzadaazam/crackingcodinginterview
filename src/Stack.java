public class Stack {

    private static class Node {

        private Object data;
        private Node next;

        private Node(Object data) {
            this.data = data;
        }
    }

    private Node top;

    public void push(Object data) {
        Node t = new Node(data);
        t.next = top;
        top = t;
    }

    public Object pop() {
        if (top != null) {
            Object data = top.data;
            top = top.next;
            return data;
        }
        return null;
    }

    public Object peek() {
        return top.data;
    }

    public void printStack() {

        Node n = top;

        while (n != null) {
            System.out.print(n.data + " -> ");
            n = n.next;
        }
        System.out.println();
    }
}
