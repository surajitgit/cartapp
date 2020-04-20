package com.cart.customdto;

import java.io.Serializable;
import java.util.Date;

public class CustomResponseUser implements Serializable{

	public CustomResponseUser() {
		
	}
	/**
	 * 
	 */
	private static final long serialVersionUID = -8352357254167952877L;
	private String name;
	private String email;
	private String organization;
	private String corporatename;
	private String usrtype;
	private String appid;
	private String msg;
	private Integer status;
	private String active;
	private Integer meetingid;
	private Date createdon;
	private String createdby;
	private Date joinedon;
	private String joinedby;
	private Date updatedon;
	private String mode;
	private float appversion;
	private float webrtcversion;
	private Date modificationdt;
	
	//private ResponseMsg rspmsg = new ResponseMsg();
	
	
	/*static response*/
	public static String USR_ACC_NOT_FOUND = "User account not found !!";
	public static String USR_PAS_WRNG = "User password wrong !!";
	public static String USR_BLOCK = "Your account is blocked !!";
	public static String USR_SUCCESS = "success";
	public static String DUPLICATE_USR_ERR = "Duplicate user";
	public static String DUPLICATE_EMAIL = "Non-Apple login already found in record";
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getOrganization() {
		return organization;
	}
	public void setOrganization(String organization) {
		this.organization = organization;
	}
	public String getCorporatename() {
		return corporatename;
	}
	public void setCorporatename(String corporatename) {
		this.corporatename = corporatename;
	}
	public String getUsrtype() {
		return usrtype;
	}
	public void setUsrtype(String usrtype) {
		this.usrtype = usrtype;
	}
	public String getAppid() {
		return appid;
	}
	public void setAppid(String appid) {
		this.appid = appid;
	}
	public String getMsg() {
		return msg;
	}
	public void setMsg(String msg) {
		this.msg = msg;
	}
	public Integer getStatus() {
		return status;
	}
	public void setStatus(Integer status) {
		this.status = status;
	}
	public Date getCreatedon() {
		return createdon;
	}
	public void setCreatedon(Date createdon) {
		this.createdon = createdon;
	}
	public Date getUpdatedon() {
		return updatedon;
	}
	public void setUpdatedon(Date updatedon) {
		this.updatedon = updatedon;
	}
	public String getActive() {
		return active;
	}
	public void setActive(String active) {
		this.active = active;
	}
	public Integer getMeetingid() {
		return meetingid;
	}
	public void setMeetingid(Integer meetingid) {
		this.meetingid = meetingid;
	}
	public String getMode() {
		return mode;
	}
	public void setMode(String mode) {
		this.mode = mode;
	}
	public String getJoinedby() {
		return joinedby;
	}
	public void setJoinedby(String joinedby) {
		this.joinedby = joinedby;
	}
	public String getCreatedby() {
		return createdby;
	}
	public void setCreatedby(String createdby) {
		this.createdby = createdby;
	}
	public Date getJoinedon() {
		return joinedon;
	}
	public void setJoinedon(Date joinedon) {
		this.joinedon = joinedon;
	}
	public float getAppversion() {
		return appversion;
	}
	public void setAppversion(float appversion) {
		this.appversion = appversion;
	}
	public float getWebrtcversion() {
		return webrtcversion;
	}
	public void setWebrtcversion(float webrtcversion) {
		this.webrtcversion = webrtcversion;
	}
	public Date getModificationdt() {
		return modificationdt;
	}
	public void setModificationdt(Date modificationdt) {
		this.modificationdt = modificationdt;
	}

}
