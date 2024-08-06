package entity;

public class InscriptionEntity {
    //attributes
    private int id;
    private int student;
    private  int course;

    //constructor
    public InscriptionEntity(){}

    public InscriptionEntity(int id) {
        this.id = id;
    }

    public InscriptionEntity(int id, int student, int course) {
        this.id = id;
        this.student = student;
        this.course = course;
    }
    //getters

    public int getId() {
        return id;
    }

    public int getStudent() {
        return student;
    }

    public int getCourse() {
        return course;
    }

    //setters

    public void setId(int id) {
        this.id = id;
    }

    public void setStudent(int student) {
        this.student = student;
    }

    public void setCourse(int course) {
        this.course = course;
    }

    //method

    @Override
    public String toString() {
        return "| id: " + id +
                "| student: " + student +
                "| course: " + course + " |\n";
    }
}
