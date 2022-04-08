
import java.time.LocalDate;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.HashMap;

public class DataAgenda {

	// atributos
	private LocalDate data;
	private String efemeride;
	private HashMap<LocalTime, Compromisso> compromissos = new HashMap<>();

	// construtor
	public DataAgenda(LocalDate data, String efemeride) {
		super();
		this.setData(data);
		this.setEfemeride(efemeride);
	}

	// métodos
	public boolean addCompromisso(Compromisso c) {
		if (compromissos.containsKey(c.getHora())) {
			return false;
		} else {
			compromissos.put(c.getHora(), c);
			return true;
		}
	}
	
	public int getTempoMedio() {
		int tempoTotal = 0;
		for (Compromisso comp: compromissos.values()) {
			tempoTotal += comp.getTempo();
		}
		return tempoTotal / compromissos.size();
	}
	
	public ArrayList<Compromisso> getCompromissosPrioridade(char prior){
		ArrayList<Compromisso> retorno = new ArrayList<>();
		for (Compromisso comp: compromissos.values()) {
			if (comp.getPrioridade() == prior) {
				retorno.add(comp);
			}
		}
		return retorno;
	}
	
	public int getQtdCompromissosPrioridade(char prior) {
		int total = 0;
		for (Compromisso comp: compromissos.values()) {
			if (comp.getPrioridade() == prior) {
				total++;
			}
		}
		return total;
	}
	
	public Compromisso getMenorCompromisso() {
		Compromisso menor = null;
		for (Compromisso comp: compromissos.values()) {
			if (menor == null || comp.getTempo() < menor.getTempo()) {
				menor = comp;
			}
		}
		return menor;
	}

	public String mostrarCompromissos() {
		String str = "";
		for (Compromisso c: this.compromissos.values()) {
			str += "\n"+c.toString();
		}
		return str;
	}
	
	public LocalDate getData() {
		return data;
	}

	public void setData(LocalDate data) {
		if (data != null) {
			this.data = data;
		}
	}

	public String getEfemeride() {
		return efemeride;
	}

	public void setEfemeride(String efemeride) {
		this.efemeride = efemeride;
	}
}
