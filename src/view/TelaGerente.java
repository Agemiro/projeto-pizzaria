package view;

import java.awt.Graphics;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JPanel;

public class TelaGerente extends TelaPadrao{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private JButton cadastrarFuncionario;
	private JButton cadastrarCliente;
	private JButton cadastrarPizza;
	private JButton funcionarios;
	private JButton clientes;
	private JButton addSabor;
	
	public TelaGerente() {
			
		setTitle(controlFuncionario.acessaUsuarioLogado() + " (Gerente)");
        
		botoes();
		
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

	public void botoes() {
		
		cadastrarFuncionario = new BotaoPadrao("CADASTRAR FUNCIONÁRIO", 12, 126, 240, 35, Icones.ADDFUNCIONARIO);
		cadastrarFuncionario.setToolTipText("Clique para cadastrar o funcionário");
		
		cadastrarFuncionario.addActionListener(new ActionListener() {
	
			public void actionPerformed(ActionEvent e) {
				new TelaCadastroFuncionario();
			}
			
		});
		
		cadastrarCliente = new BotaoPadrao("CADASTRAR CLIENTE", 230, 126, 240, 35, Icones.ADDCLIENTE);
		cadastrarCliente.setToolTipText("Clique para cadastrar o cliente");
		
		cadastrarCliente.addActionListener(new ActionListener() {
			
			public void actionPerformed(ActionEvent e) {
				new TelaCadastroCliente();
			}
			
		});
		
		cadastrarPizza = new BotaoPadrao("CADASTRAR PIZZA", 455, 126, 240, 35, Icones.ADDPIZZA);
		cadastrarPizza.setToolTipText("Clique para cadastrar pedidos da Pizzaria");
		
		cadastrarPizza.addActionListener(new ActionListener(){
			
			public void actionPerformed(ActionEvent e) {
				new TelaCadastroPizza();
			}
			
		});
		
		funcionarios = new BotaoPadrao("FUNCIONÁRIOS", 655, 126, 240, 35, Icones.FUNCIONARIO);
		funcionarios.setToolTipText("Clique para ver os funcionários da Pizzaria");
		
		funcionarios.addActionListener(new ActionListener(){
			
			public void actionPerformed(ActionEvent e) {
				new TelaFuncionarios();
			}
			
		});
		
		clientes = new BotaoPadrao("CLIENTES", 820, 126, 240, 35, Icones.CLIENTE);
		clientes.setToolTipText("Clique para ver os clientes da Pizzaria");
		
		clientes.addActionListener(new ActionListener(){
			
			public void actionPerformed(ActionEvent e) {
				new TelaClientes();
			}
			
		});
		
		addSabor = new BotaoPadrao("DISPONILIZAR SABORES", 1020, 126, 240, 35, Icones.ADDSABOR);
		addSabor.setToolTipText("Clique para ver os clientes da Pizzaria");
		
		addSabor.addActionListener(new ActionListener(){
			
			public void actionPerformed(ActionEvent e) {
				new TelaDisponibilizaSaboresIngredientesEPreparo();
			}
			
		});

		add(cadastrarFuncionario);
		add(cadastrarCliente);
		add(cadastrarPizza);
		add(funcionarios);
		add(clientes);
		add(addSabor);
	}

	public JButton getCadastrarFuncionario() {
		return cadastrarFuncionario;
	}

	public void setCadastrarFuncionario(JButton cadastrarFuncionario) {
		this.cadastrarFuncionario = cadastrarFuncionario;
	}

	public JButton getCadastrarCliente() {
		return cadastrarCliente;
	}

	public void setCadastrarCliente(JButton cadastrarCliente) {
		this.cadastrarCliente = cadastrarCliente;
	}

	public JButton getCadastrarPizza() {
		return cadastrarPizza;
	}

	public void setCadastrarPizza(JButton cadastrarPizza) {
		this.cadastrarPizza = cadastrarPizza;
	}
	
}
