package pl.bezdomniaki.servlets;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import pl.bezdomniaki.Pies;
import pl.bezdomniaki.dto.BezdomniakiDTO;

public class SzukajServlet extends HttpServlet {
	BezdomniakiDTO bezdomniaki = new BezdomniakiDTO();

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		try {
			processRequest(req, resp);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		try {
			processRequest(req, resp);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	protected void processRequest(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException, SQLException {
	//path = req.getRequestURI();
	String actionName = req.getServletPath();
			//path.substring(path.lastIndexOf("/")+1, path.lastIndexOf("."));
	System.out.println(actionName);
	
	if(actionName.equals("/Szukaj") ){
		String miejscowosc = req.getParameter("city");
		System.out.println("Miejscowosc:" + miejscowosc);
		Pies[] listaPsow = null;
		try {
			listaPsow = bezdomniaki.getPsy(miejscowosc);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		req.setAttribute("listaPsow", listaPsow);
		RequestDispatcher view = req.getRequestDispatcher("list2.jsp");
		view.forward(req, resp);
	}
	
	else if(actionName.equals("/Dodaj") ){
		Pies pies = new Pies();
		pies.setImie(req.getParameter("imie"));
		pies.setDataPrzyjecia(req.getParameter("dataPrzyjecia"));
		pies.setIdSchroniska(req.getParameter("idSchroniska"));
		pies.setNrChipa(req.getParameter("nrChipa"));
		bezdomniaki.addPies(pies);
		req.setAttribute("komunikat", "Pies zosta³ dodany!");
		RequestDispatcher view = req.getRequestDispatcher("/Szukaj");
		view.forward(req, resp);
	}
	
	else if(actionName.equals("/Edytuj")){
		Pies pies = new Pies();
		pies.setId(Integer.parseInt(req.getParameter("id")));
		pies.setImie(req.getParameter("imie"));
		pies.setDataPrzyjecia(req.getParameter("dataPrzyjecia"));
		pies.setIdSchroniska(req.getParameter("idSchroniska"));
		pies.setNrChipa(req.getParameter("nrChipa"));
		bezdomniaki.editPies(pies);
		
	/*if(actionName.equals("editPies?id=X"))

	{
		BezdomniakiDTO bezdomniaki = new BezdomniakiDTO();
		req.setAttribute("listaPsow", listaPsow);
		RequestDispatcher view = req.getRequestDispatcher("list2.jsp");
		view.forward(req, resp);
	}*/
	}
	}
}
