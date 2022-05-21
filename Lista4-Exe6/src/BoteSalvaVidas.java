public class BoteSalvaVidas extends Embarcacao {
	private boolean inflavel;
	private int qtdRemos;
	private int qtdColetes;

	public boolean isInflavel() {
		return inflavel;
	}

	public void setInflavel(boolean inflavel) {
		this.inflavel = inflavel;
	}

	public int getQtdRemos() {
		return qtdRemos;
	}

	public void setQtdRemos(int qtdRemos) {
		this.qtdRemos = qtdRemos;
	}

	public int getQtdColetes() {
		return qtdColetes;
	}

	public void setQtdColetes(int qtdColetes) {
		this.qtdColetes = qtdColetes;
	}

	@Override
	public String verificaSeguranca() {
		if (this.getQtdColetes() >= this.getQtdPessoas()) {
			return "Bote OK!";
		} else {
			int n = this.getQtdPessoas() - this.getQtdColetes();
			return "Insuficiência de " + n + " coletes salva-vidas.";
		}
	}

	public BoteSalvaVidas(String num, int qtdPes, boolean i, int qr, int qc) {
		super(num, qtdPes);
		this.setInflavel(i);
		this.setQtdRemos(qr);
		this.setQtdColetes(qc);
	}
}
