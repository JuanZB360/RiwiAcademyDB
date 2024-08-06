package model.IModel;

import entity.CourseEntity;
import persistence.CRUD.Create;
import persistence.CRUD.Delete;
import persistence.CRUD.Read;
import persistence.CRUD.ReadAll;

public interface ICourseModel extends   Create<CourseEntity>,
                                        ReadAll<CourseEntity>,
                                        Delete<CourseEntity>,
                                        Read<CourseEntity>{}
