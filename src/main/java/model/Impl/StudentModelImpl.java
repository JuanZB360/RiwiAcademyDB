package model.Impl;

import entity.StudentEntity;
import model.IModel.IStudentModel;
import persistence.ConnectionDataBase.ConnectionDB;

import javax.swing.*;
import java.sql.*;
import java.util.ArrayList;

public class StudentModelImpl implements IStudentModel {
    @Override
    public StudentEntity create(StudentEntity response) {
        Connection connection = ConnectionDB.openConnection();

            String sql = "INSERT INTO student (name, email) VALUES (?, ?);";

            try{
                PreparedStatement pst = connection.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
                pst.setString(1, response.getName());
                pst.setString(2,response.getEmail());

                pst.execute();
                ResultSet rst = pst.getGeneratedKeys();
                if(rst.next()){
                    response.setId(rst.getInt(1));
                    response.setState(rst.getBoolean(1));
                }
                pst.close();
            }catch(SQLException e){
                throw new RuntimeException("Error Create: " + e.getMessage());
            }finally{
                ConnectionDB.closeConnection();
            }
        return response;
    }

    @Override
    public void delete(StudentEntity request) {
        Connection connection = ConnectionDB.openConnection();
        String sql = "UPDATE student SET state = false WHERE id = ?;";
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
    public StudentEntity update(StudentEntity request) {
        Connection connection = ConnectionDB.openConnection();
        String sql = "UPDATE student SET name = ?, email = ? WHERE id = ?;";
        try{
            PreparedStatement ps = connection.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
            ps.setString(1,request.getName());
            ps.setString(2,request.getEmail());
            ps.setInt(3,request.getId());

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
        return null;
    }

    @Override
    public StudentEntity read(StudentEntity request) {

        Connection connection = ConnectionDB.openConnection();
        String sql = "SELECT * FROM student WHERE id= ?;";
        try{
            PreparedStatement ps = connection.prepareStatement(sql);
            ps.setInt(1,request.getId());
            ResultSet rs = ps.executeQuery();
            if(rs.next()){
                request.setName(rs.getString("name"));
                request.setEmail(rs.getString("email"));
                request.setState(rs.getBoolean("state"));
            }
            ps.close();
        }catch(SQLException e){
            throw new RuntimeException("Error Create: " + e.getMessage());
        }finally{
            ConnectionDB.closeConnection();
        }
        return request;
    }

    @Override
    public ArrayList<StudentEntity> readAll() {
        ArrayList<StudentEntity> list = new ArrayList<>();
        Connection connection = ConnectionDB.openConnection();
        String sql = "SELECT * FROM student;";
        try{
            PreparedStatement ps = connection.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
            while(rs.next()){
                StudentEntity student = new StudentEntity(rs.getInt("id"),rs.getString("name"),rs.getString("email"),rs.getBoolean("state"));
                list.add(student);
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
    public StudentEntity readByEmail(StudentEntity request) {
        StudentEntity student = new StudentEntity();
        Connection connection = ConnectionDB.openConnection();
        String sql = "SELECT * FROM student WHERE email = ?;";
        try{
            PreparedStatement ps = connection.prepareStatement(sql);
            ps.setString(1,request.getEmail());
            ResultSet rs = ps.executeQuery();
            if(rs.next()){
                student.setId(rs.getInt("id"));
                student.setName(rs.getString("name"));
                student.setEmail(rs.getString("email"));
                student.setState(rs.getBoolean("state"));
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
