package model;

public class NoFila {
	private Atendimento ate;
	private NoFila proximo;    
    
    public NoFila(Atendimento ate) {
        this.ate = ate;
        this.proximo = null;
    }
    
    public NoFila(Atendimento ate, NoFila proximo) {
        this.ate = ate;
        this.proximo = proximo;
    }  
    
    public Atendimento getAtendimento(){ 
    	return this.ate; 
    }
    
    public NoFila getProximo(){ 
    	return this.proximo; 
    }
    
    public void setAtendimento(Atendimento ate){ 
    	this.ate = ate;
    }
    
    public void setProximo(NoFila proximo){ 
    	this.proximo = proximo; 
    }  
}
