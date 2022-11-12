package br.com.fiap.gs2.models;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity
@Table(name = "TB_REGIONAL")
public class RegionalModel {
	
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator="regionalSequence")
	@SequenceGenerator(name="regionalSequence", sequenceName="regionalSequence")
	@Id
	private int regionalID;
	
	@Column(nullable = false)
	private String dataDeOperacao;
	
	@Column(nullable = false)
	private String veiculos;

	public int getRegionalID() {
		return regionalID;
	}

	public void setRegionalID(int regionalID) {
		this.regionalID = regionalID;
	}

	public String getDataDeOperacao() {
		return dataDeOperacao;
	}

	public void setDataDeOperacao(String dataDeOperacao) {
		this.dataDeOperacao = dataDeOperacao;
	}

	public String getVeiculos() {
		return veiculos;
	}

	public void setVeiculos(String veiculos) {
		this.veiculos = veiculos;
	}
	
}
