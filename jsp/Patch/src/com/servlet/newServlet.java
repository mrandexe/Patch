package com.servlet;
import java.io.IOException;

import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.ckt.PatchDeployment;
import com.ckt.Update;



@SuppressWarnings("serial")
public class newServlet extends HttpServlet {
	List<PatchDeployment> list = null;
	public newServlet() {
		super();
	}

	public void destroy() {
		super.destroy(); // Just puts "destroy" string in log
	}

	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
	}

	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		int idpatch = Integer.parseInt(request.getParameter("idp"));
		String project = request.getParameter("pro");
		String internal_bug_id = request.getParameter("bug");
		request.getParameter("sta");
		
		String sql = "INSERT INTO patch_deployment (idpatch_deployment, idpatch, project, internal_bug_id) VALUES (?,?,?,?)";
		PatchDeployment pd = new PatchDeployment();
		pd.setIdpatch_deployment(0);
		pd.setIdpatch(idpatch);
		pd.setProject(project);
		pd.setInternal_bug_id(internal_bug_id);
		Update.insert(sql, pd);
		request.getRequestDispatcher("show.jsp").forward(request, response);
	}

	public void init() throws ServletException {
		
	}

}
