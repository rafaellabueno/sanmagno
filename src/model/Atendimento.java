package model;

import java.text.DateFormat;

public class Atendimento {
	//atributos da classe
	private int senha, prioridade;
	private Paciente pac;
	private long dataC, dataA;
	private String dataS, horaS;
	
	//construtor
	public Atendimento(Paciente pac, long dataC, int senha) {
		super();
		this.senha = senha;
		this.pac = pac;
		this.dataC = dataC;
		this.dataA = 0;
		this.dataS = null;
		this.horaS = null;
		this.prioridade = 0;
	}

	//getters e setters dos atributos
	public int getSenha() {
		return senha;
	}

	public void setSenha(int senha) {
		this.senha = senha;
	}

	public Paciente getPac() {
		return pac;
	}

	public void setPac(Paciente pac) {
		this.pac = pac;
	}

	public long getDataC() {
		return dataC;
	}

	public void setDataC(long dataC) {
		this.dataC = dataC;
	}

	public String getDataS() {
		return dataS;
	}

	public void setDataS(String dataS) {
		this.dataS = dataS;
	}

	public String getHoraS() {
		return horaS;
	}

	public void setHoraS(String horaS) {
		this.horaS = horaS;
	}

	public long getDataA() {
		return dataA;
	}

	public void setDataA(long dataA) {
		this.dataA = dataA;
	}

	public int getPrioridade() {
		return prioridade;
	}

	public void setPrioridade(int prioridade) {
		this.prioridade = prioridade;
	}
}
