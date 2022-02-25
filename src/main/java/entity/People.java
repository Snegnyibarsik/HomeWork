package entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;


/* 
 Класс для извлечения данных из базы SQL
 */
@Entity
@Table (name="epicwaves")
public class People {
	@Id
	@Column (name="id", nullable=true)
	private Integer id;
	@Column (name="names")
	private String name;
	@Column (name="iid", nullable=true)
	private Integer iid;
	
	public People() {}
	
	public People (Integer id, String name, Integer iid) {
		this.id=id;
		this.name=name;
		this.iid=iid;
	}
	
	
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public Integer getIid() {
		return iid;
	}
	public void setIid(Integer iid) {
		this.iid = iid;
	}
	//Метод для представления извлеченных данных в читабельном виде
	@Override
	public String toString() {
		return "Person: id " + id + ", name " + name + ", iid " 
	+ iid +".";
	
	
	}
}

