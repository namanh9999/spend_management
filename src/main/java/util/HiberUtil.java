package util;

import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class HiberUtil {
	public static final SessionFactory sessionFactory = buildSessionFactory();

	private static SessionFactory buildSessionFactory() {
		try {
			return new Configuration().configure().buildSessionFactory();
		} catch (Exception e) {
			System.out.println("Session is null");
			e.printStackTrace();
			return null;
		}
	}

	public static SessionFactory getSessionfactory() {
		return sessionFactory;
	}

	public void shutdown() {
		getSessionfactory().close();
	}
}
