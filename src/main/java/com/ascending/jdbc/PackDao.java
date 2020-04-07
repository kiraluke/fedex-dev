 //package com.ascending.jdbc;
//
//import com.ascending.model.Pack;
//import com.ascending.model.User;
//
//import java.sql.*;
//import java.util.ArrayList;
//import java.util.List;
//
//public class PackDao {
//    static final String DB_URL = "jdbc:postgresql://localhost:5429/fedex1_dev";
//    static final String USER = "admin";
//    static final String PASS = "password";
//
//public long save(Pack pack){
//    Connection conn = null;
//    Statement stmt = null;
//    int packages = 0;
//    try{
//        //STEP 2: Open a connection
//        System.out.println("Connecting to database...");
//        conn = DriverManager.getConnection(DB_URL, USER, PASS);
//        //STEP 3: Execute a query
//        System.out.println("Creating statement...");
//        stmt = conn.createStatement();
//        String sql;
//        sql = ( "INSERT INTO Pack(type,destination)"+" values('pack.getType()','pack.getDestination()')");
//        packages = stmt.executeUpdate(sql);
//
//    }
//    catch(Exception e) {
//        e.printStackTrace();
//    }
//    finally {
//        //STEP 6: finally block used to close resources
//        try {
//            if(stmt != null) stmt.close();
//            if(conn != null) conn.close();
//        }
//        catch(SQLException se) {
//            se.printStackTrace();
//        }
//    }
//    return packages;
//    }
//    public boolean delete(long trackingid){
//        Connection conn = null;
//        Statement stmt = null;
//        int packages = 0;
//        try{
//            //STEP 2: Open a connection
//            System.out.println("Connecting to database...");
//            conn = DriverManager.getConnection(DB_URL, USER, PASS);
//            //Step 3. Execute a query
//            System.out.println("Deleting statement...");
//            stmt = conn.createStatement();
//            String sql;
//            sql = "delete from Pack where destination = "+ trackingid+";";
//            packages = stmt.executeUpdate(sql);
//            return true;
//        } catch (Exception e) {
//            e.printStackTrace();
//        }
//        return false;
//    }
//
//
//    public static List<Pack> getPacks(){
//        List<Pack> packs = new ArrayList();
//        Connection conn = null;
//        Statement stmt = null;
//        ResultSet rs = null;
//        try {
//            //STEP 2: Open a connection
//            System.out.println("Connecting to database...");
//            conn = DriverManager.getConnection(DB_URL, USER, PASS);
//            //STEP 3: Execute a query
//            System.out.println("Creating statement...");
//            stmt = conn.createStatement();
//            String sql;
//            sql = "SELECT * FROM pack";
//            rs = stmt.executeQuery(sql);
//            //STEP 4: Extract data from result set
//            while(rs.next()) {
//                //Retrieve by column name
//                long trackingid  = rs.getLong("trackingid");
//                String type = rs.getString("type");
//                String destination = rs.getString("destination");
//                //Fill the object
//                Pack pack = new Pack();
//                pack.setTrackingid(trackingid);
//                pack.setType(type);
//                pack.setDestination(destination);
//                packs.add(pack);
//            }
//        }
//        catch(Exception e){
//            e.printStackTrace();
//        }
//        finally {
//            //STEP 6: finally block used to close resources
//            try {
//                if(rs != null) rs.close();
//                if(stmt != null) stmt.close();
//                if(conn != null) conn.close();
//            }
//            catch(SQLException se) {
//                se.printStackTrace();
//            }
//        }
//        return packs;
//    }
//
//    public static Pack getPackByDestination(String destination) {
//        Pack tracking = new Pack();
//        Connection conn = null;
//        Statement stmt = null;
//        ResultSet rs = null;
//        try {
//            //STEP 2: Open a connection
//            System.out.println("Connecting to database...");
//            conn = DriverManager.getConnection(DB_URL, USER, PASS);
//            //STEP 3: Execute a query
//            System.out.println("Creating statement...");
//            stmt = conn.createStatement();
//            String sql;
//            sql = "SELECT * FROM pack where destination = tracking.getDestination()";
//            rs = stmt.executeQuery(sql);
//            while (rs.next()) {
//                //Retrieve by column name
//                tracking.setTrackingid(77777777);
//                tracking.setType("fedex tube");
//                tracking.setDestination("Fedex office");
//            }
//            conn.close();
//
//        } catch (Exception e) {
//            e.printStackTrace();
//        }
//        return tracking;
//    }
//}
//
