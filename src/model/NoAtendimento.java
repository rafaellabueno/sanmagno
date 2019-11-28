package model;

public class NoAtendimento {
	//atributos da classe
	private NoAtendimento anterior;
	private Atendimento ate;
	private NoAtendimento proximo;    
    
	//construtor da classe - primeiro No
    public NoAtendimento(Atendimento ate) {
        this.ate = ate;
        this.proximo = null;
        this.anterior = null;
    }
    
    //construtor da classe
    public NoAtendimento(NoAtendimento anterior, Atendimento ate, NoAtendimento proximo) {
        this.ate = ate;
        this.proximo = proximo;
        this.anterior = anterior;
    }  
    
    //getters e setters da classe
    public NoAtendimento getAnterior(){ 
    	return this.anterior; 
    }
    
    public Atendimento getAtendimento(){ 
    	return this.ate; 
    }
    
    public NoAtendimento getProximo(){ 
    	return this.proximo; 
    }
    
    public void setAnterior(NoAtendimento anterior){ 
    	this.anterior = anterior; 
    }
    
    public void setAtendimento(Atendimento ate){ 
    	this.ate = ate;
    }
    
    public void setProximo(NoAtendimento proximo){ 
    	this.proximo = proximo; 
    }  
}
