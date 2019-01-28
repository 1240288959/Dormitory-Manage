package com.b10_608.DM.utils;

import java.sql.*;

public class JdbcUtils {
     private static String url="jdbc:mysql://localhost:3306/bizzard?characterEncoding=utf8";
     private static String user="root";
     private static String password="955300";
     private  JdbcUtils(){}
     static{
          try {
               Class.forName("com.mysql.jdbc.Driver");
          } catch (ClassNotFoundException e) {
               throw new ExceptionInInitializerError(e);
          }
     }
     public static Connection getConnection() throws SQLException{
    	 return DriverManager.getConnection(url,user,password);
     }
     public static void free(ResultSet rs, Statement st, Connection conn){
    	 
			try {
				if(rs!=null)
				   rs.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}finally{
					try {
						if(st!=null)
						   st.close();
					} catch (SQLException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}finally{
						try {
						  if(conn!=null)
							conn.close();
						} catch (SQLException e) {
							// TODO Auto-generated catch block
							e.printStackTrace();
						}
					}
			}
     }
}
