import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class Camara {
	public HashMap<Integer, Partido> partidos = new HashMap<>();	
	
	public HashMap<Integer, Partido> getPartidos(){
		return this.partidos;
	}
	
	public Camara() {
		
	}
	
	public void addPartido(int num, String nome) {
		if(num > 0) {
			Partido p = new Partido(num, nome);
			partidos.put(num, p);
		}
	}
	
	public int getTotalProjAprov() {
		if(!partidos.isEmpty()) {
			int total = 0;
			List<Partido> lista = new ArrayList<>(partidos.values());
			for(Partido p : lista) {
				total += p.getTotalAprovados();
			}
			return total;
		}
		return -1;//-1 será o parâmetro enviado para a interface caso não tenha nada no HashMap
	}
	
	public int getTotalProjApres() {
		if(!partidos.isEmpty()) {
			int total = 0;
			List<Partido> lista = new ArrayList<>(partidos.values());
			for(Partido p : lista) {
				total += p.getTotalApresentados();
			}
			return total;
		}
		return -1;//-1 será o parâmetro enviado para a interface caso não tenha nada no HashMap
	}
	
	public double getDesempMedio() {
		if(!partidos.isEmpty()) {
			double media = 0;
			int qtd = 0;
			List<Partido> lista = new ArrayList<>(partidos.values());
			for(Partido p : lista) {
				media += p.getMediaDesempenho();
				qtd += p.getQtdVereadores();
			}
			return media/qtd;
		}
		return -1;
	}
	
	public String getVereadorMaisProjAprov() {
		if(!partidos.isEmpty()) {
			List<Partido> lista = new ArrayList<>(partidos.values());
			Vereador maior = null;
			String str = "";
			for(Partido p : lista) {
				if(maior == null || p.getVereadorMaisAprovados().getQtdProjetosAprovados() > maior.getQtdProjetosAprovados()) {
					maior = p.getVereadorMaisAprovados();
					str = maior.getNome()+" ("+p.getNome()+" - "+p.getNumero()+"): "+maior.getDesempenho();
				}
			}
			return str;
		}
		return null;//null será o parâmetro enviado para a interface caso não tenha nada no HashMap
	}
	
	public String getVereadorMenorDesemp() {
		if(!partidos.isEmpty()) {
			List<Partido> lista = new ArrayList<>(partidos.values());
			Vereador menor = null;
			String str = "";
			for(Partido p : lista) {
				if(menor == null || p.getVereadorMenorDesempenho().getDesempenho() < menor.getDesempenho()) {
					menor = p.getVereadorMenorDesempenho();
					str = menor.getNome()+" ("+p.getNome()+" - "+p.getNumero()+"): "+menor.getDesempenho();
				}
			}
			return str;
		}
		return null;//null será o parâmetro enviado para a interface caso não tenha nada no HashMap
	}
	
	public String getVereadoresAcimaMedia(){
		if(!partidos.isEmpty()) {
			List<Partido> lista = new ArrayList<>(partidos.values());
			String str = "";
			for(Partido p : lista) {
				for (Vereador v : p.getVereadoresDesempAcimaMedia(this.getDesempMedio())) {
					str += v.getNome()+" ("+p.getNome()+" - "+p.getNumero()+"): "+v.getDesempenho()+"\n";
				}
			}
			return str;
		}
		return null;
	}
	
	public boolean isNumeroExistente(int n) {
		return partidos.containsKey(n);
	}
}
