package com.prestafacturaService.vista.action.login;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;

@Component("springDemoAction")
@Scope(value="session")
public class CrearCabecera extends ActionSupport{

	private static final long serialVersionUID = -2320776611453212160L;

 
	 public static final String SUCCESS = "success";
   
	 
	 public String execute() throws Exception{
		 ActionContext.getContext().getSession().get(SUCCESS);
		return null;
		 
	 }
}
