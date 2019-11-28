package visao;

import javax.swing.JPanel;
import java.awt.Color;
import javax.swing.JLabel;
import java.awt.Font;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.SwingConstants;
import net.miginfocom.swing.MigLayout;
import java.awt.FlowLayout;

public class TelaConfirmacao extends JPanel {

	//Declaração dos componentes da tela
	private JButton btnMenu;
	ImageIcon  imgConfirma = new ImageIcon(getClass().getResource("cadastroSucesso.png"));
	private JLabel lblConfirma;
	private JPanel panel;
	
	public TelaConfirmacao() {
		setBackground(new Color(102, 205, 170));
		setLayout(new MigLayout("", "[579px]", "[514px][23px]"));
		
		panel = new JPanel();
		panel.setBackground(new Color(102, 205, 170));
		add(panel, "cell 0 0,alignx left,aligny top");
		panel.setLayout(new MigLayout("", "[500px][61px]", "[500px]"));
				
		lblConfirma = new JLabel(new ImageIcon(TelaConfirmacao.class.getResource("/visao/cadastroSucesso.png")));
		lblConfirma.setText("");
		lblConfirma.setSize(60, 60);
		panel.add(lblConfirma, "cell 0 0,alignx center,growy");
		
		btnMenu = new JButton("Voltar");
		btnMenu.setFont(new Font("Tahoma", Font.PLAIN, 16));
		add(btnMenu, "cell 0 1,alignx center,aligny bottom");
		

	}

	//getters e setters dos componentes da tela
	public JButton getBtnMenu() {
		return btnMenu;
	}

	public void setBtnMenu(JButton btnMenu) {
		this.btnMenu = btnMenu;
	}
}
