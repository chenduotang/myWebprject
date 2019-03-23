package src.com.bdqn.zmj.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import src.com.bdqn.zmj.dao.UserDao;
import src.com.bdqn.zmj.dao.UserDaotwo;
import src.com.bdqn.zmj.entity.Page;
import src.com.bdqn.zmj.entity.User;
import src.com.bdqn.zmj.service.UserService;

@WebServlet("/UserServlet")
public class UserServlet extends HttpServlet {
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html;charset=utf-8");
		UserService userse=new UserService();
		int currnPage = request.getParameter("opr") == null ? 1 : Integer.parseInt(request.getParameter("opr"));
		try {
			Page<User> userPage=userse.getList(currnPage, 3);
			request.setAttribute("userPage", userPage);
			request.getRequestDispatcher("userlist.jsp").forward(request, response);
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
}
