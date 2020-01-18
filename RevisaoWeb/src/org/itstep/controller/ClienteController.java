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

import org.itstep.facade.ClienteFacade;
import org.itstep.model.Cliente;

@Path("/cliente")
public class ClienteController {
	
	@GET
	@Produces(MediaType.APPLICATION_JSON)
	@Path("/listarClientes")
	public List<Cliente> listarTodosClientes(@Context HttpHeaders httpHeaders) {
		List<Cliente> clientes = new ArrayList<Cliente>();
		ClienteFacade clienteFacade = new ClienteFacade();
		
		try {
			clientes = clienteFacade.listarTodosClientes();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return clientes;
		
	}

}
