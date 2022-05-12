package objetos;

public class Utilizador {
	protected String nomeCompleto;
	protected String username;
	protected String senha;
	protected int anoNascimeto;
	protected String genero;
	public Utilizador(String nomeCompleto, String username, String senha, int anoNascimeto, String genero) {
		super();
		this.nomeCompleto = nomeCompleto;
		this.username = username;
		this.senha = senha;
		this.anoNascimeto = anoNascimeto;
		this.genero = genero;
	}
	public String getNomeCompleto() {
		return nomeCompleto;
	}
	public void setNomeCompleto(String nomeCompleto) {
		this.nomeCompleto = nomeCompleto;
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getSenha() {
		return senha;
	}
	public void setSenha(String senha) {
		this.senha = senha;
	}
	public int getAnoNascimeto() {
		return anoNascimeto;
	}
	public void setAnoNascimeto(int anoNascimeto) {
		this.anoNascimeto = anoNascimeto;
	}
	public String getGenero() {
		return genero;
	}
	public void setGenero(String genero) {
		this.genero = genero;
	}
	@Override
	public String toString() {
		return "Utilizador [nomeCompleto=" + nomeCompleto + ", username=" + username + ", senha=" + senha
				+ ", anoNascimeto=" + anoNascimeto + ", genero=" + genero + "]";
	}
	
	
	

}
