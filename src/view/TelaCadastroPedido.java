package view;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JComboBox;
import javax.swing.JFormattedTextField;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;
import javax.swing.text.MaskFormatter;

import controller.ControlCliente;
import controller.ControlPedido;
import controller.ControlPizza;
import controller.ControlSabores;

public class TelaCadastroPedido extends TelaCadastroPadrao{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private JTextField cpf;
	private JTextField nomeCliente;
	private JTextField telefoneCliente;
	private JCheckBox pProntas;
	private JComboBox<String> escolherSabores;
	private JButton addSabor;
	private JButton removerSabor;
	private ArrayList<String> saboresEscolhidos = new ArrayList<>();
	private JComboBox<String> nFatias;
	private JCheckBox verValor; 
	private JTextField valor;
	private JComboBox<String> tamanhos; 
	private JButton cadastrarPedido;
	private DefaultTableModel modelo;
	private JTable tabela;
	
	public TelaCadastroPedido() {
		
		setTitle("Cadastro de Pedido");
        
		labels();
		campoDeDigito();
		botoes();
		tabelaSabores();
		
		this.setVisible(true);
		
	}
	
	private void labels() {
		
		JLabel cpf = new JLabel("Pesquisar cliente (CPF)"); 
		cpf.setBounds(30, 20, 180, 15);
		cpf.setFont(new Font("Arial", Font.BOLD, 15));
		cpf.setForeground(Color.BLACK);
		
		JLabel nome = new JLabel("Nome"); 
		nome.setBounds(30, 100, 180, 15);
		nome.setFont(new Font("Arial", Font.BOLD, 15));
		nome.setForeground(Color.BLACK);
		
		JLabel telefone = new JLabel("Telefone"); 
		telefone.setBounds(289, 100, 180, 15);
		telefone.setFont(new Font("Arial", Font.BOLD, 15));
		telefone.setForeground(Color.BLACK);
		
		JLabel traco = new JLabel(Icones.TRACO); 
		traco.setBounds(0, 160, 450, 15);
		traco.setForeground(Color.BLACK);
		
		JLabel sabor = new JLabel("Escolher Sabor"); 
		sabor.setBounds(30, 230, 180, 15);
		sabor.setFont(new Font("Arial", Font.BOLD, 15));
		sabor.setForeground(Color.BLACK);
		
		/*JLabel nSabor = new JLabel("Nº de Sabores"); 
		nSabor.setBounds(300, 230, 180, 15);
		nSabor.setFont(new Font("Arial", Font.BOLD, 15));
		nSabor.setForeground(Color.BLACK);*/
		
		JLabel tamanho = new JLabel("Tamanho"); 
		tamanho.setBounds(160, 340, 100, 15);
		tamanho.setFont(new Font("Arial", Font.BOLD, 15));
		tamanho.setForeground(Color.BLACK);
		
		JLabel nFatias = new JLabel("Nº de Fatias"); 
		nFatias.setBounds(30, 340, 100, 15);
		nFatias.setFont(new Font("Arial", Font.BOLD, 15));
		nFatias.setForeground(Color.BLACK);
		
		add(nome);
		add(telefone);
		add(cpf);
		add(traco);
		add(sabor);
		//add(nSabor);
		add(tamanho);
		add(nFatias);

	}
	
	public void campoDeDigito() {
		
		try {
			
			MaskFormatter maskcpf = new MaskFormatter("***.***.***-**");
		
			maskcpf.setValidCharacters("0123456789");
			
			cpf = new JFormattedTextField(maskcpf);
					
			cpf.setFont(new Font("Arial", Font.LAYOUT_LEFT_TO_RIGHT, 15));
			
			cpf.setBounds(30, 40, 120, 35);
			
		}catch(ParseException e) {}
		
		cpf.addKeyListener(new KeyListener() {
			
			@Override
			public void keyTyped(KeyEvent e) {
				// TODO Auto-generated method stub
				
			}
			
			@Override
			public void keyReleased(KeyEvent e) {
				
				ControlCliente control = new ControlCliente();
				
				try {
					
					if(!cpf.getText().equals("   .   .   -  ")) {
						nomeCliente.setText(control.procurar(cpf.getText())[0]);	
						telefoneCliente.setText(control.procurar(cpf.getText())[3]);	
					}else {
						nomeCliente.setText("");	
						telefoneCliente.setText("");	
					}                                                 
				
				}catch(NullPointerException e1) {}
				
			}
			
			@Override
			public void keyPressed(KeyEvent e) {
				// TODO Auto-generated method stub
				
			}
		});;
		
		nomeCliente = new JTextField();
		nomeCliente.setBounds(30, 120, 220, 35);
		nomeCliente.setEditable(false);
		nomeCliente.setFont(new Font("Arial", Font.LAYOUT_LEFT_TO_RIGHT, 15));
		
		telefoneCliente = new JTextField();
		telefoneCliente.setBounds(289, 120, 130, 35);
		telefoneCliente.setEditable(false);
		telefoneCliente.setFont(new Font("Arial", Font.LAYOUT_LEFT_TO_RIGHT, 15));
		
		pProntas = new JCheckBox("Ver pizzas prontas?", false);
		pProntas.setBounds(30, 180, 180, 15);
		pProntas.setForeground(Color.BLACK);//Fonte
		pProntas.setBackground(Color.LIGHT_GRAY);
		pProntas.setFont(new Font("Arial", Font.BOLD, 15));
		pProntas.addActionListener(new ActionListener(){
			
			public void actionPerformed(ActionEvent e) {
				
				if(pProntas.isSelected()) {
					
					escolherSabores.setEnabled(false);
					nFatias.setEnabled(false);
					tamanhos.setEnabled(false);
					verValor.setEnabled(false);
					addSabor.setEnabled(false);
					valor.setEnabled(false);
					new TelaEscolherPizzasProntas();
				
				}else {
					
					escolherSabores.setEnabled(true);
					nFatias.setEnabled(true);
					tamanhos.setEnabled(true);
					addSabor.setEnabled(true);
					verValor.setEnabled(true);
					valor.setEnabled(true);
					
				}
				
			}
		});
		
		
		
		ControlSabores control = new ControlSabores();
		
		ArrayList<String> sabores = new ArrayList<>();
		
		for(int i = 0; i < control.acessaSabores().size(); i++) {
			sabores.add(control.acessaSabores().get(i)[0]);
		}
				
		String[] vetor = sabores.toArray(new String[sabores.size()]);  

		escolherSabores = new JComboBox<String>(vetor); 				
		escolherSabores.setBounds(30, 250, 120, 35);
		escolherSabores.setFont(new Font("Arial", Font.LAYOUT_LEFT_TO_RIGHT, 15));
		
		String[] tamanho = {"Pequena", "Média", "Grande", "Família", "Gigante"};
		
		tamanhos = new JComboBox<String>(tamanho);
		tamanhos.setBounds(160, 360, 100, 35);
		tamanhos.setFont(new Font("Arial", Font.LAYOUT_LEFT_TO_RIGHT, 15));
		
		String[] fatias = {"6", "8", "10", "12", "16"};
		
		nFatias = new JComboBox<String>(fatias);
		nFatias.setBounds(30, 360, 50, 35);
		nFatias.setFont(new Font("Arial", Font.LAYOUT_LEFT_TO_RIGHT, 15));

		verValor = new JCheckBox("Gerar valor", false);
		verValor.setBounds(300, 340, 150, 15);
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
		valor.setBounds(320, 360, 80, 35);
		valor.setFont(new Font("Arial", Font.LAYOUT_LEFT_TO_RIGHT, 15));
		
		add(cpf);
		add(nomeCliente);
		add(telefoneCliente);
		add(pProntas);
		add(escolherSabores);
//		add(nSabores);
		add(tamanhos);
		add(nFatias);
		add(verValor);
		add(valor);
		
	}
	
	public void botoes() {
			
		cadastrarPedido = new JButton("CADASTRAR PEDIDO", Icones.OK);
		cadastrarPedido.setBounds(120, 445, 200, 35);
		cadastrarPedido.setToolTipText("Clique para cadastrar o pedido");
		
		addSabor = new JButton(Icones.ADD);
		addSabor.setOpaque(false);
		addSabor.setContentAreaFilled(false);
		addSabor.setBorderPainted(false);
		addSabor.setBounds(150, 248, 50, 40);
		addSabor.setToolTipText("Clique para adicionar o sabor");
		
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
		removerSabor.setBounds(380, 248, 32, 32);
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
		
		
		OuvinteInternoCadastrarPedido ouvintePizza = new OuvinteInternoCadastrarPedido();
		
		cadastrarPedido.addActionListener(ouvintePizza);
		
		add(cadastrarPedido);
		add(addSabor);
		add(removerSabor);
		
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
		painel.setBounds(220, 210, 150, 100);
		
		add(painel);
		
	}
	
	private class OuvinteInternoCadastrarPedido implements ActionListener{
		
		private String data() {
			Date data = new Date();
			DateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss");
			String formatada = dateFormat.format(data);
			return formatada;
		}
		
		public void actionPerformed(ActionEvent evento) {
			
			String textoBotao = evento.getActionCommand();
			
			switch (textoBotao) {
			
				case "CADASTRAR PEDIDO":
					
					boolean confere = true;
					
					String campoCpf = cpf.getText();
					
					if (campoCpf.equals("   .   .   -  ")) {
						JOptionPane.showMessageDialog(null, "CPF em branco!", "Falha", JOptionPane.ERROR_MESSAGE);
						confere = false;
						break;
					}
					
					if (nomeCliente.getText().equals("")) {
						JOptionPane.showMessageDialog(null, "Não existe nenhum cliente com esse CPF!", "Falha", JOptionPane.ERROR_MESSAGE);
						confere = false;
						break;
					}
										
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

					
					if (confere == true) {
						
						ControlPizza control1 = new ControlPizza();
						
						ControlPedido control2 = new ControlPedido();
						
						if(control1.addPizza(sabores, tamanho, fatias, preco, data())) {
							control2.addPedido(campoCpf, data());
							JOptionPane.showMessageDialog(null, "Pizza cadastrada com sucesso!", "Cadastrado", JOptionPane.INFORMATION_MESSAGE);
							dispose();
							new TelaCadastroPedido();
						}
							
					}	
					break;
			}	
		}
	}

}
