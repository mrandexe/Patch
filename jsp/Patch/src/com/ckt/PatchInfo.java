package com.ckt;

public class PatchInfo {
	private int idpatch_info;
	private int status;
	private String originator;
	private String title;
	private String description;
	private String repeat_steps;
	private String branch;
	private String platform;
	private String patch_id;
	private String eservice_id;
	private String patch_name;
	private String sw_version;
	
	public PatchInfo(){
		
	}
	
	public PatchInfo(int idpatch_info, int status, String originator, String title, String description,
	String repeat_steps, String branch, String platform, String patch_id, String eservice_id, String patch_name, String sw_version){
		this.setIdpatch_info(idpatch_info);
		this.setStatus(status);
		this.setOriginator(originator);
		this.setTitle(title);
		this.setDescription(description);
		this.setRepeat_steps(repeat_steps);
		this.setBranch(branch);
		this.setPatch_id(patch_id);
		this.setEservice_id(eservice_id);
		this.setPatch_name(patch_name);
		this.setSw_version(sw_version);
	}
	
	public int getStatus() {
		return status;
	}

	public void setStatus(int status) {
		this.status = status;
	}

	public String getOriginator() {
		return originator;
	}

	public void setOriginator(String originator) {
		this.originator = originator;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getRepeat_steps() {
		return repeat_steps;
	}

	public void setRepeat_steps(String repeat_steps) {
		this.repeat_steps = repeat_steps;
	}

	public String getBranch() {
		return branch;
	}

	public void setBranch(String branch) {
		this.branch = branch;
	}

	public String getPlatform() {
		return platform;
	}

	public void setPlatform(String platform) {
		this.platform = platform;
	}

	public String getPatch_id() {
		return patch_id;
	}

	public void setPatch_id(String patch_id) {
		this.patch_id = patch_id;
	}

	public String getEservice_id() {
		return eservice_id;
	}

	public void setEservice_id(String eservice_id) {
		this.eservice_id = eservice_id;
	}

	public String getPatch_name() {
		return patch_name;
	}

	public void setPatch_name(String patch_name) {
		this.patch_name = patch_name;
	}

	public String getSw_version() {
		return sw_version;
	}

	public void setSw_version(String sw_version) {
		this.sw_version = sw_version;
	}
	
	public int getIdpatch_info() {
		return idpatch_info;
	}
	
	public void setIdpatch_info(int idpatch_info) {
		this.idpatch_info = idpatch_info;
	}
}
