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

import priv.liu.Blogger.entity.Article;
import priv.liu.Blogger.usecase.GetAllArticlesUseCase;

//@WebFilter("/GetAllArticlesFilter")
public class GetAllArticlesFilter implements Filter {
	
    public GetAllArticlesFilter() {
        // TODO Auto-generated constructor stub
    }

	public void destroy() {
		// TODO Auto-generated method stub
	}

	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
		List<Article> articles = new GetAllArticlesUseCase().execute();
		((HttpServletRequest) request).getSession().setAttribute("allArticles", articles);		
		chain.doFilter(request, response);
	}

	public void init(FilterConfig fConfig) throws ServletException {
		// TODO Auto-generated method stub
	}

}
