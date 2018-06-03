import java.util.ArrayList;
import java.util.List;

import DAO.MunicipiosDAO;
import DAO.SistemaDAO;
import model.Categoria;
import model.Municipios;
import model.Usuario;
import service.CategoriaService;
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
	static CategoriaService categoriaService = new CategoriaService();
	static SistemaDAO sis = new SistemaDAO();

	public static void main(String[] args) {
//		
		usuario = new Usuario();
		usuario.setBairro("xaxim");
		usuario.setComplemento("casa");
		usuario.setCpf("12633939937");
		usuario.setEmail("Henrique@email");
		usuario.setEndereco("gerharddddd");
		usuario.setNumero("1111");
		municipio = municipioService.FindById(61);
		usuario.setMunicipio(municipio);
		usuario.setNome("Henrique");
		usuario.setRg("1315555151");
		usuario.setRgEmissor("pr");
		usuario.setSenha("senha");
		usuarioService.save(usuario);
//		List<Categoria> cat = new ArrayList<Categoria>();
//		cat = categoriaService.listar();
//		for (Categoria categoria : cat) {
//			System.out.println(categoria.getDescricao());
//		}
//		SistemaService sis = new SistemaService();
//		Sistema sistema = new Sistema();
//		sistema.setNome("carreira");
//		sistema.setFabricante("Carlos");
//		sis.save(sistema);
		// TODO Auto-generated method stub
//		List<Municipios> muni = new ArrayList<Municipios>();
//		muni = municipioService.listar();
//		for (Municipios municipio : muni) {
//			System.out.println(municipio.getNome());
//		}
		//
		// Sistema sistema = sistemaService.FindById(6);
		// sistema.setFabricante("hp");
		// sistema.setNome("notebook");
		// sistemaService.save(sistema);
		// System.out.println(sistema.getNome());
		// Municipios muni = municipioService.FindById(4106902);
		// System.out.println(muni.getNome());
		// municipioDAO.findById(4105805);
		// System.out.println(municipio.getNome());
		// //municipioService.FindById(4105805);
//		 municipio.setNome("indiassss");
//		 municipio.setUf("PR");
//		 municipio.setIdmunicipio(4);
//		 municipioService.save(municipio);
		// usuario.setNome("carlosAlberto");
		// usuario.setCpf("01223929938");
		// usuario.setBairro("xaxim");
		// usuario.setComplemento("casa");
		// usuario.setEndereco("Gerhdar Heinrichs");
		// usuario.setRg("12131133");
		// usuario.setRgEmissor("PR");
		// usuario.setMunicipio(muni);
		// usuarioService.save(usuario);
		//
	}

}
