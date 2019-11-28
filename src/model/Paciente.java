package model;

public class Paciente {
	//atributos da classe
	private String nome;
	private String cpf;
	private int datanasc;
	
	//construtor da classe
	public Paciente(String nome, String cpf, int datanasc) {
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
	
	public String getCpf() {
		return cpf;
	}
	
	public void setCpf(String cpf) {
		this.cpf = cpf;
	}
	
	public int getDatanasc() {
		return datanasc;
	}
	
	public void setDatanasc(int datanasc) {
		this.datanasc = datanasc;
	}	
}
