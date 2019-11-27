package model;

public class Paciente {
	private String nome;
	private int cpf;
	private int datanasc;
	
	public Paciente(String nome, int cpf, int datanasc) {
		super();
		this.nome = nome;
		this.cpf = cpf;
		this.datanasc = datanasc;
	}
	
	public Paciente() {
		
	}
	
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
