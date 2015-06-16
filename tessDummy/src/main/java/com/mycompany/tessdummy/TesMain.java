/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.tessdummy;

import com.mysql.jdbc.Connection;
import com.mysql.jdbc.Statement;
import java.io.File;
import javax.naming.NamingException;
import net.sourceforge.tess4j.Tesseract;
import net.sourceforge.tess4j.TesseractException;
import java.sql.*;

/**
 *
 * @author kasun
 */
public class TesMain {
    
    
    
    // JDBC driver name and database URL
        static final String JDBC_DRIVER = "com.mysql.jdbc.Driver";  
        static final String DB_URL = "jdbc:mysql://localhost/Tesseract_Output";

        //  Database credentials
        static final String USER = "teseract_user";
        static final String PASS = "password";
    
    //method fovr jdbc connection
        static Connection connctToDb() throws NamingException{

               Connection conn = null;
               
               try{
                  //STEP 2: Register JDBC driver
                  Class.forName("com.mysql.jdbc.Driver");

                  //STEP 3: Open a connection
                  System.out.println("Connecting to database...");
                  conn = (Connection) DriverManager.getConnection(DB_URL,USER,PASS);

                  /*
                  //STEP 4: Execute a query
                  System.out.println("Creating statement...");
                  stmt = (Statement) conn.createStatement();
                  String sql;
                  sql = "SELECT id, first, last, age FROM Employees";
                  ResultSet rs = stmt.executeQuery(sql);

                  //STEP 5: Extract data from result set
                  while(rs.next()){
                     //Retrieve by column name
                     int id  = rs.getInt("id");
                     int age = rs.getInt("age");
                     String first = rs.getString("first");
                     String last = rs.getString("last");

                     //Display values
                     System.out.print("ID: " + id);
                     System.out.print(", Age: " + age);
                     System.out.print(", First: " + first);
                     System.out.println(", Last: " + last);
                          
                        
                  }
                  //STEP 6: Clean-up environment
                  rs.close();
                  stmt.close();
                  conn.close();
                            */
               }catch(SQLException se){
                  //Handle errors for JDBC
                  se.printStackTrace();
               }catch(Exception e){
                  //Handle errors for Class.forName
                  e.printStackTrace();
               }finally{
                  //finally block used to close resources
//                  try{
//                     if(stmt!=null)
//                        stmt.close();
//                  }catch(SQLException se2){
//                  }// nothing we can do
//                  try{
//                     if(conn!=null)
//                       // conn.close();
//                  }catch(SQLException se){
//                    // se.printStackTrace();
//                  }//end finally try
               }//end try
               System.out.println("Goodbye!");
               return conn;

               }
        
        
        static void insertOutput(Connection conn,String output,String filelocation) throws SQLException{
             
             System.out.println("Creating statement...");
             
                  
//                  String sql;
//                  sql = "INSERT INTO output_text (file_location,output_string) values('"+filelocation+"','"+output+"')";
                  Statement s=(Statement) conn.createStatement();
                   s.executeUpdate("INSERT INTO output_text (file_location,output_string) values('"+filelocation+"','"+output+"')");
                  
                  s.close();
                  conn.close();
                  System.out.println("One Record added!!");
                
                 
            
        }

                public static void main(String[] args) throws NamingException, SQLException {
                    
                    System.setProperty("jna.library.path", "32".equals(System.getProperty("sun.arch.data.model")) ? "lib/win32-x86" : "lib/win32-x86-64");
                    
                    File imageFile = new File("eurotext.tif");
                    Tesseract instance = Tesseract.getInstance();  // JNA Interface Mapping
                    // Tesseract1 instance = new Tesseract1(); // JNA Direct Mapping
                    // File tessDataFolder = LoadLibs.extractTessResources("tessdata"); // Maven build bundles English data
                    // instance.setDatapath(tessDataFolder.getAbsolutePath());

                    try {
                        String result = instance.doOCR(imageFile);
                        System.out.println(result);
                        Connection con=TesMain.connctToDb();
                        TesMain.insertOutput(con,"eurotext.tif", result);
                        
                    } catch (TesseractException e) {
                        System.err.println(e.getMessage());
                    }



    
        
    }
    
}
