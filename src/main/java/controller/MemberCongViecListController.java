package controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import dao.CongViecDAO;
import model.User; 

@WebServlet("/member-congviec-list")
public class MemberCongViecListController extends HttpServlet {

	 
		private CongViecDAO congViecDAO = null; 

		public MemberCongViecListController() {
			congViecDAO = new CongViecDAO(); 
		}

		@Override
		protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
			HttpSession session = req.getSession();
			User user = (User) session.getAttribute("user");
			req.setAttribute("congViecs", congViecDAO.getAllCongViecByUserId(user.getId())); 
			req.getRequestDispatcher("./views/member/congviec/congviec-list.jsp").forward(req, resp);
		}
	 
}
