package view;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;

import controller.ControlPizza;
import controller.ControlSabores;

public class TelaCadastroPizza extends TelaCadastroPadrao{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private JComboBox<String> escolherSabores;
	private JButton addSabor;
	private JButton removerSabor;
	private ArrayList<String> saboresEscolhidos = new ArrayList<>();
	private JComboBox<String> nFatias;
	private JCheckBox verValor; 
	private JTextField valor;
	private JComboBox<String> tamanhos; 
	private JButton cadastrarPizza;
	private DefaultTableModel modelo;
	private JTable tabela;

	public TelaCadastroPizza(){
		
		setTitle("Cadastro de Pizza");
		
		labels();
		campoDeDigito();
		tabelaSabores();
		botoes();
		
		this.setVisible(true);
		
	}
	
	private void labels() {
		
		JLabel sabor = new JLabel("Sabores"); 
		sabor.setBounds(30, 40, 180, 15);
		sabor.setFont(new Font("Arial", Font.BOLD, 15));
		sabor.setForeground(Color.BLACK);
		
		JLabel tamanho = new JLabel("Tamanho"); 
		tamanho.setBounds(220, 200, 100, 15);
		tamanho.setFont(new Font("Arial", Font.BOLD, 15));
		tamanho.setForeground(Color.BLACK);
		
		JLabel nFatias = new JLabel("Nº de Fatias"); 
		nFatias.setBounds(30, 200, 100, 15);
		nFatias.setFont(new Font("Arial", Font.BOLD, 15));
		nFatias.setForeground(Color.BLACK);
		
		add(sabor);
		add(tamanho);
		add(nFatias);

	}
	
	public void campoDeDigito() {
		
		ControlSabores control = new ControlSabores();
		
		ArrayList<String> sabores = new ArrayList<>();
		
		for(int i = 0; i < control.acessaSabores().size(); i++) {
			sabores.add(control.acessaSabores().get(i)[0]);
		}
		
	//	String[] sabores = {"Atum", "Bacon", "Calabresa", "Frango", "Madalena", "Milho Verde", "Mussarela", "Napolitana", "Portuguesa", "Queijo"};
		
		String[] vetor = sabores.toArray(new String[sabores.size()]);  

		escolherSabores = new JComboBox<String>(vetor); 
		escolherSabores.setBounds(30, 60, 120, 35);
		escolherSabores.setFont(new Font("Arial", Font.LAYOUT_LEFT_TO_RIGHT, 15));
		
		String[] tamanho = {"Pequena", "Média", "Grande", "Família", "Gigante"};
		
		tamanhos = new JComboBox<String>(tamanho);
		tamanhos.setBounds(220, 220, 100, 35);
		tamanhos.setFont(new Font("Arial", Font.LAYOUT_LEFT_TO_RIGHT, 15));
		
		String[] fatias = {"6", "8", "10", "12", "16"};
		
		nFatias = new JComboBox<String>(fatias);
		nFatias.setBounds(30, 220, 50, 35);
		nFatias.setFont(new Font("Arial", Font.LAYOUT_LEFT_TO_RIGHT, 15));

		verValor = new JCheckBox("Gerar valor", false);
		verValor.setBounds(30, 310, 150, 15);
		verValor.setForeground(Color.BLACK);//Fonte
		verValor.setBackground(Color.LIGHT_GRAY);
		verValor.setFont(new Font("Arial", Font.BOLD, 15));
		
		verValor.addActionListener(new ActionListener(){
			
			public void actionPerformed(ActionEvent e) {
									
						float valorAPagar = 0;
					
						if(verValor.isSelected()) {
											
							float fatia = (float) 5.00;
						
							valorAPagar = fatia *= Integer.parseInt((String) nFatias.getSelectedItem());
						
						}
					
						valor.setText(Float.toString(valorAPagar));
				
			}
		});
		
		valor = new JTextField();
		valor.setEditable(false);
		valor.setBounds(53, 330, 80, 35);
		valor.setFont(new Font("Arial", Font.LAYOUT_LEFT_TO_RIGHT, 15));
		
		add(escolherSabores);
		add(tamanhos);
		add(nFatias);
		add(verValor);
		add(valor);
		
	}
	
	public void tabelaSabores() {
		
		modelo = new DefaultTableModel();
		tabela = new JTable(modelo);
		
		modelo.addColumn("Sabores");
		
		try {
				
			for(int i = 0; i < saboresEscolhidos.size(); i++) {
						
				Object[] coluna = new Object[modelo.getColumnCount()];
			
				coluna[0] = saboresEscolhidos.get(i); //sabor no indice 0++
							
				modelo.addRow(coluna);
				
			}
			
		}catch(NullPointerException e2) {}
		
		JScrollPane painel = new JScrollPane(tabela);
		painel.setBounds(220, 30, 150, 100);
		
		add(painel);
		
	}	
	public void botoes() {
		
		cadastrarPizza = new JButton("CADASTRAR PIZZA", Icones.OK);
		cadastrarPizza.setBounds(140, 430, 180, 35);
		cadastrarPizza.setToolTipText("Clique para cadastrar a pizza");
		
		OuvinteInternoCadastrarPizza ouvintePizza = new OuvinteInternoCadastrarPizza();
		
		cadastrarPizza.addActionListener(ouvintePizza);
		
		addSabor = new JButton(Icones.ADD);
		addSabor.setOpaque(false);
		addSabor.setContentAreaFilled(false);
		addSabor.setBorderPainted(false);
		addSabor.setBounds(160, 62, 32, 32);
		addSabor.setToolTipText("Clique para adicionar um sabor");
		
		addSabor.addActionListener(new ActionListener(){
			
			public void actionPerformed(ActionEvent e) {
				
				String sabor = (String) escolherSabores.getSelectedItem();
				
				saboresEscolhidos.add(sabor);
				
				Object[] coluna = new Object[1];
				
				coluna[0] = sabor;
								
				modelo.addRow(coluna);
				
			}
			
		});
		
		removerSabor = new JButton(Icones.REMOVER);
		removerSabor.setOpaque(false);
		removerSabor.setContentAreaFilled(false);
		removerSabor.setBorderPainted(false);
		removerSabor.setBounds(380, 62, 32, 32);
		removerSabor.setToolTipText("Clique para remover um sabor");
		
		removerSabor.addActionListener(new ActionListener(){
			
			public void actionPerformed(ActionEvent e) {
				
				int linhaSelecionada = tabela.getSelectedRow();
				
				if (linhaSelecionada == -1) {
					
					JOptionPane.showMessageDialog(null, "Nenhuma linha foi selecionada!", "Aviso", JOptionPane.WARNING_MESSAGE);
					
				} else {		
										
						String saborSelecionado = (String) tabela.getValueAt(linhaSelecionada, 0);  
						
						saboresEscolhidos.remove(saborSelecionado);
																									
						JOptionPane.showMessageDialog(null, "Sabor removido com sucesso!", "Sabor removido", JOptionPane.INFORMATION_MESSAGE);
							
						modelo.removeRow(linhaSelecionada);
						
				}
				
			}
			
		});
		
		add(cadastrarPizza);
		add(addSabor);
		add(removerSabor);
		
	}
	
	private class OuvinteInternoCadastrarPizza implements ActionListener{
		
		private String data() {
			Date data = new Date();
			DateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss");
			String formatada = dateFormat.format(data);
			return formatada;
		}
		
		public void actionPerformed(ActionEvent evento) {
			
			String textoBotao = evento.getActionCommand();
			
			switch (textoBotao) {
			
				case "CADASTRAR PIZZA":
					
					boolean confere = true;
										
					ArrayList<String> sabores = saboresEscolhidos;
					
					if(sabores.size() < 1) {
						JOptionPane.showMessageDialog(null, "Adicione pelo menos um sabor!", "Falha", JOptionPane.ERROR_MESSAGE);
						confere = false;
						break;
					}
					
				    String tamanho = (String) tamanhos.getSelectedItem();
										
					int fatias = Integer.parseInt((String) nFatias.getSelectedItem());
					
					if(!verValor.isSelected()) {
						JOptionPane.showMessageDialog(null, "Gere o valor da pizza!", "Falha", JOptionPane.ERROR_MESSAGE);
						confere = false;	
						break;
					}
					
					float preco = Float.parseFloat(valor.getText());
					
					if (confere) {
						
						ControlPizza control = new ControlPizza();
													
						if(control.addPizza(sabores, tamanho, fatias, preco, data())) {
							JOptionPane.showMessageDialog(null, "Pizza cadastrada com sucesso!", "Cadastrado", JOptionPane.INFORMATION_MESSAGE);
							dispose();
							new TelaCadastroPizza();
						}
							
					}	
					break;
			}	
		}
	}

}
