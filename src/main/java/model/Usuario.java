package model;

import java.io.Serializable;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

import org.hibernate.validator.constraints.NotEmpty;

import controller.SampleEntity;

@Entity
@Table(name = "usuario")
@SequenceGenerator(name = "usuario_usu_codigo_seq", sequenceName = "usuario_usu_codigo_seq", allocationSize = 1, initialValue = 0)
public class Usuario implements Serializable, SampleEntity {

	private static final long serialVersionUID = 8483843087446338476L;

	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "usuario_usu_codigo_seq")
	private long usu_codigo;

	@NotEmpty
	@Column(name = "usu_nome", nullable = false, length = 50)
	private String usu_nome;

	@NotEmpty
	@Column(name = "usu_tipo", nullable = false, length = 15)
	private String usu_tipo;

	@Column(name = "usu_senha")
	private int usu_senha;

	@Column(name = "usu_primeiro_acesso")
	private boolean usu_primeiro_acesso;

	@OneToMany(mappedBy = "usuario")
	private List<Processo> processos;

	public List<Processo> getProcessos() {
		return processos;
	}

	public void setProcessos(List<Processo> processos) {
		this.processos = processos;
	}

	public long getUsu_codigo() {
		return usu_codigo;
	}

	public void setUsu_codigo(long usu_codigo) {
		this.usu_codigo = usu_codigo;
	}

	public String getUsu_nome() {
		return usu_nome;
	}

	public void setUsu_nome(String usu_nome) {
		this.usu_nome = usu_nome;
	}

	public String getUsu_tipo() {
		return usu_tipo;
	}

	public void setUsu_tipo(String usu_tipo) {
		this.usu_tipo = usu_tipo;
	}

	public int getUsu_senha() {
		return usu_senha;
	}

	public void setUsu_senha(int usu_senha) {
		this.usu_senha = usu_senha;
	}

	public boolean getUsu_primeiro_acesso() {
		return usu_primeiro_acesso;
	}

	public void setUsu_primeiro_acesso(boolean usu_primeiro_acesso) {
		this.usu_primeiro_acesso = usu_primeiro_acesso;
	}

	

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((processos == null) ? 0 : processos.hashCode());
		result = prime * result + (int) (usu_codigo ^ (usu_codigo >>> 32));
		result = prime * result + ((usu_nome == null) ? 0 : usu_nome.hashCode());
		result = prime * result + (usu_primeiro_acesso ? 1231 : 1237);
		result = prime * result + usu_senha;
		result = prime * result + ((usu_tipo == null) ? 0 : usu_tipo.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Usuario other = (Usuario) obj;
		if (processos == null) {
			if (other.processos != null)
				return false;
		} else if (!processos.equals(other.processos))
			return false;
		if (usu_codigo != other.usu_codigo)
			return false;
		if (usu_nome == null) {
			if (other.usu_nome != null)
				return false;
		} else if (!usu_nome.equals(other.usu_nome))
			return false;
		if (usu_primeiro_acesso != other.usu_primeiro_acesso)
			return false;
		if (usu_senha != other.usu_senha)
			return false;
		if (usu_tipo == null) {
			if (other.usu_tipo != null)
				return false;
		} else if (!usu_tipo.equals(other.usu_tipo))
			return false;
		return true;
	}

	@Override
	public Long getId() {
		// TODO Auto-generated method stub
		return usu_codigo;
	}

}
