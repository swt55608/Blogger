package priv.liu.Blogger.servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import priv.liu.Blogger.exception.RegisterException;
import priv.liu.Blogger.usecase.RegisterUseCase;

@WebServlet("/RegisterServlet")
public class RegisterServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String username = request.getParameter("username");
		String password = request.getParameter("password");
		HttpSession session = request.getSession();
		try {
			new RegisterUseCase().execute(username, password);
			session.setAttribute("username", username);
			response.sendRedirect("index.jsp");
		} catch (RegisterException e) {
			session.setAttribute("username", null);
			request.setAttribute("errorMessage", e.getMessage());
			request.getRequestDispatcher("register.jsp").forward(request, response);
		}
	}

}
