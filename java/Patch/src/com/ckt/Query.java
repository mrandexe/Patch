package com.ckt;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;


/**
 * @version 1.2
 * @author MM
 */
public class Query {
	static PageResultSet rs = null;
	static int pgsize = 20;
	
	// 设置分页
	public static void setPageSize(int size)
	{
		if (size!=0)
		{
			pgsize = size;
		}
	}
	
	// 第一页
	public static void pageFirst()
	{
		try {
			rs.pageFirst();
		} catch (SQLException e) {
		}
	}
	
	// 最后页
	public static void pageEnd()
	{
		try {
			rs.pageEnd();
		} catch (SQLException e) {
		}
	}
	
	// 当前页
	public static int currPage()
	{
		return rs.getCurPage();
	}
	
	// 总分页
	public static int totalPages()
	{
		return rs.getPageCount();
	}
	
	public static List<PatchDeployment> listPage(int curPage)
	{
		Connection conn = null;
		PreparedStatement stmt = null;
		int i = 0;
		String sql = "SELECT * FROM patch_deployment";

		try
		{
			conn = DbConnect.getInstance().getConnection();
			System.out.println("当前连接池大小:"+DbConnect.size());
			stmt = conn.prepareStatement(sql);
			
			rs = new PageResultSet(stmt.executeQuery());
			rs.setPageSize(pgsize);
			System.out.println("每页记录:"+rs.getPageSize()+" 分页:"+rs.getPageCount());
			rs.gotoPage(curPage);
			System.out.println("当前页:"+rs.getCurPage());
			List<PatchDeployment> list = new ArrayList<PatchDeployment>();
			PatchDeployment pDement;
			while (rs.next() && i < rs.getPageRowsCount())
			{
				pDement = new PatchDeployment();
				pDement.setIdpatch_deployment(rs.getInt(1));
				pDement.setIdpatch(rs.getInt(2));
				pDement.setProject(rs.getString(3));
				pDement.setInternal_bug_id(rs.getString(4));
				list.add(pDement);
				i++;
			}
			return list;
		}
		catch (Exception e)
		{
			System.out.println("err: function listPage(void)");
			return null;
		}
		finally
		{
			DbConnect.close(conn, stmt, rs);
		}
	}
	public static List<PatchDeployment> listPage(String sql, List<String> ls)
	{
		Connection conn = null;
		PreparedStatement stmt = null;
		ResultSet rs = null;
		
		try
        {
			//
			conn = DbConnect.getInstance().getConnection();
			stmt = conn.prepareStatement(sql);
			//
			
			for (int i=0; i<ls.size(); i++)
			{
				stmt.setString(i+1, ls.get(i));
			}
			//
			rs = stmt.executeQuery();
			//
			List<PatchDeployment> list = new ArrayList<PatchDeployment>();
			PatchDeployment pDement;
			while (rs.next())
			{
				pDement = new PatchDeployment();
				pDement.setIdpatch_deployment(rs.getInt(1));
				pDement.setIdpatch(rs.getInt(2));
				pDement.setProject(rs.getString(3));
				pDement.setInternal_bug_id(rs.getString(4));
				list.add(pDement);
			}
			return list;
        }
		catch (Exception e)
		{
			System.out.println("err: function listPage(PatchDeployment)");
			return null;
		}
		finally
		{
			DbConnect.close(conn, stmt, rs);
		}

	}
	
	public static List<PatchInfo> listPage(String sql, PatchInfo pi)
	{
		Connection conn = DbConnect.getInstance().getConnection();
		PreparedStatement stmt = null;
		ResultSet rs = null;
		
		try
        {
			//
			stmt = conn.prepareStatement(sql);
			//
			stmt.setString(1, ""+pi.getIdpatch_info());
			stmt.setString(2, ""+pi.getStatus());
			stmt.setString(3, ""+pi.getOriginator());
			stmt.setString(4, ""+pi.getTitle());
			stmt.setString(5, ""+pi.getDescription());
			stmt.setString(6, ""+pi.getRepeat_steps());
			stmt.setString(7, ""+pi.getBranch());
			stmt.setString(8, ""+pi.getPlatform());
			stmt.setString(9, ""+pi.getPatch_id());
			stmt.setString(10, ""+pi.getEservice_id());
			stmt.setString(11, ""+pi.getPatch_name());
			stmt.setString(12, ""+pi.getSw_version());
			//
			rs = stmt.executeQuery();
			//
			List<PatchInfo> list = new ArrayList<PatchInfo>();
			PatchInfo pInfo;
			while (rs.next())
			{
				pInfo = new PatchInfo();
				pInfo.setIdpatch_info(rs.getInt(1));
				pInfo.setStatus(rs.getInt(2));
				pInfo.setOriginator(rs.getString(3));
				pInfo.setTitle(rs.getString(4));
				pInfo.setDescription(rs.getString(5));
				pInfo.setRepeat_steps(rs.getString(6));
				pInfo.setBranch(rs.getString(7));
				pInfo.setPlatform(rs.getString(8));
				pInfo.setPatch_id(rs.getString(9));
				pInfo.setEservice_id(rs.getString(10));
				pInfo.setPatch_name(rs.getString(11));
				pInfo.setSw_version(rs.getString(12));
				list.add(pInfo);
			}
			return list;
        }
		catch (Exception e)
		{
			System.out.println("err: function listPage(PatchInfo)");
			return null;
		}
		finally
		{
			DbConnect.close(conn, stmt, rs);
		}

	}
}
