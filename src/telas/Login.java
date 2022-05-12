package telas;

import java.awt.EventQueue;

import javax.swing.JFrame;
import java.awt.GridLayout;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPasswordField;
import javax.swing.JButton;
import javax.swing.JTextField;

import manipulaColecao.ManipulacaoDeFicheiros;
import objetos.Administrador;
import objetos.Cliente;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Font;
import java.awt.Frame;
import java.awt.Color;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.ArrayList;

public class Login {

	private JFrame frmTelaDeLogin;
	private JTextField username;
	private JPasswordField senha;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Login window = new Login();
					window.frmTelaDeLogin.setVisible(true);
					window.frmTelaDeLogin.setLocationRelativeTo(null);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public Login() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		

		// gravando o administrador padrao		
		ManipulacaoDeFicheiros.gravarArquivoBinario(new Administrador("admin", "admin", "admin", 2021, "masculino", "Gerente"), "Administracao.txt");
		ArrayList<Object> ob = ManipulacaoDeFicheiros.lerArquivoBinario("Administracao.txt");
		if (ob.size()>1) {
			ob.remove(ob.size()-1);
			ManipulacaoDeFicheiros.gravarArquivoBinario(ob, "Administracao.txt");
		}
		
		frmTelaDeLogin = new JFrame();
		frmTelaDeLogin.getContentPane().setBackground(Color.WHITE);
		frmTelaDeLogin.setTitle("Tela de login");
		frmTelaDeLogin.setBounds(100, 100, 364, 255);
		frmTelaDeLogin.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frmTelaDeLogin.getContentPane().setLayout(null);
		
		JLabel lblNewLabel = new JLabel("USERNAME:");
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lblNewLabel.setBounds(10, 43, 110, 22);
		frmTelaDeLogin.getContentPane().add(lblNewLabel);
		
		username = new JTextField();
		username.setFont(new Font("Tahoma", Font.PLAIN, 16));
		username.setBounds(125, 43, 213, 24);
		frmTelaDeLogin.getContentPane().add(username);
		username.setColumns(10);
		
		JLabel lblSenha = new JLabel("SENHA:");
		lblSenha.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lblSenha.setBounds(10, 81, 110, 22);
		frmTelaDeLogin.getContentPane().add(lblSenha);
		
		JButton btnNewButton = new JButton("ENTRAR");
		btnNewButton.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				
				// instaciamento do da classe ManipulacaoDeFicheiros 
				ManipulacaoDeFicheiros mf = new ManipulacaoDeFicheiros();
				
				//ArrayList que guiarda todos os administradores
				ArrayList<Object> administradors = mf.lerArquivoBinario("Administracao.txt");
				
				//ArrayList que guiarda todos os clientes
				ArrayList<Object> clientes= mf.lerArquivoBinario("Cliente.txt");
				
				//variavel booleana usada para verificar se as credenciais sao validas ou nao
				boolean entrou=false;
				for (int i = 0; i < administradors.size(); i++) {

					String str = administradors.get(i).toString();
					String usernameVal = str.substring(str.indexOf("Username")+9, str.indexOf("Senha")-2);
					String senhaVal = str.substring(str.indexOf("Senha")+6, str.indexOf("Ano Nascimeto")-2);

					if (administradors.get(i).toString().contains(username.getText())) {
						if (usernameVal.equals(username.getText()) && senhaVal.equals(senha.getText()) ) {
							System.out.println("entrou");
							
							//abre tela de administrador
							
							Administracao ad = new Administracao();
							ad.frame.setVisible(true);
							frmTelaDeLogin.setVisible(false);
							
							entrou=true;
							break;							
						}
					}
				}
				
				for (int i = 0; i < clientes.size(); i++) {

					String str = clientes.get(i).toString();
					
					String usernameVal = str.substring(str.indexOf("Username")+9, str.indexOf("Senha")-2);
					String senhaVal = str.substring(str.indexOf("Senha")+6, str.indexOf("Ano Nascimeto")-2);
					
					if (clientes.get(i).toString().contains(username.getText())) {
						if (usernameVal.equals(username.getText()) && senhaVal.equals(senha.getText()) ) {
							System.out.println("entrou");
							
							String saldoVal= str.substring(str.indexOf("saldo=")+6, str.indexOf("Nome Completo")-2);
							String nomeCompletoVal = str.substring(str.indexOf("Nome Completo")+14, str.indexOf("Username")-2);
														
							//abre tela do cliente
							recebe2(saldoVal, nomeCompletoVal);
							
							//fecha tela de login
							frmTelaDeLogin.setVisible(false);
							entrou=true;
							break;							
						}
					}
				}
				
				if (entrou == false) {
					JOptionPane.showMessageDialog(null, "As credenciais introduzidas sao invalidas.");
				}
			}
		});
		btnNewButton.setFont(new Font("Tahoma", Font.PLAIN, 17));
		btnNewButton.setBounds(10, 127, 328, 29);
		frmTelaDeLogin.getContentPane().add(btnNewButton);
		
		JButton btnCancelar = new JButton("CANCELAR");
		btnCancelar.setFont(new Font("Tahoma", Font.PLAIN, 17));
		btnCancelar.setBounds(10, 169, 328, 29);
		frmTelaDeLogin.getContentPane().add(btnCancelar);
		
		senha = new JPasswordField();
		senha.setBounds(125, 78, 213, 25);
		frmTelaDeLogin.getContentPane().add(senha);
	}
	

	//abre a tela do cliente
	public static void recebe2(String saldo, String nome) {
		telas.Cliente enviaFrame = null;
		if (enviaFrame == null) {
			enviaFrame=new telas.Cliente();
			enviaFrame.frame.setVisible(true);
			enviaFrame.recebe(saldo, nome);
		}else {
			enviaFrame.frame.setVisible(true);
			enviaFrame.frame.setState(telas.Cliente.NORMAl);
			enviaFrame.recebe(saldo, nome);
		}
	}
}
