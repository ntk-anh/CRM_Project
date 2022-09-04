package controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.DuAnDAO;
import dao.UserDAO;
import model.DuAn;

@WebServlet("/admin-duan-add")
public class AdminDuAnAddController extends HttpServlet {

	private DuAnDAO duAnDAO = null;
	private UserDAO userDAO = null;

	public AdminDuAnAddController() {
		duAnDAO = new DuAnDAO();
		userDAO=new UserDAO();
	}

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// khi bấm thêm mới
		req.setAttribute("users", userDAO.getAllUser());
		req.getRequestDispatcher("./views/duan/duan-add.jsp").forward(req, resp);
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		req.setCharacterEncoding("utf-8");
		resp.setCharacterEncoding("utf-8");
		// khi bấm nút thêm
		DuAn duAn = new DuAn();
		duAn.setTenDuAn(req.getParameter("ten_du_an"));
		duAn.setMoTa(req.getParameter("mo_ta"));
		duAn.setNgayBatDau(req.getParameter("ngay_bat_dau"));
		duAn.setNgayKetThuc(req.getParameter("ngay_ket_thuc"));
		duAn.setIdLeader(Integer.parseInt(req.getParameter("id_leader")));
		
		//thêm
		int result = duAnDAO.insertDuAn(duAn);
		if (result>0) {
			resp.sendRedirect(req.getContextPath()+"/admin-duan-list?result=insertSuccess");
		}else {
			resp.sendRedirect(req.getContextPath()+"/admin-duan-list?result=insertError");
		}
	}
}
