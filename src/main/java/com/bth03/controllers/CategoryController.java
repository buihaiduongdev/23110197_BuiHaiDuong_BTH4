package com.bth03.controllers;

import java.io.IOException;
import java.util.List;

import com.bth03.dao.CategoryDao;
import com.bth03.dao.impl.CategoryDaoImpl;
import com.bth03.entity.Category;
import com.bth03.entity.User;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

@WebServlet({ "/user/home", "/manager/home", "/admin/home", "/category/add", "/category/edit", "/category/delete" })
public class CategoryController extends HttpServlet {

	private static final long serialVersionUID = 1L;
	private CategoryDao cateDao = new CategoryDaoImpl();

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		HttpSession session = req.getSession();
		User user = (User) session.getAttribute("user");
		String uri = req.getRequestURI();

		if (uri.endsWith("home")) {
			List<Category> list;
			if (user.getRoleid() == 2) {
				// Manager
				list = cateDao.findByUserId(user.getUserid());
			} else {
				// User, Admin
				list = cateDao.findAll();
			}
			req.setAttribute("categories", list);
			req.getRequestDispatcher("/views/home.jsp").forward(req, resp);
		} else if (uri.endsWith("add")) {
			req.getRequestDispatcher("/views/category-form.jsp").forward(req, resp);
		} else if (uri.endsWith("edit")) {
			int id = Integer.parseInt(req.getParameter("id"));
			Category c = cateDao.findById(id);
			req.setAttribute("category", c);
			req.getRequestDispatcher("/views/category-form.jsp").forward(req, resp);
		} else if (uri.endsWith("delete")) {
			int id = Integer.parseInt(req.getParameter("id"));
			cateDao.delete(id);
			resp.sendRedirect(req.getContextPath() + "/" + rolePath(user) + "/home");
		}
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		HttpSession session = req.getSession();
		User user = (User) session.getAttribute("user");

		String idStr = req.getParameter("id");
		String name = req.getParameter("catename");
		String icon = req.getParameter("icon");

		Category c;
		if (idStr == null || idStr.isEmpty()) {
			c = new Category();
			c.setCatename(name);
			c.setIcon(icon);
			c.setUser(user);
			cateDao.insert(c);
		} else {
			int id = Integer.parseInt(idStr);
			c = cateDao.findById(id);
			c.setCatename(name);
			c.setIcon(icon);
			cateDao.update(c);
		}

		resp.sendRedirect(req.getContextPath() + "/" + rolePath(user) + "/home");
	}

	private String rolePath(User user) {
		switch (user.getRoleid()) {
		case 1:
			return "user";
		case 2:
			return "manager";
		case 3:
			return "admin";
		default:
			return "";
		}
	}

}
