public class BinarySearchTree {

    private int data;
    private BinarySearchTree left;
    private BinarySearchTree right;

    public BinarySearchTree(int data) {
        this.data = data;
        this.left = null;
        this.right = null;
    }

    public int getData() {
        return this.data;
    }

    public void insert(int data) {
        if (data < this.data) {
            if (left == null) {
                left = new BinarySearchTree(data);
            } else {
                this.left.insert(data);
            }
        } else if (data > this.data) {
            if (right == null) {
                right = new BinarySearchTree(data);
            } else {
                this.right.insert(data);
            }
        }
    }

    public boolean contains(int value) {
        if (value == data) {
            return true;
        } else if (value < data) {
            if (left == null) {
                return false;
            } else {
                return left.contains(value);    //Don't forget returns!
            }
        } else if (value > data) {
            if (right == null) {
                return false;
            } else {
                return right.contains(value);
            }
        } else {
            return false;
        }
    }

    public void printInOrder() {
        if (left != null) {
            left.printInOrder();
        }
        System.out.println(this.data);
        if (right != null) {
            right.printInOrder();
        }
    }

    public void printPreOrder() {
        System.out.println(this.data);
        if (left != null) {
            left.printInOrder();
        }
        if (right != null) {
            right.printInOrder();
        }
    }

    public void printPostOrder() {
        if (left != null) {
            left.printInOrder();
        }
        if (right != null) {
            right.printInOrder();
        }
        System.out.println(this.data);
    }

    public void DFS(int value) {

        if (value == data) {
            System.out.println("found!");
        }
        if (left != null) {
            left.DFS(value);
        }
        if (right != null) {
            right.DFS(value);
        }
    }

    public void BFS(int value) {

        Queue bfsQueue = new Queue();
        bfsQueue.push(this);

        while(!bfsQueue.isEmpty()) {
            BinarySearchTree bst = (BinarySearchTree) bfsQueue.pop();

            System.out.println(bst.data);
            if (value == bst.data) {
                System.out.println("found!");
            }
            if (bst.left != null) {
                //System.out.println(bst.left.data);
                bfsQueue.push(bst.left);
            }
            if (bst.right != null) {
                //System.out.println(bst.right.data);
                bfsQueue.push(bst.right);
            }
        }

    }

}
