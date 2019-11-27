package visao;

import javax.swing.JPanel;
import net.miginfocom.swing.MigLayout;
import javax.swing.JLabel;
import java.awt.Font;
import java.awt.Color;
import javax.swing.JComboBox;
import javax.swing.JButton;

public class TelaFilasDePrioridades extends JPanel {

	private JComboBox<String> comboPrioridade;
	private JButton btnPesquisarPrioridade;
	private JLabel lblPacientePrioridade;

	/**
	 * Create the panel.
	 */
	public TelaFilasDePrioridades() {
		setLayout(new MigLayout("", "[][][][]", "[][][][][][]"));

		JLabel lblFilasDePrioridades = new JLabel("Filas de Prioridades");
		lblFilasDePrioridades.setForeground(new Color(0, 128, 128));
		lblFilasDePrioridades.setFont(new Font("Tahoma", Font.BOLD, 25));
		add(lblFilasDePrioridades, "cell 0 0");

		JLabel lblSelecioneAPrioridade = new JLabel("Selecione a prioridade");
		lblSelecioneAPrioridade.setFont(new Font("Tahoma", Font.PLAIN, 14));
		add(lblSelecioneAPrioridade, "flowx,cell 0 2");

		comboPrioridade = new JComboBox<String>();
		comboPrioridade.setFont(new Font("Tahoma", Font.PLAIN, 14));
		add(comboPrioridade, "cell 0 2,growx");
		comboPrioridade.addItem("");
		comboPrioridade.addItem("Prioridade 1");
		comboPrioridade.addItem("Prioridade 2");
		comboPrioridade.addItem("Prioridade 3");
		comboPrioridade.addItem("Prioridade 4");
		comboPrioridade.addItem("Prioridade 5");

		btnPesquisarPrioridade = new JButton("Pesquisar Prioridade");
		btnPesquisarPrioridade.setFont(new Font("Tahoma", Font.PLAIN, 14));
		add(btnPesquisarPrioridade, "cell 1 2,growx");

		JLabel lblPacientes = new JLabel("Pacientes");
		lblPacientes.setFont(new Font("Tahoma", Font.PLAIN, 12));
		add(lblPacientes, "cell 0 4");

		lblPacientePrioridade = new JLabel("");
		lblPacientePrioridade.setFont(new Font("Tahoma", Font.PLAIN, 12));
		add(lblPacientePrioridade, "cell 0 5 2 1,growx");
	}

	public JComboBox<String> getComboPrioridade() {
		return comboPrioridade;
	}

	public void setComboPrioridade(JComboBox<String> comboPrioridade) {
		this.comboPrioridade = comboPrioridade;
	}

	public JButton getBtnPesquisarPrioridade() {
		return btnPesquisarPrioridade;
	}

	public void setBtnPesquisarPrioridade(JButton btnPesquisarPrioridade) {
		this.btnPesquisarPrioridade = btnPesquisarPrioridade;
	}

	public JLabel getLblPacientePrioridade() {
		return lblPacientePrioridade;
	}

	public void setLblPacientePrioridade(JLabel lblPacientePrioridade) {
		this.lblPacientePrioridade = lblPacientePrioridade;
	}

}
