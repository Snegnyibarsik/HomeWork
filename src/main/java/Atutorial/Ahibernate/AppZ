package Atutorial.Ahibernate;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;


import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.transform.Transformers;


import entity.People;
import entity.PeopleZ;

public class AppZ {

	public static void main(String[] args) {
		Session s = UtilConnection.getsf().openSession();
		
    	Query qP = s.createQuery("From entity.People");
    	
    	@SuppressWarnings("unchecked")
    	List <People> pl = qP.list();
    	
    	//Данные извлечены из БД и собраны в коллекции объектов People
    	System.out.println("SQL DB: \n ");
    	for (People p: pl) {
		System.out.println("-" + p);}
		
    	//Частичное заполнение коллекции объектов PeopleZ
		Query qPZ = s.createQuery("select m.id as idZ, m.name as nameZ, m.iid as iidZ" 
				  + " from entity.People m");
				qPZ.setResultTransformer(Transformers.aliasToBean(PeopleZ.class));
				@SuppressWarnings("unchecked")
				List<PeopleZ> pZ = qPZ.list();		
				
		// Коллекция для связи id  и родительского объекта	
			HashMap <Integer,PeopleZ> pMap = new HashMap<Integer,PeopleZ>();
			
		//Заполнение коллекции	
			for (int i=0; i<pZ.size();i++) {
				pMap.put(pZ.get(i).idZ,pZ.get(i));
					}
		//Заполнение поля родительского объекта в PeopleZ
			for (int i=0; i<pZ.size();i++) {
				pZ.get(i).setInfecting(pMap.get(pZ.get(i).iidZ));
			}
		// Коллекция для связи id  и коллекции дочерних объектов	
			HashMap<Integer, ArrayList<PeopleZ>> iMap = new HashMap <Integer,ArrayList<PeopleZ>>();
		//Заполнение коллекции	
			for (int i=0; i<pZ.size();i++) {
				iMap.computeIfAbsent(pZ.get(i).iidZ, k -> new ArrayList<>()).add(pMap.get(pZ.get(i).idZ));
			}
		//Заполнение поля коллекции дочерних объектов в PeopleZ
			for (int i=0; i<pZ.size();i++) {
				pZ.get(i).setInfected(iMap.get(pZ.get(i).idZ));
			}
		//Сохранение имени родительского объекта
			String fName = new String();
			
			for (int i=0; i<pZ.size();i++) {
				if (pZ.get(i).iidZ==null) {
					fName = pZ.get(i).nameZ;
				}
			}
		//Сохранение места в коллекции, где распологается родительский объект
			int fInt = 0;
			
			for (int i=0; i<pZ.size();i++) {
				if (pZ.get(i).nameZ.equals(fName)) {
					fInt = i;
				}}
		//Запуск рекурсии
			System.out.println("\n Structure of DB: ");
			pZ.get(fInt).FirstEpidZZemic(pZ.get(fInt));
			
			UtilConnection.shutdown();
			
	}}//main+class
								
	
		
				
				
	




