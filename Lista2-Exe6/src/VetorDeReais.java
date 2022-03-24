
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
		for (int i = 0; i < vetor.length; i++) {
			int v = (int) vetor[i]; // fica apenas com a parte inteira
			if (v % 2 == 0) { // é par?
				conta++;
			}
		}
		return conta;
	}

	// item c)

	public int getTamanho() {
		return this.vetor.length;
	}

	public double getValor(int posicao) {
		return this.vetor[posicao];
	}

	public VetorDeReais divisao(VetorDeReais b) {
		if (this.getTamanho() != b.getTamanho()) {
			return null;
		}
		VetorDeReais novo = new VetorDeReais(this.getTamanho());

		for (int i = 0; i < this.getTamanho(); i++) {
			double valor = this.getValor(i) / b.getValor(i);
			novo.setValor(valor, i);
		}
		return novo;
	}

	public double multiplicacao(VetorDeReais outro) {
		double m = 0;

		for (int i = 0, j = outro.getTamanho() - 1; i < this.getTamanho(); i++, j--) {
			m = m + this.getValor(i) * outro.getValor(j);
		}
		return m;
	}

	public void inversao() { // Contribuição do Lucas
		double auxiliar = 0;
		for (int I = 0, posDec = this.getTamanho() - 1; I < posDec; I++, posDec--) {
			auxiliar = this.vetor[I];
			this.vetor[I] = this.vetor[posDec];
			this.vetor[posDec] = auxiliar;
		}
	}
	
	public double maiorDiferencaEntreConsecutivos() {
        double diferenca;
        double maiorDiferenca = 0;
        for (int i = 0; i < this.vetor.length - 1; i++) {
            diferenca = Math.abs(this.vetor[i] - this.vetor[i + 1]);
            if (diferenca > maiorDiferenca)
                maiorDiferenca = diferenca;
        }
        return maiorDiferenca;
    }
}
