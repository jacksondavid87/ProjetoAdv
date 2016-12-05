package repository;

import java.io.Serializable;
import java.util.List;

import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Order;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;

import controller.UsuarioLogin;
import controller.ValidaUsuario;
import model.Processo;


public class Processos implements Serializable {

	private static final long serialVersionUID = -1309451346379148025L;

	private static final int String = 0;
	
	@Inject
	private EntityManager manager;
	@Inject
	private ValidaUsuario usuario;
	@Inject
	private UsuarioLogin login;
	
	public Processo porPro_codigo(Long pro_codigo) {
		return manager.find(Processo.class, pro_codigo);
	}
	
	public List<Processo> todos() {
		if(usuario.validaUser()==false){
			CriteriaBuilder builder = manager.getCriteriaBuilder();
			CriteriaQuery<Processo> criteriaQuery = builder.createQuery(Processo.class);
			
			Root<Processo> processo = criteriaQuery.from(Processo.class);
			Order order = builder.asc(processo.<String>get("pro_autor"));
			Predicate predicate = builder.equal(processo.<String>get("usuario"), login.getId());
			criteriaQuery.select(processo);
			criteriaQuery.where(predicate);
			criteriaQuery.orderBy(order);
			
			return manager.createQuery(criteriaQuery).getResultList();
		}else{
			CriteriaBuilder builder = manager.getCriteriaBuilder();
			CriteriaQuery<Processo> criteriaQuery = builder.createQuery(Processo.class);
			
			Root<Processo> processo = criteriaQuery.from(Processo.class);
			Order order = builder.asc(processo.<String>get("pro_autor"));
			criteriaQuery.select(processo);
			criteriaQuery.orderBy(order);
			
			return manager.createQuery(criteriaQuery).getResultList();			
		}
	}
	
	public Processo guardar(Processo processo) {
		return manager.merge(processo);
	}
	
	public void remover(Processo processo) {
		processo = porPro_codigo(processo.getPro_codigo());
		manager.remove(processo);
	}
}
