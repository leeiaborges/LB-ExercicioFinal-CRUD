package br.com.rd.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import br.com.rd.dao.IpvaDAO;
import br.com.rd.model.Ipva;

/**
 * Servlet implementation class ServletIpva
 */
@WebServlet("/ServletIpva")
public class ServletIpva extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private IpvaDAO ipva;

       
    public ServletIpva() {
    	super();
        this.ipva = new IpvaDAO();
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
				showInsertIpva(request, response);
			break;
			case ("updateForm"):
				showUpdateIpva(request, response);
			break;
			case ("update"):
				updateIpva(request, response);
			break;
			case ("delete"):
				deleteIpva(request, response);
			break;
			case ("insert"):
				insertIpva(request, response);
			break;
			default:
				selectAllIpva(request, response);
		}
	}
	


	private void showInsertIpva(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
		request.getRequestDispatcher("formIpva.jsp").forward(request, response);
	}
	
	private void showUpdateIpva(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
		Integer id = Integer.parseInt(request.getParameter("id"));
		Ipva i = this.ipva.selectById(id);
		request.setAttribute("ipva", i);
		request.getRequestDispatcher("formIpva.jsp").forward(request, response);
	}
	
	private void insertIpva(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
		String anoBack = request.getParameter("ano");
		Integer anoBack1;
		if (anoBack != null) {
			if (!anoBack.equals("")){
				anoBack1 = Integer.parseInt(anoBack);
				Ipva ipva1 = new Ipva(anoBack1);
				this.ipva.insert(ipva1);
			}
		}
		response.sendRedirect("ServletIpva");
	}
	
	private void selectAllIpva(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
		request.setAttribute("listIpva", this.ipva.selectAll());
		request.getRequestDispatcher("listTableIpva.jsp").forward(request, response);
	}
	
	private void deleteIpva(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String idBack = request.getParameter("id");
		if (idBack != null) {
			Integer id = Integer.parseInt(idBack);
			this.ipva.removeIpva(id);;
		}
		response.sendRedirect("ServletIpva");
	}
	
	private void updateIpva(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String idBack = request.getParameter("id");
		String anoBack = request.getParameter("ano");
		Integer anoBack1;
		if (anoBack != null) {
			if (!anoBack.equals("")){
				anoBack1 = Integer.parseInt(anoBack);
				Integer id = Integer.parseInt(idBack);
				Ipva ipva1 = new Ipva(anoBack1);
				ipva1.setId(id);
				this.ipva.updateIpva(ipva1);
			}
		}
		response.sendRedirect("ServletIpva");
	}

}
