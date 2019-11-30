package visao;

import java.awt.Color;
import java.awt.Font;
import java.awt.Scrollbar;
import java.util.Vector;

import javax.swing.DefaultListModel;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JPanel;
import javax.swing.JScrollPane;

import net.miginfocom.swing.MigLayout;
import javax.swing.JFormattedTextField;

public class TelaListaAtendEncer extends JPanel {
	
	//Declaração dos componentes da tela
	private JList listNome;	
	private JList listData;	
	private DefaultListModel listModelNome;
	private DefaultListModel listModelData;
	
	/**
	 * Create the panel.
	 */
	public TelaListaAtendEncer() {
		setLayout(new MigLayout("", "[][][][][][][]", "[][][][][][][][][]"));

		JLabel lblAtendEnc = new JLabel("Lista de Atendimentos Encerrados");
		lblAtendEnc.setForeground(new Color(0, 128, 128));
		lblAtendEnc.setFont(new Font("Tahoma", Font.BOLD, 25));
		add(lblAtendEnc, "cell 0 0 7 1");
		
		JLabel lblNomeDoPaciente = new JLabel("Nome do Paciente:");
		add(lblNomeDoPaciente, "cell 1 3");
		
		JLabel lblDataDoEncerramento = new JLabel("Data:");
		add(lblDataDoEncerramento, "cell 6 3");
		
		listModelNome = new DefaultListModel();
		listNome = new JList(listModelNome);
		JScrollPane scrollPane1 = new JScrollPane();
		scrollPane1.setViewportView(listNome);
		listNome.setLayoutOrientation(JList.VERTICAL);
		add(scrollPane1, "cell 1 4 5 5,grow");
		
		listModelData = new DefaultListModel();
		listData = new JList(listModelData);
		JScrollPane scrollPane2 = new JScrollPane();
		scrollPane2.setViewportView(listData);
		listData.setLayoutOrientation(JList.VERTICAL);
		add(scrollPane2, "cell 6 4 1 5,grow");
	}

	//getters e setters dos componentes da tela
	public JList getListNome() {
		return listNome;
	}

	public void setListNome(JList listNome) {
		this.listNome = listNome;
	}

	public JList getListData() {
		return listData;
	}

	public void setListData(JList listData) {
		this.listData = listData;
	}

	public DefaultListModel getListModelNome() {
		return listModelNome;
	}

	public void setListModelNome(DefaultListModel listModelNome) {
		this.listModelNome = listModelNome;
	}

	public DefaultListModel getListModelData() {
		return listModelData;
	}

	public void setListModelData(DefaultListModel listModelData) {
		this.listModelData = listModelData;
	}
	
	public void adicionaItemNome(Vector vetor) {
		listNome.setListData(vetor);
	}
	
	public void adicionaItemData(Vector vetor) {
		listData.setListData(vetor);
	}

}
