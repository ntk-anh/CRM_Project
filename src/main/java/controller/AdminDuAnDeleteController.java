package controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.DuAnDAO;
@WebServlet("/admin-duan-delete")
public class AdminDuAnDeleteController extends HttpServlet {

	private DuAnDAO duAnDAO = null;

	public AdminDuAnDeleteController() {
		duAnDAO = new DuAnDAO();
	}

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		//khi bấm nút xóa
		int id=Integer.parseInt(req.getParameter("id"));
		//xóa
		int result = duAnDAO.deleteDuAnById(id);
		//hiển thị thông báo dùng toastr
		if (result>0) {
			resp.sendRedirect(req.getContextPath()+"/admin-duan-list?result=deleteSuccess");
		}else {
			resp.sendRedirect(req.getContextPath()+"/admin-duan-list?result=deleteError");
		}		
	}
}
