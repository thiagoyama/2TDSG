package br.com.fiap.tds.entity;

import java.util.Calendar;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Lob;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
@Table(name="TB_CURSO")
@SequenceGenerator(name="curso",sequenceName = "SQ_TB_CURSO", allocationSize = 1)
public class Curso {

	@Id
	@Column(name="cd_curso")
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "curso")
	private int codigo;
	
	@Column(name="nm_curso", length = 60, nullable = false)
	private String nome;
	
	@Column(nullable = false, name="vl_curso")
	private double valor;
	
	@Column(name="dt_inicio")
	@Temporal(TemporalType.DATE)
	private Calendar dataInicio;
	
	@Column(name="dt_termino")
	@Temporal(TemporalType.DATE)
	private Calendar dataTermino;
	
	@Lob
	@Column(name="fl_logo")
	private byte[] logo;
	
	@Enumerated(EnumType.STRING)
	@Column(name="ds_periodo")
	private Periodo periodo;
	
	@Column(name="st_certificado")
	private boolean certificado;

	public int getCodigo() {
		return codigo;
	}

	public void setCodigo(int codigo) {
		this.codigo = codigo;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public double getValor() {
		return valor;
	}

	public void setValor(double valor) {
		this.valor = valor;
	}

	public Calendar getDataInicio() {
		return dataInicio;
	}

	public void setDataInicio(Calendar dataInicio) {
		this.dataInicio = dataInicio;
	}

	public Calendar getDataTermino() {
		return dataTermino;
	}

	public void setDataTermino(Calendar dataTermino) {
		this.dataTermino = dataTermino;
	}

	public byte[] getLogo() {
		return logo;
	}

	public void setLogo(byte[] logo) {
		this.logo = logo;
	}

	public Periodo getPeriodo() {
		return periodo;
	}

	public void setPeriodo(Periodo periodo) {
		this.periodo = periodo;
	}

	public boolean isCertificado() {
		return certificado;
	}

	public void setCertificado(boolean certificado) {
		this.certificado = certificado;
	}
	
}
