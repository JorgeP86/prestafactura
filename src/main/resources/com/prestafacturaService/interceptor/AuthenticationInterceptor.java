package com.prestafacturaService.interceptor;

import java.util.Map;

import com.opensymphony.xwork2.ActionInvocation;
import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.interceptor.Interceptor;
import com.prestafacturaService.mongo.dto.Usuario;

public class AuthenticationInterceptor implements Interceptor{

	/**
	 * 
	 */
	private static final long serialVersionUID = 530033756572512232L;


	public void destroy() {
		// TODO Auto-generated method stub
		
	}

	public void init() {
		// TODO Auto-generated method stub
		
	}

	public String intercept(ActionInvocation invocation) throws Exception {
		Map<String, Object> session= invocation.getInvocationContext().getSession();
		Usuario u=(Usuario) session.get("user");
		if(u==null){
			return ActionSupport.LOGIN;
		}else{
			return invocation.invoke();
		}
}
	

}
