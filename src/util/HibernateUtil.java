/**
 * 
 */
package util;

import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.hibernate.service.ServiceRegistry;
import org.hibernate.service.ServiceRegistryBuilder;

/**
 * Classe para realizar a ponte entre o arquivo de conexão e o banco de dados.
 * 
 * @author Baracho
 * 
 * @since 26/05/2013
 * 
 * @version 1.0
 * 
 */

public class HibernateUtil {

	private static SessionFactory sessionFactory = buildSessionFactory();

	private static SessionFactory buildSessionFactory() {

		ServiceRegistry serviceRegistry = null;

		try {

			Configuration configuration = new Configuration();

			configuration.configure("hibernate.cfg.xml");

			serviceRegistry = new ServiceRegistryBuilder().applySettings(
					configuration.getProperties()).buildServiceRegistry();

			return configuration.buildSessionFactory(serviceRegistry);

		} catch (Throwable e) {
			// TODO: handle exception

			System.err
					.println("Criação inicial do objeto SessionFactory falhou. Erro: "
							+ e.getMessage());

			throw new ExceptionInInitializerError();
		}
	}

	public static SessionFactory getSessionFactory() {

		return sessionFactory;
	}
	
	  public static void shutdown() {
	        // Close caches and connection pools
	        getSessionFactory().close();
	    }
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		
		HibernateUtil.getSessionFactory();
	}

}
