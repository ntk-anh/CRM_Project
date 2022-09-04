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
import model.CongViec;
@WebServlet("/leader-congviec-edit")
public class LeaderCongViecEditController extends HttpServlet{
	private CongViecDAO congViecDAO = null;
	private DuAnDAO duAnDAO = null;
	private UserDAO userDAO = null;
	private TrangThaiCVDAO trangThaiCVDAO = null;

	public LeaderCongViecEditController() {
		congViecDAO = new CongViecDAO();
		duAnDAO = new DuAnDAO();
		userDAO = new UserDAO();
		trangThaiCVDAO = new TrangThaiCVDAO();
	}
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		 //bấm nút sửa
		int id=Integer.parseInt(req.getParameter("id"));
		req.setAttribute("users", userDAO.getAllMemberUser());
		req.setAttribute("trangThaiCVs", trangThaiCVDAO.getAllTrangThaiCV());
		req.setAttribute("congViec", congViecDAO.getCongViecById(id));
		//kiểm tra log
		System.out.println("id_duAn "+ congViecDAO.getCongViecById(id).getIdDuAn());
		req.getRequestDispatcher("./views/leader/congviec-edit.jsp").forward(req, resp);
	}
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		req.setCharacterEncoding("utf-8");
		resp.setCharacterEncoding("utf-8");
		//kiểm tra log
		System.out.println("id "+req.getParameter("id"));
		System.out.println("ten_cong_viec "+req.getParameter("ten_cong_viec"));
		System.out.println("ngay_bat_dau "+req.getParameter("ngay_bat_dau"));
		System.out.println("ngay_ket_thuc "+req.getParameter("ngay_ket_thuc"));
		System.out.println("id_duAn "+req.getParameter("id_duAn"));
		System.out.println("id_trangThaiCV "+req.getParameter("id_trangThaiCV"));
		System.out.println("id_user "+req.getParameter("id_user"));
		// khi bấm nút lưu
		CongViec model = new CongViec(); 
		model.setId(Integer.parseInt(req.getParameter("id")));
		model.setTenCongViec(req.getParameter("ten_cong_viec"));
		model.setNgayBatDau(req.getParameter("ngay_bat_dau"));
		model.setNgayKetThuc(req.getParameter("ngay_ket_thuc"));
		model.setIdDuAn(Integer.parseInt(req.getParameter("id_duAn")));
		model.setIdTrangThaiCV(Integer.parseInt(req.getParameter("id_trangThaiCV")));
		model.setIdUser(Integer.parseInt(req.getParameter("id_user")));
		
		//sửa
		int result = congViecDAO.updateCongViec(model);
		//thông báo
		if (result>0) {
			resp.sendRedirect(req.getContextPath()+"/admin-congviec-list?result=updateSuccess");
		}else {
			resp.sendRedirect(req.getContextPath()+"/admin-congviec-list?result=updateError");
		}
	}
}
