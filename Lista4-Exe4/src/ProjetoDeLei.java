import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class ProjetoDeLei {

	private String titulo;
	private LocalDate dataApresentacao;
	private LocalDate dataAprovacao;
	private long numeroProjeto;
	
	protected DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
	
	public ProjetoDeLei(String titulo, String dataApresentacao, String dataAprovacao, long numeroProjeto) {
		this.setDataApresentacao(dataApresentacao);
		this.setDataAprovacao(dataAprovacao);
		this.setTitulo(titulo);
		this.setNumeroProjeto(numeroProjeto);
	}
	
	public boolean isAprovado() {
		if(this.dataAprovacao == null) {
			return false;
		} else {
			return true;
		}
	}
	
	public String getTitulo() {
		return titulo;
	}
	
	public void setTitulo(String titulo) {
		if(titulo == null || titulo.isBlank() || titulo.isEmpty()) {
			throw new IllegalArgumentException("Título inválido");
		}
		this.titulo = titulo;
	}
	
	public LocalDate getDataApresentacao() {
		return dataApresentacao;
	}
	
	public void setDataApresentacao(String dataApresentacao) {
		this.dataApresentacao = LocalDate.parse(dataApresentacao, formatter);
	}
	
	public LocalDate getDataAprovacao() {
		return dataAprovacao;
	}
	
	public void setDataAprovacao(String dataAprovacao) {
		if(dataAprovacao == null || dataAprovacao.isBlank() || dataAprovacao.isEmpty()) {
			this.dataAprovacao = null;
		} else {
			this.dataAprovacao = LocalDate.parse(dataAprovacao, formatter);
		}
	}
	
	public long getNumeroProjeto() {
		return numeroProjeto;
	}
	
	public void setNumeroProjeto(long numeroProjeto) {
		if(numeroProjeto == 0) {
			throw new IllegalArgumentException("Número de projeto inválido!");
		}
		this.numeroProjeto = numeroProjeto;
	}
	
	public String mostrar() {
		if(this.getDataAprovacao()!= null) {
			return "Título: "+this.getTitulo()+" - Dt Apres: "+this.getDataApresentacao().format(formatter)+" Dt Aprov: "+this.getDataAprovacao().format(formatter);
		} else {
			return "Título: "+this.getTitulo()+" - Dt Apres: "+this.getDataApresentacao().format(formatter);
		}
	}
	
}
