package view;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.ParseException;

import javax.swing.JButton;
import javax.swing.JFormattedTextField;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.text.MaskFormatter;

import controller.ControlCliente;

public class TelaCadastroCliente extends TelaCadastroPadrao{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private JTextField campoNome;
	private JFormattedTextField campoCpf;
	private JTextField campoEndereco;
	private JFormattedTextField campoTelefone;
	private JButton cadastrarCliente;
	
	public TelaCadastroCliente() {
		
		setTitle("Cadastro de Cliente");

		labels();
		campoDeDigito();
		botoes();
		
        this.setVisible(true);

	}
	
	private void labels() {
		
		JLabel nome = new JLabel("Nome");
		nome.setBounds(115, 40, 80, 15);
		nome.setFont(new Font("Arial", Font.BOLD, 15));
		nome.setForeground(Color.BLACK);
		
		JLabel cpf = new JLabel("CPF");
		cpf.setBounds(115, 140, 80, 15);
		cpf.setFont(new Font("Arial", Font.BOLD, 15));
		cpf.setForeground(Color.BLACK);
		
		JLabel endereco = new JLabel("Endereço");
		endereco.setBounds(115, 240, 80, 15);
		endereco.setFont(new Font("Arial", Font.BOLD, 15));
		endereco.setForeground(Color.BLACK);
		
		JLabel telefone = new JLabel("Telefone");
		telefone.setBounds(115, 340, 80, 15);
		telefone.setFont(new Font("Arial", Font.BOLD, 15));
		telefone.setForeground(Color.BLACK);

		add(nome);
		add(cpf);
		add(endereco);
		add(telefone);

	}
	
	public void campoDeDigito() {
		
		campoNome = new JTextField();
		campoNome.setBounds(115,70,220,35);
		campoNome.setFont(new Font("Arial", Font.LAYOUT_LEFT_TO_RIGHT, 15));
		
		try {
			
			MaskFormatter cpf = new MaskFormatter("***.***.***-**");
			MaskFormatter telefone = new MaskFormatter("(**) * ****-****");
		
			cpf.setValidCharacters("0123456789");
			telefone.setValidCharacters("0123456789");
			
			campoCpf = new JFormattedTextField(cpf);
			campoTelefone = new JFormattedTextField(telefone);
		
			campoCpf.setFont(new Font("Arial", Font.LAYOUT_LEFT_TO_RIGHT, 15));
			campoTelefone.setFont(new Font("Arial", Font.LAYOUT_LEFT_TO_RIGHT, 15));
			
			campoCpf.setBounds(115,170,220,35);
			campoTelefone.setBounds(115,370,220,35);
			
		}catch(ParseException e) {}
		
		campoEndereco = new JTextField();
		campoEndereco.setBounds(115,270,220,35);
		campoEndereco.setFont(new Font("Arial", Font.LAYOUT_LEFT_TO_RIGHT, 15));
		
		add(campoNome);
		add(campoCpf);
		add(campoEndereco);
		add(campoTelefone);
	
	}
	
	public void botoes() {
		
		cadastrarCliente = new JButton("CADASTRAR", Icones.CADASTRAR);
		cadastrarCliente.setBounds(155, 438, 150, 35);
		cadastrarCliente.setToolTipText("Clique para cadastrar o cliente");
		
		OuvinteInternoCadastroCliente ouvinteCliente = new OuvinteInternoCadastroCliente();
		
		cadastrarCliente.addActionListener(ouvinteCliente);

		add(cadastrarCliente);
		
	}
	
	public class OuvinteInternoCadastroCliente  implements ActionListener{
		
		public void actionPerformed(ActionEvent evento) {
			
			String label = evento.getActionCommand();
			
			switch (label) {
			
				case "CADASTRAR":
					
					boolean confere = true;
										
					String pegaNome = campoNome.getText();
								
					if (pegaNome.equals("")) {
						JOptionPane.showMessageDialog(null, "Digite o nome do cliente!", "Falha", JOptionPane.ERROR_MESSAGE);
						confere = false;
						break;
					}
					
					String pegaCpf = campoCpf.getText();	
					
					if(pegaCpf.equals("   .   .   -  ")) {
						JOptionPane.showMessageDialog(null, "Digite o CPF do cliente!", "Falha", JOptionPane.ERROR_MESSAGE);
						confere = false;
						break;
					}
					
					String pegaEndereco = campoEndereco.getText();
					
					if(pegaEndereco.equals("")) {
						JOptionPane.showMessageDialog(null, "Digite o endereço do cliente!", "Falha", JOptionPane.ERROR_MESSAGE);
						confere = false;
						break;
					}
					
					String pegaTelefone = campoTelefone.getText();
					
					if(pegaTelefone.equals("(  )       -    ")) {
						JOptionPane.showMessageDialog(null, "Digite o telefone do cliente!", "Falha", JOptionPane.ERROR_MESSAGE);
						confere = false;	
						break;
					}

					if (confere == true) {
						
						try {
							
							ControlCliente controlCliente = new ControlCliente();
							
							if(controlCliente.addCliente(pegaNome, pegaCpf, pegaEndereco, pegaTelefone) == true) {
								JOptionPane.showMessageDialog(null, "Cliente cadastrado com sucesso!", "Cadastrado", JOptionPane.INFORMATION_MESSAGE);
								dispose();
								new TelaCadastroCliente();
							}
							
						}
						catch(CPFRepetidoException e) {
							JOptionPane.showMessageDialog(null, e.getMessage(), "Falha", JOptionPane.ERROR_MESSAGE);
						}
						
					}
					
					break;
					
			}	
		}
	}

}
