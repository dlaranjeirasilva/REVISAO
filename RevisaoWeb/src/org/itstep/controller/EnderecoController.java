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

import org.itstep.facade.EnderecoFacade;
import org.itstep.model.Endereco;

@Path("/endereco")
public class EnderecoController {
	
	@GET
	@Produces(MediaType.APPLICATION_JSON)
	@Path("/listarEnderecos")
	public List<Endereco> listarTodosEnderecos(@Context HttpHeaders httpHeaders) {
		List<Endereco> enderecos = new ArrayList<Endereco>();
		EnderecoFacade enderecoFacade = new EnderecoFacade();
		
		try {
			enderecos = enderecoFacade.listarTodosEnderecos();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return enderecos;
		
	}

}
