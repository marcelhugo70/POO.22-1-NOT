
public class PassageirosHora { 

	private int[][][] passageiroHora = new int[12][30][24];

	public void adiciona(int mes, int dia, int hora) {
		this.passageiroHora[mes-1][dia-1][hora]++;
	}

	public int quantosPassageiros(int dia, int mes) {
		int qtdPassageiros = 0;
		for (int i = 0; i < 24; i++) {
			qtdPassageiros += this.passageiroHora[mes - 1][dia - 1][i];
		}
		return qtdPassageiros;
	}

	public int quantosPassageiros(int mes) {
		int qtdeMes = 0;
		for (int dia = 1; dia < 31; dia++) {
			qtdeMes += this.quantosPassageiros(dia, mes);
		}
		return qtdeMes;
	}
	
	public int mesMenorFluxo() {
		int menorMes = 1;
		int qtdMenor = this.quantosPassageiros(1);
		int qtdMes = 0;
		for (int mes = 2; mes <= 12; mes++) {
			qtdMes = this.quantosPassageiros(mes);
			if (qtdMes < qtdMenor) {
				menorMes = mes;
				qtdMenor = qtdMes;
			}
		}
		return menorMes;
	}

	public int[] picoTransporte() {
		int[] qtdPico = new int[3];
		int valorPico = 0;
		for (int m = 0; m < 12; m++) {
			for (int d = 0; d < 30; d++) {
				for (int h = 0; h < 24; h++) {
					if (this.passageiroHora[m][d][h] > valorPico) {
						valorPico = this.passageiroHora[m][d][h];
						qtdPico[0] = m + 1;
						qtdPico[1] = d + 1;
						qtdPico[2] = h;
					}
				}
			}
		}
		return qtdPico;
	}

}
