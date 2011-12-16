package com.ckt;

import java.sql.*;

public interface Pageable extends ResultSet{
	
	public int getPageCount();
	public int getPageRowsCount();
	public int getPageSize();
	public void setPageSize(int size);
	public void gotoPage(int page);
	public int getRowsCount();
	public void pageFirst() throws SQLException;
	public void pageEnd() throws SQLException;
	public int getCurPage();
}
