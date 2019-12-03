package visao;

import javax.swing.JPanel;
import net.miginfocom.swing.MigLayout;
import javax.swing.JLabel;
import java.awt.Font;
import java.awt.Color;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.SwingConstants;
import javax.swing.border.BevelBorder;
import java.awt.FlowLayout;
import javax.swing.ImageIcon;
import javax.swing.JFormattedTextField;
import javax.swing.text.MaskFormatter;
import java.text.ParseException;

public class TelaAtendEncer extends JPanel {

	// Declaração dos componentes da tela
	private JTextField textCpf;
	private JTextField textHorasS;
	private JTextField textDataS;
	private JButton btnPesquisarCpf;
	private JButton btnAtualizar;
	private JLabel lblNome;
	private JButton btnLimpar;
	private JButton btnVoltar;
	private JLabel lblAviso;
	private JPanel panel;
	private JPanel panel_1;
	private JPanel panel_2;
	private JLabel label;

	/**
	 * Create the panel.
	 */
	public TelaAtendEncer() {
		setBackground(new Color(255, 255, 255));
		setLayout(new MigLayout("", "[grow][]", "[grow][grow][grow][][grow][][][][]"));

		panel = new JPanel();
		panel.setBackground(new Color(102, 205, 170));
		add(panel, "cell 0 0 2 1,grow");
		panel.setLayout(new FlowLayout(FlowLayout.CENTER, 5, 5));

		panel_2 = new JPanel();
		panel_2.setBackground(new Color(102, 205, 170));
		panel.add(panel_2);
		panel_2.setLayout(new MigLayout("", "[]", "[]"));

		label = new JLabel("");
		label.setIcon(new ImageIcon(TelaAtendEncer.class.getResource("/img/pasta.png")));
		label.setFont(new Font("Tahoma", Font.PLAIN, 14));
		panel_2.add(label, "cell 0 0,alignx center");

		JLabel lblAtendimentosEncerrados = new JLabel("Encerrar Atendimento");
		panel.add(lblAtendimentosEncerrados);
		lblAtendimentosEncerrados.setHorizontalAlignment(SwingConstants.CENTER);
		lblAtendimentosEncerrados.setForeground(new Color(255, 255, 255));
		lblAtendimentosEncerrados.setFont(new Font("Tahoma", Font.BOLD, 25));

		panel_1 = new JPanel();
		panel_1.setBorder(new BevelBorder(BevelBorder.LOWERED, new Color(102, 205, 170), new Color(102, 205, 170),
				new Color(102, 205, 170), new Color(102, 205, 170)));
		panel_1.setBackground(new Color(255, 255, 255));
		add(panel_1, "cell 0 1 2 2,grow");
		panel_1.setLayout(new MigLayout("", "[][][]", "[][][][][]"));

		JLabel lblDigiteOCpf = new JLabel("Digite o CPF do Paciente");
		panel_1.add(lblDigiteOCpf, "flowx,cell 0 0,alignx right");
		lblDigiteOCpf.setFont(new Font("Tahoma", Font.PLAIN, 14));

		try {
			textCpf = new JFormattedTextField(new MaskFormatter("###.###.###-##"));
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		panel_1.add(textCpf, "cell 1 0");
		textCpf.setColumns(10);

		btnPesquisarCpf = new JButton("Pesquisar CPF");
		panel_1.add(btnPesquisarCpf, "cell 2 0");

		btnPesquisarCpf.setFont(new Font("Tahoma", Font.PLAIN, 14));

		lblNome = new JLabel("");
		panel_1.add(lblNome, "cell 0 1,alignx right");
		lblNome.setFont(new Font("Tahoma", Font.PLAIN, 14));

		JLabel lblDataDeSada = new JLabel("Data de Sa\u00EDda");
		panel_1.add(lblDataDeSada, "flowx,cell 0 2,alignx right");
		lblDataDeSada.setFont(new Font("Tahoma", Font.PLAIN, 14));

		try {
			textDataS = new JFormattedTextField(new MaskFormatter("##/##/####"));
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		panel_1.add(textDataS, "cell 1 2");
		textDataS.setColumns(10);

		JLabel lblHoraDeSada = new JLabel("Hora de Sa\u00EDda");
		panel_1.add(lblHoraDeSada, "cell 0 3,alignx right");
		lblHoraDeSada.setFont(new Font("Tahoma", Font.PLAIN, 14));

		try {
			textHorasS = new JFormattedTextField(new MaskFormatter("##:##:##"));
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		panel_1.add(textHorasS, "cell 1 3");
		textHorasS.setColumns(10);
		
				lblAviso = new JLabel("");
				panel_1.add(lblAviso, "cell 0 4 3 1");
				lblAviso.setFont(new Font("Tahoma", Font.PLAIN, 14));

		btnVoltar = new JButton("Voltar");
		add(btnVoltar, "flowx,cell 0 6,alignx center");

		btnVoltar.setFont(new Font("Tahoma", Font.PLAIN, 14));

		btnAtualizar = new JButton("Atualizar");
		add(btnAtualizar, "cell 0 6");

		btnAtualizar.setEnabled(false);
		btnAtualizar.setFont(new Font("Tahoma", Font.PLAIN, 14));

		btnLimpar = new JButton("Limpar");
		add(btnLimpar, "cell 0 6,alignx center");

		btnLimpar.setFont(new Font("Tahoma", Font.PLAIN, 14));

	}

	// getters e setters dos componentes da tela
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

	// torna o botão de atualizar visivel ao encontrar paciente com cpf
	// informado
	public void tornarBotaoVisivel() {
		btnAtualizar.setEnabled(true);
	}

	// torna o botão de atualizar invisivel quando não encontrar paciente com
	// cpf
	// informado
	public void tornarBotaoInvisivel() {
		btnAtualizar.setEnabled(false);
	}
}
