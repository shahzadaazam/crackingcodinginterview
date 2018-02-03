import java.util.HashMap;

public class main{


    public static HashMap<Integer, Employee> createMap(Employee[] emps){   //Mistake: Note that it is HashMap not Hashmap

        HashMap<Integer, Employee> map = new HashMap<>();
        for (Employee e : emps){
            map.put(e.getId(), e);  //Mistake: when adding entry to map using put also add value
        }
        return map;
    }

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

        


        //***************************************************




    }


}