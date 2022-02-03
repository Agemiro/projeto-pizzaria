package view;

import java.awt.Color;
import java.awt.Font;

import javax.swing.ImageIcon;
import javax.swing.JButton;

public class BotaoPadrao extends JButton{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public BotaoPadrao(String texto, int x, int y, int w, int h, ImageIcon icone) {
		
		setText(texto);
		setFont(new Font("Bahnschrift", Font.BOLD, 13));
		setIcon(icone);
		setForeground(Color.BLACK);
		setBounds(x, y, w, h);
		setOpaque(false);
		setContentAreaFilled(false);
		setBorderPainted(false);
		
	}
	
}
