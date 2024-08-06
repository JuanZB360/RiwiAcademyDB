package model.IModel;

import entity.StudentEntity;
import persistence.CRUD.*;

public interface IStudentModel extends  Create<StudentEntity>,
                                        Delete<StudentEntity>,
                                        Update<StudentEntity>,
                                        ReadAll<StudentEntity>,
                                        Read<StudentEntity>,
                                        ReadByEmail<StudentEntity>{

}
