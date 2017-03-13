package app.exam.servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import app.exam.dao.imp.userDaoImp;

@WebServlet("/loginServlet")
public class loginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public loginServlet() {
		super();
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		doPost(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		response.setCharacterEncoding("UTF-8");
		String name = request.getParameter("name");
		userDaoImp daoImp = new userDaoImp();
		int isExit = 0;
		try {
			isExit = daoImp.selectUser(name);
		} catch (Exception e) {
			e.printStackTrace();
		}
		if (isExit == 1) {
			String msg="登陆成功！";
			request.setAttribute("msg", msg);
			request.getSession().setAttribute("user", name);
			request.getRequestDispatcher("/index.jsp").forward(request, response);
		}else{
			String msg="请重新登陆！";
			request.setAttribute("msg", msg);
			request.getRequestDispatcher("/login.jsp").forward(request, response);
		}

	}

}
