import java.time.LocalDate;
import java.util.ArrayList;

public class Transatlantico extends Embarcacao {
	private String nome;
	private LocalDate dataInauguracao;
	private ArrayList<BoteSalvaVidas> botes = new ArrayList<>();

	public Transatlantico(String nome, LocalDate dataInauguracao, String registroCapitania, int qtdPessoas) {
		super(registroCapitania, qtdPessoas);
		this.setNome(nome);
		this.setDataInauguracao(dataInauguracao);
	}

	public void addBote(BoteSalvaVidas b) {
		botes.add(b);
	}

	public void addBote(String n, int q, boolean i, int qr, int qc) {
		BoteSalvaVidas b = new BoteSalvaVidas(n, q, i, qr, qc);
		botes.add(b);
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public LocalDate getDataInauguracao() {
		return dataInauguracao;
	}

	public void setDataInauguracao(LocalDate dataInauguracao) {
		this.dataInauguracao = dataInauguracao;
	}

	public String verificaSeguranca() {
		int qtd = 0;
		for (BoteSalvaVidas b : botes) {
			qtd += b.getQtdPessoas();
		}
		if (qtd < this.getQtdPessoas()) {
			LocalDate hoje = LocalDate.now();
			if (this.dataInauguracao.isBefore(hoje)) {
				return "CUIDADO: navio em perigo!";
			} else {
				return "ALERTA: navio necessitando de mais botes!";
			}
		} else {
			return "Está em condições adequadas de segurança.";
		}
	}

}