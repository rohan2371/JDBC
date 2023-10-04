package com.student.mgmt.dao;

import com.student.mgmt.connection.ConnectionProvider;
import com.student.mgmt.entity.Student;

import java.sql.*;

public class StudentDaoImpl implements StudentDao {

    @Override
    public void display() {
        boolean res = false;
        try {
            Connection conn = ConnectionProvider.createConn();
            Statement stmt = conn.createStatement();

            String query = "select * from student";
            ResultSet resultSet = stmt.executeQuery(query);
            while (resultSet.next()) {
                System.out.println(resultSet.getInt(1) + " " + resultSet.getString(2) + " " + resultSet.getString(3) + " " + resultSet.getString(4));
            }
            res = true;
            System.out.println("*******************************************************************");
            conn.close();
        } catch (Exception e) {
            e.printStackTrace();
        }

        if(!res){
            System.out.println("something went wrong....");
        }

    }



    @Override
    public void insert(Student st) {
        boolean res = false;

        try {
            Connection conn = ConnectionProvider.createConn();
                String q = "insert into student values(?,?,?,?)";
            // PreparedStatement
            PreparedStatement pstmt = conn.prepareStatement(q);
            // set the values of the parameter
            pstmt.setInt(1,st.getStudentId());
            pstmt.setString(2, st.getStudentName());
            pstmt.setString(3, st.getStudentPhone());
            pstmt.setString(4, st.getStudentCity());

            // execute query
            pstmt.executeUpdate();
            res = true;
            conn.close();
        } catch (Exception e) {
            e.printStackTrace();
        }

       if(!res){
           System.out.println("something went wrong");
       }
    }



    @Override
    public void delete(int id) {
        boolean res = false;
        try
        {
            Connection conn = ConnectionProvider.createConn();
            Statement stmt = conn.createStatement();

            String query = "delete from student where id = "+id;
            stmt.executeUpdate(query);
            conn.close();

        }catch (Exception e){
            e.printStackTrace();
        }
        res = true;

        if(!res){
            System.out.println("something went wrong....");
        }
    }

    @Override
    public void update(int id, String city) {
        try
        {
          Connection conn = ConnectionProvider.createConn();
          String q = "update student set city=? where id=?";
          PreparedStatement pst = conn.prepareStatement(q);
          pst.setString(1,city);
          pst.setInt(2,id);
            int res = pst.executeUpdate();
            if(res==1){
                System.out.println("successfully updated");
                String query = "select * from student where id=?";
                PreparedStatement ps = conn.prepareStatement(query);
                ps.setInt(1,id);
                ResultSet resultSet = ps.executeQuery();
                while (resultSet.next()){
                    System.out.println(resultSet.getInt(1)+" "+resultSet.getString(2)+" "+
                            resultSet.getString(3)+" "+resultSet.getString(4));
                }

            }else{
                System.out.println("something went wrong");
            }

        } catch (Exception exception) {
            exception.printStackTrace();
        }

    }

    @Override
    public void searchStudent(int id) {
        try {
            Connection conn = ConnectionProvider.createConn();
            String query = "select * from student where id=?";
            PreparedStatement pstmt = conn.prepareStatement(query);
            pstmt.setInt(1,id);
            ResultSet resultSet = pstmt.executeQuery();
            while (resultSet.next()){
                System.out.println(resultSet.getInt(1)+" "+resultSet.getString(2)+" "+
                        resultSet.getString(3)+" "+resultSet.getString(4));
            }
        } catch (Exception exception) {
            exception.printStackTrace();
        }
    }

    @Override
    public void jdbcDriverInfo() {
        try{
            Connection conn = ConnectionProvider.createConn();
            DatabaseMetaData dbmd = conn.getMetaData();
            System.out.println("Driver name : "+dbmd.getDriverName());
            System.out.println("Driver version : "+dbmd.getDriverVersion());
            System.out.println("Username : "+dbmd.getUserName());
            System.out.println("url : "+dbmd.getURL());
            System.out.println("product name : "+dbmd.getDatabaseProductName());
            System.out.println("product version : "+dbmd.getDatabaseProductVersion());
        }catch (Exception exception){
            exception.printStackTrace();
        }
    }
}
