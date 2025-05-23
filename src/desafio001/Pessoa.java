package desafio001;

public class Pessoa {
	
	private String nome;
	private int idade;
	private Sexo sexo;
	
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public int getIdade() {
		return idade;
	}
	public void setIdade(int idade) {
		this.idade = idade;
	}
	public Sexo getSexo() {
		return sexo;
	}
	public void setSexo(Sexo sexo) {
		this.sexo = sexo;
	}
	
	public String toString() {
		
		return "----------------------\n" + 
				"NOME: " + getNome() + 
				"\nIDADE: " + getIdade() +
				"\nSEXO: " + getSexo().getSexo();
	}
}
