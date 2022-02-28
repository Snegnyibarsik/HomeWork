package Atutorial.Ahibernate;

import org.hibernate.*;
import org.hibernate.cfg.*;

// Класс создаёт SessionFactory

public class UtilConnection{
	
	private static final SessionFactory sf = buildsf();

private static SessionFactory buildsf() {
	try {
		return new AnnotationConfiguration().configure().buildSessionFactory();
	} catch (Throwable ex){
		System.err.println("SF faile " + ex);
		throw new ExceptionInInitializerError(ex);
	}
	}

public static SessionFactory getsf() {
return sf;
	}

public static void shutdown() {
	getsf().close();
}
}
