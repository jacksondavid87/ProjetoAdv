package controller;

import java.io.Serializable;
import java.util.Arrays;
import java.util.List;

import javax.faces.view.ViewScoped;
import javax.inject.Inject;
import javax.inject.Named;

import org.primefaces.context.RequestContext;

import model.Usuario;
import repository.Usuarios;
import service.CadastroUsuarioService;
import util.FacesMessages;

@Named
@ViewScoped
public class GestaoUsuariosBean implements Serializable {

	private static final long serialVersionUID = 1056420698717333034L;
	
	@Inject
	private Usuarios usuarios;
	
	@Inject
	private CadastroUsuarioService cadastroUsuario;
	
	@Inject
	private FacesMessages messages;
	
	private List<Usuario> todosUsuarios;
	private Usuario usuarioEdicao = new Usuario();
	private Usuario usuarioSelecionado;
	
	
	public void prepararNovoCadastro() {
		usuarioEdicao = new Usuario();
	}
	
	public void salvar() {
		usuarioEdicao.setUsu_primeiro_acesso(false);
		cadastroUsuario.salvar(usuarioEdicao);
		//System.out.println(login.getNome());
		consultar();

		messages.info("Usuário salvo com sucesso!");

		RequestContext.getCurrentInstance().update(Arrays.asList("frm:msgs", "frm:usuarios-table"));
	}
	
	public void excluir() {
		cadastroUsuario.excluir(usuarioSelecionado);
		usuarioSelecionado = null;
		//System.out.println(login.getNome());

		consultar();

		messages.info("Usuário excluído com sucesso!");
	}
	
	public void consultar() {
		todosUsuarios = usuarios.todos();
		System.out.println(todosUsuarios.size());

	}

	public Usuario getUsuarioEdicao() {
		return usuarioEdicao;
	}

	public void setUsuarioEdicao(Usuario usuarioEdicao) {
		this.usuarioEdicao = usuarioEdicao;
	}

	public Usuario getUsuarioSelecionado() {
		return usuarioSelecionado;
	}

	public void setUsuarioSelecionado(Usuario usuarioSelecionado) {
		this.usuarioSelecionado = usuarioSelecionado;
	}

	public List<Usuario> getTodosUsuarios() {
		return todosUsuarios;
	}
	

}
