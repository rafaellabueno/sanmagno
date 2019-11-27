package visao;

import javax.swing.JPanel;
import net.miginfocom.swing.MigLayout;
import javax.swing.JLabel;
import java.awt.Font;
import java.awt.Color;
import javax.swing.JTextField;
import javax.swing.JButton;

public class TelaConsulta extends JPanel {

	private JTextField textCPF;
	private JButton btnPesquisar;
	private JButton btnGerarSenha;
	private JLabel lblPaciente;
	private JLabel lblSenha;
	private JButton btnVoltar;
	private JButton btnLimpar;

	/**
	 * Create the panel.
	 */
	public TelaConsulta() {
		setLayout(new MigLayout("", "[][]", "[][][][][][][][][][]"));

		JLabel lblTelaConsulta = new JLabel("Tela Consulta");
		lblTelaConsulta.setForeground(new Color(0, 128, 128));
		lblTelaConsulta.setFont(new Font("Tahoma", Font.BOLD, 25));
		add(lblTelaConsulta, "cell 0 0");

		JLabel lblDigiteOCpf = new JLabel("Digite o CPF do paciente");
		lblDigiteOCpf.setFont(new Font("Tahoma", Font.PLAIN, 14));
		add(lblDigiteOCpf, "flowx,cell 0 3");

		textCPF = new JTextField();
		textCPF.setFont(new Font("Tahoma", Font.PLAIN, 14));
		add(textCPF, "cell 0 3");
		textCPF.setColumns(10);

		btnPesquisar = new JButton("Pesquisar");
		btnPesquisar.setFont(new Font("Tahoma", Font.PLAIN, 14));
		add(btnPesquisar, "cell 1 3");

		lblPaciente = new JLabel("");
		lblPaciente.setFont(new Font("Tahoma", Font.PLAIN, 14));
		add(lblPaciente, "cell 0 5,growx");

		btnVoltar = new JButton("Voltar");
		btnVoltar.setFont(new Font("Tahoma", Font.PLAIN, 14));
		add(btnVoltar, "flowx,cell 0 8");

		btnGerarSenha = new JButton("Gerar Senha");
		btnGerarSenha.setEnabled(false);
		btnGerarSenha.setFont(new Font("Tahoma", Font.PLAIN, 14));
		add(btnGerarSenha, "cell 0 8,alignx right");

		lblSenha = new JLabel("");
		lblSenha.setFont(new Font("Tahoma", Font.PLAIN, 14));
		add(lblSenha, "cell 1 8,alignx center");

		btnLimpar = new JButton("Limpar");
		btnLimpar.setFont(new Font("Tahoma", Font.PLAIN, 14));
		add(btnLimpar, "cell 0 9");

	}

	public JTextField getTextCPF() {
		return textCPF;
	}

	public void setTextCPF(JTextField textCPF) {
		this.textCPF = textCPF;
	}

	public JButton getBtnPesquisar() {
		return btnPesquisar;
	}

	public void setBtnPesquisar(JButton btnPesquisar) {
		this.btnPesquisar = btnPesquisar;
	}

	public JButton getBtnGerarSenha() {
		return btnGerarSenha;
	}

	public void setBtnGerarSenha(JButton btnGerarSenha) {
		this.btnGerarSenha = btnGerarSenha;
	}

	public JLabel getLblPaciente() {
		return lblPaciente;
	}

	public void setLblPaciente(JLabel lblPaciente) {
		this.lblPaciente = lblPaciente;
	}

	public JLabel getLblSenha() {
		return lblSenha;
	}

	public void setLblSenha(JLabel lblSenha) {
		this.lblSenha = lblSenha;
	}

	public void botaoSenha() {
		btnGerarSenha.setEnabled(true);
	}

	public void botaoSenhaDesabilitar() {
		btnGerarSenha.setEnabled(false);
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

}
