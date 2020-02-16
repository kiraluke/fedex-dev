//package com.ascending.jdbc;
//
//import com.ascending.model.Recipient;
//
//import java.sql.*;
//import java.util.ArrayList;
//import java.util.List;
//
//public class RecipientDao {
//    static final String DB_URL = "jdbc:postgresql://localhost:5429/fedex1_dev";
//    static final String USER = "admin";
//    static final String PASS = "password";
//
//    public static Recipient save(Recipient p){
//        return new Recipient();
//    }
//    public static boolean delete(long id){
//        return false;
//    }
//
//    public static List<Recipient> getRecipients(){
//        List<Recipient> recipients = new ArrayList();
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
//            sql = "SELECT * FROM recipient";
//            rs = stmt.executeQuery(sql);
//            //STEP 4: Extract data from result set
//            while(rs.next()) {
//                //Retrieve by column name
//                long id  = rs.getLong("id");
//                String name = rs.getString("name");
//                String first_name = rs.getString("first_name");
//                String last_name = rs.getString("last_name");
//                String email = rs.getString("email");
//                String adress = rs.getString("adress");
//                long trackingid  = rs.getInt("trackingid");
//                //Fill the object
//                Recipient recipient = new Recipient();
//                recipient.setId(id);
//                recipient.setName(name);
//                recipient.setFirstName(first_name);
//                recipient.setLastName(last_name);
//                recipient.setEmail(email);
//                recipient.setAdress(adress);
//                recipient.setTrackingid(trackingid);
//                recipients.add(recipient);
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
//        return recipients;
//    }
//
//}
