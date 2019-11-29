package model;

import java.text.DateFormat;

public class Atendimento {
	//atributos da classe
	private int senha;
	private Paciente pac;
	private String dataC, dataS, horaS;
	
	//construtor
	public Atendimento(Paciente pac, String dataC, int senha) {
		super();
		this.senha = senha;
		this.pac = pac;
		this.dataC = dataC;
		this.dataS = null;
		this.horaS = null;
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

	public String getDataC() {
		return dataC;
	}

	public void setDataC(String dataC) {
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
	
}
