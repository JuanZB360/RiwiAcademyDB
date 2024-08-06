package model.Impl;

import entity.RatingsEntity;
import model.IModel.IRatingsModel;
import persistence.ConnectionDataBase.ConnectionDB;

import javax.swing.*;
import java.sql.*;

public class RatingsModelImpl implements IRatingsModel {
    @Override
    public RatingsEntity create(RatingsEntity request) {
        Connection connection = ConnectionDB.openConnection();

        String sql = "INSERT INTO student (student_id,course_id,rating,description) VALUES (?, ?, ?, ?);";

        try{
            PreparedStatement pst = connection.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
            pst.setInt(1, request.getStudent());
            pst.setInt(2, request.getCourse());
            pst.setInt(3,request.getRating());
            pst.setString(4, request.getDescription());

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
    public RatingsEntity update(RatingsEntity request) {
        Connection connection = ConnectionDB.openConnection();
        String sql = "UPDATE student SET rating WHERE id = ? and student_id = ? and course_id = ?;";
        try{
            PreparedStatement ps = connection.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
            ps.setInt(1,request.getId());
            ps.setInt(1,request.getStudent());
            ps.setInt(1,request.getCourse());

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

}
