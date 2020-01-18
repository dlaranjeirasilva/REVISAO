package org.itstep.facade;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.itstep.dao.JdbcDAOFactory;
import org.itstep.model.Telefone;

public class TelefoneFacade {
	
	public List<Telefone> listarTodosTelefones() throws SQLException {
		JdbcDAOFactory jdbc = new JdbcDAOFactory();
		List<Telefone> telefones = new ArrayList<Telefone>();
		
	try {
			
		String sql = "SELECT ID, IDCLIENTE, DDD, NUMERO FROM TREVISAO.CLIENTE";
		PreparedStatement ps = jdbc.getConexao().prepareStatement(sql);
		
		ResultSet rs = ps.executeQuery();
		
		while(rs.next()) {
			
			Telefone telefone = new Telefone();
			telefone.setId(rs.getLong("id"));
			telefone.setIdCliente(rs.getLong("idCliente"));
			telefone.setDdd(rs.getInt("ddd"));
			telefone.setNumero(rs.getInt("numero"));


			telefones.add(telefone);
			telefone = null;
			
		}
		
	} catch (Exception e) {
		System.out.println("Erro na execução da busca de todos os telefones.");
		e.printStackTrace();
	}		
		
		return telefones;
		
	}

}
