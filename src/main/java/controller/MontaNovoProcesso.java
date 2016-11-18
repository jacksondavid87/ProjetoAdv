package controller;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.faces.component.html.HtmlInputText;


@ManagedBean
@ViewScoped
public class MontaNovoProcesso {
	
	private HtmlInputText inputNome;
	
	public void verificaPermicao(){
		this.inputNome.setDisabled(true);
		
	}

}
