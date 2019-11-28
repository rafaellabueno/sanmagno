package controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;

import model.Atendimento;
import model.FilaPrioridade;
import model.ListaAtendimentosEncerrados;
import model.ListaPaciente;
import model.No;
import model.NoAtendimento;
import model.NoFila;
import model.Paciente;
import visao.JanelaPrincipal;
import visao.TelaConfirmacao;

public class Controller implements ActionListener {

	private JanelaPrincipal jan;
	private Paciente pac;
	private Paciente pLista;
	private ListaPaciente listaPac;
	private Atendimento proxAtendimento;
	private FilaPrioridade filaP1;
	private FilaPrioridade filaP2;
	private FilaPrioridade filaP3;
	private FilaPrioridade filaP4;
	private FilaPrioridade filaP5;
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
		this.jan.getTatendenc().getBtnAtualizar().addActionListener(this);
		this.jan.getTatendenc().getBtnPesquisarCpf().addActionListener(this);

		listaPac = new ListaPaciente();
		listaAtenEnc = new ListaAtendimentosEncerrados();
		filaP1 = new FilaPrioridade();
		filaP2 = new FilaPrioridade();
		filaP3 = new FilaPrioridade();
		filaP4 = new FilaPrioridade();
		filaP5 = new FilaPrioridade();
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
			this.jan.getTcad().getLblAviso().setText("");
			this.jan.getTtriagem().getChckbxApneia().setSelected(false);
			this.jan.getTtriagem().getChckbxConfusoDesorientado().setSelected(false);
			this.jan.getTtriagem().getChckbxDor().setSelected(false);
			this.jan.getTtriagem().getChckbxEntubado().setSelected(false);
			this.jan.getTtriagem().getChckbxFluxoResp().setSelected(false);
			this.jan.getTtriagem().getChckbxfreqC().setSelected(false);
			this.jan.getTtriagem().getChckbxFreqR().setSelected(false);
			this.jan.getTtriagem().getChckbxLetargico().setSelected(false);
			this.jan.getTtriagem().getChckbxOutrosP().setSelected(false);
			this.jan.getTtriagem().getChckbxOximetria().setSelected(false);
			this.jan.getTtriagem().getChckbxProcedimentos().setSelected(false);
			this.jan.getTtriagem().getChckbxSemPulso().setSelected(false);
			this.jan.getTtriagem().getChckbxSemReacao().setSelected(false);
			this.jan.getTtriagem().getChckbxSituacaoDeRisco().setSelected(false);
			this.jan.getTtriagem().getChckbxTempC().setSelected(false);
			this.jan.getTtriagem().getChckbxTempC2().setSelected(false);
			this.jan.getTatendenc().getTextCpf().setText("");
			this.jan.getTatendenc().getTextDataS().setText("");
			this.jan.getTatendenc().getTextHorasS().setText("");
			

		}
		if (arg0.getActionCommand().equals("Cadastrar")) {
			try {
				String nomeAux = this.jan.getTcad().getTextNome().getText();
				if(nomeAux.equals("") || this.jan.getTcad().getTextCPF().getText().equals("") || 
						this.jan.getTcad().getTextData().getText().equals(""))
				{
					this.jan.getTcad().getLblAviso().setText("Todos os campos devem ser preenchidos");
				}
				else {
					int cPFAux = Integer.parseInt(this.jan.getTcad().getTextCPF().getText());
					int dataAux = Integer.parseInt(this.jan.getTcad().getTextData().getText());
					
					Paciente pac = new Paciente(nomeAux, cPFAux, dataAux);
					listaPac.adicionar(pac);
					this.jan.setContentPane(this.jan.getTconfirma());
					this.jan.revalidate();
					this.jan.repaint();
				}
			}catch(NumberFormatException  e) {
				this.jan.getTcad().getLblAviso().setText("Campos com valores inadequados");
			}
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
			try {
				this.jan.setContentPane(this.jan.getTsenha());
				this.jan.revalidate();
				this.jan.repaint();
				proxAtendimento = listaPac.getFilaA().desempilhar().getAtendimento();
				this.jan.getTsenha().getLblSenhaPainel().setText(String.valueOf(proxAtendimento.getSenha()));
				this.jan.getTsenha().getLblNomePainel().setText(String.valueOf(proxAtendimento.getPac().getNome()));
				this.jan.getTsenha().getLblCpfPainel().setText(String.valueOf(proxAtendimento.getPac().getCpf()));
			}catch(Exception e) {
				this.jan.getTsenha().getLblAviso().setText("Não há pacientes para atendimento");
			}
		}

		if (arg0.getActionCommand().equals("Triagem")) {
			this.jan.setContentPane(this.jan.getTtriagem());
			this.jan.revalidate();
			this.jan.revalidate();
			this.jan.getTtriagem().getLblNomePaciente().setText(proxAtendimento.getPac().getNome());

		}

		if (arg0.getActionCommand().equals("Calcular Prioridade")) {
			int fila = 0;

			if (this.jan.getTtriagem().getChckbxOutrosP().isSelected()) {
				fila = 4;
			}

			if (this.jan.getTtriagem().getChckbxProcedimentos().isSelected()) {
				if (this.jan.getTtriagem().getChckbxfreqC().isSelected()
						|| this.jan.getTtriagem().getChckbxFreqR().isSelected()
						|| this.jan.getTtriagem().getChckbxTempC().isSelected()
						|| this.jan.getTtriagem().getChckbxTempC2().isSelected()
						|| this.jan.getTtriagem().getChckbxFluxoResp().isSelected()) {
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
				filaP1.empilhar(proxAtendimento);
				break;

			case 2:
				filaP2.empilhar(proxAtendimento);
				break;

			case 3:
				filaP3.empilhar(proxAtendimento);
				break;

			case 4:
				filaP4.empilhar(proxAtendimento);
				break;

			case 5:
				filaP5.empilhar(proxAtendimento);
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
				for (NoFila aux = filaP1.topo(); aux != null; aux = aux.getProximo()) {
					txt = txt + aux.getAtendimento().getPac().getNome() + " ";
				}
				this.jan.getTfpri().getLblPacientePrioridade().setText(String.valueOf(txt));
				break;
			case "Prioridade 2":
				for (NoFila aux = filaP2.topo(); aux != null; aux = aux.getProximo()) {
					txt = txt + aux.getAtendimento().getPac().getNome() + " ";
				}
				this.jan.getTfpri().getLblPacientePrioridade().setText(String.valueOf(txt));
				break;
			case "Prioridade 3":
				for (NoFila aux = filaP3.topo(); aux != null; aux = aux.getProximo()) {
					txt = txt + aux.getAtendimento().getPac().getNome() + " ";
				}
				this.jan.getTfpri().getLblPacientePrioridade().setText(String.valueOf(txt));
				break;
			case "Prioridade 4":
				for (NoFila aux = filaP4.topo(); aux != null; aux = aux.getProximo()) {
					txt = txt + aux.getAtendimento().getPac().getNome() + " ";
				}
				this.jan.getTfpri().getLblPacientePrioridade().setText(String.valueOf(txt));
				break;
			case "Prioridade 5":
				for (NoFila aux = filaP5.topo(); aux != null; aux = aux.getProximo()) {
					txt = txt + aux.getAtendimento().getPac().getNome() + " ";
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
				this.jan.getTproxpac().getLblNomeProx().setText(filaP1.topo().getAtendimento().getPac().getNome());
				this.jan.getTproxpac().getLblPrioridadeProx().setText(String.valueOf(1));
				NoFila ateEnc = filaP1.desempilhar();
				listaAtenEnc.adicionar(ateEnc.getAtendimento());
			} else {
				if (filaP2.estaVazia() == false) {
					this.jan.getTproxpac().getLblNomeProx().setText(filaP2.topo().getAtendimento().getPac().getNome());
					this.jan.getTproxpac().getLblPrioridadeProx().setText(String.valueOf(2));
					NoFila ateEnc = filaP2.desempilhar();
					listaAtenEnc.adicionar(ateEnc.getAtendimento());
				} else {
					if (filaP3.estaVazia() == false) {
						this.jan.getTproxpac().getLblNomeProx().setText(filaP3.topo().getAtendimento().getPac().getNome());
						this.jan.getTproxpac().getLblPrioridadeProx().setText(String.valueOf(3));
						NoFila ateEnc = filaP3.desempilhar();
						listaAtenEnc.adicionar(ateEnc.getAtendimento());
					} else {
						if (filaP4.estaVazia() == false) {
							this.jan.getTproxpac().getLblNomeProx().setText(filaP4.topo().getAtendimento().getPac().getNome());
							this.jan.getTproxpac().getLblPrioridadeProx().setText(String.valueOf(4));
							NoFila ateEnc = filaP4.desempilhar();
							listaAtenEnc.adicionar(ateEnc.getAtendimento());
						} else {
							if (filaP5.estaVazia() == false) {
								this.jan.getTproxpac().getLblNomeProx().setText(filaP5.topo().getAtendimento().getPac().getNome());
								this.jan.getTproxpac().getLblPrioridadeProx().setText(String.valueOf(5));
								NoFila ateEnc = filaP5.desempilhar();
								listaAtenEnc.adicionar(ateEnc.getAtendimento());
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
		
		if (arg0.getActionCommand().equals("Pesquisar CPF")) {
			try {
				int cpf = Integer.parseInt(this.jan.getTatendenc().getTextCpf().getText());
				pLista = listaAtenEnc.buscar(cpf).getAtendimento().getPac();
				this.jan.getTatendenc().getLblNome().setText(pLista.getNome());
				this.jan.getTatendenc().tornarBotaoVisivel();
			} catch (Exception e) {
				this.jan.getTatendenc().getLblNome().setText("CPF não encontrado");
				this.jan.getTatendenc().tornarBotaoInvisivel();
			}
		}
		
		if (arg0.getActionCommand().equals("Atualizar")) {
			try {
				int cpf = Integer.parseInt(this.jan.getTatendenc().getTextCpf().getText());
				Atendimento atAtual = listaAtenEnc.buscar(cpf).getAtendimento();
				atAtual.setDataS(Integer.parseInt(this.jan.getTatendenc().getTextDataS().getText()));
				atAtual.setHoraS(Integer.parseInt(this.jan.getTatendenc().getTextHorasS().getText()));
			}catch(Exception e) {
				this.jan.getTatendenc().getLblAviso().setText("Campos com valores inadequados");
			}
		}

	}

}
