package visao;

import javax.swing.JPanel;
import net.miginfocom.swing.MigLayout;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.Color;

public class TelaCadastro extends JPanel {
	private JTextField textNome;
	private JTextField textCPF;
	private JTextField textData;
	private JButton btnLimpar;
	private JButton btnCadastrar;
	

	/**
	 * Create the panel.
	 */
	public TelaCadastro() {
		setLayout(new MigLayout("", "[][][][][][][][][][]", "[][][][][][][]"));
		
		JLabel lblTelaCadastro = new JLabel("Tela Cadastro");
		lblTelaCadastro.setForeground(new Color(0, 128, 128));
		lblTelaCadastro.setFont(new Font("Tahoma", Font.BOLD, 25));
		add(lblTelaCadastro, "cell 0 0");
		
		JLabel lblNome = new JLabel("Nome: ");
		lblNome.setFont(new Font("Tahoma", Font.PLAIN, 14));
		add(lblNome, "flowx,cell 0 2 2 1,alignx left");
		
		JLabel lblDataNas = new JLabel("Data de Nascimento:");
		lblDataNas.setFont(new Font("Tahoma", Font.PLAIN, 14));
		add(lblDataNas, "flowx,cell 0 4 2 1");
		
		btnCadastrar = new JButton("Cadastrar");
		add(btnCadastrar, "flowx,cell 0 6");
		
		btnLimpar = new JButton("Limpar");
		add(btnLimpar, "cell 0 6");
		
		textNome = new JTextField();
		add(textNome, "cell 0 2 4 1,alignx left,grow");
		textNome.setColumns(10);
		
		JLabel lblCPF = new JLabel("CPF:");
		lblCPF.setFont(new Font("Tahoma", Font.PLAIN, 14));
		add(lblCPF, "flowx,cell 0 3 2 1,alignx left");
		
		textCPF = new JTextField();
		add(textCPF, "flowy,cell 0 3 2 1,grow");
		textCPF.setColumns(10);
		
		textData = new JTextField();
		add(textData, "cell 0 4,grow");
		textData.setColumns(10);

	}


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
	
	

}
