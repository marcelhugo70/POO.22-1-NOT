
import java.time.LocalTime;

public class Compromisso {
	private LocalTime hora;
	private String desc;
	private int tempo;
	private char prioridade;

	public Compromisso(LocalTime hora, String desc, int tempo, char prioridade) {
		this.setHora(hora);
		this.setDesc(desc);
		this.setTempo(tempo);
		this.setPrioridade(prioridade);
	}

//------------horario----------------------
	public LocalTime getHora() {
		return hora;
	}

	public void setHora(LocalTime hora) {
		this.hora = hora;
	}

//------------descricao----------------------
	public String getDesc() {
		return desc;
	}

	public void setDesc(String desc) {
		this.desc = desc;
	}

//------------tempo----------------------
	public int getTempo() {
		return tempo;
	}

	public void setTempo(int tempo) {
		if (tempo > 0) {
			this.tempo = tempo;
		}
	}

//------------prioridade----------------------
	public char getPrioridade() {
		return prioridade;
	}

	public void setPrioridade(char prioridade) {
		if (prioridade == 'A' || prioridade == 'N' || prioridade == 'B') {
			this.prioridade = prioridade;
		}
	}
	
	public String toString() {
		return this.getHora()+" Descrição:"+this.getDesc()
		+ " Duração:"+this.getTempo()+" Prior:"+this.getPrioridade();
	}
}
