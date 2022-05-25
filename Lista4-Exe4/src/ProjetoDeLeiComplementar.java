import java.time.LocalDate;

public class ProjetoDeLeiComplementar extends ProjetoDeLei {
	private String artigoLO;
	private int qtdVotosFavoraveis;
	
	public ProjetoDeLeiComplementar(String titulo, String dataApresentacao, String dataAprovacao, long numeroProjeto, String artigoLO, int qtdVotosFavoraveis) {
		super(titulo, dataApresentacao, dataAprovacao, numeroProjeto);
		this.setArtigoLO(artigoLO);
		this.setQtdVotosFavoraveis(qtdVotosFavoraveis);	
	}

	public String getArtigoLO() {
		return artigoLO;
	}

	public void setArtigoLO(String artigoLO) {
		if(artigoLO == null || artigoLO.isBlank() || artigoLO.isEmpty()) {
			throw new IllegalArgumentException("Artigo de Lei Orgânica inválido!");
		}
		this.artigoLO = artigoLO;
	}

	public int getQtdVotosFavoraveis() {
		return qtdVotosFavoraveis;
	}

	public void setQtdVotosFavoraveis(int qtdVotosFavoraveis) {
		if(qtdVotosFavoraveis == 0) {
			throw new IllegalArgumentException("Quantidade de votos favoráveis inválido!");
		}
		this.qtdVotosFavoraveis = qtdVotosFavoraveis;
	}
	
	@Override
	public String mostrar() {
		if(this.getDataAprovacao() != null) {
			return "Título: "+this.getTitulo()+" - Dt Apres: "+this.getDataApresentacao().format(formatter)+" Dt Aprov: "+this.getDataAprovacao().format(formatter)+
				"\nArtigo de Lei Orgânica: "+this.getArtigoLO()+" - Quantidade de votos favoráveis: "+this.getQtdVotosFavoraveis();
		} else {
			return "Título: "+this.getTitulo()+" - Dt Apres: "+this.getDataApresentacao().format(formatter)+
					"\nArtigo de Lei Orgânica: "+this.getArtigoLO()+" - Quantidade de votos favoráveis: "+this.getQtdVotosFavoraveis();
		}
	}
	
}
