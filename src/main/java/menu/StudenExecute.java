package menu;

import controller.StudentController;
import entity.StudentEntity;

import javax.swing.*;
import java.sql.SQLException;
import java.util.ArrayList;

public class StudenExecute {
    public static void StudentMenu() {
        StudentController controller = new StudentController();
        boolean session = true;
        while (session){
            int option = Integer.parseInt(JOptionPane.showInputDialog("***** Menu Student *****\n\t1- create student.\n\t2- All students\n\t3- Update Student\n\t4- Search Student\n\t5- exit menu Student"));
            switch (option){
                case 1:
                    //create Student

                    boolean check = true;
                    String name = JOptionPane.showInputDialog("Name: ");
                    while(check) {

                        String email = JOptionPane.showInputDialog("Email: ");
                        StudentEntity student = new StudentEntity(name,email);

                        try {
                            StudentEntity studentCreate = controller.StudentCreate(student);
                            check = false;
                        } catch (Exception e) {
                            JOptionPane.showMessageDialog(null, "email already exists...");
                        }
                    }


                    break;
                case 2:
                    //All student

                    ArrayList<StudentEntity> list = new ArrayList<>();
                    list = controller.StudentReadAll();
                    JOptionPane.showMessageDialog(null,list);
                    break;
                case 3:
                    //Update student

                    int id = Integer.parseInt(JOptionPane.showInputDialog("Enter student id: "));
                    String newName = JOptionPane.showInputDialog(null,"Enter new name: ");
                    String newEmail = JOptionPane.showInputDialog(null,"Enter new email: ");
                    StudentEntity student = new StudentEntity(id,newName,newEmail);

                    controller.StudentUpdate(student);
                    break;
                case 4:
                    id = Integer.parseInt(JOptionPane.showInputDialog("Enter student id:"));
                    StudentEntity studentsearch = new StudentEntity(id);
                    studentsearch = controller.StudentRead(studentsearch);
                    JOptionPane.showMessageDialog(null,"Student: \n"+ studentsearch);
                    break;
                case 5:
                    session = false;
                    break;
                default:
                    JOptionPane.showMessageDialog(null,"Invalid Option...");
                    break;

            }
        }
    }
}

