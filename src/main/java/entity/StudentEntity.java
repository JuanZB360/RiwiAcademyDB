package entity;

public class StudentEntity {
    //attribute
    private int id;
    private String email;
    private String name;
    private boolean state = true;

    //constructor
    public StudentEntity(){}

    public StudentEntity(int id) {
        this.id = id;
    }

    public StudentEntity(String email) {
        this.email = email;
    }

    public StudentEntity(int id, String name, String email) {
        this.id = id;
        this.email = email;
        this.name = name;
    }

    public StudentEntity(String name, String email) {
        this.email = email;
        this.name = name;
    }

    public StudentEntity(int id, String name, String email, boolean state) {
        this.id = id;
        this.email = email;
        this.name = name;
        this.state = state;
    }

    //getters

    public int getId() {
        return id;
    }

    public String getEmail() {
        return email;
    }

    public String getName() {
        return name;
    }

    public boolean isState() {
        return state;
    }

    //setters

    public void setId(int id) {
        this.id = id;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setState(boolean state) {
        this.state = state;
    }

    //method


    @Override
    public String toString() {
        return "| id: " + id +
                "| email: " + email +
                "| name: " + name +
                "| state=" + state + "|\n";
    }
}
