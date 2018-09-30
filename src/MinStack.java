public class MinStack extends Stack {

    private Stack minStack = new Stack();
    private Node min;
    private Node top;

    private static class Node {

        private Object data;
        private Node next;

        private Node(Object data) {
            this.data = data;
        }
    }

    //Overriden method push
    public void push(Object data) {
        Node n = new Node(data);
        n.next = top;
        top = n;

        //Base case for min
        if (min == null) min = top;

        if ((int)top.data < (int)min.data) { //Assuming we're dealing with ints
            min = top;
        }
        minStack.push(min.data);
    }

    public Object pop() {
        if (top != null) {
            Object data = top.data;
            top = top.next;
            minStack.pop();
            return data;
        }
        return null;
    }

    public Object min() {
        return minStack.peek();
    }
}
