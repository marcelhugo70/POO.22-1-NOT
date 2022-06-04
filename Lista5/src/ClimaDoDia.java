import java.io.Serializable;
import java.time.LocalDate;

public class ClimaDoDia implements Serializable {  // contribuição do Mauricio Dill

	private LocalDate Date;
	private String ventoDirecao;
	private int ventoVelocidade;
	private int indicePluviometrico;
	private double temperatura;

	public ClimaDoDia(LocalDate date, String ventoDirecao, int ventoVelocidade, 
			int indicePluviometrico, double temperatura) {
		this.setDate(date);
		this.setVentoDirecao(ventoDirecao);
		this.setVentoVelocidade(ventoVelocidade);
		this.setTemperatura(temperatura);
		this.setIndicePluviometrico(indicePluviometrico);
	}

//METODOS GET
	public LocalDate getDate() {
		return Date;
	}

	public String getVentoDirecao() {
		return ventoDirecao;
	}

	public int getVentoVelocidade() {
		return ventoVelocidade;
	}

	public double getTemperatura() {
		return temperatura;
	}

	public int getIndicePluviometrico() {
		return indicePluviometrico;
	}

//METODOS SET
	public void setDate(LocalDate date) {
		Date = date;
	}

	public void setVentoDirecao(String ventoDirecao) {
		this.ventoDirecao = ventoDirecao;
	}

	public void setVentoVelocidade(int ventoVelocidade) {
		this.ventoVelocidade = ventoVelocidade;
	}

	public void setTemperatura(double temperatura) {
		this.temperatura = temperatura;
	}

	public void setIndicePluviometrico(int indicePluviometrico) {
		this.indicePluviometrico = indicePluviometrico;
	}

	@Override
	public String toString() {
		return "ClimaDoDia [Date=" + Date + ", ventoDirecao=" + ventoDirecao + ", ventoVelocidade=" + ventoVelocidade
				+ ", indicePluviometrico=" + indicePluviometrico + ", temperatura=" + temperatura + "]";
	}

}
