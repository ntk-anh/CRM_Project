package controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.DuAnDAO;

@WebServlet("/admin-duan-list")
public class AdminDuAnListController extends HttpServlet {

	private DuAnDAO duAnDAO = null;

	public AdminDuAnListController() {
		duAnDAO = new DuAnDAO();
	}

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		req.setAttribute("duans", duAnDAO.getAllDuAn()); 
		// hiển thị trang duan
		req.getRequestDispatcher("./views/duan/duan-list.jsp").forward(req, resp);
	}
}
