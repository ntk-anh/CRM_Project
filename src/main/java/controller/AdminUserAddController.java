package controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.UserDAO;
import model.User;

@WebServlet("/admin-user-add")
public class AdminUserAddController extends HttpServlet {

	private UserDAO userDAO = null;

	public AdminUserAddController() {
		userDAO = new UserDAO();
	}

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		//hiển thị trang thêm
		req.getRequestDispatcher("./views/user/user-add.jsp").forward(req, resp);
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		req.setCharacterEncoding("utf-8");
		resp.setCharacterEncoding("utf-8");
		// //khi bấm nút thêm
		User model = new User();
		model.setHoTen(req.getParameter("ho_ten"));
		model.setEmail(req.getParameter("email"));
		model.setPassword(req.getParameter("password"));
		model.setDiaChi(req.getParameter("dia_chi"));
		model.setSoDienThoai(req.getParameter("so_dien_thoai"));
		model.setId_role(Integer.parseInt(req.getParameter("id_role")));

		int result = userDAO.insertUser(model);
		//hiện thông báo nếu thêm thành công bằng thư viện toastr
		if (result > 0) {
			resp.sendRedirect(req.getContextPath() + "/admin-user-list?result=insertSuccess"); 
		}else {
			resp.sendRedirect(req.getContextPath() + "/admin-user-list?result=insertError"); 
		}

		// load lại trang danh sách
	}
}
