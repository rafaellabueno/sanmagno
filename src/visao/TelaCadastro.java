package visao;

import javax.swing.JPanel;
import net.miginfocom.swing.MigLayout;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import java.awt.Color;
import java.awt.FlowLayout;
import javax.swing.border.BevelBorder;
import javax.swing.border.SoftBevelBorder;
import javax.swing.SwingConstants;
import javax.swing.Icon;

public class TelaCadastro extends JPanel {
	
	//Declaração dos componentes da tela
	private JTextField textNome;
	private JTextField textCPF;
	private JTextField textData;
	private JButton btnLimpar;
	private JButton btnCadastrar;
	private JLabel lblAviso;
	private JPanel panel;
	private JPanel panel_1;
	private JPanel panel_2;
	private Object get;
	private JPanel panel_3;
	private JLabel lblTelaCadastro;
	private JLabel label;
	ImageIcon  imagem = new ImageIcon(getClass().getResource("user.png"));
	

	/**
	 * Create the panel.
	 */
	public TelaCadastro() {
		setBackground(new Color(255, 255, 255));
		setLayout(new MigLayout("", "[grow][][][][][][][][][]", "[grow][][][grow][][grow][][]"));
		
		panel = new JPanel();
		panel.setBackground(new Color(102, 205, 170));
		add(panel, "cell 0 0 10 1,grow");
		panel.setLayout(new FlowLayout(FlowLayout.CENTER, 5, 5));
		
		panel_3 = new JPanel();
		panel_3.setBackground(new Color(102, 205, 170));
		panel.add(panel_3);
		panel_3.setLayout(new MigLayout("", "[]", "[][]"));
		
		lblTelaCadastro = new JLabel("Tela Cadastro");
		lblTelaCadastro.setForeground(new Color(255, 255, 255));
		lblTelaCadastro.setFont(new Font("Tahoma", Font.BOLD, 25));
		panel_3.add(lblTelaCadastro, "flowy,cell 0 0");
		
		label = new JLabel(new ImageIcon(TelaCadastro.class.getResource("/visao/user.png")));
		label.setHorizontalAlignment(SwingConstants.TRAILING);
		panel_3.add(label, "cell 0 0,alignx center");
		
		panel_1 = new JPanel();
		panel_1.setBackground(new Color(255, 255, 255));
		add(panel_1, "cell 0 1 10 4,alignx center,aligny center");
		panel_1.setLayout(new MigLayout("", "[]", "[][][][][][][][]"));
		
		JLabel lblNome = new JLabel("Nome");
		panel_1.add(lblNome, "cell 0 0");
		lblNome.setFont(new Font("Tahoma", Font.PLAIN, 14));
		
		textNome = new JTextField();
		panel_1.add(textNome, "cell 0 1,growx");
		textNome.setColumns(10);
		
		JLabel lblCPF = new JLabel("CPF");
		panel_1.add(lblCPF, "cell 0 2");
		lblCPF.setFont(new Font("Tahoma", Font.PLAIN, 14));
		
		textCPF = new JTextField();
		panel_1.add(textCPF, "cell 0 3,growx");
		textCPF.setColumns(10);
		
		JLabel lblDataNas = new JLabel("Data de Nascimento");
		panel_1.add(lblDataNas, "cell 0 4");
		lblDataNas.setFont(new Font("Tahoma", Font.PLAIN, 14));
		
		textData = new JTextField();
		panel_1.add(textData, "cell 0 5,growx");
		textData.setColumns(10);
		
		btnCadastrar = new JButton("Cadastrar");
		panel_1.add(btnCadastrar, "flowx,cell 0 6");
		btnCadastrar.setFont(new Font("Tahoma", Font.PLAIN, 14));
		
		btnLimpar = new JButton("Limpar");
		panel_1.add(btnLimpar, "cell 0 6");
		btnLimpar.setFont(new Font("Tahoma", Font.PLAIN, 14));
		
		lblAviso = new JLabel("");
		panel_1.add(lblAviso, "cell 0 7");
		lblAviso.setFont(new Font("Tahoma", Font.PLAIN, 14));
		
		panel_2 = new JPanel();
		panel_2.setBackground(new Color(102, 205, 170));
		FlowLayout flowLayout_1 = (FlowLayout) panel_2.getLayout();
		add(panel_2, "cell 0 5 10 1,grow");
		
		

	}

	//getters e setters dos componentes da tela
	public JTextField getTextNome() {
		return textNome;
	}


	public void setTextNome(JTextField textNome) {
		this.textNome = textNome;
	}


	public JTextField getTextCPF() {
		return textCPF;
	}


	public void setTextCPF(JTextField textCPF) {
		this.textCPF = textCPF;
	}


	public JTextField getTextData() {
		return textData;
	}


	public void setTextData(JTextField textData) {
		this.textData = textData;
	}


	public JButton getBtnLimpar() {
		return btnLimpar;
	}


	public void setBtnLimpar(JButton btnLimpar) {
		this.btnLimpar = btnLimpar;
	}


	public JButton getBtnCadastrar() {
		return btnCadastrar;
	}


	public void setBtnCadastrar(JButton btnCadastrar) {
		this.btnCadastrar = btnCadastrar;
	}

	public JLabel getLblAviso() {
		return lblAviso;
	}


	public void setLblAviso(JLabel lblAviso) {
		this.lblAviso = lblAviso;
	}
}
