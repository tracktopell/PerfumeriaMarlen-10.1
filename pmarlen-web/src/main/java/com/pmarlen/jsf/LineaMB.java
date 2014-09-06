package com.pmarlen.jsf;

import com.pmarlen.model.beans.Linea;
import com.pmarlen.model.controller.LineaJPAController;
import java.util.List;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@ManagedBean(name="lineaMB")
@SessionScoped
@Component
public class LineaMB {
    @Autowired
    LineaJPAController lineaJPAController;

	public LineaMB() {
		System.out.println("->LineaMB created.");
	}
	
	public void setLineaJPAController(LineaJPAController lineaJPAController) {
		this.lineaJPAController = lineaJPAController;
	}
	
	public List<Linea> getLineaList() {
		return this.lineaJPAController.findAllEntities();
	}
	
}
