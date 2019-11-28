package visao;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JFormattedTextField;
import javax.swing.JMenuBar;
import javax.swing.JMenu;
import javax.swing.JMenuItem;
import javax.swing.JLabel;
import java.awt.Font;
import java.awt.Color;
import net.miginfocom.swing.MigLayout;
import javax.swing.SwingConstants;

public class JanelaPrincipal extends JFrame {

	/**
	 * 
	 */
	//Declaração de telas e componentes da tela
	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private TelaCadastro tCad;
	private TelaConfirmacao tConfirma;
	private TelaConsulta tCon;
	private TelaFilasDePrioridades tPri;
	private PainelDeSenhas tSenha;
	private TelaTriagem tTriagem;
	private TelaProxPac tProxPac;
	private TelaAtendEncer tAtendEnc; 
	private JMenuItem menuCadastro;
	private JMenuItem menuConsulta;
	private JMenuItem mntmPainelDeSenhas;
	private JMenuItem mntmAtendEnce;
	private JMenuItem mntmFilaPrioridade;
	private JMenuItem mntmProxAtend;
	private JMenuItem mntmGerarRelatorio;

	public JanelaPrincipal() {
		setTitle("Hospital San Magno");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 550, 500);

		JMenuBar menuBar = new JMenuBar();
		menuBar.setForeground(new Color(255, 255, 255));
		menuBar.setFont(new Font("Segoe UI", Font.PLAIN, 15));
		menuBar.setBackground(new Color(255, 255, 255));
		setJMenuBar(menuBar);

		JMenu mnMenu = new JMenu("Paciente");
		menuBar.add(mnMenu);

		menuCadastro = new JMenuItem("Cadastrar Paciente");
		menuCadastro.setActionCommand("menuCad");
		mnMenu.add(menuCadastro);

		menuConsulta = new JMenuItem("Consulta");
		menuConsulta.setActionCommand("menuConsulta");
		mnMenu.add(menuConsulta);

		JMenu mnAtendimento = new JMenu("Atendimento");
		menuBar.add(mnAtendimento);

		mntmPainelDeSenhas = new JMenuItem("Painel de Senhas");
		mntmPainelDeSenhas.setActionCommand("menuSenha");
		mnAtendimento.add(mntmPainelDeSenhas);

		mntmAtendEnce = new JMenuItem("Atendimentos Encerrados");
		mntmAtendEnce.setActionCommand("menuEnce");
		mnAtendimento.add(mntmAtendEnce);

		JMenu mnPrioridade = new JMenu("Prioridade");
		menuBar.add(mnPrioridade);

		mntmFilaPrioridade = new JMenuItem("Filas de Prioridades");
		mntmFilaPrioridade.setActionCommand("menuPrioridade");
		mnPrioridade.add(mntmFilaPrioridade);

		mntmProxAtend = new JMenuItem("Próximo Atendimento");
		mntmProxAtend.setActionCommand("menuProx");
		mnPrioridade.add(mntmProxAtend);
		
		JMenu mnRelatorios = new JMenu("Relatórios");
		menuBar.add(mnRelatorios);

		mntmGerarRelatorio = new JMenuItem("Gerar Relatórios");
		mntmGerarRelatorio.setActionCommand("menuRelatorio");
		mnRelatorios.add(mntmGerarRelatorio);

		contentPane = new JPanel();
		contentPane.setBackground(new Color(224, 255, 255));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(new MigLayout("", "[424px]", "[39px][14px][39px][][][]"));
		contentPane.setLayout(new MigLayout("", "[1px][][][][][][][]", "[1px][][][][][][]"));

		JLabel labelpessoas = new JLabel(
				"Respons\u00E1veis: Guilherme Menezes, Rafaella Bueno e Vit\u00F3ria Teixeira");
		labelpessoas.setFont(new Font("Tahoma", Font.PLAIN, 9));
		contentPane.add(labelpessoas, "cell 0 0,grow");
				
		JLabel lblHospitalSanMagno = new JLabel("Hospital San Magno");
		lblHospitalSanMagno.setHorizontalAlignment(SwingConstants.CENTER);
		lblHospitalSanMagno.setForeground(new Color(0, 128, 128));
		lblHospitalSanMagno.setFont(new Font("Goudy Old Style", Font.BOLD, 36));
		contentPane.add(lblHospitalSanMagno, "cell 0 2,grow");
				
		JLabel lblSlogan = new JLabel("Sua sa\u00FAde em nossas m\u00E3os");
		lblSlogan.setFont(new Font("Tahoma", Font.PLAIN, 13));
		contentPane.add(lblSlogan, "cell 1 3,grow");

		tCad = new TelaCadastro();
		tConfirma = new TelaConfirmacao();
		tCon = new TelaConsulta();
		tSenha = new PainelDeSenhas();
		tTriagem = new TelaTriagem();
		tPri = new TelaFilasDePrioridades();
		tProxPac = new TelaProxPac();
        tAtendEnc = new TelaAtendEncer(); 
	}

	//getters e setters das telas e componentes
	public TelaCadastro getTcad() {
		return tCad;
	}

	public void setTcad(TelaCadastro tCad) {
		this.tCad = tCad;
	}

	public TelaFilasDePrioridades getTfpri() {
		return tPri;
	}

	public void setTfpri(TelaFilasDePrioridades tPri) {
		this.tPri = tPri;
	}

	public JMenuItem getMenuCadastro() {
		return menuCadastro;
	}

	public void setMenuCadastro(JMenuItem menuCadastro) {
		this.menuCadastro = menuCadastro;
	}

	public JMenuItem getMenuConsulta() {
		return menuConsulta;
	}

	public void setMenuConsulta(JMenuItem menuConsulta) {
		this.menuConsulta = menuConsulta;
	}

	public TelaConfirmacao getTconfirma() {
		return tConfirma;
	}

	public void setTconfirma(TelaConfirmacao tConfirma) {
		this.tConfirma = tConfirma;
	}

	public JPanel getjPrinc() {
		return contentPane;
	}

	public TelaConsulta getTcon() {
		return tCon;
	}

	public void setTcon(TelaConsulta tCon) {
		this.tCon = tCon;
	}

	public PainelDeSenhas getTsenha() {
		return tSenha;
	}

	public void setTsenha(PainelDeSenhas tSenha) {
		this.tSenha = tSenha;
	}

	public JMenuItem getMntmPainelDeSenhas() {
		return mntmPainelDeSenhas;
	}

	public void setMntmPainelDeSenhas(JMenuItem mntmPainelDeSenhas) {
		this.mntmPainelDeSenhas = mntmPainelDeSenhas;
	}

	public TelaTriagem getTtriagem() {
		return tTriagem;
	}

	public void setTtriagem(TelaTriagem tTriagem) {
		this.tTriagem = tTriagem;
	}

	public JMenuItem getMntmFilaPrioridade() {
		return mntmFilaPrioridade;
	}

	public void setMntmFilaPrioridade(JMenuItem mntmFilaPrioridade) {
		this.mntmFilaPrioridade = mntmFilaPrioridade;
	}

	public TelaProxPac getTproxpac() {
		return tProxPac;
	}

	public void setTproxpac(TelaProxPac tProxPac) {
		this.tProxPac = tProxPac;
	}

	public JMenuItem getMntmProxAtend() {
		return mntmProxAtend;
	}

	public void setMntmProxAtend(JMenuItem mntmProxAtend) {
		this.mntmProxAtend = mntmProxAtend;
	}

	public JMenuItem getMntmAtendEnce() {
		return mntmAtendEnce;
	}

	public void setMntmAtendEnce(JMenuItem mntmAtendEnce) {
		this.mntmAtendEnce = mntmAtendEnce;
	}

	public TelaAtendEncer getTatendenc() {
		return tAtendEnc;
	}

	public void setTatendenc(TelaAtendEncer tAtendEnc) {
		this.tAtendEnc = tAtendEnc;
	}
	
	

}
