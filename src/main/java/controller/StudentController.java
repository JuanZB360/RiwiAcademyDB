package controller;

import entity.StudentEntity;
import model.IModel.IStudentModel;
import model.Impl.StudentModelImpl;

import java.util.ArrayList;

public class StudentController {
    IStudentModel Controller = new StudentModelImpl();

    public StudentEntity StudentCreate(StudentEntity request){
        return this.Controller.create(request);
    }

    public void StudentDelete(StudentEntity request){
        this.Controller.delete(request);
    }

    public StudentEntity StudentRead(StudentEntity requet){
        return this.Controller.read(requet);
    }

    public ArrayList<StudentEntity> StudentReadAll(){
        return this.Controller.readAll();
    }

    public StudentEntity StudentReadEmail(StudentEntity request){
        return this.Controller.read(request);
    }

    public StudentEntity StudentUpdate(StudentEntity request){ return this.Controller.update(request);}
}
