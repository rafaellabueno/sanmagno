package model;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.ZoneId;
import java.util.Calendar;

//lista duplamente encadeada de pacientes
public class ListaPaciente {
	//atributos da classe
	private No primeiro;
	private No ultimo;
	private FilaAtendimento filaA;
	private int senha = 0;

	//construtor da classe
	public ListaPaciente() {
		this.primeiro = null;
		this.ultimo = null;
		this.filaA = new FilaAtendimento();
	}
	
	//método que retorna se a lista está vazia
	public boolean estaVazia() {
		if (this.primeiro == null) {
			return true;
		}
		return false;
	}
	
	//método para adicionar novos pacientes na lista
	public void adicionar(Paciente pac) {
		//se estiver vazia adiciona no começo
		if(estaVazia()) {
			No novo = new No(pac);
			this.primeiro = novo;
			this.ultimo = novo;
		}
		else {
			No p = buscar(pac.getCpf());
			if(p == null) {
				int cont = 0;
				for(No aux = primeiro; aux != null; aux = aux.getProximo()) {
					//inserir em ordem alfabética
					int comp = pac.getNome().compareToIgnoreCase(aux.getPaciente().getNome());
					if(cont == 0) {
						if(comp < 0){
							No novo = new No(aux.getAnterior(), pac, aux);
							if(aux.getAnterior() != null) {
								aux.getAnterior().setProximo(novo);
							}
							aux.setAnterior(novo);
							if(this.primeiro.equals(aux)) {
								this.primeiro = novo;
							}
							cont++;
						} else if(comp > 0) {
							
						}
						//se forem iguais adiciona antes igual
						else {
							No novo = new No(aux.getAnterior(), pac, aux);
							this.primeiro = novo;
							cont++;
						}
					}
				}
				if(cont == 0) {
					No novo = new No(this.ultimo, pac, null);
					this.ultimo.setProximo(novo);
					this.ultimo = novo;
				}
			}
		}
	}
	
	//método para gerar a senha do paciente para ser chamado para a triagem
	public int gerarSenha(String cpf) {
		No p = buscar(cpf);	
		Calendar cal = Calendar.getInstance();
		long d = cal.getTimeInMillis();
		
		this.senha++;
		Atendimento a = new Atendimento(p.getPaciente(), d, this.senha);
		filaA.empilhar(a);
		return this.senha;
		
	}
	
	//método para buscar o paciente que possui o cpf informado
	public No buscar(String cpf) {
		No aux = primeiro;
		if(! this.estaVazia()) {
			do {
				if (aux.getPaciente().getCpf().equals(cpf)) {
					return aux;
				}
				aux = aux.getProximo();
			} while (aux != null);
		}
        return null;
	}
	
	//método para imprimir a lista
	public void imprimir() {
		if(! this.estaVazia()) {
			for(No aux = primeiro; aux != null; aux = aux.getProximo()) {
			    System.out.println(aux.getPaciente().getNome());
			} 
		}
		
    }
	
	//método para limpar a lista
	public void limpar() {
		this.primeiro = null;
		this.ultimo = null;
	}

	//
	public FilaAtendimento getFilaA() {
		return filaA;
	}

	public void setFilaA(FilaAtendimento filaA) {
		this.filaA = filaA;
	}	
	
	public No primeiro ()
	{
		return primeiro; 
	}
	
	
}
