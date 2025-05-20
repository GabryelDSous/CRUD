package desafio001;

public enum Sexo {

	MASCULINO("M"), FEMININO("F");
	
	private String sexo;
	Sexo(String sexo){
		this.sexo = sexo;
	}
	
	public String getSexo() {
		return sexo;
	}
	
}
