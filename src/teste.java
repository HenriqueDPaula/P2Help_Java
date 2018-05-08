import model.Municipios;
import model.Usuario;
import service.MunicipioService;
import service.UsuarioService;

public class teste {

	static Usuario usuario = new Usuario();
	static UsuarioService usuarioService = new UsuarioService();
	static Municipios municipio = new Municipios();
	static MunicipioService municipioService = new MunicipioService();
	public static void main(String[] args) {
		// TODO Auto-generated method stub

		municipio.setNome("Curitiba");
		municipio.setUf("PR");
		municipioService.save(municipio);
		
//		usuario.setNome("roberci");
//		usuario.setLogin("loginTesww");
//		usuario.setSenha("senhaTestdd");
//		usuarioService.save(usuario);
	
	}

}
