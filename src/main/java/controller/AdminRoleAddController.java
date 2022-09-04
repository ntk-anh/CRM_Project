package controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.RoleDAO;
import model.Role;

@WebServlet("/admin-role-add")
public class AdminRoleAddController extends HttpServlet {
	private RoleDAO roleDAO = null;

	public AdminRoleAddController() {
		roleDAO = new RoleDAO();
	}

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// khi ấn thêm mới
		req.getRequestDispatcher("./views/role/role-add.jsp").forward(req, resp);
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		req.setCharacterEncoding("utf-8");
		resp.setCharacterEncoding("utf-8");
		// khi ấn lưu ở trang thêm mới
		Role role = new Role();
		role.setTenRole(req.getParameter("ten_quyen"));
		role.setMoTa(req.getParameter("mo_ta"));  
		// thêm
		int result = roleDAO.insertRole(role); 
		// để hiện thông báo
		if (result > 0) {
			resp.sendRedirect(req.getContextPath() + "/admin-role-list?result=insertSuccess");
		} else {
			resp.sendRedirect(req.getContextPath() + "/admin-role-list?result=insertError");
		}
	}
}
