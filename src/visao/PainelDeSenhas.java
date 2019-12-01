package visao;

import javax.swing.JPanel;
import net.miginfocom.swing.MigLayout;
import javax.swing.JLabel;
import java.awt.Font;
import java.awt.Color;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import java.awt.BorderLayout;
import java.awt.FlowLayout;
import javax.swing.border.BevelBorder;

public class PainelDeSenhas extends JPanel {
	
	//Declaração dos componentes da tela
	private JLabel lblSenhaPainel;
	private JLabel lblNomePainel; 
	private JLabel lblCpfPainel;  
	private JLabel lblAviso;
	private JButton btnTriagem; 
	private JPanel panel;
	private JPanel panel_2;
	private JLabel label;
	private JPanel panel_3;
	private JLabel lblNewLabel;

	/**
	 * Create the panel.
	 */
	public PainelDeSenhas() {
		setBackground(new Color(255, 255, 255));
		setLayout(new MigLayout("", "[500px]", "[127px][228px]"));
		
		panel = new JPanel();
		panel.setBackground(new Color(102, 205, 170));
		add(panel, "cell 0 0 10 1,grow");
		
		panel_3 = new JPanel();
		panel_3.setBackground(new Color(102, 205, 170));
		panel.add(panel_3);
		panel_3.setLayout(new MigLayout("", "[]", "[][]"));
		
		JLabel lblPainelDeSenhas = new JLabel("Painel De Senhas");
		panel_3.add(lblPainelDeSenhas, "flowy,cell 0 0");
		lblPainelDeSenhas.setForeground(new Color(255, 255, 255));
		lblPainelDeSenhas.setFont(new Font("Tahoma", Font.BOLD, 25));
		
		label = new JLabel(new ImageIcon(TelaCadastro.class.getResource("/img/senha.png")));
		label.setBackground(new Color(102, 205, 170));
		panel_3.add(label, "cell 0 0,alignx center");
		label.setHorizontalAlignment(SwingConstants.TRAILING);
	    
	    lblNewLabel = new JLabel("");
	    add(lblNewLabel, "cell 4 1");
	    
	    lblAviso = new JLabel("");
	    lblAviso.setHorizontalAlignment(SwingConstants.CENTER);
	    add(lblAviso, "cell 0 3 6 1,alignx center,aligny center");
	    lblAviso.setForeground(new Color(0, 0, 0));
	    lblAviso.setFont(new Font("Tahoma", Font.BOLD, 14));
	    
	    panel_2 = new JPanel();
	    panel_2.setBackground(new Color(102, 205, 170));
	    add(panel_2, "cell 0 4 6 1,grow");
	    
	    btnTriagem = new JButton("Triagem");
	    btnTriagem.setEnabled(false);
	    panel_2.add(btnTriagem);
	    btnTriagem.setFont(new Font("Tahoma", Font.PLAIN, 14));
	    
	    JPanel panel_1 = new JPanel();
	    panel_1.setBackground(Color.WHITE);
	    add(panel_1, "cell 0 2 6 1,alignx center,growy");
	    panel_1.setLayout(new MigLayout("", "[][]", "[][][][][][]"));
	    
	    JLabel lblSenha = new JLabel("Senha");
	    panel_1.add(lblSenha, "flowx,cell 0 0");
	    lblSenha.setFont(new Font("Tahoma", Font.PLAIN, 14));
	    
	    lblSenhaPainel = new JLabel("");
	    lblSenhaPainel.setBackground(new Color(102, 205, 170));
	    panel_1.add(lblSenhaPainel, "cell 1 0");
	    lblSenhaPainel.setFont(new Font("Tahoma", Font.BOLD, 45));
	    
	    JLabel lblNome = new JLabel("Nome");
	    panel_1.add(lblNome, "cell 0 2");
	    lblNome.setFont(new Font("Tahoma", Font.PLAIN, 14));
	    
	    lblNomePainel = new JLabel("");
	    lblNomePainel.setForeground(new Color(102, 205, 170));
	    panel_1.add(lblNomePainel, "cell 1 2");
	    lblNomePainel.setFont(new Font("Tahoma", Font.BOLD, 14));
	    
	    JLabel lblCpf = new JLabel("CPF");
	    panel_1.add(lblCpf, "cell 0 3");
	    lblCpf.setFont(new Font("Tahoma", Font.PLAIN, 14));
	    
	    lblCpfPainel = new JLabel("");
	    lblCpfPainel.setForeground(new Color(102, 205, 170));
	    panel_1.add(lblCpfPainel, "cell 1 3");
	    lblCpfPainel.setFont(new Font("Tahoma", Font.BOLD, 14));

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
	
	//botao da triagem só é liberado se pacientes com senha
	public void botaoTriagem() {
		btnTriagem.setEnabled(true);
	}

	// botao da triagem é ocultado
	public void botaoTriagemDesabilitar() {
		btnTriagem.setEnabled(false);
	}
}
