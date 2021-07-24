package TextCommunication.controller;

import java.io.*;
import javax.servlet.*;
import javax.servlet.http.*;
import TextCommunication.property.User;
import TextCommunication.database.ComentDao;

public class LoginController extends HttpServlet{
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		String str = request.getParameter("id");
		String pass = request.getParameter("pass");
		String name;
		User user = new User();
		ComentDao dao = new ComentDao();
		int id = Integer.parseInt(str); 
		boolean login = doa.loginJudgement(id, pass);
		if(login){name = dao.searchName(id);} else {name = null;}
		user.setUser(id, name, pass, login);

		HttpSession session = request.getSession();
		session.setAttribute("user", user);

		if(login){
			request.getRequestDispatcher("/ComentController").forward(request, response);
		} else {
			request.getRequestDispatcher("/WEB-INF/jsp/TextCommunication/Error.jsp").forward(request, response);
			session.removeAttribute("user");
		}
	}
}
