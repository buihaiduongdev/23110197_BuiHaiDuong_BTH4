package com.bth03.controllers;

import java.io.IOException;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

@WebServlet("/profile")
public class ProfileController extends HttpServlet {

	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		HttpSession session = request.getSession(false);

		if (session == null || session.getAttribute("username") == null) {
			response.sendRedirect(request.getContextPath() + "/login");
			return;
		}

		String username = (String) session.getAttribute("username");
		String role = (String) session.getAttribute("role");

		// Gửi sang JSP
		request.setAttribute("username", username);
		request.setAttribute("role", role);

		// Forward tới trang profile.jsp
		request.getRequestDispatcher("/views/profile.jsp").forward(request, response);
	}
}
