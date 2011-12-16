package com.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.ckt.Update;

@SuppressWarnings("serial")
public class deleteServlet extends HttpServlet{

	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String page = request.getParameter("page");
		Update.delete(page);
		request.getRequestDispatcher("show.jsp").forward(request, response);
	}

	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse resp)
			throws ServletException, IOException {
		
	}

}
