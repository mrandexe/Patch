package com.ckt;
import java.sql.*;
import java.util.Vector;

/**
 * @version 1.1
 * @author MM
 */
public class DbConnect {
	private static DbConnect db = null;
	private static String url = "jdbc:mysql://127.0.0.1:3306/patch_management";
	private static String user = "root";
	private static String pass = "11011300";
	private static int    pool_size = 5;
	private static Vector<Connection> pool = null;
	
	
	public synchronized static DbConnect getInstance()
	{
		if (db==null)
		{
			db = new DbConnect();
			initPool();
		}
		return db;
	}
	
	public synchronized static int size()
	{
		return pool.size();
	}
	private synchronized static Connection createConn(){
		Connection conn = null;
		try {
			conn = DriverManager.getConnection(url, user, pass);
		} catch (SQLException e) {
		}
		return conn;
	}
	
	private synchronized static void initPool()
	{
		try {
			Class.forName("com.mysql.jdbc.Driver");// 创建数据库驱动
			if (pool==null)
			{
				pool = new Vector<Connection>();
			}
			
			for (int i=0; i<pool_size; i++)
			{
				
				pool.add(createConn());
			}
		} catch (Exception e) {
			System.out.println("DB  异常");
		}
	}
	
	public synchronized Connection getConnection()
	{
		int last = pool.size()-1;
		if (last<=0)
		{
			pool.add(createConn());
		}
		Connection conn = pool.get(last);
		pool.remove(last);
		return conn;
	}
	
	public static void close(Connection conn, Statement stmt, ResultSet rs)
	{
		closeResult(rs);
		closeStatemnet(stmt);
		closeConnection(conn);
	}
	
	public static void closeResult(ResultSet rs)
	{
		try
		{
			if (rs != null)
			{
			    //if (!rs.isClosed())
				{
					rs.close();
				}
			}
		}
		catch (Exception e)
		{
			System.out.println("ResultSet 关闭异常");
		}

	}

	public static void closeStatemnet(Statement stmt)
	{
		try
		{
			if (stmt != null)
			{
				//if (!stmt.isClosed())
				{
					stmt.close();
				}
			}
		}
		catch (Exception e)
		{
			System.out.println("Statement 关闭异常");
		}

	}

	public static void closeConnection(Connection conn)
	{
		try
		{
			if (conn != null)
			{
				//if (!conn.isClosed())
				{
					pool.add(conn);
				}
			}
		}
		catch (Exception e)
		{
			System.out.println("Connection 关闭异常");
		}
	}
}
