package controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.RoleDAO;

@WebServlet("/admin-role-delete")
public class AdminRoleDeleteController extends HttpServlet {
	private RoleDAO roleDAO = null;

	public AdminRoleDeleteController() {
		roleDAO = new RoleDAO();
	}

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// khi bấm xóa
		int id=Integer.parseInt(req.getParameter("id"));
		int result = roleDAO.deleteRoleById(id);
		if (result > 0) {
			resp.sendRedirect(req.getContextPath()+"/admin-role-list?result=deleteSuccess");
		} else {
			resp.sendRedirect(req.getContextPath()+"/admin-role-list?result=deleteError");
		}
	}
}
