package com.ascending.jdbc;

import com.ascending.model.Pack;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class PackDao {
    static final String DB_URL = "jdbc:postgresql://localhost:5429/fedex_dev";
    static final String USER = "admin";
    static final String PASS = "password";

public Pack save(Pack p){

    return new Pack();
}
public boolean delete(int trackingid){

    return false;
}


    public List<Pack> getPacks(){
        List<Pack> packs = new ArrayList();
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
            sql = "SELECT * FROM pack";
            rs = stmt.executeQuery(sql);
            //STEP 4: Extract data from result set
            while(rs.next()) {
                //Retrieve by column name
                int trackingid  = rs.getInt("trackingid");
                String type = rs.getString("type");
                String destination = rs.getString("destination");
                //Fill the object
                Pack pack = new Pack();
                pack.setTrackingid(trackingid);
                pack.setType(type);
                pack.setDestination(destination);
                packs.add(pack);
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
        return packs;
    }
}
