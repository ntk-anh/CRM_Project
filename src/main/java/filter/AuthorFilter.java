package filter;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.swing.text.ChangedCharSetException;

import model.User;

@WebFilter(urlPatterns = { "/admin-user-list", "/admin-user-add", "/admin-user-edit", "/admin-user-delete",
							"/admin-role-list", "/admin-role-add", "/admin-role-edit", "/admin-role-delete",
							"/admin-duan-list", "/admin-duan-add", "/admin-duan-edit", "/admin-duan-delete",
							"/admin-congviec-list", "/admin-congviec-add", "/admin-congviec-edit", "/admin-congviec-delete","/admin-congviec-detail",
							"/leader-duan-list", "/leader-duan-add", "/leader-duan-edit", "/leader-duan-delete","/leader-congviec-detail",
							"/member-congviec-list", "/member-congviec-edit", "/member-congviec-thongke"
						})
public class AuthorFilter implements Filter {

	@Override
	public void destroy() {
		// TODO Auto-generated method stub

	}

	@Override
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
			throws IOException, ServletException {

		HttpServletRequest req = (HttpServletRequest) request;
		HttpServletResponse resp = (HttpServletResponse) response;
		// user gõ link có admin => có login chưa (có session k) => có đúng role k =>
		// sai thì chuyển về login page + câu thông báo
		// user gõ link có leader => có login chưa (có session k) => có đúng role k
		// user gõ link có member => có login chưa (có session k) => có đúng role k
		String uri = req.getRequestURI();// lấy uri ; /crm/admin
		HttpSession session = req.getSession();
		User user = (User) session.getAttribute("user");
		if (uri.startsWith("/crm/admin")) {
			if (user != null) {
				if (user.getId_role() == 1) {
					chain.doFilter(request, response);
				} else {
					resp.sendRedirect(req.getContextPath() + "/auth?result=notPermission");
				}
			} else {
				resp.sendRedirect(req.getContextPath() + "/auth?result=notLogin");
			}
		} else if (uri.startsWith("/crm/leader")) {
			if (user != null) {
				if (user.getId_role() == 2) {
					chain.doFilter(request, response);
				} else {
					resp.sendRedirect(req.getContextPath() + "/auth?result=notPermission");
				}
			} else {
				resp.sendRedirect(req.getContextPath() + "/auth?result=notLogin");
			}
		} else if (uri.startsWith("/crm/member")) {
			if (user != null) {
				if (user.getId_role() == 3) {
					chain.doFilter(request, response);
				} else {
					resp.sendRedirect(req.getContextPath() + "/auth?result=notPermission");
				}
			} else {
				resp.sendRedirect(req.getContextPath() + "/auth?result=notLogin");
			}
		}

//		StringBuffer url=req.getRequestURL();//lấy url 
	}

	@Override
	public void init(FilterConfig filterConfig) throws ServletException {

	}

}
