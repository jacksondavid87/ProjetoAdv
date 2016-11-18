package service;

import java.io.Serializable;

import javax.inject.Inject;

import model.Processo;
import repository.Processos;
import util.Transacional;

public class CadastroProcessoService implements Serializable {

	private static final long serialVersionUID = -1185378667099934459L;
	
	@Inject
	private Processos processos;
	
	@Transacional
	public void salvar(Processo processo) {
		processos.guardar(processo);
	}
	
	@Transacional
	public void excluir(Processo processo) {
		processos.remover(processo);
	}
	
	

}
