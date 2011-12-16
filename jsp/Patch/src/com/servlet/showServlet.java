package com.servlet;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.ckt.PatchDeployment;
import com.ckt.Query;

@SuppressWarnings("serial")
public class showServlet extends HttpServlet{

	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String pg = request.getParameter("page");
		int page = 1;
		if (pg!=null)
		{
			page = Integer.parseInt(pg);
		}
			
		ArrayList<PatchDeployment> ls = Query.listPage(page);
		request.setAttribute("list", ls);
		request.getRequestDispatcher("show.jsp").forward(request, response);
	}

	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		ArrayList<PatchDeployment> ls = Query.listPage(1);
		request.setAttribute("list", ls);
		request.getRequestDispatcher("show.jsp").forward(request, response);
	}

	@Override
	public void init() throws ServletException {
		Query.setPageSize(20);
	}

	
}
