package repository;

import java.io.Serializable;
import java.util.List;

import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Order;
import javax.persistence.criteria.Root;

import model.Usuario;


public class Usuarios implements Serializable {

	private static final long serialVersionUID = 7329934803400325096L;
	
	@Inject
	private EntityManager manager;
	
	public Usuario porUsu_codigo(Long usu_codigo) {
		return manager.find(Usuario.class, usu_codigo);
	}
	
	public List<Usuario> todos() {
		CriteriaBuilder builder = manager.getCriteriaBuilder();
		CriteriaQuery<Usuario> criteriaQuery = builder.createQuery(Usuario.class);
		
		Root<Usuario> usuario = criteriaQuery.from(Usuario.class);
		Order order = builder.asc(usuario.<String>get("usu_nome"));
		criteriaQuery.select(usuario);
		criteriaQuery.orderBy(order);
		
		return manager.createQuery(criteriaQuery).getResultList();
		//return manager.createQuery("from Usuario", Usuario.class).getResultList();
	}
	
	public Usuario guardar(Usuario usuario) {
		return manager.merge(usuario);
	}
	
	public void remover(Usuario usuario) {
		usuario = porUsu_codigo(usuario.getUsu_codigo());
		manager.remove(usuario);
	}

}
