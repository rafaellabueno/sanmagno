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
import javax.swing.border.BevelBorder;
import javax.swing.ImageIcon;

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
		setBackground(new Color(255, 255, 255));
		setLayout(new MigLayout("", "[grow]", "[grow]"));
				
				JPanel panel = new JPanel();
				panel.setBackground(new Color(102, 205, 170));
				add(panel, "cell 0 0 4 1,grow");
				
				JPanel panel_2 = new JPanel();
				panel_2.setBackground(new Color(102, 205, 170));
				panel.add(panel_2);
				panel_2.setLayout(new MigLayout("", "[]", "[]"));
		
				JLabel lblFilasDePrioridades = new JLabel("Filas de Prioridades");
				panel_2.add(lblFilasDePrioridades, "flowy,cell 0 0");
				lblFilasDePrioridades.setForeground(Color.WHITE);
				lblFilasDePrioridades.setFont(new Font("Tahoma", Font.BOLD, 25));
				
				JLabel label = new JLabel("");
				panel_2.add(label, "cell 0 0,alignx center");
				label.setIcon(new ImageIcon(TelaFilasDePrioridades.class.getResource("/img/fila.png")));
				label.setFont(new Font("Tahoma", Font.PLAIN, 12));
				
						JLabel lblSelecioneAPrioridade = new JLabel("Selecione a prioridade");
						lblSelecioneAPrioridade.setFont(new Font("Tahoma", Font.PLAIN, 14));
						add(lblSelecioneAPrioridade, "flowx,cell 0 1,growx");
		
				comboPrioridade = new JComboBox<String>();
				comboPrioridade.setFont(new Font("Tahoma", Font.PLAIN, 14));
				add(comboPrioridade, "cell 0 1,growx");
				comboPrioridade.addItem("");
				comboPrioridade.addItem("Prioridade 1");
				comboPrioridade.addItem("Prioridade 2");
				comboPrioridade.addItem("Prioridade 3");
				comboPrioridade.addItem("Prioridade 4");
				comboPrioridade.addItem("Prioridade 5");

		JLabel lblPacientes = new JLabel("Pacientes");
		lblPacientes.setFont(new Font("Tahoma", Font.PLAIN, 12));
		add(lblPacientes, "cell 0 5 4 1,alignx center");
		
		listModel = new DefaultListModel();
		list = new JList(listModel);
		list.setBorder(new BevelBorder(BevelBorder.LOWERED, new Color(102, 205, 170), new Color(102, 205, 170), new Color(102, 205, 170), new Color(102, 205, 170)));
		list.setToolTipText("");
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setViewportView(list);
		list.setLayoutOrientation(JList.VERTICAL);
		
		add(scrollPane, "flowx,cell 0 6 4 2,alignx center,aligny center");
		
		JPanel panel_1 = new JPanel();
		panel_1.setBackground(new Color(102, 205, 170));
		add(panel_1, "cell 0 8 4 1,grow");
		
				btnPesquisarPrioridade = new JButton("Pesquisar Prioridade");
				btnPesquisarPrioridade.setFont(new Font("Tahoma", Font.PLAIN, 14));
				add(btnPesquisarPrioridade, "cell 0 1 4 1,growx");
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
