/**
 * 
 */
package util;

import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.hibernate.service.ServiceRegistry;
import org.hibernate.service.ServiceRegistryBuilder;

/**
 * Classe para criar uma a conex�o entre o arquivo de configura��o e a conex�o
 * com o Banco de dados.
 * 
 * @author Baracho
 * 
 * @since 01/02/2012
 * 
 * @version 1.0
 * 
 */

public class HibernateUtil {

	private static final SessionFactory sessionFactory = buildSessionFactory();

	private static SessionFactory buildSessionFactory() {

		ServiceRegistry serviceRegistry = null;

		try {

			Configuration configuration = new Configuration();

			configuration.configure("hibernate.cfg.xml");

			serviceRegistry = new ServiceRegistryBuilder().applySettings(configuration.getProperties())
					.buildServiceRegistry();

			return configuration.buildSessionFactory(serviceRegistry);

		} catch (Throwable e) {
			// TODO: handle exception
			System.out.println("Cria��o inicial do objeto sessionfactory falhou. Erro: " + e);
			throw new ExceptionInInitializerError(e);
		}
	}

	public static SessionFactory getSessionFactory() {

		return sessionFactory;
	}
}
