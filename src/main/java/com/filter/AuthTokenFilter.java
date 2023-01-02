package com.filter;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.dao.UserDao;

 
public class AuthTokenFilter implements Filter {

	@Autowired
	UserDao userDao;

	@Override
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
			throws IOException, ServletException {
		// TODO Auto-generated method stub

		HttpServletRequest req = (HttpServletRequest) (request);
		HttpServletResponse res = (HttpServletResponse)(response);
		System.out.println("AuthTokenFilter()::doFilter()");
		String url = req.getRequestURL().toString();
		String uri = req.getRequestURI();

		System.out.println("url => " + url);
		System.out.println("uri => " + uri);

		if (uri.contains("/public/") || url.contains("swagger") || url.contains("api-docs")) {
			System.out.println("Public api call---by pass AuthTokenFilter");
			chain.doFilter(request, response);
		} else {
			System.out.println("private api call---verfying token AuthTokenFilter");
			String token = req.getHeader("token");
			if (token == null || userDao.isValidToken(token) == false) {
				System.out.println("Security check fail");
				res.setStatus(401);
				res.getOutputStream().print("Please Enter Valid Token");
					
			} else {
				System.out.println("Security Check Pass");
				chain.doFilter(request, response);

			}

		}

	}

}
