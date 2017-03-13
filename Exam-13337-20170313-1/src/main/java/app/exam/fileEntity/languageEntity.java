package app.exam.fileEntity;

import java.util.Date;

public class languageEntity extends idEntity {
	private Integer language_id;
	private String name;
	private Date last_update;
	public Integer getLanguage_id() {
		return language_id;
	}
	public void setLanguage_id(Integer language_id) {
		this.language_id = language_id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public Date getLast_update() {
		return last_update;
	}
	public void setLast_update(Date last_update) {
		this.last_update = last_update;
	}
	@Override
	public String toString() {
		return "languageEntity [language_id=" + language_id + ", name=" + name + ", last_update=" + last_update
				+ ", id=" + id + "]";
	}
	
	

}
