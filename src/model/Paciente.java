package model;

public class Paciente {
	//atributos da classe
	private String nome;
	private int cpf;
	private int datanasc;
	
	//construtor da classe
	public Paciente(String nome, int cpf, int datanasc) {
		super();
		this.nome = nome;
		this.cpf = cpf;
		this.datanasc = datanasc;
	}
	
	//construtor da classe vazio
	public Paciente() {
		
	}
	
	//getters e setters da classe
	public String getNome() {
		return nome;
	}
	
	public void setNome(String nome) {
		this.nome = nome;
	}
	
	public int getCpf() {
		return cpf;
	}
	
	public void setCpf(int cpf) {
		this.cpf = cpf;
	}
	
	public int getDatanasc() {
		return datanasc;
	}
	
	public void setDatanasc(int datanasc) {
		this.datanasc = datanasc;
	}	
}
