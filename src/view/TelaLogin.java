package view;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

import controller.ControlFuncionario;

public class TelaLogin extends JFrame {

	/**
	* 
	*/
	private static final long serialVersionUID = 1L;

	private JTextField campoID;
	private JTextField campoDeSenha;
	private JButton botaoLogin;
	private JLabel olhoFechado;

	public TelaLogin() {

		setTitle("Pizzaria - Login");
		setSize(322, 541);
		setResizable(false);
		setLocationRelativeTo(null);
		setLayout(null);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		getContentPane().setBackground(Color.LIGHT_GRAY);

		labels();
		campoDeDigito();
		botoes();

		this.setVisible(true);

	}

	private void labels() {

		JLabel cadastro = new JLabel("ID (Número inteiro)");
		cadastro.setBounds(20, 200, 180, 28);
		cadastro.setFont(new Font("Arial", Font.BOLD, 15));

		JLabel senha = new JLabel("Senha");
		senha.setBounds(20, 280, 100, 28);
		senha.setFont(new Font("Arial", Font.BOLD, 15));

		JLabel imagem = new JLabel(Icones.LOGO_PIZZA);
		imagem.setBounds(50, 26, 213, 140);

		olhoFechado = new JLabel(Icones.OLHO_FECHADO);
		olhoFechado.setBounds(250, 300, 50, 50);

		olhoFechado.addMouseListener(new OuvinteInternoOlho());

		add(cadastro);
		add(senha);
		add(imagem);
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

			String senha = campoDeSenha.getText();
			remove(campoDeSenha);

			campoDeSenha = new JTextField(senha);
			campoDeSenha.setBounds(20, 310, 220, 35);
			campoDeSenha.setFont(new Font("Arial", Font.LAYOUT_LEFT_TO_RIGHT, 15));

			add(campoDeSenha);

		}

		public void mouseReleased(MouseEvent e) {
			olhoFechado.setIcon(Icones.OLHO_FECHADO);

			String senha = campoDeSenha.getText();
			remove(campoDeSenha);

			campoDeSenha = new JPasswordField(senha);
			campoDeSenha.setBounds(20, 310, 220, 35);
			campoDeSenha.setFont(new Font("Arial", Font.LAYOUT_LEFT_TO_RIGHT, 15));

			add(campoDeSenha);

		}

	}

	private void campoDeDigito() {

		campoID = new JTextField();
		campoID.setBounds(20, 230, 220, 35);
		campoID.setFont(new Font("Arial", Font.LAYOUT_LEFT_TO_RIGHT, 15));

		campoDeSenha = new JPasswordField();
		campoDeSenha.setBounds(20, 310, 220, 35);
		campoDeSenha.setFont(new Font("Arial", Font.LAYOUT_LEFT_TO_RIGHT, 15));

		add(campoID);
		add(campoDeSenha);

	}

	private void botoes() {

		botaoLogin = new JButton("ENTRAR", Icones.ENTRAR);
		botaoLogin.setBounds(80, 400, 150, 35);
		botaoLogin.setToolTipText("Clique para fazer Login");
		botaoLogin.setBackground(Color.WHITE);

		add(botaoLogin);

		OuvinteBotaoLogin ouvinteLogin = new OuvinteBotaoLogin();

		botaoLogin.addActionListener(ouvinteLogin);

		add(botaoLogin);

	}

	private class OuvinteBotaoLogin implements ActionListener {

		public void actionPerformed(ActionEvent evento) {

			try {
				
				int id = Integer.parseInt(campoID.getText());
				String acessoSenha = campoDeSenha.getText();

				ControlFuncionario controlFunc = new ControlFuncionario();

				if (controlFunc.fazerLogin(id, acessoSenha) == null) {

					JOptionPane.showMessageDialog(null, "Funcionário não existe!", "Falha", JOptionPane.ERROR_MESSAGE);
					dispose();
					new TelaLogin();
					
				} else if (controlFunc.fazerLogin(id, acessoSenha).equalsIgnoreCase("Administrador")) {

					controlFunc.salvaUsuarioLogado(campoID.getText());
					dispose();
					new TelaADM();

				} else if (controlFunc.fazerLogin(id, acessoSenha).equalsIgnoreCase("Gerente")) {

					controlFunc.salvaUsuarioLogado(campoID.getText());
					dispose();
					new TelaGerente();

				} else if (controlFunc.fazerLogin(id, acessoSenha).equalsIgnoreCase("Atendente")) {

					controlFunc.salvaUsuarioLogado(campoID.getText());
					dispose();
					new TelaAtendente();

				} else if (controlFunc.fazerLogin(id, acessoSenha).equalsIgnoreCase("Motoboy")) {

					controlFunc.salvaUsuarioLogado(campoID.getText());
					dispose();
					new TelaMotoboy();

				} else if (controlFunc.fazerLogin(id, acessoSenha).equalsIgnoreCase("Pizzaiolo")) {

					controlFunc.salvaUsuarioLogado(campoID.getText());
					dispose();
					new TelaPizzaiolo();

				} else if (controlFunc.fazerLogin(id, acessoSenha).equalsIgnoreCase("Serviços Gerais")) {

					controlFunc.salvaUsuarioLogado(campoID.getText());
					dispose();
					new TelaServicosGerais();

				}
				
			}catch(NumberFormatException e) {
				JOptionPane.showMessageDialog(null, "Dígitos não seguem o formato ideal!", "Falha", JOptionPane.ERROR_MESSAGE);
			}

		}

	}

}
