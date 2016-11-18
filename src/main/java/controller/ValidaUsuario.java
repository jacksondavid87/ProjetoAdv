package controller;

import java.io.Serializable;

import javax.faces.bean.ViewScoped;
import javax.faces.component.html.HtmlInputText;
import javax.inject.Inject;
import javax.inject.Named;

import model.Processo;

@Named
@ViewScoped
public class ValidaUsuario implements Serializable {

	private static final long serialVersionUID = 1626542151861652588L;
	
	@Inject
	private UsuarioLogin login;
	
	@Inject
	private GestaoProcessosBean bean;
	
	private boolean master;
	private boolean acao;
	private boolean autor;
	private boolean reu;
	private boolean numProcesso;
	private boolean vara;
	private boolean valoAca;
	private boolean status;
	private boolean valoPago;
	
	
	public boolean validaUser(){
		if(login.getTipo().equals("master")){
			master = true;
		}else{ master = false; }
		return master;
	}
	
	public boolean validaAcao(){
		//bean.getProcessoEdicao().getPro_reu();
		//System.out.println(bean.getProcessoEdicao().getPro_acao());
		if(bean.getProcessoEdicao().getPro_acao()!=null || login.getTipo().equals("comum")){
			acao = true;
		}else{ acao = false; }
		
		return acao;
	}
	
	

}
