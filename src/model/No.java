package model;

public class No {
	//atributos da classe
	private No anterior;
	private Paciente pac;
	private No proximo;    
    
	//construtor da classe - primeiro No
    public No(Paciente pac) {
        this.pac = pac;
        this.proximo = null;
        this.anterior = null;
    }
    
    //construtor da classe
    public No(No anterior, Paciente pac, No proximo) {
        this.pac = pac;
        this.proximo = proximo;
        this.anterior = anterior;
    }  
    
    //getters e setters da classe
    public No getAnterior(){ 
    	return this.anterior; 
    }
    
    public Paciente getPaciente(){ 
    	return this.pac; 
    }
    
    public No getProximo(){ 
    	return this.proximo; 
    }
    
    public void setAnterior(No anterior){ 
    	this.anterior = anterior; 
    }
    
    public void setPaciente(Paciente pac){ 
    	this.pac = pac;
    }
    
    public void setProximo(No proximo){ 
    	this.proximo = proximo; 
    }  
}
