package TextCommunication.controller;

import java.io.*;
import javax.servlet.*;
import javax.servlet.http.*;
import TextCommunication.database.ComentDao;

public class RegisterController extends HttpServlet{
	protected void doPost(HttpServletRequest request, HttpServletResponse response)throws ServletException, IOException{
		request.setCharacterEncoding("UTF-8");	
		String idString = request.getParameter("id");
		String name = request.getParameter("name");
		String pass = request.getParameter("pass");
		String conPass = request.getParameter("conPass");
		boolean registerStatus = false;
		if(idString.length()!=0 && name.length()!=0 && pass.length()!=0 && conPass.length()!=0){
			if(name.length()<=10 && pass.equals(conPass) && pass.length()<=10 ){
				int idInt = Integer.parseInt(idString);
				ComentDao dao = new ComentDao();
				if(dao.registerJudge(idInt){registerStatus = dao.registerUser(idInt, name, pass);}
			}
			
		}
		if(registerStatus){
			response.sendRedirect("/Beihic/JSP/Enter.jsp");
		}else{
			request.getRequestDispatcher("/WEB-INF/jsp/TextCommunication/Error.jsp").forward(request, response);
		}
	}	
}
