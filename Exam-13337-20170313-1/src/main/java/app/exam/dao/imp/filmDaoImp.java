package app.exam.dao.imp;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import app.exam.dao.filmDao;
import app.exam.fileEntity.filmEntity;
import app.exam.fileEntity.languageEntity;
import app.exam.util.ConnectionFactory;

public class filmDaoImp implements filmDao {
	

	@Override
	public List<filmEntity> film_allQuery() throws Exception {
		String sql="SELECT film_id,title,description,name "
				 + "FROM film f ,language g "
				 + "where f.language_id=g.language_id";
		Connection conn = ConnectionFactory.getInstance().makeConnection();
		PreparedStatement ps = conn.prepareStatement(sql);
		 ResultSet rs= ps.executeQuery();
		 List<filmEntity> list= new ArrayList<filmEntity>();
		 if(rs.next()){
			 filmEntity film= new filmEntity();
			 film.setFilm_id( rs.getInt("film_id"));
			 film.setTitle(rs.getString("title"));
			 film.setDescription(rs.getString("description"));
			 film.getLan().setName(rs.getString("name"));
			 list.add(film);			 
		 }
		
		
		
		return list;
	}
	
	
	public filmEntity film_Query_by_id(int id) throws Exception{
		filmEntity film =new filmEntity();
		
		
		String sql="SELECT * FROM sakila.film where film_id=?;";
		Connection conn = ConnectionFactory.getInstance().makeConnection();
		PreparedStatement ps = conn.prepareStatement(sql);
		ps.setLong(1, id);
		ResultSet rs= ps.executeQuery();
		while(rs.next()){
			film.setFilm_id(rs.getInt("film_id"));			
			film.setTitle(rs.getString("title"));
			film.setDescription(rs.getString("description"));
			film.setRelease_year(rs.getInt("release_year"));
			film.setLanguage_id(rs.getInt("language_id"));
			film.setOriginal_language_id(rs.getInt("original_language_id"));
			film.setRental_duration(rs.getInt("rental_duration"));
			film.setRental_rate(rs.getDouble("rental_duration"));
			film.setLength(rs.getInt("length"));
			film.setReplacement_cost(rs.getDouble("replacement_cost"));
			film.setRating(rs.getString("rating"));
			film.setSpecial_features(rs.getString("special_features"));
			film.setLast_update(rs.getDate("last_update"));
		}
		
		
		return film;
	}

	@Override
	public int film_add(filmEntity file_add) throws Exception {
		
		return 0;
	}

	@Override
	public int film_del(filmEntity file_del) throws Exception {
	
		return 0;
	}

	@Override
	public int film_upt(filmEntity file_upt) throws Exception {
		String sql=" update film set title=?,description=?,language_id=? ;";
		 Connection conn = ConnectionFactory.getInstance().makeConnection();
		 PreparedStatement ps=conn.prepareStatement(sql);
		 ps.setString(1, file_upt.getTitle());
		 ps.setString(1, file_upt.getDescription());
		 ps.setInt(1, file_upt.getLanguage_id());
		 int i= ps.executeUpdate();
		return i;
	}
	
	 public languageEntity lan_Query_by_name(String name) throws Exception{
		 String sql="SELECT * FROM sakila.language where name=?;";
		 languageEntity lan =new languageEntity();
		 Connection conn = ConnectionFactory.getInstance().makeConnection();
		 PreparedStatement ps=conn.prepareStatement(sql);
		 ps.setString(1, name);
		 ResultSet rs =ps.executeQuery();
		 while(rs.next()) {
			 lan.setLanguage_id(rs.getInt("language_id"));
			 lan.setName(rs.getString("name"));
			 lan.setLast_update(rs.getDate("last_update"));
		 }
		 
		 
		 return lan;
	 };
	 public int lan_upt(String name) throws Exception{
			String sql="update language set name=? ;";
			Connection conn = ConnectionFactory.getInstance().makeConnection();
			 PreparedStatement ps=conn.prepareStatement(sql);
			 ps.setString(1, name);
		 return 0;
	 };
	 public int film_del_id(int id) throws Exception{
		 String sql="delete from film where film_id=?;";
			Connection conn = ConnectionFactory.getInstance().makeConnection();
			 PreparedStatement ps=conn.prepareStatement(sql);
			 ps.setInt(1, id);
			 int i= ps.executeUpdate();
		 return i;
	 };

}
