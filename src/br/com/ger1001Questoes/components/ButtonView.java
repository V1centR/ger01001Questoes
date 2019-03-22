package br.com.ger1001Questoes.components;


import java.util.ArrayList;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.context.FacesContext;

import org.primefaces.model.menu.DefaultMenuItem;
import org.primefaces.model.menu.DefaultMenuModel;
import org.primefaces.model.menu.DefaultSubMenu;
import org.primefaces.model.menu.MenuModel;

@ManagedBean
public class ButtonView {
	
	 private MenuModel model;
	 private List<String> items;
	 
	 @PostConstruct
	 public void init() {
		 
		 model = new DefaultMenuModel();

		 DefaultMenuItem item = new DefaultMenuItem("External");
		 DefaultSubMenu secondSubmenu = new DefaultSubMenu("Dynamic Actions");
		 
		 item = new DefaultMenuItem("Save");
	     item.setIcon("pi pi-save");
	     item.setCommand("#{buttonView.save}");
	     item.setUpdate("messages");
	     secondSubmenu.addElement(item);
	     
	     items = new ArrayList<>();
	     items.add("shirt");
	     items.add("skirt");
	     items.add("trouser");
	     
	     model.addElement(secondSubmenu);
		 
	 }

	  public List<String> getItems() {
	    return items;
	  }
	 
	 public MenuModel getModel() {
	        return model;
	 }
	 
	 public void save() {
	    addMessage("Data saved");
	 }
	 
	 public void addMessage(String summary) {
	        FacesMessage message = new FacesMessage(FacesMessage.SEVERITY_INFO, summary, null);
	        FacesContext.getCurrentInstance().addMessage(null, message);
	 }
	

}
