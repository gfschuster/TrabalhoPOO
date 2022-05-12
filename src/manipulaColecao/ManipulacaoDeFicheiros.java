package manipulaColecao;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;

import objetos.Administrador;
import objetos.Cliente;
import objetos.Utilizador;

public class ManipulacaoDeFicheiros {
	
	public static void manipulaAdmin() {
		Object string = (new Administrador("admin", "gabriel", "gabe", 2021, "masculino", "Gerente")).toString(); 
		//gravarArquivoBinario(string, "Administracao.txt");
		ArrayList<Object> list = lerArquivoBinario("Administracao.txt");
		
		for (int i = 0; i < list.size(); i++) {
			String str = list.get(i).toString();
			System.out.println(list.get(i));

			String nomeCompleto = str.substring(str.indexOf("Username")+9, str.indexOf("Senha")-2);
			String saldo = str.substring(str.indexOf("Senha")+6, str.indexOf("Ano Nascimeto")-2);

			/*
			String username = str.substring(str.indexOf("Username")+9, str.indexOf("Senha")-2);
			String senha = str.substring(str.indexOf("Senha")+6, str.indexOf("Ano Nascimeto")-2);

			System.out.println("username: "+username);
			System.out.println("senha: "+senha);
			*/
		}
	}
	
	public static void main(String[] args) {
		Object string = (new Cliente("af", "ff", "aa", 2021, "masculino", 100)).toString(); 
		//gravarArquivoBinario(string, "Cliente.txt");
		ArrayList<Object> list = lerArquivoBinario("Cliente.txt");
		
		for (int i = 0; i < list.size(); i++) {
			String str = list.get(i).toString();
			System.out.println(list.get(i));

			String saldo= str.substring(str.indexOf("saldo=")+6, str.indexOf("Nome Completo")-2);
			String  nomeCompleto = str.substring(str.indexOf("Nome Completo")+14, str.indexOf("Username")-2);

			System.out.println("nomeCompleto: "+nomeCompleto);
			System.out.println("saldo: "+saldo);
			
		}
	}


	// desserialização: recuperando os objetos gravados no arquivo binário "nomeArq"
		  public static ArrayList<Object> lerArquivoBinario(String nomeArq) {
		    ArrayList<Object> lista = new ArrayList();
		    try {
		      File arq = new File(nomeArq);
		      if (arq.exists()) {
		         ObjectInputStream objInput = new ObjectInputStream(new FileInputStream(arq));
		         lista = (ArrayList<Object>)objInput.readObject();
		         objInput.close();
		      }
		    } catch(IOException erro1) {
		        System.out.printf("Erro: %s", erro1.getMessage());
		    } catch(ClassNotFoundException erro2) {
		        System.out.printf("Erro: %s", erro2.getMessage());
		    }

		    return(lista);
		  }

		  //metodo para acrescentar um valor a lista
		  public static void gravarArquivoBinario(Object obj, String nomeArq) {
			  	ArrayList<Object> lista =  lerArquivoBinario(nomeArq);
			  	Object string = obj.toString();
			  	lista.add(string);
			    File arq = new File(nomeArq);
			    try {
			      arq.delete();
			      arq.createNewFile();

			      ObjectOutputStream objOutput = new ObjectOutputStream(new FileOutputStream(arq));
			      objOutput.writeObject(lista);
			      objOutput.close();

			    } catch(IOException erro) {
			        System.out.printf("Erro: %s", erro.getMessage());
			    }
			  }
		  
		  
		  // Gravar lista sem precisar de aumentar um objectp
		  public static void gravarArquivoBinario(ArrayList<Object> lista, String nomeArq) {
			  	
			    File arq = new File(nomeArq);
			    try {
			      arq.delete();
			      arq.createNewFile();

			      ObjectOutputStream objOutput = new ObjectOutputStream(new FileOutputStream(arq));
			      objOutput.writeObject(lista);
			      objOutput.close();

			    } catch(IOException erro) {
			        System.out.printf("Erro: %s", erro.getMessage());
			    }
			  }
		  
		  
}
