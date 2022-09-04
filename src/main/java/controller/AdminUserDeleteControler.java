package controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.UserDAO;

/**
 * Servlet implementation class DeleteUserControler
 */
@WebServlet("/admin-user-delete")
public class AdminUserDeleteControler extends HttpServlet {
	private static final long serialVersionUID = 1L;
     
	UserDAO userDAO=null;
    public AdminUserDeleteControler() {
        userDAO=new UserDAO();
    }

	
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		//khi bấm nút xóa
		int id=Integer.parseInt(req.getParameter("id")); 
		//xóa
		int result = userDAO.deleteUserById(id);
		//hiển thị thông báo dùng toastr
		if (result>0) {
			resp.sendRedirect(req.getContextPath()+"/admin-user-list?result=deleteSuccess");
		}else {
			resp.sendRedirect(req.getContextPath()+"/admin-user-list?result=deleteError");
		}
	}

	

}
