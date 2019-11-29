package visao;

import javax.swing.JPanel;
import javax.swing.JScrollPane;

import net.miginfocom.swing.MigLayout;
import javax.swing.JLabel;
import java.awt.Font;
import java.awt.Color;
import javax.swing.JComboBox;
import javax.swing.DefaultListModel;
import javax.swing.JButton;
import javax.swing.JList;
import java.awt.Scrollbar;
import java.util.Vector;

public class TelaFilasDePrioridades extends JPanel {

	//Declaração dos componentes da tela
	private JComboBox<String> comboPrioridade;
	private JButton btnPesquisarPrioridade;
	private JList list;
	private Scrollbar scrollbar;
	private DefaultListModel listModel;

	/**
	 * Create the panel.
	 */
	public TelaFilasDePrioridades() {
		setLayout(new MigLayout("", "[grow][][][]", "[][][][][][][grow]"));

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
		
		listModel = new DefaultListModel();
		list = new JList(listModel);
		add(list, "flowx,cell 0 5 4 2,grow");
		
		scrollbar = new Scrollbar();
		add(scrollbar, "cell 2 5 2 1,grow");
	}
	
	//getters e setters dos componentes da tela
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

	public JList getList() {
		return list;
	}

	public void setList(JList list) {
		this.list = list;
	}
	
	public void adicionaItem(Vector vetor) {
		list.setListData(vetor);
	}
	
}
