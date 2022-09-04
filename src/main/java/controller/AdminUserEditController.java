package controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.catalina.valves.rewrite.RewriteCond;

import com.google.gson.Gson;

import dao.UserDAO;
import model.User;

@WebServlet("/admin-user-edit")
public class AdminUserEditController extends HttpServlet {

	private UserDAO userDAO = null;

	public AdminUserEditController() {
		userDAO = new UserDAO();
	}

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// hiển thị trang sửa
		int id =Integer.parseInt(req.getParameter("id"));
		User user = userDAO.getUserById(id);	 

 		req.setAttribute("user", user); 
		req.getRequestDispatcher("./views/user/user-edit.jsp").forward(req, resp);
		
 		/* Dùng gson chuyển model => json (bằng thư viện gson) => ajax 
		PrintWriter out=resp.getWriter();
		resp.setContentType("application/json");
		Gson gson=new Gson();
		
		User model=userDAO.getUserById(Integer.parseInt(id));
		
		String objectToReturn=gson.toJson(model);
		out.write(objectToReturn);//đưa json về ajax
		out.flush();
		return;
		*/
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		req.setCharacterEncoding("utf-8");
		resp.setCharacterEncoding("utf-8");
		// khi bấm nút cập nhật
		User model = new User();
		int id = Integer.parseInt(req.getParameter("id"));
		model.setId(id);
		model.setHoTen(req.getParameter("ho_ten"));
		model.setEmail(req.getParameter("email"));
		model.setDiaChi(req.getParameter("dia_chi"));
		model.setSoDienThoai(req.getParameter("so_dien_thoai"));	 
		model.setId_role(Integer.parseInt(req.getParameter("id_role")));	System.out.println(req.getParameter("id_role")); 

//		System.out.println(model.getId());
//		System.out.println(model.getHoTen());
//		System.out.println(model.getEmail());
//		System.out.println(model.getDiaChi());
//		System.out.println(model.getSoDienThoai());
		//cập nhật
		int result = userDAO.updateUser(model);

		// hiện thông báo
		if (result > 0) {
			resp.sendRedirect(req.getContextPath()+"/admin-user-list?result=updateSuccess");
		} else {
			resp.sendRedirect(req.getContextPath()+"/admin-user-list?result=updateError");
		}
	}
}
