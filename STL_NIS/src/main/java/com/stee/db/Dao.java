package com.stee.db;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.stee.asm.configuration.Status;

public class Dao {  
 
	
	private static String url;
	private static String user;
	private static String password;
    
//    public static   String url =  "jdbc:mysql://192.168.0.197:3306/sl";       
//    public static   String user =  "sl";  
//    public static   String password = "123456";  
    String name =  "com.mysql.jdbc.Driver"; 
    List<String> list;//记录id
    List<Integer> list1;//记录设备id
    
    
    
    public Dao(String url,String user,String password) {
		 this.url=url;
		 this.password=password; 
		 this.user=user;
	}    
    public Dao (){
    	
    }
    
    public Connection conn = null;  
     public Statement pst = null;  
     
     public List<String> id(){
    	  list=new ArrayList<String>();
    	 try {
			 Class.forName(name);
			 conn = DriverManager.getConnection(url, user, password);//获取连接   
			   pst=conn.createStatement();
	            ResultSet rs=pst.executeQuery("SELECT stl_lim_lamp_info.id from stl_lim_lamp_info;");
	              while (rs.next()) {	                 
	                  String id=rs.getString("stl_lim_lamp_info.id");
	                  list.add(id);
	                  
}
		} catch (Exception e){			 
		}
    	 return list;
     }
  
     //获取转态Id
     public int id1(String id){
    	 int a = 0;
   	 try {
			 Class.forName(name);
			 conn = DriverManager.getConnection(url, user, password);//获取连接   
			   pst=conn.createStatement();
	            ResultSet rs = pst.executeQuery("SELECT stl_lim_lamp_info.status_id from stl_lim_lamp_info WHERE id ='" + id + "'");		 
	              while (rs.next()) {
	                   a= rs.getInt("stl_lim_lamp_info.status_id");	                 
	              }
		} catch (Exception e){			 
		}
   	 return a;
    }
    
     //获取燃烧时间和开关
     public Status mo(int id){
    	 Status status=new Status();
   	 try {
			 Class.forName(name);
			 conn = DriverManager.getConnection(url, user, password);//获取连接   
			   pst=conn.createStatement();
	            ResultSet rs = pst.executeQuery("SELECT stl_lim_lamp_status.burn_hour,stl_lim_lamp_status.lamp_switch from stl_lim_lamp_status where   id ='" + id + "'");
	              while (rs.next()) {
	            	int hour= rs.getInt("stl_lim_lamp_status.burn_hour");
	              	boolean swi = rs.getBoolean("stl_lim_lamp_status.lamp_switch"); 
	              	status.setBurningHour(hour);
	              	status.setLampOn(swi);
	              }
		} catch (Exception e){			 
		}
   	 return status;
    }
     
     //获取寿命
     public int lifetime(String id){
    	 int a = 0;
   	 try {
			 Class.forName(name);
			 conn = DriverManager.getConnection(url, user, password);//获取连接   
			   pst=conn.createStatement();
	            ResultSet rs = pst.executeQuery("SELECT t.lifetime from stl_asm_lifetime t WHERE t.luminaire_id  ='" + id + "'");
	              while (rs.next()) {
	                   a= rs.getInt("t.lifetime");	                 
	              }
		} catch (Exception e){			 
		}
   	 return a;
    }
    
     public void close() {  
        try {  
            this.conn.close();  
            this.pst.close();  
        } catch (SQLException e) {  
            e.printStackTrace();  
        }  
    }
}  