import java.time.LocalDate;
import java.time.Period;

public abstract class Aluno implements Comparable<Aluno> {
	private String nome;
	private LocalDate dataNascimento;

	public Aluno(String nome, LocalDate dataNascimento) {
		super();
		this.setNome(nome);
		this.setDataNascimento(dataNascimento);
	}

	// Destrutor
	protected void finalize() throws Throwable {
		System.out.println("passando pelo destrutor do Aluno " + this.nome);
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		if (nome.length() < 5) {
			throw new IllegalArgumentException("Nome do aluno não pode ultrapassar 5 caracteres ");
		} else {
			this.nome = nome;
		}
	}

	public LocalDate getDataNascimento() {
		return dataNascimento;
	}

	public void setDataNascimento(LocalDate dataNascimento) {
		this.dataNascimento = dataNascimento;
	}

	public abstract String mostra();

	public int getIdade() {
		Period p = Period.between(this.getDataNascimento(), LocalDate.now());
		return p.getYears();
	}

	@Override
	public int compareTo(Aluno outro) {
		return this.getNome().compareTo(outro.getNome());
	}

}
