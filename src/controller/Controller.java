package controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;

import model.Atendimento;
import model.FilaPaciente;
import model.ListaAtendimentosEncerrados;
import model.ListaPaciente;
import model.No;
import model.Paciente;
import visao.JanelaPrincipal;
import visao.TelaConfirmacao;

public class Controller implements ActionListener {

	private JanelaPrincipal jan;
	private Paciente pac;
	private Paciente pLista;
	private ListaPaciente listaPac;
	private Atendimento proxAtendimento;
	private FilaPaciente filaP1;
	private FilaPaciente filaP2;
	private FilaPaciente filaP3;
	private FilaPaciente filaP4;
	private FilaPaciente filaP5;
	private ListaAtendimentosEncerrados listaAtenEnc;

	public Controller(JanelaPrincipal jan, Paciente pac) {
		super();
		this.jan = jan;
		this.pac = pac;
		this.jan.getMenuCadastro().addActionListener(this);
		this.jan.getTcad().getBtnLimpar().addActionListener(this);
		this.jan.getTcad().getBtnCadastrar().addActionListener(this);
		this.jan.getTconfirma().getBtnMenu().addActionListener(this);
		this.jan.getMenuConsulta().addActionListener(this);
		this.jan.getTcon().getBtnPesquisar().addActionListener(this);
		this.jan.getTcon().getBtnGerarSenha().addActionListener(this);
		this.jan.getTcon().getBtnVoltar().addActionListener(this);
		this.jan.getTcon().getBtnLimpar().addActionListener(this);
		this.jan.getMntmPainelDeSenhas().addActionListener(this);
		this.jan.getMntmProxAtend().addActionListener(this);
		this.jan.getMntmAtendEnce().addActionListener(this);
		this.jan.getMntmAtendEnce().addActionListener(this);
		this.jan.getTsenha().getBtnTriagem().addActionListener(this);
		this.jan.getTtriagem().getBtnPrioridade().addActionListener(this);
		this.jan.getTtriagem().getChckbxProcedimentos().addActionListener(this);
		this.jan.getTtriagem().getBtnVoltar().addActionListener(this);
		this.jan.getMntmFilaPrioridade().addActionListener(this);
		this.jan.getTfpri().getBtnPesquisarPrioridade().addActionListener(this);
		this.jan.getTtriagem().getBtnLimpar().addActionListener(this);
		this.jan.getTproxpac().getBtnVoltar().addActionListener(this);
		this.jan.getTatendenc().getBtnLimpar().addActionListener(this);
		this.jan.getTatendenc().getBtnVoltar().addActionListener(this);

		listaPac = new ListaPaciente();
		listaAtenEnc = new ListaAtendimentosEncerrados();
		filaP1 = new FilaPaciente();
		filaP2 = new FilaPaciente();
		filaP3 = new FilaPaciente();
		filaP4 = new FilaPaciente();
		filaP5 = new FilaPaciente();
	}

	@Override
	public void actionPerformed(ActionEvent arg0) {
		if (arg0.getActionCommand().equals("menuCad")) {
			this.jan.setContentPane(this.jan.getTcad());
			this.jan.revalidate();
			this.jan.repaint();
		}

		if (arg0.getActionCommand().equals("Limpar")) {
			this.jan.getTcon().getTextCPF().setText("");
			this.jan.getTcad().getTextNome().setText("");
			this.jan.getTcad().getTextCPF().setText("");
			this.jan.getTcad().getTextData().setText("");
			this.jan.getTtriagem().getChckbxApneia().setSelected(false);
			this.jan.getTtriagem().getChckbxConfusoDesorientado().setSelected(false);
			this.jan.getTtriagem().getChckbxDor().setSelected(false);
			this.jan.getTtriagem().getChckbxEntubado().setSelected(false);
			this.jan.getTtriagem().getChckbxfluxoResp().setSelected(false);
			this.jan.getTtriagem().getChckbxfreqC().setSelected(false);
			this.jan.getTtriagem().getChckbxFreqR().setSelected(false);
			this.jan.getTtriagem().getChckbxLetargico().setSelected(false);
			this.jan.getTtriagem().getChckbxoutrosP().setSelected(false);
			this.jan.getTtriagem().getChckbxoximetria().setSelected(false);
			this.jan.getTtriagem().getChckbxProcedimentos().setSelected(false);
			this.jan.getTtriagem().getChckbxSemPulso().setSelected(false);
			this.jan.getTtriagem().getChckbxSemReacao().setSelected(false);
			this.jan.getTtriagem().getChckbxSituacaoDeRisco().setSelected(false);
			this.jan.getTtriagem().getChckbxtempC().setSelected(false);
			this.jan.getTtriagem().getChckbxtempC2().setSelected(false);
			this.jan.getTatendenc().getTextCpf().setText("");
			this.jan.getTatendenc().getTextDataS().setText("");
			this.jan.getTatendenc().getTextHorasS().setText("");
			

		}
		if (arg0.getActionCommand().equals("Cadastrar")) {
			String nomeAux = this.jan.getTcad().getTextNome().getText();
			int CPFAux = Integer.parseInt(this.jan.getTcad().getTextCPF().getText());
			int dataAux = Integer.parseInt(this.jan.getTcad().getTextData().getText());
			Paciente pac = new Paciente(nomeAux, CPFAux, dataAux);
			listaPac.adicionar(pac);
			this.jan.setContentPane(this.jan.getTconfirma());
			this.jan.revalidate();
			this.jan.repaint();
		}

		if (arg0.getActionCommand().equals("Voltar")) {
			this.jan.setContentPane(this.jan.getjPrinc());
			this.jan.revalidate();
			this.jan.repaint();
		}

		if (arg0.getActionCommand().equals("Pesquisar")) {
			try {
				int cpf = Integer.parseInt(this.jan.getTcon().getTextCPF().getText());
				pLista = listaPac.buscar(cpf).getPaciente();
				this.jan.getTcon().getLblPaciente().setText(pLista.getNome());
				this.jan.getTcon().botaoSenha();
			} catch (Exception e) {
				this.jan.getTcon().getLblPaciente().setText("CPF não encontrado");
				this.jan.getTcon().botaoSenhaDesabilitar();
			}
		}

		if (arg0.getActionCommand().equals("menuConsulta")) {
			this.jan.setContentPane(this.jan.getTcon());
			this.jan.revalidate();
			this.jan.repaint();
		}

		if (arg0.getActionCommand().equals("Gerar Senha")) {
			int senha = listaPac.gerarSenha(pLista.getCpf());
			this.jan.getTcon().getLblSenha().setText(String.valueOf(senha));
		}

		if (arg0.getActionCommand().equals("menuSenha")) {
			this.jan.setContentPane(this.jan.getTsenha());
			this.jan.revalidate();
			this.jan.repaint();
			proxAtendimento = listaPac.getFilaA().desempilhar().getAtendimento();
			this.jan.getTsenha().getLblSenhaPainel().setText(String.valueOf(proxAtendimento.getSenha()));
			this.jan.getTsenha().getLblNomePainel().setText(String.valueOf(proxAtendimento.getPac().getNome()));
			this.jan.getTsenha().getLblCpfPainel().setText(String.valueOf(proxAtendimento.getPac().getCpf()));
		}

		if (arg0.getActionCommand().equals("Triagem")) {
			this.jan.setContentPane(this.jan.getTtriagem());
			this.jan.revalidate();
			this.jan.revalidate();
			this.jan.getTtriagem().getLblNomePaciente().setText(proxAtendimento.getPac().getNome());

		}

		if (arg0.getActionCommand().equals("Calcular Prioridade")) {
			int fila = 0;

			if (this.jan.getTtriagem().getChckbxoutrosP().isSelected()) {
				fila = 4;
			}

			if (this.jan.getTtriagem().getChckbxProcedimentos().isSelected()) {
				if (this.jan.getTtriagem().getChckbxfreqC().isSelected()
						|| this.jan.getTtriagem().getChckbxFreqR().isSelected()
						|| this.jan.getTtriagem().getChckbxtempC().isSelected()
						|| this.jan.getTtriagem().getChckbxtempC2().isSelected()
						|| this.jan.getTtriagem().getChckbxfluxoResp().isSelected()) {
					fila = 2;
				} else {
					fila = 3;
				}
			}

			if (this.jan.getTtriagem().getChckbxSituacaoDeRisco().isSelected()
					|| this.jan.getTtriagem().getChckbxConfusoDesorientado().isSelected()
					|| this.jan.getTtriagem().getChckbxLetargico().isSelected()
					|| this.jan.getTtriagem().getChckbxDor().isSelected()) {
				fila = 2;
			}

			if (this.jan.getTtriagem().getChckbxEntubado().isSelected()
					|| this.jan.getTtriagem().getChckbxApneia().isSelected()
					|| this.jan.getTtriagem().getChckbxSemPulso().isSelected()
					|| this.jan.getTtriagem().getChckbxSemReacao().isSelected()) {
				fila = 1;
			}

			if (fila == 0) {
				fila = 5;
			}

			switch (fila) {
			case 1:
				filaP1.empilhar(proxAtendimento.getPac());
				break;

			case 2:
				filaP2.empilhar(proxAtendimento.getPac());
				break;

			case 3:
				filaP3.empilhar(proxAtendimento.getPac());
				break;

			case 4:
				filaP4.empilhar(proxAtendimento.getPac());
				break;

			case 5:
				filaP5.empilhar(proxAtendimento.getPac());
				break;
			}

			this.jan.getTtriagem().getLblPrioridade().setText(String.valueOf(fila));
		}

		if (arg0.getActionCommand().equals("Procedimentos")) {
			if (this.jan.getTtriagem().getChckbxProcedimentos().isSelected()) {
				this.jan.getTtriagem().checkAtivado();
			} else {
				this.jan.getTtriagem().checkDesativado();
			}
		}

		if (arg0.getActionCommand().equals("menuPrioridade")) {
			this.jan.setContentPane(this.jan.getTfpri());
			this.jan.revalidate();
			this.jan.revalidate();
		}

		if (arg0.getActionCommand().equals("Pesquisar Prioridade")) {
			String prioridade = (String) (this.jan.getTfpri().getComboPrioridade().getSelectedItem());
			String txt = "";
			switch (prioridade) {
			case "Prioridade 1":
				for (No aux = filaP1.topo(); aux != null; aux = aux.getProximo()) {
					txt = txt + aux.getPaciente().getNome() + " ";
				}
				this.jan.getTfpri().getLblPacientePrioridade().setText(String.valueOf(txt));
				break;
			case "Prioridade 2":
				for (No aux = filaP2.topo(); aux != null; aux = aux.getProximo()) {
					txt = txt + aux.getPaciente().getNome() + " ";
				}
				this.jan.getTfpri().getLblPacientePrioridade().setText(String.valueOf(txt));
				break;
			case "Prioridade 3":
				for (No aux = filaP3.topo(); aux != null; aux = aux.getProximo()) {
					txt = txt + aux.getPaciente().getNome() + " ";
				}
				this.jan.getTfpri().getLblPacientePrioridade().setText(String.valueOf(txt));
				break;
			case "Prioridade 4":
				for (No aux = filaP4.topo(); aux != null; aux = aux.getProximo()) {
					txt = txt + aux.getPaciente().getNome() + " ";
				}
				this.jan.getTfpri().getLblPacientePrioridade().setText(String.valueOf(txt));
				break;
			case "Prioridade 5":
				for (No aux = filaP5.topo(); aux != null; aux = aux.getProximo()) {
					txt = txt + aux.getPaciente().getNome() + " ";
				}
				this.jan.getTfpri().getLblPacientePrioridade().setText(String.valueOf(txt));
				break;
			}
		}

		if (arg0.getActionCommand().equals("menuProx")) {
			this.jan.setContentPane(this.jan.getTproxpac());
			this.jan.revalidate();
			this.jan.repaint();
			if (filaP1.estaVazia() == false) {
				this.jan.getTproxpac().getLblNomeProx().setText(filaP1.topo().getPaciente().getNome());
				this.jan.getTproxpac().getLblPrioridadeProx().setText(String.valueOf(1));
				No pacEnc = filaP1.desempilhar();
				listaAtenEnc.adicionar(pacEnc.getPaciente());
				listaAtenEnc.imprimir();
			} else {
				if (filaP2.estaVazia() == false) {
					this.jan.getTproxpac().getLblNomeProx().setText(filaP2.topo().getPaciente().getNome());
					this.jan.getTproxpac().getLblPrioridadeProx().setText(String.valueOf(2));
					No pacEnc = filaP2.desempilhar();
					listaAtenEnc.adicionar(pacEnc.getPaciente());
					listaAtenEnc.imprimir();
				} else {
					if (filaP3.estaVazia() == false) {
						this.jan.getTproxpac().getLblNomeProx().setText(filaP3.topo().getPaciente().getNome());
						this.jan.getTproxpac().getLblPrioridadeProx().setText(String.valueOf(3));
						No pacEnc = filaP3.desempilhar();
						listaAtenEnc.adicionar(pacEnc.getPaciente());
						listaAtenEnc.imprimir();
					} else {
						if (filaP4.estaVazia() == false) {
							this.jan.getTproxpac().getLblNomeProx().setText(filaP4.topo().getPaciente().getNome());
							this.jan.getTproxpac().getLblPrioridadeProx().setText(String.valueOf(4));
							No pacEnc = filaP4.desempilhar();
							listaAtenEnc.adicionar(pacEnc.getPaciente());
							listaAtenEnc.imprimir();
						} else {
							if (filaP5.estaVazia() == false) {
								this.jan.getTproxpac().getLblNomeProx().setText(filaP5.topo().getPaciente().getNome());
								this.jan.getTproxpac().getLblPrioridadeProx().setText(String.valueOf(5));
								No pacEnc = filaP5.desempilhar();
								listaAtenEnc.adicionar(pacEnc.getPaciente());
								listaAtenEnc.imprimir();
							}
						}
					}
				}
			}
		}

		if (arg0.getActionCommand().equals("menuEnce")) {
			this.jan.setContentPane(this.jan.getTatendenc());
			this.jan.revalidate();
			this.jan.repaint();
		}

	}

}
