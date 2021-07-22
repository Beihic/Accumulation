package TextCommunication.controller;

import java.io.*;
import javax.servlet.*;
import javax.servlet.http.*;
import java.util.*;
import TextCommunication.property.Coment;
import TextCommunication.database.ComentDao;

public class ComentController extends HttpServlet{
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
		ComentDao dao = new ComentDao();
		List<Coment> coment = dao.getComent();

		ServletContext application = getServletContext();
		application.setAttribute("coment", coment);	
		request.getRequestDispatcher("/WEB-INF/jsp/TextCommunication/Display.jsp").forward(request, response);
	}	
}
