package controller;

import java.io.IOException;

import javax.faces.bean.ManagedBean;
import javax.faces.context.FacesContext;

//@ManagedBean(name = "MenuBean")
public class MenuBean {
	
	
	
	public void sair() throws IOException {
		System.out.println("Passou");
		//FacesContext.getCurrentInstance().getExternalContext().redirect("login.xhtml");
	}

}
