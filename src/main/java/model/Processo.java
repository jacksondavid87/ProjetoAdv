package model;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

import controller.SampleEntity;

@Entity
@Table(name = "processo")
@SequenceGenerator(name = "processo_pro_codigo_seq", sequenceName = "processo_pro_codigo_seq", allocationSize = 1, initialValue = 0)
public class Processo implements Serializable, SampleEntity {

	private static final long serialVersionUID = -7286973067171555032L;

	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "processo_pro_codigo_seq")
	private long pro_codigo;

	@NotNull
	private String pro_acao;

	@NotNull
	private String pro_autor;

	@NotNull
	private String pro_reu;

	private String pro_num_processo;

	private String pro_vara;

	private Double pro_honorario;

	private String pro_status;

	private Double pro_valor_pago;

	private String pro_andamento;

	private String pro_obs_honorario;

	private String pro_obs_valor_pago;

	@ManyToOne
	@JoinColumn(name = "usu_codigo")
	private Usuario usuario;

	@NotNull
	private boolean pro_ativo;

	@Override
	public Long getId() {
		// TODO Auto-generated method stub
		return pro_codigo;
	}

	public long getPro_codigo() {
		return pro_codigo;
	}

	public void setPro_codigo(long pro_codigo) {
		this.pro_codigo = pro_codigo;
	}

	public String getPro_acao() {
		return pro_acao;
	}

	public void setPro_acao(String pro_acao) {
		this.pro_acao = pro_acao;
	}

	public String getPro_autor() {
		return pro_autor;
	}

	public void setPro_autor(String pro_autor) {
		this.pro_autor = pro_autor;
	}

	public String getPro_reu() {
		return pro_reu;
	}

	public void setPro_reu(String pro_reu) {
		this.pro_reu = pro_reu;
	}

	public String getPro_num_processo() {
		return pro_num_processo;
	}

	public void setPro_num_processo(String pro_num_processo) {
		this.pro_num_processo = pro_num_processo;
	}

	public String getPro_vara() {
		return pro_vara;
	}

	public void setPro_vara(String pro_vara) {
		this.pro_vara = pro_vara;
	}

	public Double getPro_honorario() {
		return pro_honorario;
	}

	public void setPro_honorario(Double pro_honorario) {
		this.pro_honorario = pro_honorario;
	}

	public String getPro_status() {
		return pro_status;
	}

	public void setPro_status(String pro_status) {
		this.pro_status = pro_status;
	}

	public Double getPro_valor_pago() {
		return pro_valor_pago;
	}

	public void setPro_valor_pago(Double pro_valor_pago) {
		this.pro_valor_pago = pro_valor_pago;
	}

	public Usuario getUsuario() {
		return usuario;
	}

	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
	}

	public boolean isPro_ativo() {
		return pro_ativo;
	}

	public void setPro_ativo(boolean pro_ativo) {
		this.pro_ativo = pro_ativo;
	}

	public String getPro_andamento() {
		return pro_andamento;
	}

	public void setPro_andamento(String pro_andamento) {
		this.pro_andamento = pro_andamento;
	}

	public String getPro_obs_honorario() {
		return pro_obs_honorario;
	}

	public void setPro_obs_honorario(String pro_obs_honorario) {
		this.pro_obs_honorario = pro_obs_honorario;
	}

	public String getPro_obs_valor_pago() {
		return pro_obs_valor_pago;
	}

	public void setPro_obs_valor_pago(String pro_obs_valor_pago) {
		this.pro_obs_valor_pago = pro_obs_valor_pago;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((pro_acao == null) ? 0 : pro_acao.hashCode());
		result = prime * result + ((pro_andamento == null) ? 0 : pro_andamento.hashCode());
		result = prime * result + (pro_ativo ? 1231 : 1237);
		result = prime * result + ((pro_autor == null) ? 0 : pro_autor.hashCode());
		result = prime * result + (int) (pro_codigo ^ (pro_codigo >>> 32));
		result = prime * result + ((pro_honorario == null) ? 0 : pro_honorario.hashCode());
		result = prime * result + ((pro_num_processo == null) ? 0 : pro_num_processo.hashCode());
		result = prime * result + ((pro_obs_honorario == null) ? 0 : pro_obs_honorario.hashCode());
		result = prime * result + ((pro_obs_valor_pago == null) ? 0 : pro_obs_valor_pago.hashCode());
		result = prime * result + ((pro_reu == null) ? 0 : pro_reu.hashCode());
		result = prime * result + ((pro_status == null) ? 0 : pro_status.hashCode());
		result = prime * result + ((pro_valor_pago == null) ? 0 : pro_valor_pago.hashCode());
		result = prime * result + ((pro_vara == null) ? 0 : pro_vara.hashCode());
		result = prime * result + ((usuario == null) ? 0 : usuario.hashCode());
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
		Processo other = (Processo) obj;
		if (pro_acao == null) {
			if (other.pro_acao != null)
				return false;
		} else if (!pro_acao.equals(other.pro_acao))
			return false;
		if (pro_andamento == null) {
			if (other.pro_andamento != null)
				return false;
		} else if (!pro_andamento.equals(other.pro_andamento))
			return false;
		if (pro_ativo != other.pro_ativo)
			return false;
		if (pro_autor == null) {
			if (other.pro_autor != null)
				return false;
		} else if (!pro_autor.equals(other.pro_autor))
			return false;
		if (pro_codigo != other.pro_codigo)
			return false;
		if (pro_honorario == null) {
			if (other.pro_honorario != null)
				return false;
		} else if (!pro_honorario.equals(other.pro_honorario))
			return false;
		if (pro_num_processo == null) {
			if (other.pro_num_processo != null)
				return false;
		} else if (!pro_num_processo.equals(other.pro_num_processo))
			return false;
		if (pro_obs_honorario == null) {
			if (other.pro_obs_honorario != null)
				return false;
		} else if (!pro_obs_honorario.equals(other.pro_obs_honorario))
			return false;
		if (pro_obs_valor_pago == null) {
			if (other.pro_obs_valor_pago != null)
				return false;
		} else if (!pro_obs_valor_pago.equals(other.pro_obs_valor_pago))
			return false;
		if (pro_reu == null) {
			if (other.pro_reu != null)
				return false;
		} else if (!pro_reu.equals(other.pro_reu))
			return false;
		if (pro_status == null) {
			if (other.pro_status != null)
				return false;
		} else if (!pro_status.equals(other.pro_status))
			return false;
		if (pro_valor_pago == null) {
			if (other.pro_valor_pago != null)
				return false;
		} else if (!pro_valor_pago.equals(other.pro_valor_pago))
			return false;
		if (pro_vara == null) {
			if (other.pro_vara != null)
				return false;
		} else if (!pro_vara.equals(other.pro_vara))
			return false;
		if (usuario == null) {
			if (other.usuario != null)
				return false;
		} else if (!usuario.equals(other.usuario))
			return false;
		return true;
	}

}
