package com.prestafacturaService.vista.action.login;

import javax.servlet.http.HttpServletRequest;

import org.apache.struts2.interceptor.ServletRequestAware;

import com.opensymphony.xwork2.ActionSupport;

public class LogoutAction extends ActionSupport implements ServletRequestAware {

	/**
	 * 
	 */
	private static final long serialVersionUID = -5504945475323171912L;
	private HttpServletRequest servletRequest;
	private static final String Success = "success";


	@Override
	public String execute(){
		servletRequest.getSession().invalidate();
		return SUCCESS;	
	}
	
	
	public HttpServletRequest getServletRequest() {
		return servletRequest;
	}


	public void setServletRequest(HttpServletRequest servletRequest) {
		this.servletRequest = servletRequest;
	}

	

}