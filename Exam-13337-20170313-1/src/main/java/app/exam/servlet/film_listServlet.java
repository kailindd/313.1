package app.exam.servlet;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import app.exam.dao.imp.filmDaoImp;
import app.exam.fileEntity.filmEntity;

@WebServlet("/film_listServlet")
public class film_listServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       

    public film_listServlet() {
        super();
        
    }

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request, response);
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setCharacterEncoding("UTF-8");
		 List<filmEntity> list= new ArrayList<filmEntity>();
		 filmDaoImp fdi=new filmDaoImp();
		 try {
			 list=fdi.film_allQuery();
		} catch (Exception e) {
			 e.printStackTrace();
		}
		 if(list.isEmpty()){
			 request.getRequestDispatcher("/index.jsp").forward(request, response);
		 }else{
			 request.setAttribute("list", list);
			 request.getRequestDispatcher("/film_select.jsp").forward(request, response);
		 }
		
		
	}

}
