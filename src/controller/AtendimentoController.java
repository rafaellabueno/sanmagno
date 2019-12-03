package controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.TimeZone;
import java.util.Vector;

import dao.AtendimentoDAO;
import dao.TempoAtendGeralDAO;
import dao.TempoAtendPriDAO;
import dao.TempoEsperaDAO;
import model.Atendimento;
import model.FilaAtendimento;
import model.FilaPrioridade;
import model.ListaAtendimentos;
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

	private AtendimentoDAO atendDao;
	private TempoEsperaDAO teDAO;
	TempoAtendPriDAO tapDAO;
	TempoAtendGeralDAO tagDAO;

	private Atendimento proxAtendimento;
	private FilaPrioridade filaP1;
	private FilaPrioridade filaP2;
	private FilaPrioridade filaP3;
	private FilaPrioridade filaP4;
	private FilaPrioridade filaP5;

	private ListaAtendimentos listaAtenEnc;
	private ListaAtendimentos listaAtenConsulta;

	public AtendimentoController(JanelaPrincipal jan, Paciente pac) {
		super();
		this.jan = jan;
		this.pac = pac;
		// Botão para limpar tela de cadastro
		this.jan.getTcad().getBtnLimpar().addActionListener(this);

		// Pesquisar paciente para atendimento
		this.jan.getTcon().getBtnPesquisar().addActionListener(this);

		// Volta para o menu na confirmação de cadastro
		this.jan.getTconfirma().getBtnMenu().addActionListener(this);

		// Botões de voltar para a tela principal e de limpar dados na tela de consulta
		this.jan.getTcon().getBtnVoltar().addActionListener(this);
		this.jan.getTcon().getBtnLimpar().addActionListener(this);
		this.jan.gettConfirmaAtendEnc().getBtnMenu().addActionListener(this);
		
		// Menu item para mudança de telas
		this.jan.getMntmPainelDeSenhas().addActionListener(this);
		this.jan.getMntmProxAtend().addActionListener(this);
		this.jan.getMntmFilaPrioridade().addActionListener(this);
		this.jan.getMntmListEnce().addActionListener(this);
		this.jan.getMntmEnceAtend().addActionListener(this);

		// Vai para a tela de triagem a partir do painel de senhas
		this.jan.getTsenha().getBtnTriagem().addActionListener(this);

		// Pesquisa os pacientes na fila de prioridade selecionada
		this.jan.getTfpri().getBtnPesquisarPrioridade().addActionListener(this);

		// Ações relacionados a tela de triagem
		this.jan.getTtriagem().getBtnPrioridade().addActionListener(this);
		this.jan.getTtriagem().getChckbxProcedimentos().addActionListener(this);
		this.jan.getTtriagem().getBtnVoltar().addActionListener(this);
		this.jan.getTtriagem().getBtnProxPac().addActionListener(this);

		// Ações relacionados a tela de atendimentos encerrados
		this.jan.getTatendenc().getBtnLimpar().addActionListener(this);
		this.jan.getTatendenc().getBtnVoltar().addActionListener(this);
		this.jan.getTatendenc().getBtnAtualizar().addActionListener(this);
		this.jan.getTatendenc().getBtnPesquisarCpf().addActionListener(this);

		// Ações relacionadas aos JMenuItem de gerar relatório
		this.jan.getMntmGerarRelatorioAtend().addActionListener(this);
		this.jan.getMntmGerarRelatorioTME().addActionListener(this);
		this.jan.getMntmGerarRelatorioTMAG().addActionListener(this);
		this.jan.getMntmGerarRelatorioTMAP().addActionListener(this);

		// instanciando as filas de prioridades
		filaP1 = new FilaPrioridade();
		filaP2 = new FilaPrioridade();
		filaP3 = new FilaPrioridade();
		filaP4 = new FilaPrioridade();
		filaP5 = new FilaPrioridade();

		// instanciando os dao
		atendDao = new AtendimentoDAO();
		teDAO = new TempoEsperaDAO();
		tapDAO = new TempoAtendPriDAO();
		tagDAO = new TempoAtendGeralDAO();

		pCon = new PacienteController(jan, pac);
		listaAtenEnc = new ListaAtendimentos();
		listaAtenConsulta = new ListaAtendimentos();
	}

	@Override
	public void actionPerformed(ActionEvent arg0) {
		// Limpa os campos da tela
		if (arg0.getActionCommand().equals("Limpar")) {
			this.jan.getTcon().botaoSenhaDesabilitar();
			this.jan.getTcon().getTextCPF().setText("");
			this.jan.getTcad().getTextNome().setText("");
			this.jan.getTcad().getTextCPF().setText("");
			this.jan.getTcad().getTextData().setText("");
			this.jan.getTcad().getLblAviso().setText(" ");
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

		// Botão para voltar para a janela principal
		if (arg0.getActionCommand().equals("Voltar")) {
			this.jan.setContentPane(this.jan.getjPrinc());
			this.jan.revalidate();
			this.jan.repaint();
		}

		// Próxima senha a ser chamada para atendimento
		if (arg0.getActionCommand().equals("menuSenha")) {
			try {
				this.jan.setContentPane(this.jan.getTsenha());
				this.jan.revalidate();
				this.jan.repaint();
				this.jan.getTsenha().getLblAviso().setText(" ");
				this.jan.getTsenha().getLblNomePainel().setText("");
				this.jan.getTsenha().getLblCpfPainel().setText("");
				this.jan.getTsenha().getLblSenhaPainel().setText("");
				proxAtendimento = pCon.listaPaciente().getFilaA().desempilhar().getAtendimento();
				this.jan.getTsenha().getLblSenhaPainel().setText(String.valueOf(proxAtendimento.getSenha()));
				this.jan.getTsenha().getLblNomePainel().setText(String.valueOf(proxAtendimento.getPac().getNome()));
				this.jan.getTsenha().getLblCpfPainel().setText(proxAtendimento.getPac().getCpf());
				if (this.jan.getTsenha().getLblSenhaPainel().equals("")) {
					this.jan.getTsenha().botaoTriagemDesabilitar();
				} else {
					this.jan.getTsenha().botaoTriagem();
				}
			} catch (Exception e) {
				this.jan.getTsenha().botaoTriagemDesabilitar();
				this.jan.getTsenha().getLblAviso().setText("Não há pacientes para atendimento");
			}
		}

		// Tela de triagem
		if (arg0.getActionCommand().equals("Triagem")) {
			this.jan.setContentPane(this.jan.getTtriagem());
			this.jan.revalidate();
			this.jan.revalidate();
			this.jan.getTtriagem().botaoPrioridadeHabilitar();
			this.jan.getTtriagem().botaoProxPacDesabilitar();
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

		// Calcula a prioridade do atendimento a partir dos campos marcados na tela
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
				proxAtendimento.setPrioridade(1);
				break;

			case 2:
				filaP2.empilhar(proxAtendimento);
				proxAtendimento.setPrioridade(2);
				break;

			case 3:
				filaP3.empilhar(proxAtendimento);
				proxAtendimento.setPrioridade(3);
				break;

			case 4:
				filaP4.empilhar(proxAtendimento);
				proxAtendimento.setPrioridade(4);
				break;

			case 5:
				filaP5.empilhar(proxAtendimento);
				proxAtendimento.setPrioridade(5);
				break;
			}

			this.jan.getTtriagem().getLblPrioridade().setText(String.valueOf(fila));
			this.jan.getTtriagem().botaoProxPac();
			this.jan.getTtriagem().botaoPrioridade();
		}

		// Chama próximo paciente para a triagem
		if (arg0.getActionCommand().equals("Próximo Paciente")) {
			try {
				this.jan.setContentPane(this.jan.getTsenha());
				this.jan.revalidate();
				this.jan.repaint();
				this.jan.getTsenha().getLblAviso().setText(" ");
				this.jan.getTsenha().getLblNomePainel().setText("");
				this.jan.getTsenha().getLblCpfPainel().setText("");
				this.jan.getTsenha().getLblSenhaPainel().setText("");
				proxAtendimento = pCon.listaPaciente().getFilaA().desempilhar().getAtendimento();
				this.jan.getTsenha().getLblSenhaPainel().setText(String.valueOf(proxAtendimento.getSenha()));
				this.jan.getTsenha().getLblNomePainel().setText(String.valueOf(proxAtendimento.getPac().getNome()));
				this.jan.getTsenha().getLblCpfPainel().setText(proxAtendimento.getPac().getCpf());
				if (this.jan.getTsenha().getLblSenhaPainel().equals("")) {
					this.jan.getTsenha().botaoTriagemDesabilitar();
				} else {
					this.jan.getTsenha().botaoTriagem();
				}
			} catch (Exception e) {
				this.jan.getTsenha().botaoTriagemDesabilitar();
				this.jan.getTsenha().getLblAviso().setText("Não há pacientes para atendimento");
			}
		}

		// Ativa ou desativa ckeckboxes relacionadas com o campo de múltiplos
		// procedimentos
		if (arg0.getActionCommand().equals("Procedimentos")) {
			if (this.jan.getTtriagem().getChckbxProcedimentos().isSelected()) {
				this.jan.getTtriagem().checkAtivado();
			} else {
				this.jan.getTtriagem().checkDesativado();
			}
		}

		// Tela de prioridades

		if (arg0.getActionCommand().equals("menuPrioridade")) {
			Vector vector = new Vector();
			vector.add("Não há pacientes");
			this.jan.getTfpri().adicionaItem(vector);
			this.jan.setContentPane(this.jan.getTfpri());
			this.jan.revalidate();
			this.jan.repaint();

		}

		// Pesquisa os pacientes em seu atendimento que estão na prioridade selecionada
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

		// Tela para encerrar atendimento
		if (arg0.getActionCommand().equals("menuEnceAtend")) {
			this.jan.setContentPane(this.jan.getTatendenc());
			this.jan.revalidate();
			this.jan.repaint();
			this.jan.getTatendenc().getTextCpf().setText("");
			this.jan.getTatendenc().getTextDataS().setText("");
			this.jan.getTatendenc().getTextHorasS().setText("");
			this.jan.getTatendenc().getLblNome().setText("");
			this.jan.getTatendenc().getLblAviso().setText(" ");
		}

		// Tela para próximo atendimento a ser chamado de acordo com as prioridades
		if (arg0.getActionCommand().equals("menuProx")) {
			this.jan.setContentPane(this.jan.getTproxpac());
			this.jan.revalidate();
			this.jan.repaint();
			this.jan.getTproxpac().getLblNomeProx().setText("");
			this.jan.getTproxpac().getLblPrioridadeProx().setText("");
			this.jan.getTproxpac().getLblAviso().setText(" ");
			NoFila ateEnc = null;
			if (filaP1.estaVazia() == false) {
				this.jan.getTproxpac().getLblNomeProx().setText(filaP1.topo().getAtendimento().getPac().getNome());
				this.jan.getTproxpac().getLblPrioridadeProx().setText(String.valueOf(1));
				ateEnc = filaP1.desempilhar();
			} else {
				if (filaP2.estaVazia() == false) {
					this.jan.getTproxpac().getLblNomeProx().setText(filaP2.topo().getAtendimento().getPac().getNome());
					this.jan.getTproxpac().getLblPrioridadeProx().setText(String.valueOf(2));
					ateEnc = filaP2.desempilhar();
				} else {
					if (filaP3.estaVazia() == false) {
						this.jan.getTproxpac().getLblNomeProx()
								.setText(filaP3.topo().getAtendimento().getPac().getNome());
						this.jan.getTproxpac().getLblPrioridadeProx().setText(String.valueOf(3));
						ateEnc = filaP3.desempilhar();
					} else {
						if (filaP4.estaVazia() == false) {
							this.jan.getTproxpac().getLblNomeProx()
									.setText(filaP4.topo().getAtendimento().getPac().getNome());
							this.jan.getTproxpac().getLblPrioridadeProx().setText(String.valueOf(4));
							ateEnc = filaP4.desempilhar();
						} else {
							if (filaP5.estaVazia() == false) {
								this.jan.getTproxpac().getLblNomeProx()
										.setText(filaP5.topo().getAtendimento().getPac().getNome());
								this.jan.getTproxpac().getLblPrioridadeProx().setText(String.valueOf(5));
								ateEnc = filaP5.desempilhar();
							} else {
								this.jan.getTproxpac().getLblAviso().setText("Não há pacientes para chamada");
							}
						}
					}
				}
			}
			if (ateEnc != null) {
				Calendar cal = Calendar.getInstance();
				long d = cal.getTimeInMillis();
				ateEnc.getAtendimento().setDataA(d);
				listaAtenConsulta.adicionar(ateEnc.getAtendimento());
			}
		}

		// Tela da lista de atendimentos encerrados
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

		// Pesquisa CPF do paciente para atualizar atendimento
		if (arg0.getActionCommand().equals("Pesquisar CPF")) {
			try {
				String cpf = (this.jan.getTatendenc().getTextCpf().getText());
				pLista = listaAtenConsulta.buscar(cpf).getAtendimento().getPac();
				this.jan.getTatendenc().getLblNome().setText(pLista.getNome());
				this.jan.getTatendenc().tornarBotaoVisivel();
			} catch (Exception e) {
				this.jan.getTatendenc().getLblNome().setText("CPF não encontrado");
				this.jan.getTatendenc().tornarBotaoInvisivel();
			}
		}

		// Atualiza os dados do atendimento
		if (arg0.getActionCommand().equals("Atualizar")) {		
			
				if (this.jan.getTatendenc().getTextDataS().getText().equals("  /  /    ")
						|| this.jan.getTatendenc().getTextHorasS().getText().equals("  :  :  ")) {
					this.jan.getTatendenc().getLblAviso().setText("Todos os campos devem ser preenchidos");
				}
				else {
					String cpf = (this.jan.getTatendenc().getTextCpf().getText());
					Atendimento atAtual = listaAtenConsulta.buscar(cpf).getAtendimento();
					atAtual.setDataS(this.jan.getTatendenc().getTextDataS().getText());
					atAtual.setHoraS(this.jan.getTatendenc().getTextHorasS().getText());
					listaAtenConsulta.removerInicio(atAtual);
					listaAtenEnc.adicionar(atAtual);
					this.jan.setContentPane(this.jan.gettConfirmaAtendEnc());
					this.jan.revalidate();
					this.jan.repaint();
				}			
		}
		// gera relatório
		if (arg0.getActionCommand().equals("menuAtend")) {
			atendDao.relatorioAtendimento(this.listaAtenEnc);
		}

		// gera relatório
		if (arg0.getActionCommand().equals("menuRelatorioTME")) {
			long total = 0;
			int cont = 0;
			// as duas listas de atendimento
			for (NoAtendimento aux = listaAtenEnc.primeiro(); aux != null; aux = aux.getProximo()) {
				long espera = aux.getAtendimento().getDataA() - aux.getAtendimento().getDataC();
				total = total + espera;
				cont++;
			}

			for (NoAtendimento aux = listaAtenConsulta.primeiro(); aux != null; aux = aux.getProximo()) {
				long espera = aux.getAtendimento().getDataA() - aux.getAtendimento().getDataC();
				total = total + espera;
				cont++;
			}
			if(cont != 0){
				total = total / cont;
			}
			String tempo = String.format("%03d:%02d:%02d", total / 3600000, (total / 60000) % 60, (total / 1000) % 60);
			teDAO.tempoEspera(tempo);
		}

		// gera relatório
		if (arg0.getActionCommand().equals("menuRelatorioTMAP")) {
			long total1 = 0, total2 = 0, total3 = 0, total4 = 0, total5 = 0;
			int cont1 = 0, cont2 = 0, cont3 = 0, cont4 = 0, cont5 = 0;
			for (NoAtendimento aux = listaAtenEnc.primeiro(); aux != null; aux = aux.getProximo()) {
				String data = aux.getAtendimento().getDataS() + " " + aux.getAtendimento().getHoraS();
				Calendar cal = Calendar.getInstance();
				DateFormat tes = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss");
				try {
					cal.setTime(tes.parse(data));
				} catch (ParseException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				long d = cal.getTimeInMillis();
				long espera = d - aux.getAtendimento().getDataC();
				if (aux.getAtendimento().getPrioridade() == 1) {
					total1 = total1 + espera;
					cont1++;
				}
				if (aux.getAtendimento().getPrioridade() == 2) {
					total2 = total2 + espera;
					cont2++;
				}
				if (aux.getAtendimento().getPrioridade() == 3) {
					total3 = total3 + espera;
					cont3++;
				}
				if (aux.getAtendimento().getPrioridade() == 4) {
					total4 = total4 + espera;
					cont4++;
				}
				if (aux.getAtendimento().getPrioridade() == 5) {
					total5 = total5 + espera;
					cont5++;
				}
			}
			if (cont1 != 0) {
				total1 = total1 / cont1;
			}
			if (cont2 != 0) {
				total2 = total2 / cont2;
			}
			if (cont3 != 0) {
				total3 = total3 / cont3;
			}
			if (cont4 != 0) {
				total4 = total4 / cont4;
			}
			if (cont5 != 0) {
				total5 = total5 / cont5;
			}
			String tempo1 = String.format("%03d:%02d:%02d", total1 / 3600000, (total1 / 60000) % 60,
					(total1 / 1000) % 60);
			String tempo2 = String.format("%03d:%02d:%02d", total2 / 3600000, (total2 / 60000) % 60,
					(total2 / 1000) % 60);
			String tempo3 = String.format("%03d:%02d:%02d", total3 / 3600000, (total3 / 60000) % 60,
					(total3 / 1000) % 60);
			String tempo4 = String.format("%03d:%02d:%02d", total4 / 3600000, (total4 / 60000) % 60,
					(total4 / 1000) % 60);
			String tempo5 = String.format("%03d:%02d:%02d", total5 / 3600000, (total5 / 60000) % 60,
					(total5 / 1000) % 60);
			tapDAO.tempoAtendPri(tempo1, tempo2, tempo3, tempo4, tempo5);

		}

		// gera relatório
		if (arg0.getActionCommand().equals("menuRelatorioTMAG")) {
			long total = 0;
			long cont = 0;
			Date date1 = null;
			for (NoAtendimento aux = listaAtenEnc.primeiro(); aux != null; aux = aux.getProximo()) {
				String data = aux.getAtendimento().getDataS() + " " + aux.getAtendimento().getHoraS();
				Calendar cal = Calendar.getInstance();
				DateFormat tes = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss");
				try {
					cal.setTime(tes.parse(data));
				} catch (ParseException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				long d = cal.getTimeInMillis();
				long espera = d - aux.getAtendimento().getDataC();
				total = total + espera;
				cont++;
			}
			if(cont != 0){
				total = total / cont;
			}
			String tempo = String.format("%03d:%02d:%02d", total / 3600000, (total / 60000) % 60, (total / 1000) % 60);
			tagDAO.tempoAtendGeral(tempo);
		}

		// Pesquisar paciente
		if (arg0.getActionCommand().equals("Pesquisar"))

		{
			try {
				String cpf = (this.jan.getTcon().getTextCPF().getText());
				if (listaAtenConsulta.buscar(cpf) == null && pCon.listaPaciente().getFilaA().buscar(cpf) == null
						&& filaP1.buscar(cpf) == null && filaP2.buscar(cpf) == null && filaP3.buscar(cpf) == null
					&& filaP4.buscar(cpf) == null && filaP5.buscar(cpf) == null) {
					pLista = pCon.listaPaciente().buscar(cpf).getPaciente();
					this.jan.getTcon().getLblPaciente().setText(pLista.getNome());
					this.jan.getTcon().botaoSenha();
				} else {
					this.jan.getTcon().getLblPaciente().setText("Paciente em atendimento");
				}
			} catch (Exception ex) {
				this.jan.getTcon().getLblPaciente().setText("CPF não encontrado");
				this.jan.getTcon().botaoSenhaDesabilitar();
			}
		}
	}
}