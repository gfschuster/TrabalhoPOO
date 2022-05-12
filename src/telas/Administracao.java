package telas;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import java.awt.Color;
import javax.swing.JLabel;
import javax.swing.JTextField;

import manipulaColecao.ManipulacaoDeFicheiros;
import objetos.Cliente;

import javax.swing.JRadioButton;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.ArrayList;

import javax.swing.JList;
import javax.swing.JOptionPane;
import javax.swing.AbstractListModel;
import javax.swing.SwingConstants;
import java.awt.Font;
import javax.swing.JTextPane;

public class Administracao {

	JFrame frame;
	private static JTextField username;
	private static JTextField senha;
	private static JTextField saldo;
	private static JTextField nomeCompleto;
	private static JTextField anoNascimento;
	private static JTextField textField_5;
	static JTextField textField_6;
	static JTextPane mostra = new JTextPane();
	static JLabel lblGenero = new JLabel("Genero:");
	static JComboBox genero = new JComboBox();

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Administracao window = new Administracao();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public Administracao() {
		initialize();
	}
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 835, 502);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setLocationRelativeTo(null);
		frame.getContentPane().setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBackground(Color.WHITE);
		panel.setBounds(10, 25, 799, 118);
		frame.getContentPane().add(panel);
		panel.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Username:");
		lblNewLabel.setBounds(10, 11, 58, 14);
		panel.add(lblNewLabel);
		
		username = new JTextField();
		username.setBounds(88, 8, 137, 20);
		panel.add(username);
		username.setColumns(10);
		
		senha = new JTextField();
		senha.setColumns(10);
		senha.setBounds(88, 36, 137, 20);
		panel.add(senha);
		
		JLabel lblSenha = new JLabel("Senha:");
		lblSenha.setBounds(10, 39, 58, 14);
		panel.add(lblSenha);
		
		saldo = new JTextField();
		saldo.setColumns(10);
		saldo.setBounds(88, 62, 137, 20);
		panel.add(saldo);
		
		JLabel lblSaldo = new JLabel("Saldo:");
		lblSaldo.setBounds(10, 65, 58, 14);
		panel.add(lblSaldo);
		
		nomeCompleto = new JTextField();
		nomeCompleto.setColumns(10);
		nomeCompleto.setBounds(367, 11, 137, 20);
		panel.add(nomeCompleto);
		
		JLabel lblNomeCompleto = new JLabel("Nome Completo:");
		lblNomeCompleto.setBounds(266, 11, 91, 14);
		panel.add(lblNomeCompleto);
		
		anoNascimento = new JTextField();
		anoNascimento.setColumns(10);
		anoNascimento.setBounds(367, 36, 137, 20);
		panel.add(anoNascimento);
		
		JLabel lblAnoDeNascimento = new JLabel("Ano de nascimento:");
		lblAnoDeNascimento.setBounds(266, 36, 103, 14);
		panel.add(lblAnoDeNascimento);
		
		JPanel panel_1 = new JPanel();
		panel_1.setBounds(536, 11, 137, 96);
		panel.add(panel_1);
		panel_1.setLayout(null);
		
		JRadioButton gravar = new JRadioButton("GRAVAR");
		gravar.setSelected(true);
		gravar.setBounds(6, 7, 109, 23);
		panel_1.add(gravar);
		
		JRadioButton editar = new JRadioButton("EDITAR");
		editar.setBounds(6, 33, 109, 23);
		panel_1.add(editar);
		
		JButton btnNewButton = new JButton("Executar");
		btnNewButton.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				if (gravar.isSelected()) {
					ManipulacaoDeFicheiros.gravarArquivoBinario(
							new Cliente(nomeCompleto.getText(), 
									username.getText(), 
									senha.getText(), 
									(int)Double.parseDouble(anoNascimento.getText()), 
									genero.getSelectedItem().toString(), 
									Double.parseDouble(saldo.getText())), 
							"Cliente.txt");
				}else {
					
				}
				
				
				
				listarTodosClientes();
			}
		});
		btnNewButton.setBounds(6, 62, 109, 23);
		panel_1.add(btnNewButton);
		
		lblGenero.setBounds(266, 65, 91, 14);
		panel.add(lblGenero);
		
		genero.setModel(new DefaultComboBoxModel(new String[] {"Masculino", "Feminino"}));
		genero.setBounds(367, 62, 137, 20);
		panel.add(genero);
		
		JPanel panel_2 = new JPanel();
		panel_2.setBackground(Color.WHITE);
		panel_2.setBounds(10, 162, 799, 65);
		frame.getContentPane().add(panel_2);
		panel_2.setLayout(null);
		
		textField_5 = new JTextField();
		textField_5.setBounds(10, 11, 132, 20);
		textField_5.setColumns(10);
		panel_2.add(textField_5);
		
		JButton btnNewButton_1 = new JButton("Apagar");
		btnNewButton_1.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				removerCliente();
			}
		});
		btnNewButton_1.setBounds(10, 31, 132, 23);
		panel_2.add(btnNewButton_1);
		
		textField_6 = new JTextField();
		textField_6.setColumns(10);
		textField_6.setBounds(164, 11, 132, 20);
		panel_2.add(textField_6);
		
		JButton btnNewButton_1_1 = new JButton("Pesquisar");
		btnNewButton_1_1.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				pesquisaCliente();
			}
		});
		btnNewButton_1_1.setBounds(164, 31, 132, 23);
		panel_2.add(btnNewButton_1_1);
		
		JButton btnNewButton_2 = new JButton("Ver todos");
		btnNewButton_2.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				listarTodosClientes();
			}
		});
		btnNewButton_2.setBounds(367, 11, 155, 44);
		panel_2.add(btnNewButton_2);
		
		JButton btnNewButton_2_1 = new JButton("Apagar todos");
		btnNewButton_2_1.setBounds(532, 10, 150, 44);
		panel_2.add(btnNewButton_2_1);
		
		mostra.setText("asfa\r\nasfas\r\n\r\n\r\naaaf\r\naa");
		mostra.setBounds(10, 250, 799, 183);
		frame.getContentPane().add(mostra);

		gravar.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				editar.setSelected(false);
			}
		});

		editar.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				gravar.setSelected(false);
			}
		});
		
		//imprime todos os clientes
		listarTodosClientes();
	}
	
	
	//metodo para efectuar a pesquisa
	public static void pesquisaCliente() {
		ArrayList<Object>  lista = ManipulacaoDeFicheiros.lerArquivoBinario("Cliente.txt");
		String clientes="";
		for (int i = 0; i < lista.size(); i++) {
			if (lista.get(i).toString().contains(textField_6.getText())) {
				clientes = clientes+"\n";
			}
		}	
		mostra.setText(clientes);

	}
	
	private static void listarTodosClientes() {
		ArrayList<Object> list = ManipulacaoDeFicheiros.lerArquivoBinario("Cliente.txt");
		String clientes="";
		for (int i = 0; i < list.size(); i++) {
			clientes=clientes+"\n"+list.get(i).toString();
		}
		System.out.println(clientes);
		mostra.setText(clientes);
	}
	
	private static void removerCliente() {
		String nome = textField_5.getText();
		boolean removeu=false;
		ArrayList<Object> clientes = ManipulacaoDeFicheiros.lerArquivoBinario("Cliente.txt");
		
		for (int i = 0; i < clientes.size(); i++) {

			String str = clientes.get(i).toString();
			
			String nomeCompletoVal = str.substring(str.indexOf("Nome Completo")+14, str.indexOf("Username")-2);
			
			if (clientes.get(i).toString().contains(nome)) {
				if (nome.equals(nomeCompletoVal)) {
					clientes.remove(i);
					ManipulacaoDeFicheiros.gravarArquivoBinario(clientes, "Cliente.txt");
					removeu=true;
					listarTodosClientes();
					break;							
				}
			}
		}
		
		if (!removeu) {
			JOptionPane.showMessageDialog(null, "Clinte nao existe na lista");
		}
	}
}



















