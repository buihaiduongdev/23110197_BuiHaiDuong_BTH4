package com.bth03.controllers;

import java.io.File;
import java.io.IOException;

import com.bth03.dao.UserDao;
import com.bth03.dao.impl.UserDaoImpl;
import com.bth03.entity.User;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.MultipartConfig;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import jakarta.servlet.http.Part;

@WebServlet({ "/profile", "/profile/edit", "/profile/update" })
@MultipartConfig(fileSizeThreshold = 1024 * 1024, maxFileSize = 5 * 1024 * 1024, maxRequestSize = 10 * 1024 * 1024)
public class ProfileController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private UserDao userDao = new UserDaoImpl();

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		HttpSession session = req.getSession(false);
		User user = (session != null) ? (User) session.getAttribute("user") : null;

		if (user == null) {
			resp.sendRedirect(req.getContextPath() + "/login");
			return;
		}

		String uri = req.getRequestURI();

		if (uri.endsWith("/profile")) {
			req.setAttribute("user", user);
			req.getRequestDispatcher("/views/profile.jsp").forward(req, resp);
		} else if (uri.endsWith("edit")) {
			req.setAttribute("user", user);
			req.getRequestDispatcher("/views/profile-form.jsp").forward(req, resp);
		}
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		HttpSession session = req.getSession(false);
		User user = (session != null) ? (User) session.getAttribute("user") : null;

		if (user == null) {
			resp.sendRedirect(req.getContextPath() + "/login");
			return;
		}

		String uri = req.getRequestURI();

		if (uri.endsWith("update")) {
			String fullname = req.getParameter("fullname");
			String phone = req.getParameter("phone");
			String email = req.getParameter("email");

			// Upload file ảnh
			Part filePart = req.getPart("image");
			String fileName = (filePart != null) ? filePart.getSubmittedFileName() : null;

			if (fileName != null && !fileName.isEmpty()) {
				String uploadDir = req.getServletContext().getRealPath("/uploads");
				File dir = new File(uploadDir);
				if (!dir.exists()) {
					dir.mkdirs();
				}
				String filePath = uploadDir + File.separator + fileName;
				filePart.write(filePath);

				user.setAvatar(fileName);
			}

			user.setFullName(fullname);
			user.setPhone(phone);
			user.setEmail(email);
			userDao.update(user);
			session.setAttribute("user", user);

			resp.sendRedirect(req.getContextPath() + "/profile");
		}
	}
}
