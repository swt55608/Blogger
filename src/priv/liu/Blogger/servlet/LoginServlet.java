package priv.liu.Blogger.servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import priv.liu.Blogger.usecase.LoginUseCase;

@WebServlet("/LoginServlet")
public class LoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String username = request.getParameter("username");
		String password = request.getParameter("password");
		HttpSession session = request.getSession();
		boolean isLogin = new LoginUseCase().execute(username, password);
		if (isLogin) {
			session.setAttribute("username", username);
			response.sendRedirect("index.jsp");	
		} else {
			session.setAttribute("username", null);
			request.setAttribute("errorMessage", "Incorrect Username or Password");
			request.getRequestDispatcher("register.jsp").forward(request, response);
		}		
	}

}
