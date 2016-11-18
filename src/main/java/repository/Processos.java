package repository;

import java.io.Serializable;
import java.util.List;

import javax.inject.Inject;
import javax.persistence.EntityManager;

import model.Processo;


public class Processos implements Serializable {

	private static final long serialVersionUID = -1309451346379148025L;
	
	@Inject
	private EntityManager manager;
	
	public Processo porPro_codigo(Long pro_codigo) {
		return manager.find(Processo.class, pro_codigo);
	}
	
	public List<Processo> todos() {
		return manager.createQuery("from Processo", Processo.class).getResultList();
	}
	
	public Processo guardar(Processo processo) {
		return manager.merge(processo);
	}
	
	public void remover(Processo processo) {
		processo = porPro_codigo(processo.getPro_codigo());
		manager.remove(processo);
	}
}
