public class StackSet extends Stack {

    private int capacity;
    private int max;

    private Stack stackOfStacks;

    public StackSet(int max) {
        stackOfStacks = new Stack();
        stackOfStacks.push(new Stack());
        this.capacity = 0;
        this.max = max;
    }

    public void push(Object data) {
        if (capacity < max) {
            Stack current = (Stack)stackOfStacks.peek();
            current.push(data);
            capacity++;
        } else {
            Stack newStack = new Stack();
            newStack.push(data);
            stackOfStacks.push(newStack);
            capacity = 1;
        }
    }

    public Object pop() {
        if (capacity > 0) {
            return stackHelper();
        } else {
            if (!stackOfStacks.isEmpty()) {
                stackOfStacks.pop();
                if (!stackOfStacks.isEmpty()) {
                    capacity = max;
                    return stackHelper();
                } else {
                    return null;
                }
            } else {
                return null;
            }
        }
    }

    private Object stackHelper() {
        Stack current = (Stack)stackOfStacks.peek();
        Object data = current.pop();
        capacity--;
        return data;
    }


}
