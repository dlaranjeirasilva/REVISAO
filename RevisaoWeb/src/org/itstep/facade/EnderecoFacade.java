package org.itstep.facade;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.itstep.dao.JdbcDAOFactory;
import org.itstep.model.Endereco;

public class EnderecoFacade {
	
	public List<Endereco> listarTodosEnderecos() throws SQLException {
		JdbcDAOFactory jdbc = new JdbcDAOFactory();
		List<Endereco> enderecos = new ArrayList<Endereco>();
		
	try {
				
		String sql = "SELECT ID, IDCLIENTE, LOGRADOURO, COMPLEMENTO, NUMERO, BAIRRO, UF, CEP FROM TREVISAO.ENDERECO";
		PreparedStatement ps = jdbc.getConexao().prepareStatement(sql);
		
		ResultSet rs = ps.executeQuery();
		
		while(rs.next()) {
			
			Endereco endereco = new Endereco();
			endereco.setId(rs.getLong("id"));
			endereco.setIdCliente(rs.getLong("idCliente"));
			endereco.setLogradouro(rs.getString("logradouro"));
			endereco.setComplemento(rs.getString("complemento"));
			endereco.setNumero(rs.getString("numero"));
			endereco.setBairro(rs.getString("bairro"));
			endereco.setUf(rs.getString("uf"));
			endereco.setCep(rs.getString("cep"));

			enderecos.add(endereco);
			endereco = null;
			
		}
		
	} catch (Exception e) {
		System.out.println("Erro na execução da busca de todos os endereços.");
		e.printStackTrace();
	}		
		
		return enderecos;
		
	}

}
