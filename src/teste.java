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

		municipioService.FindById(4105805);
//		municipio.setNome("paranagua");
//		municipio.setUf("PR");
//		municipio.setIdmunicipio(4);
//		municipioService.save(municipio);
//		usuario.setNome("roberci");
//		usuario.setCpf("01222929938");
//		usuario.setBairro("xaxim");
//		usuario.setComplemento("casa");
//		usuario.setEndereco("Gerhdar Heinrichs");
//		usuario.setRg("12131133");
//		usuario.setRgEmissor("PR");
//		usuario.setMunicipio(municipio);
//		usuarioService.save(usuario);
	
	}

}
