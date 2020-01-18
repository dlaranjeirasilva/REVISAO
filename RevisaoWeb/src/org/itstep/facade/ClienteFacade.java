package org.itstep.facade;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.itstep.dao.JdbcDAOFactory;
import org.itstep.model.Cliente;

public class ClienteFacade {
	
	public List<Cliente> listarTodosClientes() throws SQLException {
		JdbcDAOFactory jdbc = new JdbcDAOFactory();
		List<Cliente> clientes = new ArrayList<Cliente>();
		
	try {
				
		String sql = "SELECT ID, MATRICULA, NOME FROM TREVISAO.CLIENTE";
		PreparedStatement ps = jdbc.getConexao().prepareStatement(sql);
		
		ResultSet rs = ps.executeQuery();
		
		while(rs.next()) {
			
			Cliente cliente = new Cliente();
			cliente.setId(rs.getLong("id"));
			cliente.setMatricula(rs.getString("matricula"));
			cliente.setNome(rs.getString("nome"));
			
			clientes.add(cliente);
			cliente = null;
			
		}
		
	} catch (Exception e) {
		System.out.println("Erro na execução da busca de todos os clientes.");
		e.printStackTrace();
	}		
		
		return clientes;
		
	}

}
