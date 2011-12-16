package com.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.ckt.PatchDeployment;
import com.ckt.Update;

@SuppressWarnings("serial")
public class modifyServlet extends HttpServlet {

	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse resp)
			throws ServletException, IOException {

	}

	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		int dep = Integer.parseInt(request.getParameter("dep"));
		int idpatch = Integer.parseInt(request.getParameter("idp"));
		String project = request.getParameter("pro");
		String internal_bug_id = request.getParameter("bug");
		String state = request.getParameter("sta");
		
		
		PatchDeployment pd = new PatchDeployment();
		pd.setIdpatch_deployment(dep);
		pd.setIdpatch(idpatch);
		pd.setProject(project);
		pd.setInternal_bug_id(internal_bug_id);
		
		Update.update(pd);
		response.sendRedirect("show.jsp");
	}
	
}
