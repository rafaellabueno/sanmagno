package visao;

import javax.swing.JPanel;
import net.miginfocom.swing.MigLayout;
import javax.swing.JLabel;
import java.awt.Font;
import java.awt.Color;
import javax.swing.JButton;

public class TelaProxPac extends JPanel {
	
	//Declaração dos componentes da tela
	private JLabel lblNomeProx;
	private JLabel lblPrioridadeProx;
	private JButton btnEncerrarAtendimento; 

	/**
	 * Create the panel.
	 */
	public TelaProxPac() {
		setLayout(new MigLayout("", "[][][][][]", "[][][][][][][][][][]"));

		JLabel lblPrximoPaciente = new JLabel("Chamada De Paciente");
		lblPrximoPaciente.setForeground(new Color(0, 128, 128));
		lblPrximoPaciente.setFont(new Font("Tahoma", Font.BOLD, 25));
		add(lblPrximoPaciente, "cell 0 0");

		JLabel lblNome = new JLabel("Nome:");
		lblNome.setFont(new Font("Tahoma", Font.PLAIN, 14));
		add(lblNome, "flowx,cell 0 2");

		lblNomeProx = new JLabel("");
		lblNomeProx.setFont(new Font("Tahoma", Font.PLAIN, 20));
		add(lblNomeProx, "cell 0 2");

		JLabel lblPrioridade = new JLabel("Prioridade");
		lblPrioridade.setFont(new Font("Tahoma", Font.PLAIN, 14));
		add(lblPrioridade, "flowx,cell 0 3");

		lblPrioridadeProx = new JLabel("");
		lblPrioridadeProx.setFont(new Font("Tahoma", Font.PLAIN, 20));
		add(lblPrioridadeProx, "cell 0 3");
		
		btnEncerrarAtendimento = new JButton("Encerrar Atendimento");
		btnEncerrarAtendimento.setFont(new Font("Tahoma", Font.PLAIN, 14));
		add(btnEncerrarAtendimento, "flowx,cell 0 9");

	}

	//getters e setters dos componentes da tela
	public JLabel getLblNomeProx() {
		return lblNomeProx;
	}

	public void setLblNomeProx(JLabel lblNomeProx) {
		this.lblNomeProx = lblNomeProx;
	}

	public JLabel getLblPrioridadeProx() {
		return lblPrioridadeProx;
	}

	public void setLblPrioridadeProx(JLabel lblPrioridadeProx) {
		this.lblPrioridadeProx = lblPrioridadeProx;
	}

	public JButton getBtnEncerrarAtendimento() {
		return btnEncerrarAtendimento;
	}

	public void setBtnEncerrarAtendimento(JButton btnEncerrarAtendimento) {
		this.btnEncerrarAtendimento = btnEncerrarAtendimento;
	}

	
	
	

}
