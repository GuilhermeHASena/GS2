package br.com.fiap.gs2.models;

import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity
@Table(name = "TB_AMBIENTE")
public class AmbienteModel {

	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator="ambienteSequence")
	@SequenceGenerator(name="ambienteSequence", sequenceName="ambienteSequence")
	@Id
	private int ambienteID;
	
	@OneToMany(mappedBy = "ambiente", cascade = CascadeType.DETACH, fetch = FetchType.EAGER)
	private Set<AmbienteModel> ambiente;
	
	@Column(nullable = false)
	private String estado;
	
	@Column(nullable = false)
	private String cidade;
	
	@Column(nullable = false)
	private String bairro;
	
	@Column(nullable = false)
	private String temperaturaAmbiente;
	
	@Column(nullable = false)
	private String qualidadeDoAr;

	public int getAmbienteID() {
		return ambienteID;
	}

	public void setAmbienteID(int ambienteID) {
		this.ambienteID = ambienteID;
	}

	public String getEstado() {
		return estado;
	}

	public void setEstado(String estado) {
		this.estado = estado;
	}

	public String getCidade() {
		return cidade;
	}

	public void setCidade(String cidade) {
		this.cidade = cidade;
	}

	public String getBairro() {
		return bairro;
	}

	public void setBairro(String bairro) {
		this.bairro = bairro;
	}

	public String getTemperaturaAmbiente() {
		return temperaturaAmbiente;
	}

	public void setTemperaturaAmbiente(String temperaturaAmbiente) {
		this.temperaturaAmbiente = temperaturaAmbiente;
	}

	public String getQualidadeDoAr() {
		return qualidadeDoAr;
	}

	public void setQualidadeDoAr(String qualidadeDoAr) {
		this.qualidadeDoAr = qualidadeDoAr;
	}
	
}
