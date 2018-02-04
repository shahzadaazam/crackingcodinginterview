import java.util.ArrayList;
import java.util.HashMap;

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


        //**************** Chapter 1 - pg 72 ****************
        //TODO: Q1.1 Implement an algorithm to determine if a string has all unique characters. What if you cannot use additional data structures?

        //***************************************************



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