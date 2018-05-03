package DAO;

import org.hibernate.Session;

import util.HibernateUtil;
import vo.Usuario;

public class UsuarioDAO {
	
	private Session session;
	
	
	public UsuarioDAO() {
		this.session = HibernateUtil.getSessionFactory().openSession();
	}

	public void save(Usuario usuario) {
		if(usuario.getIdusuario() == null) {
			this.session.save(usuario);
		} else {
			this.session.update(usuario);
		}
		
	}
}
