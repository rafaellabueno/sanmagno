package visao;

import javax.swing.JPanel;
import net.miginfocom.swing.MigLayout;
import javax.swing.JLabel;
import java.awt.Font;
import java.awt.Color;
import javax.swing.JTextField;
import javax.swing.ImageIcon;
import javax.swing.JButton;

public class TelaConsulta extends JPanel {

	//Declaração dos componentes da tela
	private JTextField textCPF;
	private JButton btnPesquisar;
	private JButton btnGerarSenha;
	private JLabel lblPaciente;
	private JLabel lblSenha;
	private JButton btnVoltar;
	private JButton btnLimpar;
	private JPanel panel;
	private JPanel panel_1;
	private JPanel panel_2;
	private JLabel label;
	
	ImageIcon  imgPessoas = new ImageIcon(getClass().getResource("pessoas.png"));
	private JLabel lblFotoPessoas;
	private JPanel panel_3;

	/**
	 * Create the panel.
	 */
	public TelaConsulta() {
		setBackground(new Color(255, 255, 255));
		setLayout(new MigLayout("", "[grow][]", "[grow][grow][][][][][][][][grow]"));
		
		panel = new JPanel();
		panel.setBackground(new Color(102, 205, 170));
		add(panel, "cell 0 0 2 1,grow");
				
				panel_2 = new JPanel();
				panel_2.setBackground(new Color(102, 205, 170));
				panel.add(panel_2);
				panel_2.setLayout(new MigLayout("", "[]", "[]"));
				
				label = new JLabel("Tela Consulta");
				label.setForeground(new Color(255, 255, 255));
				label.setFont(new Font("Tahoma", Font.BOLD, 25));
				panel_2.add(label, "flowy,cell 0 0");
				
				lblFotoPessoas = new JLabel(new ImageIcon(TelaConsulta.class.getResource("/visao/pessoas.png")));				
				lblFotoPessoas.setText("");
				lblFotoPessoas.setSize(66, 66);
				panel_2.add(lblFotoPessoas, "cell 0 0,alignx center");
		
		panel_1 = new JPanel();
		panel_1.setBackground(new Color(255, 255, 255));
		add(panel_1, "cell 0 1 2 6,alignx center,aligny top");
		panel_1.setLayout(new MigLayout("", "[][]", "[][][]"));
				
						JLabel lblDigiteOCpf = new JLabel("Digite o CPF do paciente");
						panel_1.add(lblDigiteOCpf, "flowx,cell 0 0");
						lblDigiteOCpf.setFont(new Font("Tahoma", Font.PLAIN, 14));
		
				textCPF = new JTextField();
				panel_1.add(textCPF, "cell 0 0");
				textCPF.setFont(new Font("Tahoma", Font.PLAIN, 14));
				textCPF.setColumns(10);
								
										btnPesquisar = new JButton("Pesquisar");
										panel_1.add(btnPesquisar, "cell 0 0 2 1,growx");
										btnPesquisar.setFont(new Font("Tahoma", Font.PLAIN, 14));
										
												lblPaciente = new JLabel("");
												panel_1.add(lblPaciente, "cell 0 1");
												lblPaciente.setFont(new Font("Tahoma", Font.PLAIN, 14));
												
														btnLimpar = new JButton("Limpar");
														panel_1.add(btnLimpar, "flowx,cell 0 2");
														btnLimpar.setFont(new Font("Tahoma", Font.PLAIN, 14));
														
																btnVoltar = new JButton("Voltar");
																panel_1.add(btnVoltar, "cell 0 2,alignx center");
																btnVoltar.setFont(new Font("Tahoma", Font.PLAIN, 14));
																
																		btnGerarSenha = new JButton("Gerar Senha");
																		panel_1.add(btnGerarSenha, "cell 0 2,alignx center");
																		btnGerarSenha.setEnabled(false);
																		btnGerarSenha.setFont(new Font("Tahoma", Font.PLAIN, 14));

		lblSenha = new JLabel("");
		panel_1.add(lblSenha, "cell 0 2,growx");
		lblSenha.setFont(new Font("Tahoma", Font.PLAIN, 14));
		
		panel_3 = new JPanel();
		panel_3.setBackground(new Color(102, 205, 170));
		add(panel_3, "cell 0 9 2 1,grow");

	}

	//getters e setters dos componentes da tela
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
	
	//botao da senha só é liberado ao encontrar cpf
	public void botaoSenha() {
		btnGerarSenha.setEnabled(true);
	}

	//botao da senhaé ocultado quando não encontrado cpf
	public void botaoSenhaDesabilitar() {
		btnGerarSenha.setEnabled(false);
	}

}
