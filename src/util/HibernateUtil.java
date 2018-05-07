/**
 * 
 */
package util;

import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.hibernate.service.ServiceRegistry;
import org.hibernate.service.ServiceRegistryBuilder;
import org.hibernate.cfg.AnnotationConfiguration;

/**
 * Classe para realizar a ponte entre o arquivo de conex�o e o banco de dados.
 * 
 * @author Baracho
 * 
 * @since 26/05/2013
 * 
 * @version 1.0
 * 
 */

public class HibernateUtil {
	// declare um objeto do tipo SessionFactory
	/*
	 * Mas pq o atributo � static? declare como static para que vc possa chamar esse
	 * m�todo mesmo sem ter uma inst�ncia da classe HibernateUtil, conceito b�sico
	 * de encapsulamento.
	 */
	// ops n�o esque�a de importar do pacote correto heim
	// deve ser o pacote org.hibernate

	public static SessionFactory sessionFactory;

	public HibernateUtil() {
	}

	/*
	 * vamos criar um m�todo que retorne a nossa sessionFactory aberta esse m�todo
	 * tb deve ser static, pois um atributo static s� pode ser visto por um m�todo
	 * tb static
	 */
	public static SessionFactory getSessionFactory() {
		// verificar se nossa session � null, se for passar a configura��o e abrir
		if (sessionFactory == null) {
			// por favor dentro de try e catch para tratarmos o erro se ocorrer
			try {
				// instanciar o objeto para receber a configura��o
				AnnotationConfiguration annotation = new AnnotationConfiguration();
				// vamos pedir para ler a configura��o e abrir a sess�o
				sessionFactory = annotation.configure().buildSessionFactory();

			} catch (Throwable ex) {
				/*
				 * Throwable � o pai de todas as excess�es ent�o qualquer excess�o que ocorrer
				 * ser� tratada
				 */
				System.out.println("Erro ao inicar o Hibernte " + ex);
				throw new ExceptionInInitializerError(ex);
			}
			// se td der certo retorna a sessao aberta
			return sessionFactory;

		} else {
			return sessionFactory;
		}
	}

}
