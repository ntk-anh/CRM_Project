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

@WebServlet("/admin-congviec-delete")
public class AdminCongViecDeleteController extends HttpServlet{

	private CongViecDAO congViecDAO = null;
	private DuAnDAO duAnDAO = null;
	private UserDAO userDAO = null;
	private TrangThaiCVDAO trangThaiCVDAO = null;

	public AdminCongViecDeleteController() {
		congViecDAO = new CongViecDAO();
		duAnDAO = new DuAnDAO();
		userDAO = new UserDAO();
		trangThaiCVDAO = new TrangThaiCVDAO();
	}
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// ấn xóa
		int id=Integer.parseInt(req.getParameter("id"));
		//xóa
		int result = congViecDAO.deleteCongViecById(id); 
		//thông báo
		if (result>0) {
			resp.sendRedirect(req.getContextPath()+"/admin-congviec-list?result=deleteSuccess");
		}else {
			resp.sendRedirect(req.getContextPath()+"/admin-congviec-list?result=deleteError");
		}	
	}
}
