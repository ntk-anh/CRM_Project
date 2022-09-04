package controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.UserDAO;

@WebServlet("/leader-user-list")
public class LeaderUserListController extends HttpServlet {
	private UserDAO userDAO = new UserDAO();
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		req.getParameter("result");
		
		req.setAttribute("users", userDAO.getAllUser());
		req.getRequestDispatcher("./views/leader/user-list.jsp").forward(req, resp); 
	}
}
