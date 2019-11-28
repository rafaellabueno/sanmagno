package controller;


import model.Paciente;
import visao.JanelaPrincipal;

public class App {
	public static void main(String[] args) {
		JanelaPrincipal j = new JanelaPrincipal();
		j.setVisible(true);
		Paciente p = new Paciente();
		Controller pcon = new Controller(j, p);	
	}
}
