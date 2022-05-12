package objetos;

public class Cliente extends Utilizador {

	private double saldo;
	
	public Cliente(String nomeCompleto, String username, String senha, int anoNascimeto, String genero, double saldo) {
		super(nomeCompleto, username, senha, anoNascimeto, genero);
		this.saldo = saldo;
	}
	public double getSaldo() {
		return saldo;
	}
	public void setSaldo(double saldo) {
		this.saldo = saldo;
	}
	
	@Override
	public String toString() {
		return "Cliente [saldo=" + saldo + ", Nome Completo=" + nomeCompleto + ", Username=" + username + ", Senha="
				+ senha + ", Ano Nascimeto=" + anoNascimeto + ", Genero=" + genero + "]";
	}
	

	
	
}
