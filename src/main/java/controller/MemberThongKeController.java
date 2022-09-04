package controller;

import java.io.IOException;
import java.util.ArrayList;

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
import model.ThongKeCV1Member;
import model.TrangThaiCV_SoLuong;
import model.User;
import model.User_ListCongViec;

@WebServlet("/member-congviec-thongke")
public class MemberThongKeController extends HttpServlet {

	private CongViecDAO congViecDAO = null;
	private DuAnDAO duAnDAO = null;
	private UserDAO userDAO = null;
	private TrangThaiCVDAO trangThaiCVDAO = null;

	public MemberThongKeController() {
		congViecDAO = new CongViecDAO();
		duAnDAO = new DuAnDAO();
		userDAO = new UserDAO();
		trangThaiCVDAO = new TrangThaiCVDAO();
	}

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		//lấy id user
		HttpSession session=req.getSession();
		User user = (User) session.getAttribute("user");
		
		//gọi hàm thống kê cv của user này
		ArrayList<ThongKeCV1Member> thongKeCV1Members = congViecDAO.getThongKeCV1Member(user.getId());
		 
		//gửi list này sang jsp
		req.setAttribute("thongKeCV1Members", thongKeCV1Members);
		
		//tính tổng số lượng cv
		int tong=0;
		for (ThongKeCV1Member o : thongKeCV1Members) {
			tong+=o.getSoLuong();
		}
		
		//gửi tong này sang jsp
		req.setAttribute("tong", tong);
		
		//chuyển hướng đến jsp
		req.getRequestDispatcher("./views/member/congviec/congviec-detail.jsp").forward(req, resp);
		
	}

}













