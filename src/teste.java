import service.UsuarioService;
import vo.Usuario;

public class teste {

	static Usuario usuario = new Usuario();
	static UsuarioService usuarioService = new UsuarioService();
	public static void main(String[] args) {
		// TODO Auto-generated method stub

		usuario.setNome("roberci");
		usuario.setLogin("loginTesww");
		usuario.setSenha("senhaTestdd");
		usuarioService.save(usuario);
	
	}

}
