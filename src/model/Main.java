package model;

public class Main {
	public static void main(String[] args) {
		ListaPaciente l = new ListaPaciente();
		Paciente p1 = new Paciente("Rafaella", 01, 21122000);
		l.adicionar(p1);
		l.imprimir();
		Paciente p2 = new Paciente("Guilherme", 01, 21122000);
		l.adicionar(p2);
		l.imprimir();
		Paciente p3 = new Paciente("Guilherme", 01, 21122000);
		l.adicionar(p3);
		l.imprimir();
		Paciente p4 = new Paciente("Matheus", 01, 21122000);
		l.adicionar(p4);
		l.imprimir();
		Paciente p5 = new Paciente("Vitória", 01, 21122000);
		l.adicionar(p5);
		l.imprimir();		
		
	}

}
