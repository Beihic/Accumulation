package TextCommunication.controller;

import java.io.*;
import javax.servlet.*;
import javax.servlet.http.*;
import java.sql.*;
import TextCommunication.property.User;
import TextCommunication.database.ComentDao;

public class DisplayController extends HttpServlet{
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		String coment = request.getParameter("coment");
		HttpSession session = request.getSession();
		User user = (User) session.getAttribute("user");
		Timestamp timestamp  = new Timestamp(System.currentTimeMillis());
		ComentDao dao = new ComentDao();
		dao.addComent(user.getId(), user.getName(), coment, timestamp);
		request.getRequestDispatcher("/ComentController").forward(request, response);
	}
}
