package priv.liu.Blogger.filter;

import java.io.IOException;
import java.util.List;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import priv.liu.Blogger.entity.Article;
import priv.liu.Blogger.exception.AuthorNotExistException;
import priv.liu.Blogger.usecase.GetAuthorArticlesUseCase;

//@WebFilter("/GetAuthorArticlesFilter")
public class GetAuthorArticlesFilter implements Filter {

    public GetAuthorArticlesFilter() {
        // TODO Auto-generated constructor stub
    }

	public void destroy() {
		// TODO Auto-generated method stub
	}

	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
		HttpSession session = ((HttpServletRequest) request).getSession();
		String authorName = (String) session.getAttribute("username");
		try {
			List<Article> articles = new GetAuthorArticlesUseCase().execute(authorName);
			session.setAttribute("authorArticles", articles);
		} catch (AuthorNotExistException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		chain.doFilter(request, response);
	}

	public void init(FilterConfig fConfig) throws ServletException {
		// TODO Auto-generated method stub
	}

}
