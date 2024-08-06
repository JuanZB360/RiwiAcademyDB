package entity;

public class RatingsEntity {
    //attribute
    private int id;
    private int student;
    private int course;
    private int rating;
    private String description;

    //constructor
    public RatingsEntity(){}

    public RatingsEntity(int id) {
        this.id = id;
    }

    public RatingsEntity(int id, int student, int course, int rating, String description) {
        this.id = id;
        this.student = student;
        this.course = course;
        this.rating = rating;
        this.description = description;
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

    public int getRating() {
        return rating;
    }

    public String getDescription() {
        return description;
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

    public void setRating(int rating) {
        this.rating = rating;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    //method

    @Override
    public String toString() {
        return "| id: " + id +
                "| student: " + student +
                "| course: " + course +
                "| rating: " + rating +
                "| description: " + description + " |\n ";
    }
}
