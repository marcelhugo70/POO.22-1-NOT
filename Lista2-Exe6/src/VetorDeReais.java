
public class VetorDeReais {
	private double[] vetor;

	public VetorDeReais(int tamanho) {
		this.vetor = new double[tamanho];
	}

	// item a)
	public void setValor(double valor, int posicao) {
		this.vetor[posicao] = valor;
	}
	
	// item b)
	public int quantosPares() {
		int conta = 0;
		for (int i=0; i < vetor.length; i++) {
			int v = (int) vetor[i];  // fica apenas com a parte inteira
			if (v%2 == 0) { // é par?
				conta++;
			}
		}
		return conta;
	}
}
