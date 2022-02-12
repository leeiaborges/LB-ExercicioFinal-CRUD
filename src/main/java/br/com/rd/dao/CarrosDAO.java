package br.com.rd.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import br.com.rd.model.Carros;


public class CarrosDAO {
	public void insert(Carros carro) {
		Conexao c = Conexao.getInstance();
		Connection con = c.getConnection();
		
		try {
			PreparedStatement p = con.prepareStatement("insert into carros (modelo, ano) values (?, ?)");
			p.setString(1, carro.getModelo());
			p.setInt(2, carro.getAno());

			System.out.println(p);
			p.executeUpdate();
			System.out.println("Comando executado");
			p.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	
	public ArrayList<Carros> selectAll(){
		Conexao c = Conexao.getInstance();
		Connection con = c.getConnection();
		ArrayList<Carros> lista = new ArrayList<Carros>();
		try {
			PreparedStatement p = con.prepareStatement("select * from carros");
			ResultSet r = p.executeQuery();			
			
			while (r.next()) {
				Integer id = r.getInt("id");
				String modelo = r.getString("modelo");
				Integer ano = r.getInt("ano");
			
				Carros car = new Carros(modelo, ano);
				car.setId(id);
				lista.add(car);
			}
			r.close();
			p.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return lista;
	}
	
	public void removeCar(Integer id) {
		Conexao c = Conexao.getInstance();
		Connection con = c.getConnection();
		
		try {
			PreparedStatement p = con.prepareStatement("delete from carros where id = ?");
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
	
	public void updateCar(Carros updateCar) {
		Conexao c = Conexao.getInstance();
		Connection con = c.getConnection();
		
		try {
			PreparedStatement p = con.prepareStatement("update carros set modelo = ?, ano = ? where id = ?");
			p.setString(1, updateCar.getModelo());
			p.setInt(2, updateCar.getAno());
			p.setInt(3, updateCar.getId());
			System.out.println(p);
			p.executeUpdate();
			System.out.println("Comando executado");
			p.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
		
	public Carros selectById(Integer id) {
		Conexao c = Conexao.getInstance();
		Connection con = c.getConnection();
		Carros car = null;
		try {
			PreparedStatement p = con.prepareStatement("select * from carros where id = ?");
			p.setInt(1, id);
			ResultSet r = p.executeQuery();			
			
			
			while (r.next()) {
				//Integer id = r.getInt("id");
				String modelo = r.getString("modelo");
				Integer ano = r.getInt("ano");
				car = new Carros(modelo, ano);
				car.setId(id);
			}
			r.close();
			p.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return car;
	}
	
	
}
