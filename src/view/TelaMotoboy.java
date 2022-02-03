package view;

import java.awt.Graphics;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JPanel;

public class TelaMotoboy extends TelaPadrao{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JButton pedidos;
	
	public TelaMotoboy() {
				
		setTitle(controlFuncionario.acessaUsuarioLogado() + " (Motoboy)");
        
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
		
		pedidos = new BotaoPadrao("PEDIDOS PARA ENTREGA", 12, 126, 240, 35, Icones.PEDIDOS_ENTREGA);
		pedidos.setToolTipText("Clique para ver ou entregar os pedidos do cliente");
		
		pedidos.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				new TelaPedidosParaEntrega();
			}
		});
		
		add(pedidos);
		
	}

	public JButton getPedidos() {
		return pedidos;
	}

	public void setPedidos(JButton pedidos) {
		this.pedidos = pedidos;
	}
	
}
