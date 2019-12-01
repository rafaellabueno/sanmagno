package visao;

import javax.swing.JPanel;
import javax.swing.SwingConstants;

import net.miginfocom.swing.MigLayout;
import javax.swing.JLabel;
import java.awt.Font;
import java.awt.Color;

import javax.swing.ImageIcon;
import javax.swing.JButton;

public class TelaProxPac extends JPanel {

	// Declaração dos componentes da tela
	private JLabel lblNomeProx;
	private JLabel lblPrioridadeProx;
	private JLabel lblAviso;
	private JLabel label;

	/**
	 * Create the panel.
	 */
	public TelaProxPac() {
		setBackground(Color.WHITE);
		setLayout(new MigLayout("", "[97px][56px][283px][][][500px]", "[127px][][140px][][228px]"));

		JPanel panel = new JPanel();
		panel.setBackground(new Color(102, 205, 170));
		add(panel, "cell 0 0 10 1,grow");

		JPanel panel_1 = new JPanel();
		panel_1.setBackground(new Color(102, 205, 170));
		panel.add(panel_1);
		panel_1.setLayout(new MigLayout("", "[]", "[][]"));

		JLabel lblPrximoPaciente = new JLabel("Chamada De Paciente");
		panel_1.add(lblPrximoPaciente, "flowy,cell 0 0");
		lblPrximoPaciente.setForeground(new Color(255, 255, 255));
		lblPrximoPaciente.setFont(new Font("Tahoma", Font.BOLD, 25));

		label = new JLabel(new ImageIcon(TelaCadastro.class.getResource("/img/chamada.png")));
		label.setBackground(new Color(102, 205, 170));
		panel_1.add(label, "cell 0 0,alignx center");
		label.setHorizontalAlignment(SwingConstants.TRAILING);

		JPanel panel_2 = new JPanel();
		panel_2.setBackground(Color.WHITE);
		add(panel_2, "cell 0 2 6 1,alignx center,growy");
		panel_2.setLayout(new MigLayout("", "[][]", "[][][][][][]"));

		JLabel lblNome = new JLabel("Nome:");
		lblNome.setFont(new Font("Tahoma", Font.PLAIN, 14));
		panel_2.add(lblNome, "flowx,cell 0 0");

		lblNomeProx = new JLabel("");
		lblNomeProx.setForeground(new Color(102, 205, 170));
		lblNomeProx.setBackground(new Color(102, 205, 170));
		panel_2.add(lblNomeProx, "cell 1 0");
		lblNomeProx.setFont(new Font("Tahoma", Font.PLAIN, 20));

		JLabel lblPrioridade = new JLabel("Prioridade");
		panel_2.add(lblPrioridade, "cell 0 2");
		lblPrioridade.setFont(new Font("Tahoma", Font.PLAIN, 14));

		lblPrioridadeProx = new JLabel("");
		lblPrioridadeProx.setForeground(new Color(102, 205, 170));
		panel_2.add(lblPrioridadeProx, "cell 1 2");
		lblPrioridadeProx.setFont(new Font("Tahoma", Font.PLAIN, 20));

		JPanel panel_3 = new JPanel();
		panel_3.setBackground(new Color(102, 205, 170));
		add(panel_3, "cell 0 4 6 1,grow");
		
		lblAviso = new JLabel("");
	    lblAviso.setHorizontalAlignment(SwingConstants.CENTER);
	    add(lblAviso, "cell 0 3 6 1,alignx center,aligny center");
	    lblAviso.setForeground(new Color(0, 0, 0));
	    lblAviso.setFont(new Font("Tahoma", Font.BOLD, 14));

	}

	// getters e setters dos componentes da tela
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
	public JLabel getLblAviso() {
		return lblAviso;
	}

	public void setLblAviso(JLabel lblAviso) {
		this.lblAviso = lblAviso;
	}
}
