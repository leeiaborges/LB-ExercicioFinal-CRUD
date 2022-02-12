package br.com.rd.aplicacoes;

import br.com.rd.dao.CarrosDAO;
import br.com.rd.model.Carros;

public class App {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		
		CarrosDAO maca = new CarrosDAO();
		
		System.out.println(maca.selectAll());
		
		Carros laranja = new Carros("Clio", 2010);
		maca.insert(laranja);
		System.out.println(maca.selectAll());
		
		Carros laranja1 = new Carros("Uno", 2015);
		maca.insert(laranja1);
		System.out.println(maca.selectAll());
		
		maca.removeCar(2);
		System.out.println(maca.selectAll());
		
		Carros laranja2 = new Carros("Celta", 2019);
		maca.insert(laranja2);
		System.out.println(maca.selectAll());
		
		maca.removeCar(2);
		System.out.println(maca.selectAll());
		
		laranja.setAno(2013);
		maca.updateCar(laranja);
		System.out.println(maca.selectAll());
		
		Carros novo = maca.selectById(3);
		System.out.println(novo);
		
		Carros novo1 = maca.selectById(1);
		System.out.println(novo1);
	}

}
