package entity;

public class CourseEntity {
    //attribute
    private int id;
    private String name;

    //constructor
    public CourseEntity(){}

    public CourseEntity(String name){
        this.name = name;
    }

    public CourseEntity(int id){
        this.id=id;
    }

    public CourseEntity(int id, String name){
        this.id = id;
        this.name = name;
    }

    //getters
    public String getName() {
        return name;
    }

    public int getId() {
        return id;
    }

    //setters
    public void setName(String name) {
        this.name = name;
    }
    public void setId(int id) {
        this.id = id;
    }
    //method


    @Override
    public String toString() {
        return "| name: " + name + " |\n";
    }
}
