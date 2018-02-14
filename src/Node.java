import java.util.HashMap;
import java.util.Map;

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

    public Node deleteNode(Node head, int data){

        Node n = head;

        if(n.data == data){
            head = n.next;
        }

        while (n.next != null){
            if (n.next.data == data){
                n.next = n.next.next;
                return head;
            }
            n = n.next;
        }

        return head;

    }

    public void printList(){

        Node n = this;

        while (n != null){
            System.out.print(n.data + " -> ");
            n = n.next;
        }
        System.out.println();
    }

    public static Node findElement(Node head, int k){

        int length = 1;
        Node n = head;

        while (n != null){
            n = n.next;
            length++;
        }

        n = head;
        int steps = length - k;

        for (int i = 0; i < steps; i++){
            n = n.next;
        }

        return n;
    }


    public static void deleteDuplicatesNoBuffer(Node head){ //Runtime: O(n). Can do you this with 2 pointers

        Node start = head;
        Node prev = head;
        Node next = head.next;


        while (start != null){

            while (next != null){

                if (start.data == next.data){   //Mistake: have to compare data of nodes not nodes
                    prev.next = next.next;  //Mistake: assignment statement is = not ==
                    start.next = prev.next; //Mistake: forgot to do this
//                    System.out.println("Match!");
                }
                prev = next;
                next = next.next;
//                System.out.println("Inner=> Start: " + start.data);
//                System.out.println("Inner=> Prev: " + prev.data);
//                if (next != null) System.out.println("Inner=> Next: " + next.data);

            }

            start = start.next;
            prev = start;
            if (prev != null ) next = prev.next;    //Mistake: Null pointer

//            if (start != null) System.out.println("Start: " + start.data);
//            if (prev != null) System.out.println("Prev: " + prev.data);
//            if (next != null) System.out.println("Next: " + next.data);
        }
    }

    public static void deleteDuplicatesBetter(Node head){   //Runtime of ~O(n)

        Map<Integer, Boolean> map = new HashMap<>();
        Node n = head;
        Node previous = null;

        while(n != null){
            if (map.get(n.data) != null && map.get(n.data)){    //Mistake: Must check for null pointer exception
                previous.next = n.next; //Null pointer exception?
            } else {
                map.put(n.data, true);
                previous = n;   //Mistake: Had written previous outside of the loop
            }
            n = n.next; //Mistake: Had written this outside of the loop

        }

    }

    public static Node removeDuplicates(Node head){ //Runtime: O(n^2)??

        if (head.next == null) return head;

        Map<Integer, Integer> map = new HashMap<>();
        Node n = head;

        while (n.next != null){

            if (map.get(n.data) == null){
                map.put(n.data, 1);
            } else {
                map.put(n.data, map.get(n.data)+1);
            }
            n = n.next;
        }

        for (Integer i : map.keySet()){
            if (map.get(i) > 1){
                for (int j = 0; j < map.get(i); j++){
                    head = head.deleteNode(head, i);
                }

            }
        }

        return head;
    }

}