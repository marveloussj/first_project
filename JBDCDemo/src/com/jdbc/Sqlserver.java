package com.jdbc;
import java.sql.*;
public class Sqlserver {
public static void main(String[] args) {
// TODO Auto-generated method stub
String url="jdbc:sqlserver://localhost:1433; DatabaseName=soft";
String driver="com.microsoft.sqlserver.jdbc.SQLServerDriver";
        
Statement st;
Connection con;
try{
Class.forName(driver);//加载驱动
}
catch(ClassNotFoundException event){System.out.print("无法创建驱动程式实体!");}
try{
 
con=DriverManager.getConnection(url,"sa","1234");
con.setAutoCommit(true);
System.out.println("已经连接到数据库...");
st=con.createStatement();
       ResultSet rs=st.executeQuery("SELECT * from test ");
    
     	while(rs.next())
     {   String name=rs.getString("name"); 
     	     System.out.println(name);
       	 }
  
   st.close();
       	con.close(); 
    }
   	catch(SQLException e1) {System.out.println("异常"+e1);}
 	} 
}