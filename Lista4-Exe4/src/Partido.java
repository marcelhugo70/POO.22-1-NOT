import java.util.ArrayList;

public class Partido {
	private int numero;
	private String nome;
	private ArrayList<Vereador> listaVereadores = new ArrayList<>();
	
	public Vereador getVereadorAtual() {
		return this.listaVereadores.get(this.listaVereadores.size()-1);
	}
	
	public ArrayList<Vereador> getListaVereadores(){
		return this.listaVereadores;
	}
	
	public int getQtdVereadores() {
		return this.listaVereadores.size();
	}
	
	public Partido (int n, String nome) {
		this.setNome(nome);
		this.setNumero(n);
	}
	
	public int getNumero() {
		return numero;
	}
	
	public void setNumero(int numero) {
		this.numero = numero;
	}
	
	public String getNome() {
		return nome;
	}
	
	public void setNome(String nome) {
		this.nome = nome;
	}
	
	public void addVereador(String nome) {
		Vereador v = new Vereador(nome, this);
		listaVereadores.add(v);
	}
	
	public int getTotalAprovados() {
		int total = 0;
		if(this.listaVereadores.size()>0) {
			for(Vereador v : listaVereadores) {
				total += v.getQtdProjetosAprovados();
			}
		}
		return total;
	}
	
	public int getTotalApresentados() {
		int total = 0;
		if(this.listaVereadores.size()>0) {
			for(Vereador v : listaVereadores) {
				total += v.getQtdProjetosApresentados();
			}
		}
		return total;
	}
	
	public Vereador getVereadorMenorDesempenho() {
		if(this.listaVereadores.size()>0) {
			Vereador menor = listaVereadores.get(0);
			for(Vereador v : listaVereadores) {
				if(menor.getDesempenho() > v.getDesempenho()) {
					menor = v;
				}
			}
			return menor;
		}
		return null;
	}
	
	public Vereador getVereadorMaisAprovados() {
		if(this.listaVereadores.size()>0) {
			Vereador maior = listaVereadores.get(0);
			for(Vereador v : listaVereadores) {
				if(maior.getQtdProjetosAprovados() < v.getQtdProjetosAprovados()) {
					maior = v;
				}
			}
			return maior;
		}
		return null;
	}
	
	public ArrayList<Vereador> getVereadoresDesempAcimaMedia(double media){
		if(listaVereadores.size()>0) {
			ArrayList<Vereador> listaAcima = new ArrayList<>();
			for(Vereador v : listaVereadores) {
				if(v.getDesempenho()>media) {
					listaAcima.add(v);
				}
			}
			return listaAcima;
		}
		return null;
	}
	
	public double getMediaDesempenho() {
		double media = 0;
		if(listaVereadores.size()>0) {
			for(Vereador v : listaVereadores) {
				media += v.getDesempenho();
			}
			media = media/listaVereadores.size();
		}
		return media;
	}
	
}
