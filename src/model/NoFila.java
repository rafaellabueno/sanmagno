package model;

public class NoFila {
	//atributos da classe
	private Atendimento ate;
	private NoFila proximo;    
    
	//construtor da classe - primeiro No
    public NoFila(Atendimento ate) {
        this.ate = ate;
        this.proximo = null;
    }
    
    //construtor da classe
    public NoFila(Atendimento ate, NoFila proximo) {
        this.ate = ate;
        this.proximo = proximo;
    }  
    
    //getters e setters da classe
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
