package com.ckt;

/**
 * @version 1.1
 * @author MM
 */
public class PatchDeployment {
	private int idpatch_deployment;
	private int idpatch;
	private String project;
	private String internal_bug_id;
	
	public PatchDeployment(int idpatch_deployment, int idpatch, String project, String internal_bug_id){
		this.setIdpatch_deployment(idpatch_deployment);
		this.setIdpatch(idpatch);
		this.setProject(project);
		this.setInternal_bug_id(internal_bug_id);
	}
	
	public PatchDeployment()
	{
		idpatch_deployment = 0;
		idpatch = 0;
		project = "";
		internal_bug_id = "";
	}
	
	public int getIdpatch_deployment() {
		return idpatch_deployment;
	}
	public void setIdpatch_deployment(int idpatch_deployment) {
		this.idpatch_deployment = idpatch_deployment;
	}
	public int getIdpatch() {
		return idpatch;
	}
	public void setIdpatch(int idpatch) {
		this.idpatch = idpatch;
	}
	public String getProject() {
		return project;
	}
	public void setProject(String project) {
		this.project = project;
	}
	public String getInternal_bug_id() {
		return internal_bug_id;
	}
	public void setInternal_bug_id(String internal_bug_id) {
		this.internal_bug_id = internal_bug_id;
	}
}
