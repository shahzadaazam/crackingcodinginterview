public class Employee{


    private String name;    //Note that access modifiers are private
    private Integer age;
    private Integer id;

    public Employee(Integer id, String name, Integer age){
        this.id = id;
        this.age = age;
        this.name = name;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public Integer getId() {
        return id;
    }

    public String getName(){
        return name;
    }

    public Integer getAge() {
        return age;
    }
}