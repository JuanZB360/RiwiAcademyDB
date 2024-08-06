package model.Impl;

import entity.CourseEntity;
import entity.InscriptionEntity;
import model.IModel.IInscriptionModel;
import persistence.ConnectionDataBase.ConnectionDB;

import javax.swing.*;
import java.sql.*;

public class InscriptionModelImpl implements IInscriptionModel {

    @Override
    public InscriptionEntity create(InscriptionEntity request) {
        Connection connection = ConnectionDB.openConnection();

        String sql = "INSERT INTO inscription (student-id,course_id) VALUES (?, ?);";

        try{
            PreparedStatement pst = connection.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
            pst.setInt(1, request.getStudent());
            pst.setInt(2,request.getCourse());

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
    public void delete(InscriptionEntity request) {
        Connection connection = ConnectionDB.openConnection();
        String sql = "DELETE FROM inscription WHERE id = ?;";
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
    public InscriptionEntity read(InscriptionEntity request) {
        InscriptionEntity student = new InscriptionEntity();
        Connection connection = ConnectionDB.openConnection();
        String sql = "SELECT * FROM course WHERE student_id = ? and course_id = ?;";
        try{
            PreparedStatement ps = connection.prepareStatement(sql);
            ps.setInt(1,request.getStudent());
            ps.setInt(1,request.getCourse());
            ResultSet rs = ps.executeQuery();
            if(rs.next()){
                student.setId(rs.getInt("id"));
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
