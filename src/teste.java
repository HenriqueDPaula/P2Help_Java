import DAO.MunicipiosDAO;
import model.Municipios;
import model.Sistema;
import model.Usuario;
import service.MunicipioService;
import service.SistemaService;
import service.UsuarioService;

public class teste {

	static Usuario usuario = new Usuario();
	static UsuarioService usuarioService = new UsuarioService();
	static Municipios municipio = new Municipios();
	static MunicipioService municipioService = new MunicipioService();
	static MunicipiosDAO municipioDAO = new MunicipiosDAO();
	static SistemaService sistemaService = new SistemaService();
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		Sistema sistema = sistemaService.FindById(6);
		sistema.setFabricante("hp");
		sistema.setNome("notebook");
		sistemaService.save(sistema);
		System.out.println(sistema.getNome());
//		Municipios muni = municipioService.FindById(4106902);
//		System.out.println(muni.getNome());
		//municipioDAO.findById(4105805);
//System.out.println(municipio.getNome());
//		//municipioService.FindById(4105805);
//		municipio.setNome("paranagua");
//		municipio.setUf("PR");
//		municipio.setIdmunicipio(4);
////		municipioService.save(municipio);
//	usuario.setNome("carlosAlberto");
//		usuario.setCpf("01223929938");
//		usuario.setBairro("xaxim");
//		usuario.setComplemento("casa");
//		usuario.setEndereco("Gerhdar Heinrichs");
//		usuario.setRg("12131133");
//		usuario.setRgEmissor("PR");
//		usuario.setMunicipio(muni);
//		usuarioService.save(usuario);
//	
	}

}
