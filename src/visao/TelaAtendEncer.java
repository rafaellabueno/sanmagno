package visao;

import javax.swing.JPanel;
import net.miginfocom.swing.MigLayout;
import javax.swing.JLabel;
import java.awt.Font;
import java.awt.Color;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.JFormattedTextField;

public class TelaAtendEncer extends JPanel {
	
	//Declaração dos componentes da tela
	private JTextField textCpf;
	private JTextField textHorasS;
	private JTextField textDataS;
	private JButton btnPesquisarCpf;
	private JButton btnAtualizar;
	private JLabel lblNome;
	private JButton btnLimpar;
	private JButton btnVoltar;
	private JLabel lblAviso;

	/**
	 * Create the panel.
	 */
	public TelaAtendEncer() {
		setLayout(new MigLayout("", "[][]", "[][][][][][][][][][]"));

		JLabel lblAtendimentosEncerrados = new JLabel("Atendimentos Encerrados");
		lblAtendimentosEncerrados.setForeground(new Color(0, 128, 128));
		lblAtendimentosEncerrados.setFont(new Font("Tahoma", Font.BOLD, 25));
		add(lblAtendimentosEncerrados, "cell 0 0");

		JLabel lblDigiteOCpf = new JLabel("Digite o CPF do Paciente");
		lblDigiteOCpf.setFont(new Font("Tahoma", Font.PLAIN, 14));
		add(lblDigiteOCpf, "flowx,cell 0 2");

		textCpf = new JTextField();
		add(textCpf, "cell 0 2,growx");
		textCpf.setColumns(10);

		btnPesquisarCpf = new JButton("Pesquisar CPF");
		btnPesquisarCpf.setFont(new Font("Tahoma", Font.PLAIN, 14));
		add(btnPesquisarCpf, "cell 1 2");

		lblNome = new JLabel("");
		lblNome.setFont(new Font("Tahoma", Font.PLAIN, 14));
		add(lblNome, "cell 0 3");

		JLabel lblHoraDeSada = new JLabel("Hora de Sa\u00EDda");
		lblHoraDeSada.setFont(new Font("Tahoma", Font.PLAIN, 14));
		add(lblHoraDeSada, "flowx,cell 0 4");

		textHorasS = new JTextField();
		add(textHorasS, "cell 0 4");
		textHorasS.setColumns(10);

		JLabel lblDataDeSada = new JLabel("Data de Sa\u00EDda");
		lblDataDeSada.setFont(new Font("Tahoma", Font.PLAIN, 14));
		add(lblDataDeSada, "flowx,cell 0 5");

		textDataS = new JTextField();
		add(textDataS, "cell 0 5");
		textDataS.setColumns(10);
		
		lblAviso = new JLabel("");
		lblAviso.setFont(new Font("Tahoma", Font.PLAIN, 14));
		add(lblAviso, "cell 0 7");
		
		btnLimpar = new JButton("Limpar");
		btnLimpar.setFont(new Font("Tahoma", Font.PLAIN, 14));
		add(btnLimpar, "flowx,cell 0 8");

		btnAtualizar = new JButton("Atualizar");
		btnAtualizar.setEnabled(false);
		btnAtualizar.setFont(new Font("Tahoma", Font.PLAIN, 14));
		add(btnAtualizar, "cell 0 8,alignx center");
		
		btnVoltar = new JButton("Voltar");
		btnVoltar.setFont(new Font("Tahoma", Font.PLAIN, 14));
		add(btnVoltar, "cell 0 9");

	}

	//getters e setters dos componentes da tela
	public JButton getBtnPesquisarCpf() {
		return btnPesquisarCpf;
	}

	public void setBtnPesquisarCpf(JButton btnPesquisarCpf) {
		this.btnPesquisarCpf = btnPesquisarCpf;
	}

	public JButton getBtnAtualizar() {
		return btnAtualizar;
	}

	public void setBtnAtualizar(JButton btnAtualizar) {
		this.btnAtualizar = btnAtualizar;
	}

	public JLabel getLblNome() {
		return lblNome;
	}

	public void setLblNome(JLabel lblNome) {
		this.lblNome = lblNome;
	}

	public JTextField getTextCpf() {
		return textCpf;
	}

	public void setTextCpf(JTextField textCpf) {
		this.textCpf = textCpf;
	}

	public JTextField getTextHorasS() {
		return textHorasS;
	}

	public void setTextHorasS(JTextField textHorasS) {
		this.textHorasS = textHorasS;
	}

	public JTextField getTextDataS() {
		return textDataS;
	}

	public void setTextDataS(JTextField textDataS) {
		this.textDataS = textDataS;
	}

	public JButton getBtnLimpar() {
		return btnLimpar;
	}

	public void setBtnLimpar(JButton btnLimpar) {
		this.btnLimpar = btnLimpar;
	}

	public JButton getBtnVoltar() {
		return btnVoltar;
	}

	public void setBtnVoltar(JButton btnVoltar) {
		this.btnVoltar = btnVoltar;
	}

	public JLabel getLblAviso() {
		return lblAviso;
	}

	public void setLblAviso(JLabel lblAviso) {
		this.lblAviso = lblAviso;
	}
	
	//torna o botão de atualizar visivel ao encontrar paciente com cpf informado
	public void tornarBotaoVisivel() {
		btnAtualizar.setEnabled(true);
	}
	
	//torna o botão de atualizar invisivel quando não encontrar paciente com cpf informado
	public void tornarBotaoInvisivel() {
		btnAtualizar.setEnabled(false);
	}
}
