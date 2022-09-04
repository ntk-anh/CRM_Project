package controller;

import java.io.IOException;
import java.util.ArrayList;

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
import model.TrangThaiCV_SoLuong;
import model.User;
import model.User_ListCongViec;

@WebServlet("/leader-congviec-detail")
public class LeaderCongViecDetailController extends HttpServlet{
	private CongViecDAO congViecDAO = null;
	private DuAnDAO duAnDAO = null;
	private UserDAO userDAO = null;
	private TrangThaiCVDAO trangThaiCVDAO = null;

	public LeaderCongViecDetailController() {
		congViecDAO = new CongViecDAO();
		duAnDAO = new DuAnDAO();
		userDAO = new UserDAO();
		trangThaiCVDAO = new TrangThaiCVDAO();
	}

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// ấn nút xem
		int id_duAn = Integer.parseInt(req.getParameter("id"));
 
		/* chi tiết cv */
		ArrayList<User_ListCongViec> user_ListCongViecs = new ArrayList<>();
		ArrayList<Integer> userIds = congViecDAO.getUserIdByDuAnId(id_duAn);
//		System.out.println("size users "+userIds.size());
		for (Integer userId : userIds) {
			User user = userDAO.getUserById(userId);
//			System.out.println("dia chi "+user.getDiaChi());
//			System.out.println("userId "+userId);System.out.println("duanid "+id_duAn);
			ArrayList<CongViec> congViecs = congViecDAO.getByDuAnIdAndUserId(id_duAn, userId);
//			System.out.println("so ptu cv "+congViecs.size());		
//			for (CongViec cv : congViecs) {
//				System.out.println("ten cv "+cv.getTenCongViec());
//			}
			User_ListCongViec user_ListCongViec = new User_ListCongViec();
			user_ListCongViec.setHoTen(user.getHoTen());
			user_ListCongViec.setCongViecs(congViecs);
			user_ListCongViecs.add(user_ListCongViec);
		}

		req.setAttribute("user_ListCongViecs", user_ListCongViecs);
		for (User_ListCongViec o : user_ListCongViecs) {
			System.out.println("ho ten :" + o.getHoTen());
			System.out.println(o.getCongViecs().size());
			for (CongViec i : o.getCongViecs()) {
				System.out.println("ngay ket thuc " + i.getNgayKetThuc());
				System.out.println("ten cong viec " + i.getTenCongViec());
			}
		}

		/* thống kê */
		ArrayList<TrangThaiCV_SoLuong> trangThaiCV_SoLuongs = congViecDAO.getTrangThaiCV_SoLuongByDuAnId(id_duAn);
		int tong = 0;
		for (TrangThaiCV_SoLuong item : trangThaiCV_SoLuongs) {
			tong += item.getSoLuongCV();
		}
//		System.out.println("tong "+tong);
//		System.out.println("TrangThaiCV_SoLuong "+trangThaiCV_SoLuongs);
		req.setAttribute("trangThaiCV_SoLuongs", trangThaiCV_SoLuongs);
		req.setAttribute("tong", tong);
		/* load đi */
		req.getRequestDispatcher("./views/congviec/congviec-detail.jsp").forward(req, resp);

	}
}
