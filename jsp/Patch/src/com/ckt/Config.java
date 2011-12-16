package com.ckt;

import java.sql.*;

/**
 * @version 1.2
 * @author MM
 */
public class Config
{
	private static Config db = null;
	private static String url = "jdbc:mysql://10.120.10.101:3306/patch_management";//10.120.10.101
	private static String user = "pms_guest";//"pms_guest";
	private static String password = "pms_guest";//"pms_guest";
	
	
	public Config()
	{
		try {
			Class.forName("com.mysql.jdbc.Driver");
		} catch (ClassNotFoundException e) {
			System.out.println("未找到驱动  异常");
		}
	}
	
	public static Config getInstance()
	{
		if (db==null)
		{
			db = new Config();
		}
		return db;
	}
	
	public Connection getConnection()
	{
		try
		{
			Class.forName("com.mysql.jdbc.Driver");
			// 获取Connection
			return DriverManager.getConnection(url, user, password);
		}
		catch (Exception e)
		{
			System.out.println("getConnection 异常");
			return null;
		}
		finally
		{
			//System.out.println(url+user+password);
		}
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
					conn.close();
				}
			}
		}
		catch (Exception e)
		{
			System.out.println("Connection 关闭异常");
		}
	}
}
