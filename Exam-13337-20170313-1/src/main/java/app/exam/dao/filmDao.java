
package app.exam.dao;

import java.util.List;

import app.exam.fileEntity.filmEntity;
import app.exam.fileEntity.languageEntity;

public interface filmDao {
	public List<filmEntity> film_allQuery() throws Exception;
	public int film_add(filmEntity file_add) throws Exception;
	public int film_del(filmEntity file_del) throws Exception;
	public int film_upt(filmEntity file_upt) throws Exception;
	public filmEntity film_Query_by_id(int id) throws Exception;
    public languageEntity lan_Query_by_name(String name) throws Exception;
    public int lan_upt(String name) throws Exception;
    public int film_del_id(int id) throws Exception;
}
