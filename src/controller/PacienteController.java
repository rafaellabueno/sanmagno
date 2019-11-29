package controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import model.ListaPaciente;
import model.Paciente;
import visao.JanelaPrincipal;

public class PacienteController implements ActionListener{
	private JanelaPrincipal jan;
	private Paciente pac;
	private ListaPaciente listaPac;
	private Paciente pLista;
	
	public PacienteController(JanelaPrincipal jan, Paciente pac) {
		super();
		this.jan = jan;
		this.pac = pac;
		this.jan.getMenuCadastro().addActionListener(this);
		this.jan.getMenuConsulta().addActionListener(this);
		this.jan.getTcad().getBtnCadastrar().addActionListener(this);
		this.jan.getTcon().getBtnPesquisar().addActionListener(this);
		this.jan.getTcon().getBtnGerarSenha().addActionListener(this);
		
		listaPac = new ListaPaciente();
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		//Tela de cadastro de paciente
		if (e.getActionCommand().equals("menuCad")) {
			this.jan.setContentPane(this.jan.getTcad());
			this.jan.revalidate();
			this.jan.repaint();
			this.jan.getTcad().getTextNome().setText("");
			this.jan.getTcad().getTextCPF().setText("");
			this.jan.getTcad().getTextData().setText("");
			this.jan.getTcad().getLblAviso().setText("");

		}
		
		//Cadastrar paciente
		if (e.getActionCommand().equals("Cadastrar")) {
			try {
				String nomeAux = this.jan.getTcad().getTextNome().getText();
				if (nomeAux.equals("") || this.jan.getTcad().getTextCPF().getText().equals("")
						|| this.jan.getTcad().getTextData().getText().equals("")) {
					this.jan.getTcad().getLblAviso().setText("Todos os campos devem ser preenchidos");
				} else {
					String cPFAux = (this.jan.getTcad().getTextCPF().getText());
					int dataAux = Integer.parseInt(this.jan.getTcad().getTextData().getText());

					Paciente pac = new Paciente(nomeAux, cPFAux, dataAux);
					listaPac.adicionar(pac);
					this.jan.setContentPane(this.jan.getTconfirma());
					this.jan.revalidate();
					this.jan.repaint();
				}
			} catch (NumberFormatException ex) {
				this.jan.getTcad().getLblAviso().setText("Campos com valores inadequados");
			}
		}
		
		//Pesquisar paciente
		if (e.getActionCommand().equals("Pesquisar")) {
			try {
				String cpf = (this.jan.getTcon().getTextCPF().getText());
				pLista = listaPac.buscar(cpf).getPaciente();
				this.jan.getTcon().getLblPaciente().setText(pLista.getNome());
				this.jan.getTcon().botaoSenha();
			} catch (Exception ex) {
				this.jan.getTcon().getLblPaciente().setText("CPF n�o encontrado");
				this.jan.getTcon().botaoSenhaDesabilitar();
			}
		}
		
		//Gerar a senha para os pacientes
		if (e.getActionCommand().equals("Gerar Senha")) {
			int senha = listaPac.gerarSenha(pLista.getCpf());
			this.jan.getTcon().getLblSenha().setText(String.valueOf(senha));
		}
		
		//Tela de consulta de pacientes
		if (e.getActionCommand().equals("menuConsulta")) {
			this.jan.setContentPane(this.jan.getTcon());
			this.jan.revalidate();
			this.jan.repaint();
			this.jan.getTcon().getTextCPF().setText("");
			this.jan.getTcon().getLblPaciente().setText("");
			this.jan.getTcon().getLblSenha().setText("");		
		}

		
	}
	
	//Retorna a lista de pacientes para a controller de atendimentos
	public ListaPaciente listaPaciente() {
		return listaPac;
	}
}
