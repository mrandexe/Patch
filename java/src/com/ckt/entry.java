package com.ckt;

import java.util.List;





public class entry {

	/**
	 * @param args
	 */
	static int i = 0;
	static Boolean b = false;
	public static void main(String[] args) {
		
		if (!b)
		{
			Query.setPageSize(13);
			List<PatchDeployment> li = Query.listPage(4);
			//rs.setPageSize(20);
			//System.out.println(rs.getPageCount());
			//System.out.println(rs.getPageRowsCount());
			//System.out.println(rs.getPageSize());
			//rs.gotoPage(1);
			for (int i=0; i<li.size(); i++)
			{
				System.out.println(li.get(i).getIdpatch_deployment());
			}
		}
		else
		{
				String sql = "INSERT INTO patch_deployment VALUES(?,?,?,?)";
				PatchDeployment pd = new PatchDeployment(0, 0, "WOW", "WOW");
				System.out.println(Update.update(sql, pd));
		}
	}

}
