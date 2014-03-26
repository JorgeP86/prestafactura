package com.prestafacturaService.vista.action.login;

import java.util.Map;

import org.apache.struts2.interceptor.SessionAware;

import com.opensymphony.xwork2.ActionSupport;

public class LogoutAction extends ActionSupport implements SessionAware{

	/**
	 * 
	 */
	private static final long serialVersionUID = -3277337689500567507L;
	private Map<String, Object> session;
	
	public void setSession(Map<String, Object> session) {
		this.session=session;
		
	}
	@Override
	public String execute(){
		session.remove("user");
		return SUCCESS;
		
	}

}