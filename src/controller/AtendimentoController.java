package controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.util.Vector;

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

public class AtendimentoController implements ActionListener {

	private JanelaPrincipal jan;
	private Paciente pac;
	private Paciente pLista;
	private PacienteController pCon;
	
	private Atendimento proxAtendimento;
	private FilaPrioridade filaP1;
	private FilaPrioridade filaP2;
	private FilaPrioridade filaP3;
	private FilaPrioridade filaP4;
	private FilaPrioridade filaP5;
	private ListaAtendimentosEncerrados listaAtenEnc;

	public AtendimentoController(JanelaPrincipal jan, Paciente pac) {
		super();
		this.jan = jan;
		this.pac = pac;
		//Botão para limpar tela de cadastro
		this.jan.getTcad().getBtnLimpar().addActionListener(this);
		
		//Volta para o menu na confirmação de cadastro
		this.jan.getTconfirma().getBtnMenu().addActionListener(this);
		
		//Botões de voltar para a tela principal e de limpar dados na tela de consulta
		this.jan.getTcon().getBtnVoltar().addActionListener(this);
		this.jan.getTcon().getBtnLimpar().addActionListener(this);
		
		//Menu item para mudança de telas
		this.jan.getMntmPainelDeSenhas().addActionListener(this);
		this.jan.getMntmProxAtend().addActionListener(this);
		this.jan.getMntmFilaPrioridade().addActionListener(this);
		this.jan.getMntmListEnce().addActionListener(this);
		
		//Vai para a tela de triagem a partir do painel de senhas
		this.jan.getTsenha().getBtnTriagem().addActionListener(this);
		
		//Pesquisa os pacientes na fila de prioridade selecionada
		this.jan.getTfpri().getBtnPesquisarPrioridade().addActionListener(this);
		
		//Ações relacionados a tela de triagem
		this.jan.getTtriagem().getBtnPrioridade().addActionListener(this);
		this.jan.getTtriagem().getChckbxProcedimentos().addActionListener(this);
		this.jan.getTtriagem().getBtnVoltar().addActionListener(this);
		this.jan.getTtriagem().getBtnLimpar().addActionListener(this);
		
		//Botão para ir para a tela de atendimentos encerrados
		this.jan.getTproxpac().getBtnEncerrarAtendimento().addActionListener(this);
		
		//Ações relacionados a tela de atendimentos encerrados
		this.jan.getTatendenc().getBtnLimpar().addActionListener(this);
		this.jan.getTatendenc().getBtnVoltar().addActionListener(this);
		this.jan.getTatendenc().getBtnAtualizar().addActionListener(this);
		this.jan.getTatendenc().getBtnPesquisarCpf().addActionListener(this);

		//instanciando as filas de prioridades
		filaP1 = new FilaPrioridade();
		filaP2 = new FilaPrioridade();
		filaP3 = new FilaPrioridade();
		filaP4 = new FilaPrioridade();
		filaP5 = new FilaPrioridade();
		
		
		pCon = new PacienteController(jan, pac);
		listaAtenEnc = new ListaAtendimentosEncerrados();
	}

	@Override
	public void actionPerformed(ActionEvent arg0) {
		//Limpa os campos da tela
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
			this.jan.getTtriagem().getLblPrioridade().setText("");
			this.jan.getTtriagem().getLblNomePaciente().setText("");
			this.jan.getTatendenc().getTextCpf().setText("");
			this.jan.getTatendenc().getTextDataS().setText("");
			this.jan.getTatendenc().getTextHorasS().setText("");
			this.jan.getTcon().getLblSenha().setText("");
			this.jan.getTcon().getLblPaciente().setText("");

		}

		//Botão para voltar para a janela principal
		if (arg0.getActionCommand().equals("Voltar")) {
			this.jan.setContentPane(this.jan.getjPrinc());
			this.jan.revalidate();
			this.jan.repaint();
		}

		//Próxima senha a ser chamada para atendimento
		if (arg0.getActionCommand().equals("menuSenha")) {
			try {
				this.jan.setContentPane(this.jan.getTsenha());
				this.jan.revalidate();
				this.jan.repaint();
				this.jan.getTsenha().getLblAviso().setText("");
				this.jan.getTsenha().getLblNomePainel().setText("");
				this.jan.getTsenha().getLblCpfPainel().setText("");
				this.jan.getTsenha().getLblSenhaPainel().setText("");
				proxAtendimento = pCon.listaPaciente().getFilaA().desempilhar().getAtendimento();
				this.jan.getTsenha().getLblSenhaPainel().setText(String.valueOf(proxAtendimento.getSenha()));
				this.jan.getTsenha().getLblNomePainel().setText(String.valueOf(proxAtendimento.getPac().getNome()));
				this.jan.getTsenha().getLblCpfPainel().setText(proxAtendimento.getPac().getCpf());
				if(this.jan.getTsenha().getLblSenhaPainel().equals("")) {
					this.jan.getTsenha().botaoTriagemDesabilitar();
				}
				else {
					this.jan.getTsenha().botaoTriagem();
				}
			} catch (Exception e) {
				this.jan.getTsenha().botaoTriagemDesabilitar();
				this.jan.getTsenha().getLblAviso().setText("Não há pacientes para atendimento");
			}
		}

		//Tela de triagem
		if (arg0.getActionCommand().equals("Triagem")) {
			this.jan.setContentPane(this.jan.getTtriagem());
			this.jan.revalidate();
			this.jan.revalidate();
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
			this.jan.getTtriagem().getLblPrioridade().setText("");
			this.jan.getTtriagem().getLblNomePaciente().setText(proxAtendimento.getPac().getNome());

		}

		//Calcula a prioridade do atendimento a partir dos campos marcados na tela
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

		
		//Ativa ou desativa ckeckboxes relacionadas com o campo de múltiplos procedimentos
		if (arg0.getActionCommand().equals("Procedimentos")) {
			if (this.jan.getTtriagem().getChckbxProcedimentos().isSelected()) {
				this.jan.getTtriagem().checkAtivado();
			} else {
				this.jan.getTtriagem().checkDesativado();
			}
		}
		
		

		//Tela de prioridades
	
		if (arg0.getActionCommand().equals("menuPrioridade")) {
			this.jan.setContentPane(this.jan.getTfpri());
			this.jan.revalidate();
			//this.jan.revalidate();
			this.jan.repaint();
			Vector vector = new Vector(); 
			vector.add(null); 
			this.jan.getTfpri().adicionaItem(vector);
		
			
		}

		//Pesquisa os pacientes em seu atendimento que estão na prioridade selecionada
		if (arg0.getActionCommand().equals("Pesquisar Prioridade")) {
			String prioridade = (String) (this.jan.getTfpri().getComboPrioridade().getSelectedItem());
			Vector vector = new Vector();
			switch (prioridade) {
		
			case "Prioridade 1":
				for (NoFila aux = filaP1.topo(); aux != null; aux = aux.getProximo()) {
					vector.add(aux.getAtendimento().getPac().getNome());
				}
				this.jan.getTfpri().adicionaItem(vector);
				break;
			case "Prioridade 2":
				for (NoFila aux = filaP2.topo(); aux != null; aux = aux.getProximo()) {
					vector.add(aux.getAtendimento().getPac().getNome());
				}
				this.jan.getTfpri().adicionaItem(vector);
				break;
			case "Prioridade 3":
				for (NoFila aux = filaP3.topo(); aux != null; aux = aux.getProximo()) {
					vector.add(aux.getAtendimento().getPac().getNome());
				}
				this.jan.getTfpri().adicionaItem(vector);
				break;
			case "Prioridade 4":
				for (NoFila aux = filaP4.topo(); aux != null; aux = aux.getProximo()) {
					vector.add(aux.getAtendimento().getPac().getNome());
				}
				this.jan.getTfpri().adicionaItem(vector);
				break;
			case "Prioridade 5":
				for (NoFila aux = filaP5.topo(); aux != null; aux = aux.getProximo()) {
					vector.add(aux.getAtendimento().getPac().getNome());
				}
				this.jan.getTfpri().adicionaItem(vector);
				break;
			}
		}

		//Tela para próximo atendimento a ser chamado de acordo com as prioridades
		if (arg0.getActionCommand().equals("menuProx")) {
			this.jan.setContentPane(this.jan.getTproxpac());
			this.jan.revalidate();
			this.jan.repaint();
			this.jan.getTproxpac().getLblNomeProx().setText("");
			this.jan.getTproxpac().getLblPrioridadeProx().setText("");
			this.jan.getTproxpac().getLblAviso().setText("");
			if (filaP1.estaVazia() == false) {
				this.jan.getTproxpac().getLblNomeProx().setText(filaP1.topo().getAtendimento().getPac().getNome());
				this.jan.getTproxpac().getLblPrioridadeProx().setText(String.valueOf(1));
				NoFila ateEnc = filaP1.desempilhar();
				listaAtenEnc.adicionar(ateEnc.getAtendimento());
				this.jan.getTproxpac().botaoEAten();
			} else {
				if (filaP2.estaVazia() == false) {
					this.jan.getTproxpac().getLblNomeProx().setText(filaP2.topo().getAtendimento().getPac().getNome());
					this.jan.getTproxpac().getLblPrioridadeProx().setText(String.valueOf(2));
					NoFila ateEnc = filaP2.desempilhar();
					listaAtenEnc.adicionar(ateEnc.getAtendimento());
					this.jan.getTproxpac().botaoEAten();
				} else {
					if (filaP3.estaVazia() == false) {
						this.jan.getTproxpac().getLblNomeProx()
								.setText(filaP3.topo().getAtendimento().getPac().getNome());
						this.jan.getTproxpac().getLblPrioridadeProx().setText(String.valueOf(3));
						NoFila ateEnc = filaP3.desempilhar();
						listaAtenEnc.adicionar(ateEnc.getAtendimento());
						this.jan.getTproxpac().botaoEAten();
					} else {
						if (filaP4.estaVazia() == false) {
							this.jan.getTproxpac().getLblNomeProx()
									.setText(filaP4.topo().getAtendimento().getPac().getNome());
							this.jan.getTproxpac().getLblPrioridadeProx().setText(String.valueOf(4));
							NoFila ateEnc = filaP4.desempilhar();
							listaAtenEnc.adicionar(ateEnc.getAtendimento());
							this.jan.getTproxpac().botaoEAten();
						} else {
							if (filaP5.estaVazia() == false) {
								this.jan.getTproxpac().getLblNomeProx()
										.setText(filaP5.topo().getAtendimento().getPac().getNome());
								this.jan.getTproxpac().getLblPrioridadeProx().setText(String.valueOf(5));
								NoFila ateEnc = filaP5.desempilhar();
								listaAtenEnc.adicionar(ateEnc.getAtendimento());
								this.jan.getTproxpac().botaoEAten();
							}
							else {
								this.jan.getTproxpac().getLblAviso().setText("Não há pacientes para chamada");
								this.jan.getTproxpac().botaoEAtenDesabilitar();
							}
						}
					}
				}
			}
		}

		//Tela de atendimentos encerrados
		if (arg0.getActionCommand().equals("Encerrar Atendimento")) {
			this.jan.setContentPane(this.jan.getTatendenc());
			this.jan.revalidate();
			this.jan.repaint();
			this.jan.getTatendenc().getTextCpf().setText("");
			this.jan.getTatendenc().getTextDataS().setText("");
			this.jan.getTatendenc().getTextHorasS().setText("");
		}
		
		//Tela da lista de atendimentos encerrados
		if (arg0.getActionCommand().equals("menuListEnce")) {
			Vector vector1 = new Vector();
			Vector vector2 = new Vector();
			this.jan.setContentPane(this.jan.getTListEnce());
			this.jan.revalidate();
			this.jan.repaint();
			for (NoAtendimento aux = listaAtenEnc.primeiro(); aux != null; aux = aux.getProximo()) {
				vector1.add(aux.getAtendimento().getPac().getNome());
				vector2.add(String.valueOf(aux.getAtendimento().getDataS()));
			}
			this.jan.getTListEnce().adicionaItemNome(vector1);
			this.jan.getTListEnce().adicionaItemData(vector2);
		}

		//Pesquisa CPF do paciente para atualizar atendimento
		if (arg0.getActionCommand().equals("Pesquisar CPF")) {
			try {
				String cpf = (this.jan.getTatendenc().getTextCpf().getText());
				pLista = listaAtenEnc.buscar(cpf).getAtendimento().getPac();
				this.jan.getTatendenc().getLblNome().setText(pLista.getNome());
				this.jan.getTatendenc().tornarBotaoVisivel();
			} catch (Exception e) {
				this.jan.getTatendenc().getLblNome().setText("CPF não encontrado");
				this.jan.getTatendenc().tornarBotaoInvisivel();
			}
		}

		//Atualiza os dados do atendimento
		if (arg0.getActionCommand().equals("Atualizar")) {
			try {
				String cpf = (this.jan.getTatendenc().getTextCpf().getText());
				Atendimento atAtual = listaAtenEnc.buscar(cpf).getAtendimento();
				atAtual.setDataS(this.jan.getTatendenc().getTextDataS().getText());
				atAtual.setHoraS(this.jan.getTatendenc().getTextHorasS().getText());
				
				//18:21:12
				String hora = this.jan.getTatendenc().getTextHorasS().getText();
				
			} catch (Exception e) {
				this.jan.getTatendenc().getLblAviso().setText("Campos com valores inadequados");
			}
		}

	}

}
