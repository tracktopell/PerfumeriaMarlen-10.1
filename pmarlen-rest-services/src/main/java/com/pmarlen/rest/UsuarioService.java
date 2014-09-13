package com.pmarlen.rest;

import com.pmarlen.model.beans.Perfil;
import com.pmarlen.model.beans.Usuario;
import com.pmarlen.model.controller.UsuarioJPAController;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.beans.factory.annotation.Autowired;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@Controller("usuarioService")
@RequestMapping("/usuario")
public class UsuarioService {
	private Logger logger;

	public UsuarioService() {
		logger = LoggerFactory.getLogger(UsuarioService.class);
		logger.debug("->UsuarioService, created");
	}
	
	@Autowired
	private UsuarioJPAController usuarioJPAController;	

	public void setUsuarioJPAController(UsuarioJPAController usuarioJPAController){
		this.usuarioJPAController=usuarioJPAController;
	}
	
	@RequestMapping(value = "getAll", method = RequestMethod.GET, produces = "application/json")
	public @ResponseBody List<com.pmarlen.wscommons.services.dto.Usuario> getAll() {	
		logger.debug("->getAll invoked.");
		List<com.pmarlen.wscommons.services.dto.Usuario> result=new ArrayList<com.pmarlen.wscommons.services.dto.Usuario>();		
		
		final List<Usuario> jpaList = usuarioJPAController.findAllEntities();
		logger.debug("->getAll jpaList is null ?"+(jpaList==null));

		com.pmarlen.wscommons.services.dto.Usuario dto = null;
		for(Usuario l: jpaList){
			final Collection<Perfil> perfilCollection = l.getPerfilCollection();
			List<com.pmarlen.wscommons.services.dto.Perfil> perfilList=new ArrayList<com.pmarlen.wscommons.services.dto.Perfil>();
			for(Perfil p: perfilCollection){
				perfilList.add(new com.pmarlen.wscommons.services.dto.Perfil(p));
			}
			dto = new com.pmarlen.wscommons.services.dto.Usuario(l);			
			dto.setPerfilList(perfilList);
			result.add(dto);
			logger.debug("->getAll \tadd dto:"+dto);
		}
		
		return result;
	}
}