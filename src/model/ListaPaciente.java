package model;

public class ListaPaciente {
	private No primeiro;
	private No ultimo;
	private FilaAtendimento filaA;
	private int senha = 0;

	public ListaPaciente() {
		this.primeiro = null;
		this.ultimo = null;
		this.filaA = new FilaAtendimento();
	}
	
	public boolean estaVazia() {
		if (this.primeiro == null) {
			return true;
		}
		return false;
	}
	
	public void adicionar(Paciente pac) {
		if(estaVazia()) {
			No novo = new No(pac);
			this.primeiro = novo;
			this.ultimo = novo;
		}
		else {
			int cont = 0;
			for(No aux = primeiro; aux != null; aux = aux.getProximo()) {
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
	
	public int gerarSenha(int cpf) {
		No p = buscar(cpf);
		int data = 21/12/2000;
		int hora = 2;
		this.senha++;
		Atendimento a = new Atendimento(p.getPaciente(), data, hora, this.senha);
		filaA.empilhar(a);
		return this.senha;
		
	}
	
	public No buscar(int cpf) {
		No aux = primeiro;
		if(! this.estaVazia()) {
			do {
				if (aux.getPaciente().getCpf() == cpf) {
					return aux;
				}
				aux = aux.getProximo();
			} while (aux != primeiro);
		}
        return null;
	}
	
	public No buscarInverso(Paciente pac) {
		No aux = ultimo;
		if(! this.estaVazia()) {
			do {
				if (aux.getPaciente() == pac) {
					return aux;
				}
				aux = aux.getAnterior();
			} while (aux != ultimo);
		}
        return null;
	}
	
	public void removerInicio(Paciente pac) {
		No p = primeiro;
		if(p.getPaciente() != pac ) {
			No aux = primeiro;
				do {
					No remover = aux.getProximo();
					No proxRemover = remover.getProximo();
					if (remover.getPaciente() == pac) {
					    aux.setProximo(proxRemover);
					    proxRemover.setAnterior(aux);
					    break;
					}
					aux = aux.getProximo();
				}while(aux != primeiro);
		}
		else {
			this.primeiro = p.getProximo();
			this.primeiro.setAnterior(ultimo);
			this.ultimo.setProximo(primeiro);
		}
	}
	
	public void removerFinal(Paciente pac) {
		No p = ultimo;
		if(p.getPaciente() != pac ) {
			No aux = ultimo;
			do {
				No remover = aux.getAnterior();
				No antRemover = remover.getAnterior();
				if (remover.getPaciente() == pac) {
				    aux.setAnterior(antRemover);
				    antRemover.setProximo(aux);
				    break;
				}
				aux = aux.getAnterior();
			}while(aux != ultimo);
		}
		else {
			this.ultimo = p.getAnterior();
			this.primeiro.setAnterior(ultimo);
			this.ultimo.setProximo(primeiro);
		}
	}
	
	public void imprimir() {
		if(! this.estaVazia()) {
			for(No aux = primeiro; aux != null; aux = aux.getProximo()) {
			    System.out.println(aux.getPaciente().getNome());
			} 
		}
		
    }
	
	public void imprimirInverso() {
		No aux;		
		aux = ultimo;
		if(! this.estaVazia()) {
			do {
			    System.out.println(aux.getPaciente());
			    aux = aux.getAnterior();
			} while (aux != ultimo);
		}
    }
	
	public void limpar() {
		this.primeiro = null;
		this.ultimo = null;
	}
	
	public boolean existeLoop() {
		No aux;	
		aux = primeiro;
		if(! this.estaVazia()) {
			do {
			    aux = aux.getProximo();
			} while (aux != primeiro);
		}
		return false;
	}

	public FilaAtendimento getFilaA() {
		return filaA;
	}

	public void setFilaA(FilaAtendimento filaA) {
		this.filaA = filaA;
	}
	
	
}
