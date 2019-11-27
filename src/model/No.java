package model;

public class No {
	private No anterior;
	private Paciente pac;
	private No proximo;    
    
    public No(Paciente pac) {
        this.pac = pac;
        this.proximo = null;
        this.anterior = null;
    }
    
    public No(No anterior, Paciente pac, No proximo) {
        this.pac = pac;
        this.proximo = proximo;
        this.anterior = anterior;
    }  
    
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
