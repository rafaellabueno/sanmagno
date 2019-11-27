package model;

public class FilaAtendimento {
	private NoFila topo;
	
	public FilaAtendimento() {
		this.topo = null;
	}
	
	public boolean estaVazia() {
		if (this.topo == null) {
			return true;
		}
		return false;
	}
	
	public int tamanho() {
		int cont = 0;
		for(NoFila aux = topo; aux != null; aux = aux.getProximo()) {
			cont++;
		}
		return cont;
	}
	
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
	
	public NoFila desempilhar() {
		if(this.estaVazia()) {
			return null;
		} else {
			NoFila antTopo = topo;
			this.topo = this.topo.getProximo();
			return antTopo;
		}
	}
	
	public NoFila topo() {
		if(this.estaVazia()) {
			return null;
		} else {
			return topo;
		}
	}
	
	public void esvaziar() {
		this.topo = null;
	}
}
