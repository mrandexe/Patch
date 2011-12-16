package com.ckt;

import java.sql.*;

/**
 * @version 1.2
 * @author MM
 */
public class Update {
	
	
	public static int update(String sql, PatchDeployment pd)
	{
		Connection conn = null;
		PreparedStatement stmt = null;
		int err = -1;
		
		try
		{
			conn = DbConnect.getInstance().getConnection();
			stmt = conn.prepareStatement(sql);
			//
			stmt.setString(1, ""+pd.getIdpatch_deployment());
			stmt.setString(2, ""+pd.getIdpatch());
			stmt.setString(3, ""+pd.getProject());
			stmt.setString(4, ""+pd.getInternal_bug_id());
			//
			err = stmt.executeUpdate();
		}
		catch (Exception e)
		{
			System.out.println("err: function update(PatchDeployment)");
			return err;
		}
		
		return err;
	}
	
	public static int update(String sql, PatchInfo pi)
	{
		Connection conn = null;
		PreparedStatement stmt = null;
		int err = -1;
		
		try
		{
			conn = DbConnect.getInstance().getConnection();
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
			err = stmt.executeUpdate();
		}
		catch (Exception e)
		{
			System.out.println("err: function update(PatchInfo)");
			return err;
		}
		
		return err;
	}
}
