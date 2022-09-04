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

@WebServlet("/leader-duan-edit")
public class LeaderDuAnEditController extends HttpServlet {
	private DuAnDAO duAnDAO = null;
	private UserDAO userDAO = null;

	public LeaderDuAnEditController() {
		duAnDAO = new DuAnDAO();
		userDAO=new UserDAO();
	}

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// khi bấm nút sửa
		int id = Integer.parseInt(req.getParameter("id"));
		DuAn duAn = duAnDAO.getDuAnById(id); System.out.println(duAn.getIdLeader());
		// mở trang sửa
		req.setAttribute("duAn", duAn);
		req.setAttribute("users", userDAO.getAllUser());
		req.getRequestDispatcher("./views/leader/duan-edit.jsp").forward(req, resp);
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		req.setCharacterEncoding("utf-8");
		resp.setCharacterEncoding("utf-8");
		// khi bấm nút lưu lại
		DuAn model = new DuAn();
		int id = Integer.parseInt(req.getParameter("id"));
		model.setId(id);
		model.setTenDuAn(req.getParameter("ten_du_an"));
		model.setMoTa(req.getParameter("mo_ta"));
		model.setNgayBatDau(req.getParameter("ngay_bat_dau"));
		model.setNgayKetThuc(req.getParameter("ngay_ket_thuc"));
		model.setIdLeader(Integer.parseInt(req.getParameter("id_Leader")));

		// sửa
		int result = duAnDAO.updateDuAn(model);
		if (result > 0) {
			resp.sendRedirect(req.getContextPath() + "/leader-duan-list?result=updateSuccess");
		} else {
			resp.sendRedirect(req.getContextPath() + "/leader-duan-list?result=updateError");
		}
		// load lại trang duan
	}
}
