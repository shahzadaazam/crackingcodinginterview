public class Node {  //Mistake: Class declaration is with {} brackets not () brackets

    Node next = null;
    int data;

    public Node(int data){
        this.data = data;
    }

    public void appendToTail(int data){

        Node end = new Node(data);
        Node n = this;

        while(n.next != null){
            n = n.next;
        }
        n.next = end;
    }

    public void printList(){

        Node n = this;

        while (n.next != null){
            System.out.print(n.data + " -> ");
            n = n.next;
        }
    }

}