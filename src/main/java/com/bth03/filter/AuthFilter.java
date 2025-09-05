package com.bth03.filter;

import java.io.IOException;

import com.bth03.entity.User;

import jakarta.servlet.Filter;
import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.ServletRequest;
import jakarta.servlet.ServletResponse;
import jakarta.servlet.annotation.WebFilter;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

@WebFilter("/*")
public class AuthFilter implements Filter {

	@Override
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
			throws IOException, ServletException {
		HttpServletRequest req = (HttpServletRequest) request;
		HttpServletResponse resp = (HttpServletResponse) response;

		String path = req.getRequestURI();
		HttpSession session = req.getSession(false);

		if (path.startsWith(req.getContextPath() + "/user") || path.startsWith(req.getContextPath() + "/manager")
				|| path.startsWith(req.getContextPath() + "/admin")) {

			User user = (session != null) ? (User) session.getAttribute("user") : null;

			if (user == null) {
				resp.sendRedirect(req.getContextPath() + "/login.jsp");
				return;
			}

			if (path.startsWith(req.getContextPath() + "/user") && user.getRoleid() != 1) {
				resp.sendRedirect(req.getContextPath() + "/403.jsp");
				return;
			}

			if (path.startsWith(req.getContextPath() + "/manager") && user.getRoleid() != 2) {
				resp.sendRedirect(req.getContextPath() + "/403.jsp");
				return;
			}

			if (path.startsWith(req.getContextPath() + "/admin") && user.getRoleid() != 3) {
				resp.sendRedirect(req.getContextPath() + "/403.jsp");
				return;
			}
		}

		chain.doFilter(request, response);
	}
}
