package model;

public class FilaAtendimento {
	//atributo da classe
	private NoFila topo;
	
	//construtor da classe
	public FilaAtendimento() {
		this.topo = null;
	}
	
	//método que retorna se a fila está vazia
	public boolean estaVazia() {
		if (this.topo == null) {
			return true;
		}
		return false;
	}
	
	//método que retorna o tamanho da fila
	public int tamanho() {
		int cont = 0;
		for(NoFila aux = topo; aux != null; aux = aux.getProximo()) {
			cont++;
		}
		return cont;
	}
	
	//método para inserir atendimentos ao final da fila
	public void empilhar(Atendimento ate) {
		NoFila novo = new NoFila(ate, null);
		if(estaVazia()) {
			this.topo = novo;
		}
		else {
			NoFila ultimo = null;
			for(NoFila aux = topo; aux != null; aux = aux.getProximo()) {
				ultimo = aux;
			}
			ultimo.setProximo(novo);
		}
	}
	
	//método que retira o primeiro atendimento da fila, retornando o mesmo
	public NoFila desempilhar() {
		if(this.estaVazia()) {
			return null;
		} else {
			NoFila antTopo = topo;
			this.topo = this.topo.getProximo();
			return antTopo;
		}
	}
	
	//método que retorna o primeiro No da fila
	public NoFila topo() {
		if(this.estaVazia()) {
			return null;
		} else {
			return topo;
		}
	}
	
	//método para esvaziar a fila
	public void esvaziar() {
		this.topo = null;
	}
	
}
