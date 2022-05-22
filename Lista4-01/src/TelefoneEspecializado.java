import java.time.LocalDate;

public class TelefoneEspecializado extends Telefone {
	private int qtdOcorrencias;

	public TelefoneEspecializado(String numero, String nome, String endereco,
								LocalDate data, int ocorrencias) {
		super(numero, nome, endereco, data);
		this.setQtdOcorrencias(ocorrencias);
	}
	
	public int getQtdOcorrencias() {
		return qtdOcorrencias;
	}

	public void setQtdOcorrencias(int qtdOcorrencias) {
		if (qtdOcorrencias < 1) {
			throw new IllegalArgumentException("Quantidade de ocorrências deve ser maior ou igual a 1!");
		}
		this.qtdOcorrencias = qtdOcorrencias;
	}
	
	public double getValorBasico() {
		if (this.qtdOcorrencias<1001) {
			return 50;
		}
		if (this.qtdOcorrencias<5001) {
			return 67.80;
		}
		if (this.qtdOcorrencias<10001) {
			return 98.50;
		}
		if (this.qtdOcorrencias<50001) {
			return 123.90;
		}
		return 187.82;
	}
	
	public String exibir() {
		String str = "Especializado:"+super.exibir()
					+"\nQuantidade de ocorrências:"+this.qtdOcorrencias;
		return str;
	}
	
}
