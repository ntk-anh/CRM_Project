package controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import dao.DuAnDAO;
import dao.UserDAO;
import model.DuAn;
import model.User;

@WebServlet("/leader-duan-add")
public class LeaderDuAnAddController extends HttpServlet {
	private DuAnDAO duAnDAO = null;
	private UserDAO userDAO = null;

	public LeaderDuAnAddController() {
		duAnDAO = new DuAnDAO();
		userDAO = new UserDAO();
	}

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// khi bấm thêm mới
		HttpSession session=req.getSession();
		User user = (User) session.getAttribute("user"); 
		User leader = userDAO.getUserById(user.getId()); 
		
		req.setAttribute("leader", leader);
		req.getRequestDispatcher("./views/leader/duan-add.jsp").forward(req, resp);
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		req.setCharacterEncoding("utf-8");
		resp.setCharacterEncoding("utf-8");
		
		HttpSession session=req.getSession();
		User user = (User) session.getAttribute("user"); 
		
		// khi bấm nút thêm
		DuAn duAn = new DuAn();
		duAn.setTenDuAn(req.getParameter("ten_du_an"));
		duAn.setMoTa(req.getParameter("mo_ta"));
		duAn.setNgayBatDau(req.getParameter("ngay_bat_dau"));
		duAn.setNgayKetThuc(req.getParameter("ngay_ket_thuc"));
		duAn.setIdLeader(user.getId());//System.out.println(user.getId());
		
		//thêm
		int result = duAnDAO.insertDuAn(duAn);
		if (result>0) {
			resp.sendRedirect(req.getContextPath()+"/leader-duan-list?result=insertSuccess");
		}else {
			resp.sendRedirect(req.getContextPath()+"/leader-duan-list?result=insertError");
		}
}
}