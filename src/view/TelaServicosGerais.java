package view;

import java.awt.Graphics;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

public class TelaServicosGerais extends TelaPadrao{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JButton limpeza;
	
	public TelaServicosGerais() {
		
		setTitle("Serviços Gerais");
        
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
		
		limpeza = new JButton("CONFIRMAR LIMPEZA", Icones.OK);
		limpeza.setBounds(680, 300, 260, 35);
		limpeza.setToolTipText("Clique para confirmar a limpeza do ambiente de trabalho");
		
		limpeza.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e) {
				JOptionPane.showMessageDialog(null, "Limpeza do ambiente de trabalho confirmada!", "Limpeza confirmada", JOptionPane.INFORMATION_MESSAGE);
			}
		});
		
		add(limpeza);
		
	}

	public JButton getLimpeza() {
		return limpeza;
	}

	public void setLimpeza(JButton limpeza) {
		this.limpeza = limpeza;
	}
	
}
