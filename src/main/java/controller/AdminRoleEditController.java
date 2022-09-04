package controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.RoleDAO;
import model.Role;

@WebServlet("/admin-role-edit")
public class AdminRoleEditController extends HttpServlet {
	private RoleDAO roleDAO = null;

	public AdminRoleEditController() {
		roleDAO = new RoleDAO();
	}

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// khi bấm nút sửa => hiện trang sửa hiện các trường của role được chọn sửa
		int id = Integer.parseInt(req.getParameter("id"));
		req.setAttribute("role", roleDAO.getRoleById(id));
		req.getRequestDispatcher("./views/role/role-edit.jsp").forward(req, resp);
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		req.setCharacterEncoding("utf-8");
		resp.setCharacterEncoding("utf-8");
		// khi ấn lưu lại ở trang thêm
		Role role = new Role();
		role.setId(Integer.parseInt(req.getParameter("id")));
		role.setTenRole(req.getParameter("ten_role"));
		role.setMoTa(req.getParameter("mo_ta"));
		
		//sửa
		int result = roleDAO.updateRole(role);
		if (result>0) {
			resp.sendRedirect(req.getContextPath()+"/admin-role-list?result=updateSuccess");
		}else {
			resp.sendRedirect(req.getContextPath()+"/admin-role-list?result=updateError");
		}
	}
}
