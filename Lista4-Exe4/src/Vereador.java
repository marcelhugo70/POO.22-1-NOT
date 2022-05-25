import java.util.ArrayList;

public class Vereador {
	private String nome;
	//private int qtdProjetosApresentados;
	//private int qtdProjetosAprovados;
	private Partido partido;
	private ArrayList<ProjetoDeLei> listaProjetos = new ArrayList<>();
	
	public ArrayList<ProjetoDeLei> getListaProjetos(){
		return this.listaProjetos;
	}
	
	public void addProjeto(ProjetoDeLei p) {
		if(p == null) {
			throw new IllegalArgumentException("Não é possível adicionar um projeto nulo");
		}
		this.listaProjetos.add(p);
	}
	
	public Vereador(String nome,  Partido p) {
		this.setNome(nome);
		this.setPartido(p);
	}
	
	public void setPartido(Partido p) {
		if(p != null) {
			this.partido = p;
		}
	}
	
	public Partido getPartido() {
		return this.partido;
	}
	
	public double getDesempenho() {
		return ((double) this.getQtdProjetosAprovados()/(double) this.getQtdProjetosApresentados())*this.getIndiceTrabalho();
	}
	
	public double getIndiceTrabalho() {
		int qtd = this.getQtdProjetosApresentados();
		if(qtd == 0) {
			return 0;
		}
		if(qtd<= 5) {
			return 0.8;
		}
		if(qtd<= 10) {
			return 1;
		}
		if(qtd<= 17) {
			return 1.08;
		}
		return 1.22;
	}
	
	public String getNome() {
		return nome;
	}
	
	public void setNome(String nome) {
		if(nome != null && !nome.isEmpty()) {
			this.nome = nome;
		}
	}
	
	public int getQtdProjetosApresentados() {
		return this.listaProjetos.size();
	}
	/*
	public void setQtdProjetosApresentados() {
		if(qtdProjetosApresentados >= 0) {
			this.qtdProjetosApresentados = qtdProjetosApresentados;
		}
	}
	*/
	public int getQtdProjetosAprovados() {
		int qtd = 0;
		for(ProjetoDeLei p : listaProjetos) {
			if(p.isAprovado()) {
				qtd++;
			}
		}
		return qtd;
	}
	/*
	public void setQtdProjetosAprovados(int qtdProjetosAprovados) {
		if (qtdProjetosAprovados <= this.qtdProjetosApresentados) {
			this.qtdProjetosAprovados = qtdProjetosAprovados;
		}
	}
	*/
}
