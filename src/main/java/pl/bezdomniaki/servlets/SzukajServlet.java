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
	
@Override
protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
	// TODO Auto-generated method stub
	super.doGet(req, resp);
}

@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
	BezdomniakiDTO bezdomniaki = new BezdomniakiDTO();
	String miejscowosc = req.getParameter("city");
	System.out.println("Miejscowosc:" + miejscowosc); //to sie nie wypisuje na koncoli
	Pies[] listaPsow = null; 
	try {
		listaPsow = bezdomniaki.getPsy(miejscowosc);
	} catch (SQLException e) {
		e.printStackTrace();
	}
	req.setAttribute("listaPsow", listaPsow);
	//getServletContext().getRequestDispatcher("/list2.jsp").forward(req, resp);
	RequestDispatcher view = req.getRequestDispatcher("list2.jsp");
	view.forward(req, resp);
		//super.doPost(req, resp);
	}

}
