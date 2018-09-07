import com.sun.org.apache.xpath.internal.operations.Bool;

import java.util.*;
import java.util.stream.Collectors;

public class main{


    public static void main(String[] args){
//        System.out.println("Hello World!");

        //TODO: Chapter 1 : Arrays and Strings


        //**************** Chapter 1 - pg 72 ****************
        //TODO: Create a HashTable

        Employee[] emps = {
                new Employee(1, "Azam", 29),
                new Employee(2, "Sidra", 28),
                new Employee(3, "Ahmad", 25)
        };

        HashMap<Integer, Employee> empMap = createMap(emps);

        System.out.println(empMap.get(1).getName());

        //***************************************************

        //**************** Chapter 1 - pg 72 ****************
        //TODO: Create a function that takes in two arrays and outputs an Arraylist

        Employee[] emps2 = {
                new Employee(4, "Ajlan", 32),
                new Employee(5, "Mazin", 29)
        };

        ArrayList<Employee> combinedResultEmps = joinArrays(emps, emps2);
        System.out.println(combinedResultEmps.get(4).getName());

        //***************************************************


        //**************** Chapter 1 - pg 72 ****************
        //TODO: Write a function to cancatenate strings stored in an array. Now use StringBuffer to improve the runtime.

        String[] words = {"hello", "my", "name", "is", "Azam"};

        String combinedWordsResult = joinStrings(words);

        System.out.println(combinedWordsResult);

        combinedWordsResult = joinStringsBuffer(words);

        System.out.println(combinedWordsResult);

        //***************************************************


        //**************** Chapter 1 - pg 73 ****************
        //TODO: Q1.1 Implement an algorithm to determine if a string has all unique characters. What if you cannot use additional data structures?

        String testString1 = "abcdefg";
        String testString2 = "azam";

        System.out.println("is String1 unique?: " + hasUnique(testString1));
        System.out.println("is String2 unique?: " + hasUnique(testString2));

        //Trying with HashMap

        System.out.println("***********************************");

        System.out.println("is String1 unique?: " + hasUniqueHash(testString1));
        System.out.println("is String2 unique?: " + hasUniqueHash(testString2));

        //Trying the book solution
        System.out.println("***********************************");
        System.out.println("is String1 unique?: " + hasUniqueChars(testString1));
        System.out.println("is String2 unique?: " + hasUniqueChars(testString2));

        //***************************************************

        //**************** Chapter 1 - pg 73 ****************
        //TODO: Q1.3 Given two strings, write a method to decide if one is a permutation of the other.

        //Brute force using Java Collections native sort

        String anagramString1 = "azam";
        String anagramString2 = "maza";

        System.out.println("***********************************");
        System.out.println("Are both strings a permutation of each other?: " + permutedStrings(anagramString1, anagramString2));

        //Optimizing it using HashMaps

        System.out.println("***********************************");
        System.out.println("Are both strings a permutation of each other?: " + anagramStringsHash(anagramString1, anagramString2));

        //Optimize it further. Use Arrays sort method

        System.out.println("***********************************");
        System.out.println("Are both strings a permutation of each other? (Arrays.sort): " + anagramArraysSort(anagramString1, anagramString2));

        //***************************************************


        //**************** Chapter 1 - pg 72 ****************
        //TODO Q1.4: Write a method to replace all spaces in a string with'%20'

        System.out.println("***********************************");
        System.out.println("Output String: " + replaceSpaces("Mr John Smith    "));

        //***************************************************

        //**************** Chapter 1 - pg 73 ****************
        //TODO Q1.5: Implement a method to perform basic string compression using the counts of repeated characters.

        System.out.println("***********************************");
        System.out.println("Output String: " + stringCompression("aaacccccbbbb"));
        //Problem with the above is taht it changes the order!!!

        //Try the book's naive inefficient solution

        System.out.println("***********************************");
        System.out.println("Output String: " + compressBasic("aaacccccbbbb"));


        //Implement this efficiently without using StringBuffer

        //***************************************************

        //**************** Chapter 1 - pg 73 ****************
        //TODO Q1.6: Given an image represented by an NxN matrix, where each pixel in the image is 4 bytes, write a method to rotate the image by 90 degrees. Can you do this in place?

        int[][] testMatrix = {  //Mistake: Remember how to manually declare/assign n x n matrix
                { 1, 2, 3, 4 },
                { 5, 6, 7, 8 },
                { 9, 10, 11, 12 },
                { 13, 14, 15, 16 }
        };

        int[][] testMatrixSmall = {  //Mistake: Remember how to manually declare/assign n x n matrix
                { 1, 2 },
                { 3, 4 }
        };

        //Not in place

        //Work in progress.
        System.out.println("***********************************");
        printMatrix(testMatrix);

        System.out.println("***********************************");
        rotate90(testMatrix);
        printMatrix(testMatrix);



        //***************************************************

        //**************** Chapter 1 - pg 73 ****************
        //TODO Q1.7: Write an algorithm such that if an element in an MxN matrix is 0, its entire row and column are set to 0.

        int[][] zeroMatrix = {  //Mistake: Remember how to manually declare/assign n x n matrix
                { 1, 1, 1 },
                { 1, 0, 1 },
                { 1, 1, 1 },
                { 1, 1, 1 }
        };

        System.out.println("***********************************");
        toZero(zeroMatrix);


        //***************************************************

        //**************** Chapter 2 - pg 75 ****************
        //TODO: Implement a LinkedList using a class Node

        Node first = new Node(1);
        first.appendToTail(2);
        first.appendToTail(3);
        first.appendToTail(3);
        first.appendToTail(5);

        System.out.println("***********************************");
        first.printList();

        //***************************************************


        //**************** Chapter 2 - pg 76 ****************
        //TODO: Implement a method deleteNode in class Node
        //https://stackoverflow.com/questions/26191240/how-to-delete-a-node-from-a-linked-list-using-a-function-with-node-as-a-return-t?rq=1


        first.deleteNode(first, 3);
        System.out.println("***********************************");
        first.printList();


        System.out.println("***********************************");
        first.deleteNode(first, 1).printList();



        //***************************************************

        //**************** Chapter 2 - pg 77 ****************
        //TODO Q2.1: Write code to remove duplicates from an unsorted linked list. How would you solve this problem if a temporary buffer is not allowed?
        Node duplicates = new Node(4);
        duplicates.appendToTail(2);
        duplicates.appendToTail(3);
        duplicates.appendToTail(2);
        duplicates.appendToTail(1);

        System.out.println("***********************************");
        duplicates.printList();

        Node.removeDuplicates(duplicates);
        System.out.println("***********************************");
        duplicates.printList();

        //Improve efficiency

        Node duplicates1 = new Node(4);
        duplicates1.appendToTail(3);
        duplicates1.appendToTail(4);
        duplicates1.appendToTail(2);
        duplicates1.appendToTail(1);

        Node.deleteDuplicatesBetter(duplicates1);
        System.out.println("***********************************");
        duplicates1.printList();

        //Without a temporary buffer

        Node duplicates2 = new Node(4);
        duplicates2.appendToTail(4);
        duplicates2.appendToTail(3);
        duplicates2.appendToTail(2);
        duplicates2.appendToTail(1);

        Node.deleteDuplicatesNoBuffer(duplicates2);
        System.out.println("***********************************");
        duplicates2.printList();


        //**************** Chapter 2 - pg 77 ****************
        //TODO Q2.2: Implement an algorithm to find the kth to last element of a singly linked list.

        System.out.println("***********************************");
        System.out.println("Kth element of linked list is: " + Node.findElement(duplicates2, 3).data);


        //Iterative solution with two pointers
        System.out.println("***********************************");
        System.out.println("Kth element of linked list is: " + Node.findElementIterative(duplicates2, 1).data);

        //Recursive solution 1
        System.out.println("***********************************");
        Node.nthToLast(duplicates2, 3);

        //Try it with a wrapper class

        //***************************************************

        //**************** Chapter 2 - pg 77 ****************
        //TODO Q2.3: Implement an algorithm to delete a node in the middle of a singly linked list, given only access to that node.

        System.out.println("***********************************");
        Node.deleteNode(duplicates2);
        duplicates2.printList();

        //***************************************************

        //**************** Chapter 2 - pg 77 ****************
        //TODO Q2.4: Write code to partition a linked list around a value x, such that all nodes less than x come before all nodes greater than or equal to x.

        Node partitionLinkedList = new Node(2);
        partitionLinkedList.appendToTail(5);
        partitionLinkedList.appendToTail(1);
        partitionLinkedList.appendToTail(3);
        partitionLinkedList.appendToTail(9);


        System.out.println("***********************************");
        Node.partition(partitionLinkedList, 3).printList();
        System.out.println("***********************************");

        //***************************************************

        //**************** Chapter 2 - pg 77 ****************
        //TODO Q2.5: You have two numbers represented by a linked list, where each node contains a single digit....

        Node firstList = new Node(7);
        firstList.appendToTail(1);
        firstList.appendToTail(6);

        Node secondList = new Node(5);
        secondList.appendToTail(9);
        secondList.appendToTail(2);

        System.out.println("***********************************");
        Node.addLinkedLists(firstList, secondList).printList();
        System.out.println("***********************************");

        //***************************************************

        //**************** Chapter 2 - pg 77 ****************
        //TODO Q2.6: Given a circular linked list, implement an algorithm which returns the node at the beginning of the loop.

        Node.createCircularLinkedList();
        System.out.println("***********************************");
        System.out.println(Node.detectLoop(Node.createCircularLinkedList()).data);
        System.out.println(Node.detectLoop(Node.createCircularLinkedList()));
        System.out.println("***********************************");

        //***************************************************

        //**************** Chapter 2 - pg 77 ****************
        //TODO Q2.7: Implement a function to check if a linked list is a palindrome.

        //***************************************************

        //**************** Chapter 9 - pg 107 ****************
        //TODO Q9.1: A child is running up a staircase with n steps, and can hop either 1 step, 2 steps, or 3 steps at a time. Implement a method to count how many possible ways the child can run up the stairs.

        //****************************************************



    }




    public static void toZero(int[][] matrix){  //Runtime is O(mn + mn + m + n) = ~O(mn)

        int rows = matrix.length;
        System.out.println("m is: " + rows);

        int columns = matrix[0].length;
        System.out.println("n is: " + columns);

        int[][] result = new int[rows][columns];

        for (int i = 0; i < rows; i++){
            for (int j = 0; j < columns; j++){
                result[i][j] = matrix[i][j];
            }
        }

//        printMatrix(result);

        for (int i = 0; i < rows; i++){
            for (int j = 0; j < columns; j++){

                if(matrix[i][j] == 0){

                    for (int k = 0; k < columns; k++){

                        result[i][k] = 0;
                    }
                    for (int l = 0; l < rows; l++){

                        result[l][j] = 0;
                    }
                    System.out.println("***********************************");
                    printMatrix(result);
                }
            }
        }
    }


    public static void rotate90(int[][] matrix){

        int n = matrix.length;

        int[][] result = new int[n][n];

        for(int layer = 0; layer < n/2; layer++){
            int last = matrix.length - 1 - layer;

            for(int i = layer; i < last; i++){
                result[i][last] = matrix[0][i];
                result[last][last-i] = matrix[i][last];
                result[last-i][0] = matrix[last][last-i];
                result[0][i] = matrix[last-i][0];
            }
        }



//        matrix = result;  //Mistake: Can't do this!
//        matrix = result.clone();
//        printMatrix(matrix);
        System.arraycopy(result, 0, matrix, 0, result.length);    //Another possibility
    }

    public static void printMatrix(int[][] matrix){ //Mistake: Don't forget void return type

        for(int i = 0; i < matrix.length; i++){
            for(int j = 0; j < matrix[0].length; j++){
                System.out.print(matrix[i][j]);
            }
            System.out.println();
        }
    }

    public static String compressBasic(String input){

        String myString = "";
        char last = input.charAt(0);
        int counter = 1;

        for(int i = 1; i < input.length(); i++){
            if(input.charAt(i) == last){
                counter++;
            } else {
                myString = myString + last + counter;
                counter = 1;
                last = input.charAt(i);
            }
        }
        return myString + last + counter;
    }

    public static String stringCompression(String input){   //Runtime of O(n + k) ~O(n)

        Map<Character, Integer> stringHash = new HashMap<>();

        for(Character ch : input.toCharArray()){
            if(stringHash.get(ch) == null){
                stringHash.put(ch, 1);
            } else {
                stringHash.put(ch, stringHash.get(ch)+1);
            }
        }
        Iterator it = stringHash.keySet().iterator();
        StringBuffer result = new StringBuffer();
//
        while(it.hasNext()){
            Character temp = (Character) it.next();
            result.append(temp);
            result.append(stringHash.get(temp));
        }

        return (result.toString().length() < input.length()) ? result.toString() : input;

    }

    public static Boolean anagramArraysSort(String str1, String str2){

        if(str1.length() != str2.length())
            return false;
        else {
            char[] charStr1 = str1.toCharArray();
            char[] charStr2 = str2.toCharArray();

            Arrays.sort(charStr1);
            Arrays.sort(charStr2);

            for(int i = 0; i < charStr1.length; i++){

                if(charStr1[i] != charStr2[i]){
                    return false;
                }
            }
            return true;
        }



    }

    public static String replaceSpaces(String input){   //Runtime: O(3n)? ~O(n)

        char[] charString = input.toCharArray();
        List<Character> charList = new ArrayList<>();

        char space = " ".charAt(0);
        char percent = "%".charAt(0);
        char two = "2".charAt(0);
        char zero = "0".charAt(0);

        for(Character ch : charString){
            if(ch.equals(space)){   //Mistake: cannot .equals(" ")
                charList.add(percent);
                charList.add(two);
                charList.add(zero);
            } else {
                charList.add(ch);
            }
        }
        StringBuffer result = new StringBuffer();
        for (Character ch : charList){
            result.append(ch);
        }
        return result.toString();   //Mistake:
    }

    public static Boolean anagramStringsHash(String str1, String str2){ //Runtime: linear? ~O(n)??

        if (str1.length() != str2.length()){
            return false;
        } else {

            Map<Character, Integer> stringHash1 = new HashMap<>();
            Map<Character, Integer> stringHash2 = new HashMap<>();

            char[] charString1 = str1.toCharArray();
            char[] charString2 = str2.toCharArray();

            for(Character ch : charString1){
                if(stringHash1.get(ch) == null){
                    stringHash1.put(ch, 0);
                } else {
                    stringHash1.replace(ch, stringHash1.get(ch));
                }
            }

            for(Character ch : charString2){
                if(stringHash2.get(ch) == null){
                    stringHash2.put(ch, 0);
                } else {
                    stringHash2.replace(ch, stringHash2.get(ch));
                }
            }

            return stringHash1.equals(stringHash2);
        }
    }


    public static Boolean permutedStrings(String str1, String str2){    //Runtime O(nlogn)?

        char[] charString1 = str1.toCharArray();
        char[] charString2 = str2.toCharArray();

        List<Character> stringCol1 = new ArrayList<>();
        List<Character> stringCol2 = new ArrayList<>();

        if (str1.length() != str2.length()){
            return false;
        } else {

            for(Character ch : charString1){
                stringCol1.add(ch);
            }

            for(Character ch : charString2){
                stringCol2.add(ch);
            }

            Collections.sort(stringCol1);
            Collections.sort(stringCol2);

            return(stringCol1.equals(stringCol2));
        }

    }


    public static Boolean hasUniqueChars(String str){   //Mistake: missed the access identifier and static

        boolean[] characterArray = new boolean[256];    //Mistake: wrote Int instead of int AND made an int array instead of boolean

        for(int i = 0; i < str.length(); i++) { //Mistake: str.length

            if(characterArray[str.charAt(i)]){
                return false;
            } else {
                characterArray[str.charAt(i)] = true;
            }

        }
        return true;    //Mistake: forgot to add this statement
    }


    public static Boolean hasUniqueHash(String test){   //Runtime of O(n) worst case and O(n/2) average in case of duplicates??

        char[] chars = test.toCharArray();  //Mistake: Cannot use a Character[] array here
        Boolean unique = true;
        HashMap<Character, Boolean> map = new HashMap<>();
        int counter = 0;

        for(char ch : chars){
            if(map.get(ch) != null && map.get(ch) == true){ //Mistake: If you don't check for null you get a null pointer exception
                unique = false;
                System.out.println("Runtime is: " + counter);
                return unique;
            } else {
                counter++;
                map.put(ch, true);
            }
        }
        System.out.println("Runtime is: " + counter);
        return unique;
    }


    public static Boolean hasUnique(String test){   //Runtime of O(n^2) worst case and O(n) average best case??

        char[] chars = test.toCharArray();  //Mistake: Note the method to convert string to char array
        Boolean unique = true;
        int counter = 0;

        for(int i = 0; i < chars.length - 1; i++){
            for(int j = i + 1; j < chars.length; j++){

                counter++;
                if(chars[i] == chars[j]){
                    unique = false;
                    System.out.println("Runtime is: " + counter);
                    return unique;


                }
            }
        }

        System.out.println("Runtime is: " + counter);
        return unique;

    }

    public static String joinStringsBuffer(String[] words){

        StringBuffer buffer = new StringBuffer();
        for(String s : words){
            buffer.append(s);
        }
        return buffer.toString();   //Mistake: Do not forget to convert StringBuffer back to String

    }


    public static String joinStrings(String[] words){  //Runtime O(n^2)

        String combined = "";

        for(String s : words){
            combined = combined + s;
        }

        return combined;
    }

    public static HashMap<Integer, Employee> createMap(Employee[] emps){   //Mistake: Note that it is HashMap not Hashmap

        HashMap<Integer, Employee> map = new HashMap<>();
        for (Employee e : emps){
            map.put(e.getId(), e);  //Mistake: when adding entry to map using put also add value
        }
        return map;
    }

    public static ArrayList<Employee> joinArrays(Employee[] firstemps, Employee[] secondemps){

        ArrayList<Employee> combined = new ArrayList<>();

        for(Employee e:firstemps){
            combined.add(e);
        }
        for(Employee e:secondemps){
            combined.add(e);
        }
        return combined;
    }
}