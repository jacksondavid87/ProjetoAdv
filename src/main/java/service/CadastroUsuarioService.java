package service;

import java.io.Serializable;

import javax.inject.Inject;

import model.Usuario;
import repository.Usuarios;
import util.Transacional;

public class CadastroUsuarioService implements Serializable {

	private static final long serialVersionUID = -3438122775941438103L;
	
	@Inject
	private Usuarios usuarios;
	
	@Transacional
	public void salvar(Usuario usuario) {
		usuarios.guardar(usuario);
	}
	
	@Transacional
	public void excluir(Usuario usuario) {
		usuarios.remover(usuario);
	}

}
