package app.exam.servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import app.exam.dao.imp.filmDaoImp;
import app.exam.fileEntity.filmEntity;
import app.exam.fileEntity.languageEntity;

/**
 * Servlet implementation class file_update
 */
@WebServlet("/film_updateServlet")
public class film_updateServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
 
    public film_updateServlet() {
        super();
     
    }


	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request, response);
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		filmDaoImp fdi=new filmDaoImp();
		filmEntity film=new filmEntity();
		String ids = request.getParameter("id");
		int id= Integer.parseInt(ids);
		String title= request.getParameter("title");
		String description= request.getParameter("description");
		String language =request.getParameter("language");
		Integer lanid = 0 ;
		
			try {
				film=fdi.film_Query_by_id(id);
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			languageEntity lans = null;
			try {
				lans = fdi.lan_Query_by_name(language);
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			lanid =lans.getLanguage_id();
		
		
		film.setTitle(title);
		film.setDescription(description);
		film.setLanguage_id(lanid);
		
		try {
			fdi.film_upt(film);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		
	}

}
