
public abstract class Embarcacao implements AtivoEmRisco {
	private String registroCapitania;
	private int qtdPessoas;

	public Embarcacao(String registroCapitania, int qtdPessoas) {
		this.setRegistroCapitania(registroCapitania);
		this.setQtdPessoas(qtdPessoas);
	}

	public String getRegistroCapitania() {
		return registroCapitania;
	}

	public void setRegistroCapitania(String registroCapitania) {
		this.registroCapitania = registroCapitania;
	}

	public int getQtdPessoas() {
		return qtdPessoas;
	}

	public void setQtdPessoas(int qtdPessoas) {
		if (qtdPessoas <= 0) {
			throw new IllegalArgumentException("Quantidade inválida de pessoas");
		}
		this.qtdPessoas = qtdPessoas;
	}
	
}