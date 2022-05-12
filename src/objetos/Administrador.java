package objetos;

public class Administrador extends Utilizador{
	private String cargo;

	public Administrador(String nomeCompleto, String username, String senha, int anoNascimeto, String genero,
			String cargo) {
		super(nomeCompleto, username, senha, anoNascimeto, genero);
		this.cargo = cargo;
	}

	public String getCargo() {
		return cargo;
	}

	public void setCargo(String cargo) {
		this.cargo = cargo;
	}

	@Override
	public String toString() {
		return "Administrador [Cargo=" + cargo + ", Nome Completo=" + nomeCompleto + ", Username=" + username
				+ ", Senha=" + senha + ", Ano Nascimeto=" + anoNascimeto + ", Genero=" + genero + "]";
	}

	
	
}
