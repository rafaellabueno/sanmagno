package visao;

import javax.swing.JPanel;
import java.awt.Color;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JButton;

public class TelaConfirmacao extends JPanel {

	//Declaração dos componentes da tela
	private JButton btnMenu;
	
	public TelaConfirmacao() {
		setBackground(new Color(224, 255, 255));
		setLayout(null);
		
		JLabel lblConfirmacao = new JLabel("Paciente foi cadastrado com sucesso!");
		lblConfirmacao.setForeground(new Color(0, 128, 128));
		lblConfirmacao.setFont(new Font("Goudy Old Style", Font.BOLD, 25));
		lblConfirmacao.setBounds(44, 31, 430, 160);
		add(lblConfirmacao);
		
		btnMenu = new JButton("Voltar");
		btnMenu.setBounds(163, 202, 132, 23);
		add(btnMenu);

	}

	//getters e setters dos componentes da tela
	public JButton getBtnMenu() {
		return btnMenu;
	}

	public void setBtnMenu(JButton btnMenu) {
		this.btnMenu = btnMenu;
	}
}
