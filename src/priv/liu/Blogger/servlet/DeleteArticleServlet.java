package priv.liu.Blogger.servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import priv.liu.Blogger.exception.AuthorNotExistException;
import priv.liu.Blogger.usecase.DeleteArticleUseCase;

@WebServlet("/DeleteArticleServlet")
public class DeleteArticleServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String articleTitle = request.getParameter("articleTitle");
		String authorName = (String) request.getSession().getAttribute("username");
		try {
			new DeleteArticleUseCase().execute(articleTitle, authorName);
			response.sendRedirect("author_personal_page.jsp");
		} catch (AuthorNotExistException e) {
			request.setAttribute("errorMessage", e.getMessage());
			request.getRequestDispatcher("author_personal_page.jsp").forward(request, response);
		}
	}

}
