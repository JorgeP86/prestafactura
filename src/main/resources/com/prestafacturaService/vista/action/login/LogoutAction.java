package com.prestafacturaService.vista.action.login;

import javax.servlet.http.HttpServletRequest;

import org.apache.log4j.Logger;
import org.apache.struts2.interceptor.ServletRequestAware;

import com.opensymphony.xwork2.ActionSupport;

public class LogoutAction extends ActionSupport implements ServletRequestAware {

	/**
	 * 
	 */
	private static final long serialVersionUID = -5504945475323171912L;
	private HttpServletRequest servletRequest;
	private static final String Success = "success";
	
	private static final Logger logger = Logger.getLogger(LogoutAction.class);


	@Override
	public String execute(){
		servletRequest.getSession().invalidate();
		logger.info("Session invalidada");

		return SUCCESS;	
	}
	
	
	public HttpServletRequest getServletRequest() {
		return servletRequest;
	}


	public void setServletRequest(HttpServletRequest servletRequest) {
		this.servletRequest = servletRequest;
	}

	

}