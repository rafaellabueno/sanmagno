package visao;

import javax.swing.JPanel;
import net.miginfocom.swing.MigLayout;
import javax.swing.JLabel;
import java.awt.Font;
import java.awt.Color;
import javax.swing.JCheckBox;
import javax.swing.JButton;
import javax.swing.SwingConstants;

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

	/**
	 * Create the panel.
	 */
	public TelaTriagem() {
		setLayout(new MigLayout("", "[]", "[][][][][][][][][][][][][][][][][][][][][][][]"));

		JLabel lblTelaTriagem = new JLabel("Tela Triagem");
		lblTelaTriagem.setForeground(new Color(0, 128, 128));
		lblTelaTriagem.setFont(new Font("Tahoma", Font.BOLD, 25));
		add(lblTelaTriagem, "cell 0 0");

		JLabel lblSelecioneAPrioridade = new JLabel("Selecione as informa\u00E7\u00F5es que correspondem o(a) paciente:");
		lblSelecioneAPrioridade.setFont(new Font("Tahoma", Font.PLAIN, 14));
		add(lblSelecioneAPrioridade, "flowx,cell 0 1");

		chckbxEntubado = new JCheckBox("Entubado");
		chckbxEntubado.setFont(new Font("Tahoma", Font.PLAIN, 14));
		add(chckbxEntubado, "flowx,cell 0 3");

		chckbxApneia = new JCheckBox("Apneia");
		chckbxApneia.setFont(new Font("Tahoma", Font.PLAIN, 14));
		add(chckbxApneia, "flowx,cell 0 5");

		chckbxSemPulso = new JCheckBox("Sem pulso");
		chckbxSemPulso.setFont(new Font("Tahoma", Font.PLAIN, 14));
		add(chckbxSemPulso, "flowx,cell 0 6");

		chckbxProcedimentos = new JCheckBox(
				"M\u00FAltiplos atendimentos (raio x, exames laboratoriais, inje\u00E7\u00F5es) ");
		chckbxProcedimentos.setFont(new Font("Tahoma", Font.PLAIN, 14));
		chckbxProcedimentos.setActionCommand("Procedimentos");
		add(chckbxProcedimentos, "cell 0 8");

		chckbxFreqC = new JCheckBox("Frequ\u00EAncia Card\u00EDaca > 90");
		chckbxFreqC.setEnabled(false);
		chckbxFreqC.setFont(new Font("Tahoma", Font.PLAIN, 12));
		add(chckbxFreqC, "flowx,cell 0 10");

		chckbxFreqR = new JCheckBox("Frequ\u00EAncia Respirat\u00F3rio > 20");
		chckbxFreqR.setEnabled(false);
		chckbxFreqR.setFont(new Font("Tahoma", Font.PLAIN, 12));
		add(chckbxFreqR, "flowx,cell 0 12");

		chckbxTempC = new JCheckBox("Temperatura Corporal < 36 ");
		chckbxTempC.setEnabled(false);
		chckbxTempC.setFont(new Font("Tahoma", Font.PLAIN, 12));
		add(chckbxTempC, "flowx,cell 0 13");

		chckbxOutrosP = new JCheckBox("Outros procedimentos");
		chckbxOutrosP.setFont(new Font("Tahoma", Font.PLAIN, 14));
		add(chckbxOutrosP, "flowx,cell 0 14");

		chckbxDor = new JCheckBox("Dor/Sofrimento agudo");
		chckbxDor.setFont(new Font("Tahoma", Font.PLAIN, 14));
		add(chckbxDor, "cell 0 3,alignx right");

		chckbxLetargico = new JCheckBox("Let\u00E1rgico");
		chckbxLetargico.setFont(new Font("Tahoma", Font.PLAIN, 14));
		add(chckbxLetargico, "cell 0 5");

		chckbxSituacaoDeRisco = new JCheckBox("Situa\u00E7\u00E3o de risco");
		chckbxSituacaoDeRisco.setFont(new Font("Tahoma", Font.PLAIN, 14));
		add(chckbxSituacaoDeRisco, "cell 0 5");

		chckbxSemReacao = new JCheckBox("Sem rea\u00E7\u00E3o");
		chckbxSemReacao.setFont(new Font("Tahoma", Font.PLAIN, 14));
		add(chckbxSemReacao, "cell 0 6");

		chckbxConfusoDesorientado = new JCheckBox("Confuso/Desorientado");
		chckbxConfusoDesorientado.setFont(new Font("Tahoma", Font.PLAIN, 14));
		add(chckbxConfusoDesorientado, "cell 0 6");

		chckbxTempC2 = new JCheckBox("Temperatural Corporal >38");
		chckbxTempC2.setEnabled(false);
		add(chckbxTempC2, "cell 0 10");

		chckbxOximetria = new JCheckBox("Oximetria do pulso <90%");
		chckbxOximetria.setEnabled(false);
		add(chckbxOximetria, "cell 0 12");

		chckbxFluxoResp = new JCheckBox("Fluxo Respirat\u00F3rio < 200");
		chckbxFluxoResp.setEnabled(false);
		add(chckbxFluxoResp, "cell 0 13");

		btnPrioridade = new JButton("Calcular Prioridade");
		btnPrioridade.setFont(new Font("Tahoma", Font.PLAIN, 14));
		add(btnPrioridade, "cell 0 14");
		
		lblNomePaciente = new JLabel("");
		lblNomePaciente.setFont(new Font("Tahoma", Font.PLAIN, 14));
		add(lblNomePaciente, "cell 0 1");
		
		lblPrioridadeDoPaciente = new JLabel("Prioridade do paciente: ");
		lblPrioridadeDoPaciente.setFont(new Font("Tahoma", Font.PLAIN, 12));
		add(lblPrioridadeDoPaciente, "flowx,cell 0 19");
		
		lblPrioridade = new JLabel("");
		lblPrioridade.setFont(new Font("Tahoma", Font.PLAIN, 12));
		add(lblPrioridade, "cell 0 19");
		
		btnLimpar = new JButton("Limpar");
		btnLimpar.setFont(new Font("Tahoma", Font.PLAIN, 14));
		add(btnLimpar, "flowx,cell 0 21,alignx right");
		
		btnVoltar = new JButton("Voltar");
		btnVoltar.setHorizontalAlignment(SwingConstants.LEFT);
		btnVoltar.setFont(new Font("Tahoma", Font.PLAIN, 14));
		add(btnVoltar, "cell 0 21,alignx right");
		
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
