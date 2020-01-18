package org.itstep.controller;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.HttpHeaders;
import javax.ws.rs.core.MediaType;

import org.itstep.facade.TelefoneFacade;
import org.itstep.model.Telefone;

@Path("/telefone")
public class TelefoneController {
	
	@GET
	@Produces(MediaType.APPLICATION_JSON)
	@Path("/listarTelefones")
	public List<Telefone> listarTodosTelefones(@Context HttpHeaders httpHeaders) {
		List<Telefone> telefones = new ArrayList<Telefone>();
		TelefoneFacade telefoneFacade = new TelefoneFacade();
		
		try {
			telefones = telefoneFacade.listarTodosTelefones();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return telefones;
		
	}

}
