package model;

public class Atendimento {
	//atributos da classe
	private int senha;
	private Paciente pac;
	private int dataC, horaC, dataS, horaS;
	
	//construtor
	public Atendimento(Paciente pac, int dataC, int horaC, int senha) {
		super();
		this.senha = senha;
		this.pac = pac;
		this.dataC = dataC;
		this.horaC = horaC;
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

	public int getDataC() {
		return dataC;
	}

	public void setDataC(int dataC) {
		this.dataC = dataC;
	}

	public int getHoraC() {
		return horaC;
	}

	public void setHoraC(int horaC) {
		this.horaC = horaC;
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
