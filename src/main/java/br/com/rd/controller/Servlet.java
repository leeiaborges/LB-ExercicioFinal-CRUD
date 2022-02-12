package br.com.rd.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import br.com.rd.dao.CarrosDAO;
//import br.com.rd.dao.IpvaDAO;
import br.com.rd.model.Carros;



/**
 * Servlet implementation class Servlet
 */
@WebServlet("/Servlet")
public class Servlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private CarrosDAO car;
	//private IpvaDAO ip;

       
    public Servlet() {
    	super();
        this.car = new CarrosDAO();
    }


	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		
		doPost(request, response);
	}


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String option = request.getParameter("option");
		if (option == null) {
			option = "Opcao";
		}
		switch(option) {
			case ("insertForm"):
				showInsertCar(request, response);
			break;
			case ("updateForm"):
				showUpdateCar(request, response);
			break;
			case ("update"):
				updateCar(request, response);
			break;
			case ("delete"):
				deleteCar(request, response);
			break;
			case ("insert"):
				insertCar(request, response);
			break;
			default:
				selectAllCar(request, response);
		}
	}
	
	private void showInsertCar(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
		request.getRequestDispatcher("form.jsp").forward(request, response);
	}
	
	private void showUpdateCar(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
		Integer id = Integer.parseInt(request.getParameter("id"));
		Carros c = this.car.selectById(id);
		request.setAttribute("carro", c);
		request.getRequestDispatcher("form.jsp").forward(request, response);
	}
	
	private void insertCar(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
		String modeloBack = request.getParameter("modelo");
		Integer anoBack = Integer.parseInt(request.getParameter("ano"));
		if ((modeloBack != null) && (anoBack != null)) {
			if (!modeloBack.equals("")){
				Carros car1 = new Carros(modeloBack, anoBack);
				this.car.insert(car1);
			}
		}
		response.sendRedirect("Servlet");
	}
	
	private void selectAllCar(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
		request.setAttribute("listCarro", this.car.selectAll());
		request.getRequestDispatcher("listTable.jsp").forward(request, response);
	}
	
	private void deleteCar(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String idBack = request.getParameter("id");
		if (idBack != null) {
			Integer id = Integer.parseInt(idBack);
			this.car.removeCar(id);;
		}
		response.sendRedirect("Servlet");
	}
	
	private void updateCar(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String modeloBack = request.getParameter("modelo");
		Integer anoBack = Integer.parseInt(request.getParameter("ano"));
		String idBack = request.getParameter("id");
		if ((modeloBack != null) && (anoBack != null) && (idBack != null)) {
			if (!modeloBack.equals("")){
				Integer id = Integer.parseInt(idBack);
				Carros car1 = new Carros(modeloBack, anoBack);
				car1.setId(id);
				this.car.updateCar(car1);
			}
		}
		response.sendRedirect("Servlet");
	}
	
//	private void insertIpva(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
//		String anoBack = request.getParameter("anoIpva");
//		Integer anoBack1;
//		if (anoBack != null) {
//			if (!anoBack.equals("")){
//				anoBack1 = Integer.parseInt(anoBack);
//				Ipva ipva1 = new Ipva(anoBack1);
//				this.ip.insert(ipva1);
//			}
//		}
//		response.sendRedirect("ServletIpva");
//	}
}
