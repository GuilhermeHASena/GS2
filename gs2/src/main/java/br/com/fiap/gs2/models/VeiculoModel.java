package br.com.fiap.gs2.models;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity
@Table(name = "TB_VEICULO")
public class VeiculoModel {
	
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator="veiculoSequence")
	@SequenceGenerator(name="veiculoSequence", sequenceName="veiculoSequence")
	@Id
	private int veiculoID;
	
	@ManyToOne(fetch = FetchType.EAGER, optional = false)
    @JoinColumn(name = "ambiente_id", nullable = false)
	private AmbienteModel ambienteID;
	
	@Column(nullable = false)
	private String marca;
	
	@Column(nullable = false)
	private String modelo;
	
	@Column(nullable = false)
	private String placa;
	
	@Column(nullable = false)
	private double quilometragem;

	public int getVeiculoID() {
		return veiculoID;
	}

	public void setVeiculoID(int veiculoID) {
		this.veiculoID = veiculoID;
	}
	
	public AmbienteModel getAmbienteID() {
		return ambienteID;
	}

	public void setAmbienteID(AmbienteModel ambienteID) {
		this.ambienteID = ambienteID;
	}

	public String getMarca() {
		return marca;
	}

	public void setMarca(String marca) {
		this.marca = marca;
	}

	public String getModelo() {
		return modelo;
	}

	public void setModelo(String modelo) {
		this.modelo = modelo;
	}

	public String getPlaca() {
		return placa;
	}

	public void setPlaca(String placa) {
		this.placa = placa;
	}

	public double getQuilometragem() {
		return quilometragem;
	}

	public void setQuilometragem(double quilometragem) {
		this.quilometragem = quilometragem;
	}
	
}
