package view;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

import controller.ControlFuncionario;

public class TelaCadastroFuncionario extends TelaCadastroPadrao{ 
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JTextField campoNome;
	private JComboBox<String> cargos;
	private JTextField campoSenha;
	private JTextField campoID;
	private JButton botaoCadastrar;
	private JLabel olhoFechado;
	
	public TelaCadastroFuncionario() {     
		
		setTitle("Cadastro de Funcionário");
        
		labels();
		campoDeDigito();
		botoes();
		
		this.setVisible(true);
		
	}
	
	public void labels() {		
		
		JLabel nome = new JLabel("Nome");
		nome.setBounds(115, 30, 180, 28);
		nome.setFont(new Font("Arial", Font.BOLD, 15));
		nome.setForeground(Color.BLACK);
		
		JLabel cargo = new JLabel("Cargo");
		cargo.setBounds(115, 120, 100, 28);
		cargo.setFont(new Font("Arial", Font.BOLD, 15));
		cargo.setForeground(Color.BLACK);
		
		JLabel senha = new JLabel("Senha");
		senha.setBounds(115, 220, 100, 28);
		senha.setFont(new Font("Arial", Font.BOLD, 15));
		senha.setForeground(Color.BLACK);
		
		JLabel id = new JLabel("ID");
		id.setBounds(115, 320, 100, 28);
		id.setFont(new Font("Arial", Font.BOLD, 15));
		id.setForeground(Color.BLACK);
		
		olhoFechado = new JLabel(Icones.OLHO_FECHADO);
		olhoFechado.setBounds(280, 250, 220, 35);
		
		olhoFechado.addMouseListener(new OuvinteInternoOlho());
				
		add(nome);
		add(cargo);
		add(senha);
		add(id);
		add(olhoFechado);
		
	}
	
	private class OuvinteInternoOlho implements MouseListener {

		public void mouseClicked(MouseEvent e) {
		}

		public void mouseEntered(MouseEvent e) {
		}

		public void mouseExited(MouseEvent e) {
		}

		public void mousePressed(MouseEvent e) {
			olhoFechado.setIcon(Icones.OLHO_ABERTO);
			
			String senha = campoSenha.getText();
			remove(campoSenha);
			
			campoSenha = new JTextField(senha);
			campoSenha.setBounds(115, 250, 220, 35);
			campoSenha.setFont(new Font("Arial", Font.LAYOUT_LEFT_TO_RIGHT, 15));
			
			add(campoSenha);

		}

		public void mouseReleased(MouseEvent e) {
			olhoFechado.setIcon(Icones.OLHO_FECHADO);
			
			String senha = campoSenha.getText();
			remove(campoSenha);
			
			campoSenha = new JPasswordField(senha);
			campoSenha.setBounds(115, 250, 220, 35);
			campoSenha.setFont(new Font("Arial", Font.LAYOUT_LEFT_TO_RIGHT, 15));
			
			add(campoSenha);
			
		}
	}
	
	public void campoDeDigito() {
		
		campoNome = new JTextField();
		campoNome.setBounds(115, 60, 220, 35);
		campoNome.setFont(new Font("Arial", Font.LAYOUT_LEFT_TO_RIGHT, 15));
		
		String[] cargo = {"Gerente", "Atendente", "Motoboy", "Pizzaiolo", "Serviços Gerais"};
		
		cargos = new JComboBox<String>(cargo);
		cargos.setBounds(115, 150, 220, 35);
		cargos.setFont(new Font("Arial", Font.LAYOUT_LEFT_TO_RIGHT, 15));
		
		/*if(cf.getUsuarioLogado().equals(cf.getAdmin().getNome())) {
			if(cf.getGerente().getNome() == null) {
				for(int i = 1; i < cargo.length; i++) { 
					cargos.removeItem(cargo[i]);
				}
			}
		}else {
			cargos.removeItemAt(0);
		}*/

		campoSenha = new JPasswordField();
		campoSenha.setBounds(115, 250, 220, 35);
		campoSenha.setFont(new Font("Arial", Font.LAYOUT_LEFT_TO_RIGHT, 15));
		
		campoID = new JTextField();
		campoID.setBounds(115, 350, 80, 35);
		campoID.setFont(new Font("Arial", Font.LAYOUT_LEFT_TO_RIGHT, 15));

		add(campoNome);
		add(cargos);
		add(campoSenha);
		add(campoID);
		
	}
	
	public void botoes() {
		
		botaoCadastrar = new JButton("CADASTRAR", Icones.CADASTRAR);
		botaoCadastrar.setBounds(155, 425, 150, 35);
		botaoCadastrar.setToolTipText("Clique para cadastrar o funcionário");
		
		OuvinteInternoCadastroFuncionario ouvinteUsuario = new OuvinteInternoCadastroFuncionario();
		
		botaoCadastrar.addActionListener(ouvinteUsuario);
		
		add(botaoCadastrar);
		
	}
	
	public class OuvinteInternoCadastroFuncionario  implements ActionListener{
		
		public void actionPerformed(ActionEvent evento) {
			
			String acessoNome = campoNome.getText();
			String acessoSenha = campoSenha.getText();
			int id = Integer.parseInt(campoID.getText());
			String acessoCargo = (String) getCargo().getSelectedItem();
						
			ControlFuncionario control = new ControlFuncionario();
			boolean confere = true;
			
			if(acessoNome.equals("")) {
				confere = false;
			}	
										
			if (acessoSenha.equals("")) {
				confere = false;
			}
			
			try {
				if(confere == true) {
					control.addFuncionario(id, acessoNome, acessoCargo, acessoSenha);
					JOptionPane.showMessageDialog(null, acessoCargo + " cadastrado com sucesso!", "Cadastrado", JOptionPane.INFORMATION_MESSAGE);
					dispose();
					new TelaCadastroFuncionario();
				}
			}catch(IDRepetidoException e) {
				JOptionPane.showMessageDialog(null, e.getMessage(), "Falha", JOptionPane.ERROR_MESSAGE);
			}
			
		}	
	}

	public JTextField getNome() {
		return campoNome;
	}
	public void setNome(JTextField nome) {
		this.campoNome = nome;
	}
	public JComboBox<String> getCargo() {
		return cargos;
	}
	public void setCargo(JComboBox<String> cargo) {
		this.cargos = cargo;
	}
	public JTextField getSenha() {
		return campoSenha;
	}
	public void setSenha(JPasswordField senha) {
		this.campoSenha = senha;
	}

}
