package com.ascending.jdbc;

import com.ascending.model.Pack;
import com.ascending.model.User;
import com.ascending.model.Routing;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class RoutingDao {
    static final String DB_URL = "jdbc:postgresql://localhost:5429/fedex1_dev";
    static final String USER = "admin";
    static final String PASS = "password";
    public static Routing save(Routing r){
        return new Routing();
    }
    public boolean delete(int trackingid){
        return false;
    }


    public static List<Routing> getRouting(){
        List<Routing> routings = new ArrayList();
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
            sql = "SELECT * FROM routing";
            rs = stmt.executeQuery(sql);
            //STEP 4: Extract data from result set
            while(rs.next()) {
                //Retrieve by column name
                int id  = rs.getInt("id");
                String pirority = rs.getString("pirority");
                String area = rs.getString("area");
                //Fill the object
                Routing routing = new Routing();
                routing.setPirority(pirority);
                routing.setArea(area);
                routings.add(routing);
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
        return routings;
    }
}
