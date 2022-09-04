package controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.CongViecDAO;
import dao.DuAnDAO;
import dao.TrangThaiCVDAO;
import dao.UserDAO;

@WebServlet("/admin-congviec-list")
public class AdminCongViecListController extends HttpServlet {
	private CongViecDAO congViecDAO = null;
	private DuAnDAO duAnDAO = null;
	private UserDAO userDAO = null;
	private TrangThaiCVDAO trangThaiCVDAO = null;

	public AdminCongViecListController() {
		congViecDAO = new CongViecDAO();
		duAnDAO = new DuAnDAO();
		userDAO = new UserDAO();
		trangThaiCVDAO = new TrangThaiCVDAO();
	}

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		req.setAttribute("congViecs", congViecDAO.getAllCongViec());
		req.setAttribute("duAns", duAnDAO.getAllDuAn());
		req.setAttribute("users", userDAO.getAllUser());
		req.setAttribute("trangThaiCVs", trangThaiCVDAO.getAllTrangThaiCV());
		req.getRequestDispatcher("./views/congviec/congviec-list.jsp").forward(req, resp);
	}
}
