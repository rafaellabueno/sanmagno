package model;

import java.text.DateFormat;

public class Atendimento {
	//atributos da classe
	private int senha;
	private Paciente pac;
	private int dataS, horaS;
	private String dataC;
	
	//construtor
	public Atendimento(Paciente pac, String dataC, int senha) {
		super();
		this.senha = senha;
		this.pac = pac;
		this.dataC = dataC;
		this.dataS = 0;
		this.horaS = 0;
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

	public int getDataS() {
		return dataS;
	}

	public void setDataS(int dataS) {
		this.dataS = dataS;
	}

	public int getHoraS() {
		return horaS;
	}

	public void setHoraS(int horaS) {
		this.horaS = horaS;
	}
	
}
