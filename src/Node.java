import java.util.ArrayList;
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

    public void printList(){    //Note: this does not work on a circular linkedlist!!

        Node n = this;

        while (n != null){
            System.out.print(n.data + " -> ");
            n = n.next;
        }
        System.out.println();
    }

    public static void deleteNode(Node n){  //Mistake: missed void

        if (n == null) return;

        if (n.next != null){
            n.data = n.next.data;
            n.next = n.next.next;
        }

    }

    public static int nthToLast(Node head, int k){  //Runtime O(n). Try it again... need more practice

        if (head == null){
            return 0;
        }

        int i = nthToLast(head.next, k) + 1;

        if (i == k){
            System.out.println("Node's value is: " + head.data);
        }
        return i;

    }

    public static Node findElementIterative(Node head, int k){     //Mistake: int not Int

        if (k < 1) return null;

        Node p1 = head;
        Node p2 = p1;
        int counter = 0;

        for (int i = 0; i < k; i++){
            p2 = p2.next;
        }

        while (p2 != null){
            counter++;
            p1 = p1.next;
            p2 = p2.next;
        }

        return p1;
    }

    public static Node findElement(Node head, int k){   //Runtime ~O(n)

        int length = 1;
        Node n = head;

        while (n.next != null){
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

    //This isn't single pass. We can just pass through the linked list once and improve the time complexity
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

    public static Node partition(Node head, int x)  //runtime of ~O(n), space of ~O(2n)
    {
        Boolean flag = false;
        Node start = new Node(x);

        Node front = start;
        Node back = start;

        Node n = head;

        while(n != null) {
            if (n.data >= x) {
                if (n.data == x && !flag)
                {
                    flag = true;

                } else {
                    Node newList = new Node(n.data);

                    front.next = newList;
                    front = newList;
                }
            } else {
                Node newList = new Node(n.data);

                newList.next = back;
                back = newList;
            }
            n = n.next;
        }
        return back;
    }

    public static Node addLinkedLists(Node firstList, Node secondList){ //Runtime of O(n) ??

        int addition = addHelper(firstList) + addHelper(secondList);
        return makeLinkedListFromNumber(addition);
    }

    public static int addHelper(Node list){

        Node n = list;
        int sum = 0;
        int multiplier = 1;

        while (n != null){
            sum = sum + n.data*multiplier;
            System.out.println("Sum is: " + sum);
            multiplier = multiplier*10;
            n = n.next; //Forgot to increment
        }
        return sum;
    }

    //Took help from this link:
    //https://stackoverflow.com/questions/3389264/how-to-get-the-separate-digits-of-an-int-number/3390244
    public static Node makeLinkedListFromNumber(int sum){

        int number = sum;
        Node result = new Node(number%10);
        number = number/10;

        while(number!=0){
            result.appendToTail(number%10);
            number = number/10;
        }
        return result;
    }

    public static Node createCircularLinkedList(){

        Node n1 = new Node(1);
        Node n2 = new Node(2);
        Node n3 = new Node(3);
        Node n4 = new Node(4);
        Node n5 = new Node(5);

        n1.next = n2;
        n2.next = n3;
        n3.next = n4;
        n4.next = n5;
        n5.next = n3;

        //System.out.println(n3.data);
        //System.out.println(n5.next.data);

        return n1;
    }

    public static Node detectLoop(Node list){

        HashMap<Node, Integer> duplicates = new HashMap<>();    //Cannot use int here!
        Node n = list;

        while(true){
            Integer count = (duplicates.get(n) != null) ? duplicates.get(n) : 0;
            count += 1;
            duplicates.put(n, count);   //count++ doesn't work since count will always be less than 1 since it is not updated!!
            if (count > 1){
                return n;
            }
            n = n.next;
            //System.out.println(duplicates);
        }
    }

    public static boolean checkLinkedListPalindrome(Node list){

        Node n = list;
        ArrayList<Integer> listArray = new ArrayList<>();

        //check for null or single element linked list
        if (list == null || list.next == null) return false;

        while(n != null){
            listArray.add(n.data);  //Method is add not append.
            n = n.next;
        }

        int rear = listArray.size()-1;  //there is no length() method on an arrayList. The correct method is size()
        for (int i = 0; i < listArray.size()/2; i++){
            if(listArray.get(i) != listArray.get(rear)){
                return false;
            }
            rear--;
        }
        return true;
    }

}