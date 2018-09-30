public class ArrayStack {

    private int[] stackSpace;   //don't forget to use private/public
    private int stack1Top = 0;
    private int stack2Top = 100;
    private int stack3Top = 200;

    public ArrayStack() {
        stackSpace = new int[300];
    }

    public void push(int stackNum, int data) {
        switch (stackNum) {
            case 1:
                if (stack1Top < 100) {
                    stackSpace[stack1Top] = data;
                    if (stack1Top < 99) stack1Top++;
                } else {
                    System.out.println("Stack is full. Please pop some elements to make space");
                }
                break;

            case 2:
                if (stack2Top < 200) {
                    stackSpace[stack2Top] = data;
                    if (stack2Top < 199) stack2Top++;
                } else {
                    System.out.println("Stack is full. Please pop some elements to make space");
                }
                break;

            case 3:
                if (stack3Top < 300) {
                    stackSpace[stack3Top] = data;
                    if (stack3Top < 299) stack3Top++;
                } else {
                    System.out.println("Stack is full. Please pop some elements to make space");
                }
                break;
            default:
                System.out.println("Please choose a number between 1 to 3 for stackNum");
                break;

        }
    }

    public int pop (int stackNum) {
        switch (stackNum) {
            case 1:
                if (stack1Top >= 0) {
                    int data = stackSpace[stack1Top];
                    stack1Top--;
                    return data;
                } else {
                    System.out.println("Stack is empty. Cannot pop any items");
                }
                break;

            case 2:
                if (stack2Top >= 99) {
                    int data = stackSpace[stack2Top];
                    stack2Top--;
                    return data;
                } else {
                    System.out.println("Stack is empty. Cannot pop any items");
                }
                break;

            case 3:
                if (stack3Top >= 199) {
                    int data = stackSpace[stack3Top];
                    stack3Top--;
                    return data;
                } else {
                    System.out.println("Stack is empty. Cannot pop any items");
                }
                break;

            default:
                System.out.println("Please choose a number between 1 to 3 for stackNum");
                return 0;

        }
        return 0;
    }

    public int peek(int stackNum) {
        switch (stackNum) {
            case 1:
                if (stack1Top > 0) {
                    return stackSpace[stack1Top];
                } else {
                    System.out.println("Stack is empty");
                }
                break;

            case 2:
                if (stack2Top > 99) {
                    return stackSpace[stack2Top];
                } else {
                    System.out.println("Stack is empty");
                }
                break;

            case 3:
                if (stack3Top > 199) {
                    return stackSpace[stack3Top];
                } else {
                    System.out.println("Stack is empty");
                }
                break;

            default:
                System.out.println("Please choose a number between 1 to 3 for stackNum");
                return 0;

        }
        return 0;
    }


}
