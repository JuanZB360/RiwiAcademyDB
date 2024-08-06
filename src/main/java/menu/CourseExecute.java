package menu;

import controller.CourseController;
import controller.StudentController;
import entity.CourseEntity;
import entity.StudentEntity;

import javax.swing.*;
import java.util.ArrayList;

public class CourseExecute {
   public static void CourseMenu(){
       CourseController controller = new CourseController();
       boolean session = true;
       while (session){
           int option = Integer.parseInt(JOptionPane.showInputDialog("***** Menu Course *****\n\t1- create course.\n\t2- All courses\n\t3- delete courses\n\t4- exit menu courses"));
           switch (option){
               case 1:
                   //create course

                   boolean check = true;

                   while(check) {
                       String name = JOptionPane.showInputDialog("Name: ");
                       CourseEntity course = new CourseEntity(name);

                       try {
                           CourseEntity studentCreate = controller.CourseCreate(course);
                           check = false;
                       } catch (Exception e) {
                           JOptionPane.showMessageDialog(null, "Course already exists...");
                       }
                   }


                   break;
               case 2:
                   //All course

                   ArrayList<CourseEntity> list = new ArrayList<>();
                   list = controller.CourseReadAll();
                   JOptionPane.showMessageDialog(null,list);
                   break;
               case 3:
                   //delete course
                   int check = Integer.parseInt(JOptionPane.showInputDialog(null,""));

               case 5:
                   session = false;
                   break;
               default:
                   JOptionPane.showMessageDialog(null,"Invalid Option...");
                   break;

           }
   }
}
