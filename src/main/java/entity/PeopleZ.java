package entity;

import java.util.ArrayList;

import javax.persistence.Column;

//Класс для рекурсии, содержит данные о родительских и дочерних связанных объектах

public class PeopleZ {
	@Column (name="id", nullable=true)
	public Integer idZ;
	@Column (name="iid", nullable=true)
	public Integer iidZ;
	@Column (name="names")
	public String nameZ;
	@Column
	public ArrayList <PeopleZ> infected;
	@Column
	public PeopleZ infecting;

public PeopleZ() {}

public PeopleZ (Integer idZ, String nameZ, Integer iidZ) {
	this.idZ = idZ;
	this.nameZ = nameZ;
	this.iidZ = iidZ;
}//constructor

public ArrayList<PeopleZ> getInfected() {
	return infected;
}

public void setInfected(ArrayList<PeopleZ> infected) {
	this.infected = infected;
}

public PeopleZ getInfecting() {
	return infecting;
}

public void setInfecting(PeopleZ infecting) {
	this.infecting = infecting;
}

//Метода для запуска рекурсии, принимает родительский класс
public void FirstEpidZZemic (PeopleZ p) {
	System.out.println(new String(new char[p.idZ-1]).replace("\0", "   ")+"--"+p.nameZ);
	p.EpidZZemic(p,p.idZ,p.nameZ);
}

//Метод для извлечения данных в виде структуры через рекурсию
public void EpidZZemic(PeopleZ p, Integer idZ, String nameZ)
{
    if(p==null || p.getInfected()==null) return;
    for(PeopleZ z : p.getInfected())
    {
    System.out.println(new String(new char[idZ]).replace("\0", "   ")+"-"+z.nameZ);
EpidZZemic(z,idZ+1,nameZ);

}}





}//class

