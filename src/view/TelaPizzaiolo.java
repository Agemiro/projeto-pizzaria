package view;

import java.awt.Graphics;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JPanel;

public class TelaPizzaiolo extends TelaPadrao{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private JButton fazerPizza;
	private JButton cadastrarPizza;
	
	public TelaPizzaiolo() {
				
		setTitle(controlFuncionario.acessaUsuarioLogado() + " (Pizzaiolo)");
        
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
		
		fazerPizza = new BotaoPadrao("PIZZAS PARA PREPARAR", 12, 126, 240, 35, Icones.PIZZA);
		fazerPizza.setToolTipText("Clique para fazer as Pizzas");
		
		fazerPizza.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e) {
				
				new TelaPizzas();
				
			}
		});
		
		cadastrarPizza = new BotaoPadrao("CADASTRAR PIZZA", 230, 126, 240, 35, Icones.ADDPIZZA);
		cadastrarPizza.setToolTipText("Clique para cadastrar e disponibilizar pizzas feitas pela Pizzaria");
		
		cadastrarPizza.addActionListener(new ActionListener(){
			
			public void actionPerformed(ActionEvent e) {
				new TelaCadastroPizza();
			}
			
		});
		
		add(fazerPizza);
		add(cadastrarPizza);
		
	}
	
	public JButton getFazerPizzas() {
		return fazerPizza;
	}

	public void setFazerPizzas(JButton fazerPizza) {
		this.fazerPizza = fazerPizza;
	}
	
}
