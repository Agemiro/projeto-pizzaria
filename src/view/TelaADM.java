package view;

import java.awt.Graphics;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
//import java.text.DateFormat;
//import java.text.SimpleDateFormat;
//import java.util.Date;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;

import view.TelaPadrao;

/* STATUS DE ADMINISTRADOR
 * SENHA COM NÍVEL ACESSO MÁXIMO
 * PODE ALTERAR INFORMAÇÕES NO SISTEMA E ACESSAR CONTABILIDADE
 */

public class TelaADM extends TelaPadrao{ //DEVE ACESSAR TODOS OS TELAS DOS FUNCIONARIOS
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 5409569894695549966L;
	private JButton cadastrar;
	private JButton contabilidade;
	private JButton gerente;
	private JButton atendente;
	private JButton motoboy;
	private JButton pizzaiolo;
	
	public TelaADM() {
				
		setTitle(controlFuncionario.acessaUsuarioLogado() + " (Administrador)");
		
		botoes();
		labels();
		
		Panel painel = new Panel();
		add(painel);
		
		this.setVisible(true);
		
	}
	
	public class Panel extends JPanel{
		/**
		 * 
		 */
		private static final long serialVersionUID = 1L;
		ImageIcon fundo =  new ImageIcon(getClass().getResource("imagem_fundo.jpg"));;

		public void paintComponent(Graphics g) {
			super.paintComponent(g);
			Image imagem = fundo.getImage();
			g.drawImage(imagem, 0,0,this);
		}
		
	}
	
	/*private String data() {
		Date date = new Date();
		DateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss");
		String formatada = dateFormat.format(data);
		return formatada;
	}*/
	
	private void labels() {
		
		//JLabel saudacao = new JLabel("Bem-vindo " + controlFuncionario.acessaUsuarioLogado().split(" ")[0]);
		JLabel saudacao = new JLabel(Icones.TERRA);
		saudacao.setBounds(1000, 50, 80, 80);
		//saudacao.setForeground(Color.WHITE);
		//saudacao.setFont(new Font("Consolas", Font.BOLD, 20));
	
		add(saudacao);
		
	}
	
	public void botoes() {
		
		cadastrar = new BotaoPadrao("CADASTRAR FUNCIONÁRIO", 12, 126, 240, 35, Icones.ADDFUNCIONARIO);
		cadastrar.setToolTipText("Clique para cadastrar um funcionário");

		gerente = new BotaoPadrao("ACESSAR GERENTE", 250, 126, 240, 35, Icones.GERENTE);
		gerente.setToolTipText("Clique para acessar a página de Gerente");
		
		atendente = new BotaoPadrao("ACESSAR ATENDENTE", 470, 126, 240, 35, Icones.ATENDENTE);
		atendente.setToolTipText("Clique para acessar a página de Atendente");
		
		motoboy = new BotaoPadrao("ACESSAR MOTOBOY", 690, 126, 240, 35, Icones.PEDIDOS_ENTREGA);
		motoboy.setToolTipText("Clique para acessar a página de Motoboy");
		
		pizzaiolo = new BotaoPadrao("ACESSAR PIZZAILO", 900, 126, 240, 35, Icones.PIZZAIOLO);
		pizzaiolo.setToolTipText("Clique para acessar a página de Pizzaiolo");
		
		contabilidade = new BotaoPadrao("CONTABILIDADE", 1120, 126, 240, 35, Icones.LUCRO);
		contabilidade.setToolTipText("Clique para ver a contabilidade");
		
		cadastrar.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e) {
				new TelaCadastroFuncionario();
			}
			
		});
		
		gerente.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e) {
				dispose();
				new TelaGerente();
			}
			
		});
		
		atendente.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e) {
				dispose();
				new TelaAtendente();
			}
			
		});
		
		motoboy.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e) {
				dispose();
				new TelaMotoboy();
			}
			
		});
		
		pizzaiolo.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e) {
				dispose();
				new TelaPizzaiolo();
			}
			
		});
		
		contabilidade.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e) {
				new TelaContabilidade();
			}
			
		});
		
		add(cadastrar);
		add(gerente);
		add(atendente);
		add(motoboy);
		add(pizzaiolo);
		add(contabilidade);
		
	}
	
}
