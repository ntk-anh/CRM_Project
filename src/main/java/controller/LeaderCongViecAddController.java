package controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import dao.CongViecDAO;
import dao.DuAnDAO;
import dao.TrangThaiCVDAO;
import dao.UserDAO;
import model.CongViec;
import model.User;
@WebServlet("/leader-congviec-add")
public class LeaderCongViecAddController extends HttpServlet{
	private CongViecDAO congViecDAO = null;
	private DuAnDAO duAnDAO = null;
	private UserDAO userDAO = null;
	private TrangThaiCVDAO trangThaiCVDAO = null;

	public LeaderCongViecAddController() {
		congViecDAO = new CongViecDAO();
		duAnDAO = new DuAnDAO();
		userDAO = new UserDAO();
		trangThaiCVDAO = new TrangThaiCVDAO();
	}

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// bấm nút thêm mới
		HttpSession session = req.getSession();
		User user = (User) session.getAttribute("user");
		req.setAttribute("duans", duAnDAO.getAllByIdLeader(user.getId()));System.out.println(duAnDAO.getAllByIdLeader(user.getId()).size());
		req.setAttribute("user", userDAO.getAllMemberUser());
		req.setAttribute("trangThaiCV", trangThaiCVDAO.getAllTrangThaiCV());
		req.getRequestDispatcher("./views/leader/congviec-add.jsp").forward(req, resp);
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		req.setCharacterEncoding("utf-8");
		resp.setCharacterEncoding("utf-8");
		
		// bấm lưu lại ở trang thêm mới 
		int id_duAn= Integer.parseInt(req.getParameter("id_duAn")) ;//value trong option được chọn => là giá trị của id_duAn
		int id_trangThaiCV= Integer.parseInt(req.getParameter("id_trangThaiCV")) ;
		int id_user= Integer.parseInt(req.getParameter("id_user")) ; 
		
		CongViec congViec=new CongViec(); 
		congViec.setTenCongViec(req.getParameter("ten_cong_viec"));
		congViec.setNgayBatDau(req.getParameter("ngay_bat_dau"));
		congViec.setNgayKetThuc(req.getParameter("ngay_ket_thuc"));
		congViec.setIdUser(id_user);
		congViec.setIdDuAn(id_duAn);
		congViec.setIdTrangThaiCV(id_trangThaiCV);		
		
		//thêm
		int result = congViecDAO.insertCongViec(congViec); 
		
		//thông báo
		if (result>0) {
			resp.sendRedirect(req.getContextPath()+"/leader-congviec-list?result=insertSuccess");
		}else {
			resp.sendRedirect(req.getContextPath()+"/leader-congviec-list?result=insertError");
		}
	}	
}
