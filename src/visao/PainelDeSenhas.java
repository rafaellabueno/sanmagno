package visao;

import javax.swing.JPanel;
import net.miginfocom.swing.MigLayout;
import javax.swing.JLabel;
import java.awt.Font;
import java.awt.Color;
import javax.swing.JTextField;
import javax.swing.JButton;

public class PainelDeSenhas extends JPanel {
	
	//Declaração dos componentes da tela
	private JLabel lblSenhaPainel;
	private JLabel lblNomePainel; 
	private JLabel lblCpfPainel;  
	private JLabel lblAviso;
	private JButton btnTriagem; 

	/**
	 * Create the panel.
	 */
	public PainelDeSenhas() {
		setLayout(new MigLayout("", "[]", "[][][][][][][][][]"));
		
		JLabel lblPainelDeSenhas = new JLabel("Painel De Senhas");
		lblPainelDeSenhas.setForeground(new Color(0, 128, 128));
		lblPainelDeSenhas.setFont(new Font("Tahoma", Font.BOLD, 25));
		add(lblPainelDeSenhas, "cell 0 0");
		
		JLabel lblSenha = new JLabel("Senha");
		lblSenha.setFont(new Font("Tahoma", Font.PLAIN, 14));
		add(lblSenha, "flowx,cell 0 1");
		
		lblSenhaPainel = new JLabel("");
		lblSenhaPainel.setFont(new Font("Tahoma", Font.PLAIN, 50));
		add(lblSenhaPainel, "cell 0 1");
		
		JLabel lblNome = new JLabel("Nome");
		lblNome.setFont(new Font("Tahoma", Font.PLAIN, 14));
		add(lblNome, "flowx,cell 0 3");
		
		lblNomePainel = new JLabel("");
		lblNomePainel.setFont(new Font("Tahoma", Font.PLAIN, 14));
		add(lblNomePainel, "cell 0 3");
		
		JLabel lblCpf = new JLabel("CPF");
		lblCpf.setFont(new Font("Tahoma", Font.PLAIN, 14));
		add(lblCpf, "flowx,cell 0 4");
		
		lblCpfPainel = new JLabel("");
		lblCpfPainel.setFont(new Font("Tahoma", Font.PLAIN, 14));
		add(lblCpfPainel, "cell 0 4");
	    
	    lblAviso = new JLabel("");
	    lblAviso.setFont(new Font("Tahoma", Font.PLAIN, 14));
	    add(lblAviso, "cell 0 6");
		
	    btnTriagem = new JButton("Triagem");
		btnTriagem.setFont(new Font("Tahoma", Font.PLAIN, 14));
		add(btnTriagem, "cell 0 8");

	}

	//getters e setters dos componentes da tela
	public JLabel getLblSenhaPainel() {
		return lblSenhaPainel;
	}

	public void setLblSenhaPainel(JLabel lblSenhaPainel) {
		this.lblSenhaPainel = lblSenhaPainel;
	}

	public JLabel getLblNomePainel() {
		return lblNomePainel;
	}

	public void setLblNomePainel(JLabel lblNomePainel) {
		this.lblNomePainel = lblNomePainel;
	}

	public JLabel getLblCpfPainel() {
		return lblCpfPainel;
	}

	public void setLblCpfPainel(JLabel lblCpfPainel) {
		this.lblCpfPainel = lblCpfPainel;
	}

	public JButton getBtnTriagem() {
		return btnTriagem;
	}

	public void setBtnTriagem(JButton btnTriagem) {
		this.btnTriagem = btnTriagem;
	}

	public JLabel getLblAviso() {
		return lblAviso;
	}

	public void setLblAviso(JLabel lblAviso) {
		this.lblAviso = lblAviso;
	}	
}
