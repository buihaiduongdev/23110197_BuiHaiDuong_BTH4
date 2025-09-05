package com.bth03.controllers;

import java.io.IOException;

import com.bth03.dao.UserDao;
import com.bth03.dao.impl.UserDaoImpl;
import com.bth03.entity.User;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

@WebServlet("/login")
public class LoginController extends HttpServlet {

	private static final long serialVersionUID = 1L;
	private UserDao userDao = new UserDaoImpl();

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		req.getRequestDispatcher("login.jsp").forward(req, resp);
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String username = req.getParameter("username");
		String password = req.getParameter("password");

		User user = userDao.login(username, password);

		if (user != null) {
			HttpSession session = req.getSession();
			session.setAttribute("user", user);

			switch (user.getRoleid()) {
			case 1:
				resp.sendRedirect(req.getContextPath() + "/user/home");
				break;
			case 2:
				resp.sendRedirect(req.getContextPath() + "/manager/home");
				break;
			case 3:
				resp.sendRedirect(req.getContextPath() + "/admin/home");
				break;
			default:
				resp.sendRedirect("login.jsp");
				break;
			}
		} else {
			req.setAttribute("error", "Sai username hoặc password");
			req.getRequestDispatcher("login.jsp").forward(req, resp);
		}
	}
}
