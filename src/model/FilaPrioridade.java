package model;

public class FilaPrioridade {
	// atributo da classe
	private NoFila topo;

	// construtor da classe
	public FilaPrioridade() {
		this.topo = null;
	}

	// m�todo que retorna se a fila est� vazia
	public boolean estaVazia() {
		if (this.topo == null) {
			return true;
		}
		return false;
	}

	// m�todo que retorna o tamanho da fila
	public int tamanho() {
		int cont = 0;
		for (NoFila aux = topo; aux != null; aux = aux.getProximo()) {
			cont++;
		}
		return cont;
	}

	// m�todo para inserir atendimentos ao final da fila
	public void empilhar(Atendimento ate) {
		NoFila novo = new NoFila(ate, null);
		if (estaVazia()) {
			this.topo = novo;
		} else {
			NoFila ultimo = null;
			for (NoFila aux = topo; aux != null; aux = aux.getProximo()) {
				ultimo = aux;
			}
			ultimo.setProximo(novo);
		}
	}

	// m�todo que retira o primeiro atendimento da fila, retornando o mesmo
	public NoFila desempilhar() {
		if (this.estaVazia()) {
			return null;
		} else {
			NoFila antTopo = topo;
			this.topo = this.topo.getProximo();
			return antTopo;
		}
	}

	// m�todo para buscar
	public NoFila buscar(String cpf) {
		NoFila aux = topo;
		if (!this.estaVazia()) {
			do {
				if (aux.getAtendimento().getPac().getCpf().equals(cpf)) {
					return aux;
				}
				aux = aux.getProximo();
			} while (aux != null);
		}
		return null;
	}

	// m�todo que retorna o primeiro No da fila
	public NoFila topo() {
		if (this.estaVazia()) {
			return null;
		} else {
			return topo;
		}
	}

	// m�todo para esvaziar a fila
	public void esvaziar() {
		this.topo = null;
	}
}
