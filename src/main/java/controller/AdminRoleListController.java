package controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.DuAnDAO;
import dao.RoleDAO;

@WebServlet("/admin-role-list")
public class AdminRoleListController extends HttpServlet{
	private RoleDAO roleDAO = null;

	public AdminRoleListController() {
		roleDAO = new RoleDAO();
	}

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		//query list role
		req.setAttribute("roles", roleDAO.getAllRole()); 
		// hiển thị trang role
		req.getRequestDispatcher("./views/role/role-list.jsp").forward(req, resp);
	}
}
