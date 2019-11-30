package visao;

import javax.swing.JPanel;
import net.miginfocom.swing.MigLayout;
import javax.swing.JLabel;
import java.awt.Font;
import java.awt.Color;
import javax.swing.JCheckBox;
import javax.swing.JButton;
import javax.swing.SwingConstants;
import javax.swing.border.BevelBorder;
import javax.swing.ImageIcon;

public class TelaTriagem extends JPanel {

	//Declaração dos componentes da tela
	private JCheckBox chckbxEntubado;
	private JCheckBox chckbxApneia;
	private JCheckBox chckbxSemPulso;
	private JCheckBox chckbxDor;
	private JCheckBox chckbxLetargico;
	private JCheckBox chckbxSemReacao;
	private JCheckBox chckbxSituacaoDeRisco;
	private JCheckBox chckbxConfusoDesorientado;
	private JCheckBox chckbxProcedimentos;
	private JCheckBox chckbxFreqC;
	private JCheckBox chckbxFreqR;
	private JCheckBox chckbxTempC;
	private JCheckBox chckbxOutrosP;
	private JCheckBox chckbxTempC2;
	private JCheckBox chckbxOximetria;
	private JCheckBox chckbxFluxoResp;
	private JButton btnPrioridade;
	private JLabel lblNomePaciente;
	private JLabel lblPrioridadeDoPaciente;
	private JLabel lblPrioridade;
	private JButton btnVoltar;
	private JButton btnLimpar;
	private JPanel panel;
	private JPanel panel_1;
	private JLabel lblFotoTriagem;

	/**
	 * Create the panel.
	 */
	public TelaTriagem() {
		setBackground(new Color(102, 205, 170));
		setLayout(new MigLayout("", "[grow]", "[][][][][grow][grow][][][][][]"));
				
						JLabel lblTelaTriagem = new JLabel("Tela Triagem");
						lblTelaTriagem.setForeground(new Color(255, 255, 255));
						lblTelaTriagem.setFont(new Font("Tahoma", Font.BOLD, 25));
						add(lblTelaTriagem, "flowy,cell 0 0,alignx center");
		
				JLabel lblSelecioneAPrioridade = new JLabel("Selecione as informa\u00E7\u00F5es que correspondem o(a) paciente:");
				lblSelecioneAPrioridade.setFont(new Font("Tahoma", Font.PLAIN, 14));
				add(lblSelecioneAPrioridade, "cell 0 2");
		
		panel = new JPanel();
		panel.setBackground(new Color(255, 255, 255));
		panel.setBorder(new BevelBorder(BevelBorder.LOWERED, null, null, null, null));
		add(panel, "cell 0 4,grow");
		panel.setLayout(new MigLayout("", "[][][]", "[][][][]"));

		chckbxEntubado = new JCheckBox("Entubado");
		chckbxEntubado.setBackground(new Color(255, 255, 255));
		panel.add(chckbxEntubado, "cell 0 0");
		chckbxEntubado.setFont(new Font("Tahoma", Font.PLAIN, 14));
		
				chckbxDor = new JCheckBox("Dor/Sofrimento agudo");
				chckbxDor.setBackground(new Color(255, 255, 255));
				panel.add(chckbxDor, "cell 1 0");
				chckbxDor.setFont(new Font("Tahoma", Font.PLAIN, 14));
				
						chckbxSituacaoDeRisco = new JCheckBox("Situa\u00E7\u00E3o de risco");
						chckbxSituacaoDeRisco.setBackground(new Color(255, 255, 255));
						panel.add(chckbxSituacaoDeRisco, "cell 2 0");
						chckbxSituacaoDeRisco.setFont(new Font("Tahoma", Font.PLAIN, 14));

		chckbxApneia = new JCheckBox("Apneia");
		chckbxApneia.setBackground(new Color(255, 255, 255));
		panel.add(chckbxApneia, "cell 0 1");
		chckbxApneia.setFont(new Font("Tahoma", Font.PLAIN, 14));
		
				chckbxLetargico = new JCheckBox("Let\u00E1rgico");
				chckbxLetargico.setBackground(new Color(255, 255, 255));
				panel.add(chckbxLetargico, "cell 1 1");
				chckbxLetargico.setFont(new Font("Tahoma", Font.PLAIN, 14));

		chckbxSemPulso = new JCheckBox("Sem pulso");
		chckbxSemPulso.setBackground(new Color(255, 255, 255));
		panel.add(chckbxSemPulso, "cell 2 1");
		chckbxSemPulso.setFont(new Font("Tahoma", Font.PLAIN, 14));
		
				chckbxConfusoDesorientado = new JCheckBox("Confuso/Desorientado");
				chckbxConfusoDesorientado.setBackground(new Color(255, 255, 255));
				panel.add(chckbxConfusoDesorientado, "cell 0 2");
				chckbxConfusoDesorientado.setFont(new Font("Tahoma", Font.PLAIN, 14));
						
								chckbxOutrosP = new JCheckBox("Outros procedimentos");
								panel.add(chckbxOutrosP, "cell 1 2");
								chckbxOutrosP.setBackground(new Color(255, 255, 255));
								chckbxOutrosP.setFont(new Font("Tahoma", Font.PLAIN, 14));
				
						chckbxSemReacao = new JCheckBox("Sem rea\u00E7\u00E3o");
						chckbxSemReacao.setBackground(new Color(255, 255, 255));
						panel.add(chckbxSemReacao, "cell 2 2");
						chckbxSemReacao.setFont(new Font("Tahoma", Font.PLAIN, 14));
		
				chckbxProcedimentos = new JCheckBox(
						"M\u00FAltiplos atendimentos (raio x, exames laboratoriais, inje\u00E7\u00F5es) ");
				chckbxProcedimentos.setBackground(new Color(255, 255, 255));
				panel.add(chckbxProcedimentos, "cell 0 3 3 1");
				chckbxProcedimentos.setFont(new Font("Tahoma", Font.PLAIN, 14));
				chckbxProcedimentos.setActionCommand("Procedimentos");
		
		lblNomePaciente = new JLabel("");
		lblNomePaciente.setFont(new Font("Tahoma", Font.PLAIN, 14));
		add(lblNomePaciente, "flowx,cell 0 3");
		
		panel_1 = new JPanel();
		panel_1.setBackground(new Color(255, 255, 255));
		panel_1.setBorder(new BevelBorder(BevelBorder.LOWERED, null, null, null, null));
		add(panel_1, "cell 0 5,grow");
		panel_1.setLayout(new MigLayout("", "[][][]", "[][][]"));
		
				chckbxFreqC = new JCheckBox("Frequ\u00EAncia Card\u00EDaca > 90");
				chckbxFreqC.setBackground(new Color(255, 255, 255));
				panel_1.add(chckbxFreqC, "flowx,cell 0 0,alignx left");
				chckbxFreqC.setEnabled(false);
				chckbxFreqC.setFont(new Font("Tahoma", Font.PLAIN, 12));
								
										chckbxTempC2 = new JCheckBox("Temperatural Corporal >38");
										chckbxTempC2.setFont(new Font("Tahoma", Font.PLAIN, 12));
										chckbxTempC2.setBackground(new Color(255, 255, 255));
										panel_1.add(chckbxTempC2, "cell 1 0,growx");
										chckbxTempC2.setEnabled(false);
						
								chckbxFreqR = new JCheckBox("Frequ\u00EAncia Respirat\u00F3rio > 20");
								chckbxFreqR.setBackground(new Color(255, 255, 255));
								panel_1.add(chckbxFreqR, "flowx,cell 0 1");
								chckbxFreqR.setEnabled(false);
								chckbxFreqR.setFont(new Font("Tahoma", Font.PLAIN, 12));
												
														chckbxOximetria = new JCheckBox("Oximetria do pulso <90%");
														chckbxOximetria.setFont(new Font("Tahoma", Font.PLAIN, 12));
														chckbxOximetria.setBackground(new Color(255, 255, 255));
														panel_1.add(chckbxOximetria, "cell 1 1");
														chckbxOximetria.setEnabled(false);
										
												chckbxTempC = new JCheckBox("Temperatura Corporal < 36 ");
												chckbxTempC.setBackground(new Color(255, 255, 255));
												panel_1.add(chckbxTempC, "flowx,cell 0 2");
												chckbxTempC.setEnabled(false);
												chckbxTempC.setFont(new Font("Tahoma", Font.PLAIN, 12));
																
																		chckbxFluxoResp = new JCheckBox("Fluxo Respirat\u00F3rio < 200");
																		chckbxFluxoResp.setFont(new Font("Tahoma", Font.PLAIN, 12));
																		chckbxFluxoResp.setBackground(new Color(255, 255, 255));
																		panel_1.add(chckbxFluxoResp, "cell 1 2");
																		chckbxFluxoResp.setEnabled(false);
		
		lblPrioridadeDoPaciente = new JLabel("Prioridade do paciente: ");
		lblPrioridadeDoPaciente.setForeground(new Color(0, 0, 0));
		lblPrioridadeDoPaciente.setFont(new Font("Tahoma", Font.PLAIN, 14));
		add(lblPrioridadeDoPaciente, "flowx,cell 0 8");
		
		lblPrioridade = new JLabel("");
		lblPrioridade.setFont(new Font("Tahoma", Font.PLAIN, 14));
		add(lblPrioridade, "cell 0 8");
		
		btnVoltar = new JButton("Voltar");
		btnVoltar.setHorizontalAlignment(SwingConstants.LEFT);
		btnVoltar.setFont(new Font("Tahoma", Font.PLAIN, 14));
		add(btnVoltar, "flowx,cell 0 9,alignx right");
		
		btnLimpar = new JButton("Limpar");
		btnLimpar.setFont(new Font("Tahoma", Font.PLAIN, 14));
		add(btnLimpar, "cell 0 9,alignx left");
		
				btnPrioridade = new JButton("Calcular Prioridade");
				btnPrioridade.setFont(new Font("Tahoma", Font.PLAIN, 14));
				add(btnPrioridade, "cell 0 7,alignx center");
				
				lblFotoTriagem = new JLabel("");
				lblFotoTriagem.setIcon(new ImageIcon(TelaTriagem.class.getResource("/img/medico.png")));
				add(lblFotoTriagem, "cell 0 0,alignx center");
		
	}

	
	//getters e setters dos componentes da tela
	public JCheckBox getChckbxEntubado() {
		return chckbxEntubado;
	}

	public void setChckbxEntubado(JCheckBox chckbxEntubado) {
		this.chckbxEntubado = chckbxEntubado;
	}

	public JCheckBox getChckbxApneia() {
		return chckbxApneia;
	}

	public void setChckbxApneia(JCheckBox chckbxApneia) {
		this.chckbxApneia = chckbxApneia;
	}

	public JCheckBox getChckbxSemPulso() {
		return chckbxSemPulso;
	}

	public void setChckbxSemPulso(JCheckBox chckbxSemPulso) {
		this.chckbxSemPulso = chckbxSemPulso;
	}

	public JCheckBox getChckbxDor() {
		return chckbxDor;
	}

	public void setChckbxDor(JCheckBox chckbxDor) {
		this.chckbxDor = chckbxDor;
	}

	public JCheckBox getChckbxLetargico() {
		return chckbxLetargico;
	}

	public void setChckbxLetargico(JCheckBox chckbxLetargico) {
		this.chckbxLetargico = chckbxLetargico;
	}

	public JCheckBox getChckbxSemReacao() {
		return chckbxSemReacao;
	}

	public void setChckbxSemReacao(JCheckBox chckbxSemReacao) {
		this.chckbxSemReacao = chckbxSemReacao;
	}

	public JCheckBox getChckbxSituacaoDeRisco() {
		return chckbxSituacaoDeRisco;
	}

	public void setChckbxSituacaoDeRisco(JCheckBox chckbxSituacaoDeRisco) {
		this.chckbxSituacaoDeRisco = chckbxSituacaoDeRisco;
	}

	public JCheckBox getChckbxConfusoDesorientado() {
		return chckbxConfusoDesorientado;
	}

	public void setChckbxConfusoDesorientado(JCheckBox chckbxConfusoDesorientado) {
		this.chckbxConfusoDesorientado = chckbxConfusoDesorientado;
	}

	public JCheckBox getChckbxProcedimentos() {
		return chckbxProcedimentos;
	}

	public void setChckbxProcedimentos(JCheckBox chckbxProcedimentos) {
		this.chckbxProcedimentos = chckbxProcedimentos;
	}

	public JCheckBox getChckbxfreqC() {
		return chckbxFreqC;
	}

	public void setChckbxFreqC(JCheckBox chckbxFreqC) {
		this.chckbxFreqC = chckbxFreqC;
	}

	public JCheckBox getChckbxFreqR() {
		return chckbxFreqR;
	}

	public void setChckbxFreqR(JCheckBox chckbxFreqR) {
		this.chckbxFreqR = chckbxFreqR;
	}

	public JCheckBox getChckbxTempC() {
		return chckbxTempC;
	}

	public void setChckbxtempC(JCheckBox chckbxTempC) {
		this.chckbxTempC = chckbxTempC;
	}

	public JCheckBox getChckbxOutrosP() {
		return chckbxOutrosP;
	}

	public void setChckbxoutrosP(JCheckBox chckbxOutrosP) {
		this.chckbxOutrosP = chckbxOutrosP;
	}

	public JCheckBox getChckbxTempC2() {
		return chckbxTempC2;
	}

	public void setChckbxTempC2(JCheckBox chckbxTempC2) {
		this.chckbxTempC2 = chckbxTempC2;
	}

	public JCheckBox getChckbxOximetria() {
		return chckbxOximetria;
	}

	public void setChckbxOximetria(JCheckBox chckbxOximetria) {
		this.chckbxOximetria = chckbxOximetria;
	}

	public JCheckBox getChckbxFluxoResp() {
		return chckbxFluxoResp;
	}

	public void setChckbxFluxoResp(JCheckBox chckbxFluxoResp) {
		this.chckbxFluxoResp = chckbxFluxoResp;
	}

	public JButton getBtnPrioridade() {
		return btnPrioridade;
	}

	public void setBtnPrioridade(JButton btnPrioridade) {
		this.btnPrioridade = btnPrioridade;
	}
	
	public JLabel getLblNomePaciente() {
		return lblNomePaciente;
	}

	public void setLblNomePaciente(JLabel lblNomePaciente) {
		this.lblNomePaciente = lblNomePaciente;
	}

	public JLabel getLblPrioridade() {
		return lblPrioridade;
	}

	public void setLblPrioridade(JLabel lblPrioridade) {
		this.lblPrioridade = lblPrioridade;
	}

	public JButton getBtnVoltar() {
		return btnVoltar;
	}

	public void setBtnVoltar(JButton btnVoltar) {
		this.btnVoltar = btnVoltar;
	}
	

	public JButton getBtnLimpar() {
		return btnLimpar;
	}

	public void setBtnLimpar(JButton btnLimpar) {
		this.btnLimpar = btnLimpar;
	}

	//checkBox são ativadas quando múltiplos atendimentos é selecionado
	public void checkAtivado() {
		chckbxFreqR.setEnabled(true);
		chckbxFreqC.setEnabled(true);
		chckbxTempC.setEnabled(true);
		chckbxTempC2.setEnabled(true);
		chckbxOximetria.setEnabled(true);
		chckbxFluxoResp.setEnabled(true);
	}
	
	//checkBox são desativadas quando múltiplos atendimentos é desmarcado
	public void checkDesativado ()
	{
		chckbxFreqR.setEnabled(false);
		chckbxFreqC.setEnabled(false);
		chckbxTempC.setEnabled(false);
		chckbxTempC2.setEnabled(false);			
		chckbxOximetria.setEnabled(false);
		chckbxFluxoResp.setEnabled(false);
	}	
}
