package repository;

import java.io.Serializable;
import java.util.List;

import javax.inject.Inject;
import javax.persistence.EntityManager;

import model.Usuario;


public class Usuarios implements Serializable {

	private static final long serialVersionUID = 7329934803400325096L;
	
	@Inject
	private EntityManager manager;
	
	public Usuario porUsu_codigo(Long usu_codigo) {
		return manager.find(Usuario.class, usu_codigo);
	}
	
	public List<Usuario> todos() {
		return manager.createQuery("from Usuario", Usuario.class).getResultList();
	}
	
	public Usuario guardar(Usuario usuario) {
		return manager.merge(usuario);
	}
	
	public void remover(Usuario usuario) {
		usuario = porUsu_codigo(usuario.getUsu_codigo());
		manager.remove(usuario);
	}

}
