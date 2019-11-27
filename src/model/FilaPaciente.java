package model;

public class FilaPaciente {
	private No topo;
	
	public FilaPaciente() {
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
		for(No aux = topo; aux != null; aux = aux.getProximo()) {
			cont++;
		}
		return cont;
	}
	
	public void empilhar(Paciente pac) {
		No novo = new No(null, pac, null);
		if(estaVazia()) {
			this.topo = novo;
		}
		else {
			No ultimo = null;
			for(No aux = topo; aux != null; aux = aux.getProximo()) {
				ultimo = aux;
			}
			ultimo.setProximo(novo);
		}
	}
	
	public No desempilhar() {
		if(this.estaVazia()) {
			return null;
		} else {
			No antTopo = topo;
			this.topo = this.topo.getProximo();
			return antTopo;
		}
	}
	
	public No topo() {
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
