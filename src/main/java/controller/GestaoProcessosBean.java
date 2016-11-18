package controller;

import java.io.Serializable;
import java.util.Arrays;
import java.util.List;

import javax.faces.view.ViewScoped;
import javax.inject.Inject;
import javax.inject.Named;

import org.primefaces.context.RequestContext;

import model.Processo;
import model.Usuario;
import repository.Processos;
import repository.Usuarios;
import service.CadastroProcessoService;
import util.FacesMessages;

@Named
@ViewScoped
public class GestaoProcessosBean implements Serializable {

	private static final long serialVersionUID = 7430662234966360865L;

	@Inject
	private Processos processos;

	@Inject
	private Usuarios usuarios;

	@Inject
	private UsuarioLogin login;

	@Inject
	private CadastroProcessoService cadastroProcesso;

	@Inject
	private FacesMessages messages;

	private List<Processo> todosProcessos;
	private Usuario usuario;
	private Processo processoEdicao = new Processo();
	private Processo processoSelecionado;
	
	private boolean acao;
	private boolean autor;
	private boolean reu;
	private boolean numProcesso;
	private boolean vara;
	private boolean valorAcao;
	private boolean status;
	private boolean valorPago;

	public void prepararNovoCadastro() {
		processoEdicao = new Processo();
	}

	public void salvar() {

		if(processoEdicao.getUsuario()==null && !processoEdicao.isPro_ativo()){
			processoEdicao.setUsuario(usuario);
			processoEdicao.setPro_ativo(true);
		}
		
		//processoEdicao.setUsuario(usuario);
		//processoEdicao.setPro_ativo(true);
		cadastroProcesso.salvar(processoEdicao);
		consultar();

		messages.info("Processo cadastrado com sucesso!");

		RequestContext.getCurrentInstance().update(Arrays.asList("frm:msgs", "frm:processos-table"));
	}

	public void excluir() {
		cadastroProcesso.excluir(processoSelecionado);
		processoSelecionado = null;

		consultar();

		messages.info("Processo excluído com sucesso!");
	}

	public void consultar() {
		todosProcessos = processos.todos();
		System.out.println(todosProcessos.size());

	}

	public void consultarUsuario() {
		usuario = usuarios.porUsu_codigo((long) login.getId());
		// System.out.println(todosUsuarios.size());

	}
	
	//Validações da forma que foi pedido - rever depis para tirar daqui
	public boolean validaAcao(){
		//boolean teste = processoEdicao.getPro_acao().equals(null);
		//System.out.println(processoEdicao.getPro_acao().equals(processoEdicao.getPro_acao()==null));
		if(processoEdicao.getPro_acao()==null || processoEdicao.getPro_acao().equals("")){
			acao = false;
			//System.out.println("Estou no primeiro if acao");
		}else{ 
			if(login.getTipo().equals("comum") && processoEdicao.getPro_acao()!=null){
				acao = true; 
				//System.out.println("Estou no primeiro if else acao");
				}else { acao = false; }
			}
		return acao;
	}
	
	public boolean validaAutor(){
		//System.out.println(processoEdicao.getPro_autor());
		if(processoEdicao.getPro_autor()==null || processoEdicao.getPro_autor().equals("")){
			autor = false;
			//System.out.println("Estou no primeiro if auto");
		}else{ 
			if(login.getTipo().equals("comum") && processoEdicao.getPro_autor()!=null){
				autor = true; 
				//System.out.println("Estou no primeiro if else autor");
				}else { acao = false; }
			}
		return autor;
	}
	
	public boolean validaReu(){
		if(processoEdicao.getPro_reu()==null || processoEdicao.getPro_reu().equals("")){
			reu = false;
			//System.out.println("Estou no primeiro if reu");
		}else{ 
			if(login.getTipo().equals("comum") && processoEdicao.getPro_reu()!=null){
				reu = true; 
				//System.out.println("Estou no primeiro if else reu");
				}else { acao = false; }
			}
		return reu;
	}
	
	public boolean validaNumProcesso(){
		if(processoEdicao.getPro_num_processo()==null || processoEdicao.getPro_num_processo().equals("")){
			numProcesso = false;
			//System.out.println("Estou no primeiro if numPorcesso");
		}else{ 
			if(login.getTipo().equals("comum") && processoEdicao.getPro_num_processo()!=null){
				//System.out.println(processoEdicao.getPro_num_processo());
				numProcesso = true; 
				//System.out.println("Estou no primeiro if else numProcesso");
				}else { numProcesso = false; }
			}
		return numProcesso;
	}
	
	public boolean validaVara(){
		if(processoEdicao.getPro_vara()==null || processoEdicao.getPro_vara().equals("")){
			vara = false;
			//System.out.println("Estou no primeiro if vara");
		}else{ 
			if(login.getTipo().equals("comum") && processoEdicao.getPro_vara()!=null){
				vara = true; 
				//System.out.println("Estou no primeiro if else vara");
				}else { vara = false; }
			}
		return vara;
	}
	
	public boolean validaValorAcao(){
		if(processoEdicao.getPro_honorario()==null || processoEdicao.getPro_honorario().equals("")){
			valorAcao = false;
			//System.out.println("Estou no primeiro if honorario");
		}else{ 
			if(login.getTipo().equals("comum") && processoEdicao.getPro_honorario()!=null){
				valorAcao = true; 
				//System.out.println("Estou no primeiro if else honorario");
				}else { valorAcao = false; }
			}
		return valorAcao;
	}
	
	public boolean validaStatus(){
		if(processoEdicao.getPro_status()==null || processoEdicao.getPro_status().equals("")){
			status = false;
			//System.out.println("Estou no primeiro if status");
		}else{ 
			if(login.getTipo().equals("comum") && processoEdicao.getPro_status()!=null){
				status = true; 
				//System.out.println("Estou no primeiro if else status");
				}else { status = false; }
			}
		return status;
	}
	
	public boolean validaValorPago(){
		if(login.getTipo().equals("comum")){
			valorPago = true;
		}else{ valorPago = false; }
		return valorPago;
	}
	//fim das validações
	
	// geters and seters
	public Processo getProcessoEdicao() {
		return processoEdicao;
	}

	public void setProcessoEdicao(Processo processoEdicao) {
		this.processoEdicao = processoEdicao;
	}

	public Processo getProcessoSelecionado() {
		return processoSelecionado;
	}

	public void setProcessoSelecionado(Processo processoSelecionado) {
		this.processoSelecionado = processoSelecionado;
	}

	public List<Processo> getTodosProcessos() {
		return todosProcessos;
	}

	public Usuario getUsuario() {
		return usuario;
	}

}
