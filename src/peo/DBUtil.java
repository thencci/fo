package peo;

import java.sql.*;

public class DBUtil {	
	//               "jdbc:sqlserver://localhost:1433;databasename=tran_server"
	//               url="jdbc:mysql://localhost:3306/hcdp?characterEncoding=utf-8";
	private static String dbUrl="jdbc:mysql://localhost:3306/epidemicdata?characterEncoding=utf-8";
	private static String dbUser="root";
	private static String dbPassword="123456";
	private static String jdbcName="com.mysql.jdbc.Driver";
	
	//连接数据库
	public static Connection getConn(){
		Connection conn = null;
		try{
			Class.forName(jdbcName);
		}
		catch(Exception e){}
		try{
			conn=DriverManager.getConnection(dbUrl,dbUser,dbPassword);
		}
		catch(SQLException ex){}
		return conn;		
	}
	
//    测试
	public static void main(String[] args)
	{
		DBUtil dbUtil = new DBUtil();
		try {
			DBUtil.getConn();
			//System.out.println("数据库连接成功!");
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		//System.out.println(new DBUtil().getConn());
		
	}
	
}
