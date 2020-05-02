package com.ascending.jdbc;

import com.ascending.model.User;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class UserDao {
    static final String DB_URL = "jdbc:postgresql://localhost:5429/fedex1_dev";
    static final String USER = "admin";
    static final String PASS = "password";

    public static User save(User p){

        List<User> users = new ArrayList();
        Connection conn = null;
        Statement stmt = null;
        ResultSet rs = null;
        try {
            //STEP 2: Open a connection
            System.out.println("Connecting to database...");
            conn = DriverManager.getConnection(DB_URL, USER, PASS);
            //STEP 3: Execute a query
            System.out.println("Creating statement...");
            stmt = conn.createStatement();
            String sql;
            sql = "SELECT * FROM user";
            rs = stmt.executeQuery(sql);
            //STEP 4: Extract data from result set
            while(rs.next()) {
                //Retrieve by column name
                Long id  = rs.getLong("id");
                String username = rs.getString("username");
                String first_name = rs.getString("first_name");
                String last_name = rs.getString("last_name");
                String email = rs.getString("email");
                String adress = rs.getString("adress");
                String password = rs.getString("password");
                //Fill the object
                User user = new User();
                user.setUsername(username);
                user.setFirstName(first_name);
                user.setLastName(last_name);
                user.setEmail(email);
                user.setAddress(adress);
                users.add(user);
            }
        }
        catch(Exception e){
            e.printStackTrace();
        }
        finally {
            //STEP 6: finally block used to close resources
            try {
                if(rs != null) rs.close();
                if(stmt != null) stmt.close();
                if(conn != null) conn.close();
            }
            catch(SQLException se) {
                se.printStackTrace();
            }
        }


        return new User();
    }
    public static boolean delete(long id){
        return false;
    }

    public static List<User> getUsers(){
        List<User> users = new ArrayList();
        Connection conn = null;
        Statement stmt = null;
        ResultSet rs = null;
        try {
            //STEP 2: Open a connection
            System.out.println("Connecting to database...");
            conn = DriverManager.getConnection(DB_URL, USER, PASS);
            //STEP 3: Execute a query
            System.out.println("Creating statement...");
            stmt = conn.createStatement();
            String sql;
            sql = "SELECT * FROM user";
            rs = stmt.executeQuery(sql);
            //STEP 4: Extract data from result set
            while(rs.next()) {
                //Retrieve by column name
                Long id  = rs.getLong("id");
                String username = rs.getString("username");
                String first_name = rs.getString("first_name");
                String last_name = rs.getString("last_name");
                String email = rs.getString("email");
                String adress = rs.getString("adress");
                String password = rs.getString("password");
                //Fill the object
                User user = new User();
                user.setUsername(username);
                user.setFirstName(first_name);
                user.setLastName(last_name);
                user.setEmail(email);
                user.setAddress(adress);
                user.setPassword(password);
                users.add(user);
            }
        }
        catch(Exception e){
            e.printStackTrace();
        }
        finally {
            //STEP 6: finally block used to close resources
            try {
                if(rs != null) rs.close();
                if(stmt != null) stmt.close();
                if(conn != null) conn.close();
            }
            catch(SQLException se) {
                se.printStackTrace();
            }
        }
        return users;
    }

}
