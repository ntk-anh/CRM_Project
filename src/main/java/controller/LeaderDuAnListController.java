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
import model.User;

@WebServlet("/leader-duan-list")
public class LeaderDuAnListController extends HttpServlet {

	private DuAnDAO duAnDAO = null;

	public LeaderDuAnListController() {
		duAnDAO = new DuAnDAO();
	}
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		HttpSession session=req.getSession();
		User user = (User) session.getAttribute("user"); //System.out.println(user.getId());
		
		//truyền list duan của 1 user
		req.setAttribute("duans", duAnDAO.getListById(user.getId()));  
		  
		// load trang duan
		req.getRequestDispatcher("./views/leader/duan-list.jsp").forward(req, resp);
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

	}
}
