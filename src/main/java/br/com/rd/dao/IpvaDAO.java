package br.com.rd.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import br.com.rd.model.Ipva;



public class IpvaDAO {
	public void insert(Ipva ipva) {
		Conexao c = Conexao.getInstance();
		Connection con = c.getConnection();
		
		try {
			PreparedStatement p = con.prepareStatement("insert into ipva (ano) values (?)");
			p.setInt(1, ipva.getAno());

			System.out.println(p);
			p.executeUpdate();
			System.out.println("Comando executado");
			p.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	
	public ArrayList<Ipva> selectAll(){
		Conexao c = Conexao.getInstance();
		Connection con = c.getConnection();
		ArrayList<Ipva> lista = new ArrayList<Ipva>();
		try {
			PreparedStatement p = con.prepareStatement("select * from ipva");
			ResultSet r = p.executeQuery();			
			
			while (r.next()) {
				Integer id = r.getInt("id_ipva");
				Integer ano = r.getInt("ano");
			
				Ipva ipva = new Ipva(ano);
				ipva.setId(id);
				lista.add(ipva);
			}
			r.close();
			p.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return lista;
	}
	
	public void removeIpva(Integer id) {
		Conexao c = Conexao.getInstance();
		Connection con = c.getConnection();
		
		try {
			PreparedStatement p = con.prepareStatement("delete from ipva where id_ipva = ?");
			p.setInt(1, id);
			System.out.println(p);
			p.executeUpdate();
			System.out.println("Comando executado");
			p.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public void updateIpva(Ipva updateIpva) {
		Conexao c = Conexao.getInstance();
		Connection con = c.getConnection();
		
		try {
			PreparedStatement p = con.prepareStatement("update ipva set ano = ? where id_ipva = ?");
			p.setInt(1, updateIpva.getAno());
			p.setInt(2, updateIpva.getId());
			System.out.println(p);
			p.executeUpdate();
			System.out.println("Comando executado");
			p.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
		
	public Ipva selectById(Integer id) {
		Conexao c = Conexao.getInstance();
		Connection con = c.getConnection();
		Ipva ipva = null;
		try {
			PreparedStatement p = con.prepareStatement("select * from ipva where id_ipva = ?");
			p.setInt(1, id);
			ResultSet r = p.executeQuery();			
			while (r.next()) {
				//Integer id = r.getInt("id");
				Integer ano = r.getInt("ano");
				ipva = new Ipva(ano);
				ipva.setId(id);
			}
			r.close();
			p.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return ipva;
	}

}
