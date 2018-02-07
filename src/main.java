import com.sun.org.apache.xpath.internal.operations.Bool;

import java.util.*;

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

        //**************** Chapter 1 - pg 72 ****************
        //TODO: Q1.3 Given two strings, write a method to decide if one is a permutation of the other.

        //Brute force using Java Collections native sort

        String anagramString1 = "azam";
        String anagramString2 = "maza";

        System.out.println("***********************************");
        System.out.println("Are both strings a permutation of each other?: " + permutedStrings(anagramString1, anagramString2));

        //Optimizing it using HashMaps

        System.out.println("***********************************");
        System.out.println("Are both strings a permutation of each other?: " + anagramStringsHash(anagramString1, anagramString2));

        //Optimize it further

        //***************************************************


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