package view;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JFrame;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;

import controller.ControlFuncionario;

public class TelaPadrao extends JFrame{
		
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public TelaPadrao() {
						
		setSize(1366,768);
		setResizable(true);
		setLocationRelativeTo(null);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		barraMenu();
				
		this.setVisible(true);
		
	}
	
	ControlFuncionario controlFuncionario = new ControlFuncionario();
	
	private void barraMenu() {
		
		JMenuBar barraDeMenu = new JMenuBar();
		setJMenuBar(barraDeMenu);
						
		JMenuItem menuSair = new JMenuItem("Sair");
				
		menuSair.addActionListener(new ActionListener(){
			
			public void actionPerformed(ActionEvent e) {
				
				controlFuncionario.salvaUsuarioLogado("");
				dispose();
				new TelaLogin();
				
			}
		});
		
		barraDeMenu.add(menuSair);
		
	}

}
