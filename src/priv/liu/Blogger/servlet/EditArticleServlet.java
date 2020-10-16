package priv.liu.Blogger.servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import priv.liu.Blogger.exception.AuthorNotExistException;
import priv.liu.Blogger.exception.EditArticleFailureExcetion;
import priv.liu.Blogger.usecase.EditArticleUseCase;

@WebServlet("/EditArticleServlet")
public class EditArticleServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String articleTitle = request.getParameter("articleTitle");
		String newArticleTitle = request.getParameter("newArticleTitle");
		String newArticleContent = request.getParameter("newArticleContent");
		String authorName = (String) request.getSession().getAttribute("username"); 
		try {
			new EditArticleUseCase().execute(articleTitle, newArticleTitle, newArticleContent, authorName);
			response.sendRedirect("author_personal_page.jsp");
		} catch (AuthorNotExistException | EditArticleFailureExcetion e) {
			request.setAttribute("errorMessage", e.getMessage());
			request.getRequestDispatcher("edit_article.jsp").forward(request, response);
		}
	}

}
