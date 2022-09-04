package controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import dao.UserDAO;
import model.User;

@WebServlet("/auth")
public class AuthenticationController extends HttpServlet {
	private UserDAO userDAO = null;

	public AuthenticationController() {
		userDAO = new UserDAO();
	}

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		String action=req.getParameter("action");
		if (action!=null && !action.isEmpty() && action.equals("logout")) {//đăng xuất
			HttpSession session=req.getSession();
			session.removeAttribute("user");
		}  
		/**/
		req.getRequestDispatcher("views/login/login.jsp").forward(req, resp);
		
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		req.setCharacterEncoding("utf-8");
		resp.setCharacterEncoding("utf-8");
		//bấm login
		String email = req.getParameter("email");
		String password = req.getParameter("password");
		User user = userDAO.checkLogin(email, password); 
		//tạo session
		if (user != null) {//phải tạo session
			HttpSession session = req.getSession(); 
			session.setAttribute("user", user);
			//author
			if (user.getId_role()==1) {
				resp.sendRedirect(req.getContextPath()+"/admin-user-list");
			}else if (user.getId_role()==2) {
				resp.sendRedirect(req.getContextPath()+"/leader-user-list");
			}else {
				resp.sendRedirect(req.getContextPath()+"/member-congviec-list");
			}
		} else {
			resp.sendRedirect(req.getContextPath()+"/auth?result=loginError");
		}
	}
}
