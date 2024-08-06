package controller;

import entity.CourseEntity;
import model.IModel.ICourseModel;
import model.Impl.CourseModelImpl;

import java.util.ArrayList;

public class CourseController {
    ICourseModel controller = new CourseModelImpl();

    public CourseEntity CourseCreate(CourseEntity response){
        return this.controller.create(response);
    }

    public void CourseDelete(CourseEntity response){
        this.controller.delete(response);
    }

    public ArrayList<CourseEntity> CourseReadAll(){
        return this.controller.readAll();
    }
}
