package web.filter;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;

public class CharacterFilter implements Filter {

	private String character;
	
	public CharacterFilter() {
		
	}

	@Override
	public void destroy() {

	}

	@Override
	public void doFilter(ServletRequest request, ServletResponse response,
			FilterChain filterchain) throws IOException, ServletException {

			request.setCharacterEncoding(character);
			response.setCharacterEncoding(character);
			
			filterchain.doFilter(request, response);
	}

	@Override
	public void init(FilterConfig config) throws ServletException {
		
		 character = config.getInitParameter("character");

	}

}
