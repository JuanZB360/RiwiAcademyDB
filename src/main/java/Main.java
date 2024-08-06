import controller.StudentController;
import entity.StudentEntity;
import menu.CourseExecute;
import menu.InscriptionExecute;
import menu.RatingsExecute;
import menu.StudenExecute;

import javax.swing.*;

public class Main {
    public static void main(String[] args) throws ClassNotFoundException{
        boolean session = true;
        while(session){
            int option = Integer.parseInt(JOptionPane.showInputDialog("Menu:\n\t1- Student\n\t2- Courses\n\t3- Inscription\n\t4- Rating\n\t5- Exit"));
            switch (option){
                case 1:
                    StudenExecute.StudentMenu();
                    break;
                case 2:
                    CourseExecute.CourseMenu();
                    break;
                case 3:
                    InscriptionExecute.InscriptionMenu();
                    break;
                case 4:
                    RatingsExecute.RatingMenu();
                    break;
                case 5:
                    session = false;
                    break;
                case 6:
                    JOptionPane.showMessageDialog(null,"Invalid Option...");

            }
        }

    }
}
