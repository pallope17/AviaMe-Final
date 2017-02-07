package controlador;

import java.sql.SQLException;

import org.hibernate.Session;
import org.hibernate.SessionFactory;

import models.SessionFactoryUtil;

public class ConectarseBaseDatos {

	public static Session conectar() throws SQLException{
		
		SessionFactory sesion=SessionFactoryUtil.getSessionFactory();
		Session session=sesion.openSession();
		session.beginTransaction();
		
		return session;
	
	}
}
