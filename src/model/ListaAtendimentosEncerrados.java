package model;

//lista duplamente encadeada de atendimentos encerrados
public class ListaAtendimentosEncerrados {
	//atributos da classe
	private NoAtendimento primeiro;
	private NoAtendimento ultimo;

	//construtor da classe
	public ListaAtendimentosEncerrados() {
		this.primeiro = null;
		this.ultimo = null;
	}
	
	//método que retorna se a lista está vazia
	public boolean estaVazia() {
		if (this.primeiro == null) {
			return true;
		}
		return false;
	}
	
	//método para adicionar novos atendimentos na lista
	public void adicionar(Atendimento ate) {
		//se estiver vazia adiciona no começo
		if(estaVazia()) {
			NoAtendimento novo = new NoAtendimento(ate);
			this.primeiro = novo;
			this.ultimo = novo;
		}
		else {
			int cont = 0;
			for(NoAtendimento aux = primeiro; aux != null; aux = aux.getProximo()) {
				//inserir em ordem alfabética
				int comp = ate.getPac().getNome().compareToIgnoreCase(aux.getAtendimento().getPac().getNome());
				if(cont == 0) {
					if(comp < 0){
						NoAtendimento novo = new NoAtendimento(aux.getAnterior(), ate, aux);
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
						NoAtendimento novo = new NoAtendimento(aux.getAnterior(), ate, aux);
						this.primeiro = novo;
						cont++;
					}
				}
			}
			if(cont == 0) {
				NoAtendimento novo = new NoAtendimento(this.ultimo, ate, null);
				this.ultimo.setProximo(novo);
				this.ultimo = novo;
			}
		}
	}
	
	//método para buscar o atendimento e consequentemente o paciente que possui o cpf informado
	public NoAtendimento buscar(String cpf) {
		NoAtendimento aux = primeiro;
		if(! this.estaVazia()) {
			do {
				if (aux.getAtendimento().getPac().getCpf().equals(cpf)) {
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
			for(NoAtendimento aux = primeiro; aux != null; aux = aux.getProximo()) {
			    System.out.println(aux.getAtendimento().getPac().getNome());
			} 
		}
		
    }
	
	//método para limpar a lista
	public void limpar() {
		this.primeiro = null;
		this.ultimo = null;
	}
	
	//método para retornar o primeiro da lista
	public NoAtendimento primeiro() {
		return this.primeiro;
	}
}
