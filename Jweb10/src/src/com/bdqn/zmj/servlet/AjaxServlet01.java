/*package src.com.bdqn.zmj.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import src.com.bdqn.zmj.dao.UserDao;
import src.com.bdqn.zmj.entity.User;

@WebServlet("/AjaxServlet01")
public class AjaxServlet01 extends HttpServlet {

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String uname = request.getParameter("uname");
		System.out.println("进入到了后台！！" + uname);
		UserDao dao = new UserDao();
		User user = new User();
		user.setUname(uname);
		List<User> list = dao.selet(user);
		response.setContentType("text/html;charset=utf-8");
		PrintWriter out = response.getWriter();
		if (list.size() > 0) {
			out.print("error");// 说明数据库有这个人
		} else {
			out.print("ok");// 数据库没这个人
		}
	}
}*/
