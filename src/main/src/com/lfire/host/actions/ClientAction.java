package com.lfire.host.actions;

import org.apache.struts2.convention.annotation.Action;
import org.apache.struts2.convention.annotation.Namespace;
import org.apache.struts2.convention.annotation.ParentPackage;
import org.apache.struts2.convention.annotation.Result;
import org.springframework.stereotype.Controller;
@Controller 
public class ClientAction {

	public String login(){
		System.out.println("------");
		return "login";
	}
}
