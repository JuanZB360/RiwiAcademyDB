package model.Impl;

import entity.CourseEntity;
import entity.StudentEntity;
import model.IModel.ICourseModel;
import persistence.ConnectionDataBase.ConnectionDB;

import javax.swing.*;
import java.sql.*;
import java.util.ArrayList;

public class CourseModelImpl implements ICourseModel {
    @Override
    public CourseEntity create(CourseEntity request) {
        Connection connection = ConnectionDB.openConnection();

        String sql = "INSERT INTO course (name) VALUES (?);";

        try{
            PreparedStatement pst = connection.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
            pst.setString(1, request.getName());

            pst.execute();
            ResultSet rst = pst.getGeneratedKeys();
            if(rst.next()){
                request.setId(rst.getInt(1));
            }
            pst.close();
        }catch(SQLException e){
            throw new RuntimeException("Error Create: " + e.getMessage());
        }finally{
            ConnectionDB.closeConnection();
        }
        return request;
    }

    @Override
    public void delete(CourseEntity request) {
        Connection connection = ConnectionDB.openConnection();
        String sql = "DELETE FROM course WHERE id = ?;";
        try{
            PreparedStatement ps = connection.prepareStatement(sql);
            ps.setInt(1,request.getId());

            int rowAffected = ps.executeUpdate();
            if(rowAffected > 0){
                JOptionPane.showMessageDialog(null,"Delete Complete...");
            }
            ps.close();
        }catch(SQLException e){
            throw new RuntimeException("Error Create: " + e.getMessage());
        }finally{
            ConnectionDB.closeConnection();
        }
    }

    @Override
    public ArrayList<CourseEntity> readAll() {
        ArrayList<CourseEntity> list = new ArrayList<>();
        Connection connection = ConnectionDB.openConnection();
        String sql = "SELECT * FROM student;";
        try{
            PreparedStatement ps = connection.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
            while(rs.next()){
                CourseEntity course = new CourseEntity(rs.getInt("id"),rs.getString("name"));
                list.add(course);
            }
            ps.close();
        }catch(SQLException e){
            throw new RuntimeException("Error Create: " + e.getMessage());
        }finally{
            ConnectionDB.closeConnection();
        }
        return list;
    }

    @Override
    public CourseEntity read(CourseEntity request) {
        CourseEntity student = new CourseEntity();
        Connection connection = ConnectionDB.openConnection();
        String sql = "SELECT * FROM course WHERE id= ?;";
        try{
            PreparedStatement ps = connection.prepareStatement(sql);
            ps.setInt(1,request.getId());
            ResultSet rs = ps.executeQuery();
            if(rs.next()){
                student.setId(rs.getInt("id"));
                student.setName(rs.getString("name"));
            }
            ps.close();
        }catch(SQLException e){
            throw new RuntimeException("Error Create: " + e.getMessage());
        }finally{
            ConnectionDB.closeConnection();
        }
        return student;
    }
}
