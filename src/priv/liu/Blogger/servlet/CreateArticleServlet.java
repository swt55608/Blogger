package priv.liu.Blogger.servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import priv.liu.Blogger.exception.AuthorNotExistException;
import priv.liu.Blogger.exception.InvalidArticleTitleException;
import priv.liu.Blogger.usecase.CreateArticleUseCase;

@WebServlet("/CreateArticleServlet")
public class CreateArticleServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String articleTitle = request.getParameter("articleTitle");
		String articleContent = request.getParameter("articleContent");
		String authorName = (String) request.getSession().getAttribute("username");
		try {
			new CreateArticleUseCase().execute(articleTitle, articleContent, authorName);
		} catch (InvalidArticleTitleException | AuthorNotExistException e) {
			request.setAttribute("errorMessage", e.getMessage());
			request.getRequestDispatcher("create_article.jsp").forward(request, response);
		}
	}

}
