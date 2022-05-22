import java.time.LocalDate;

public class TelefoneComercial extends Telefone {
	private String ramoAtividade;  // atributo de instância ou atributo
	private static LocalDate dataBase = LocalDate.of(2017, 01, 01);  // atributo de classe
	
	public TelefoneComercial(String numero, String nome, 
							String endereco, LocalDate data, String ramo) {
		super(numero, nome, endereco, data);
		this.setRamoAtividade(ramo);
	}

	public String getRamoAtividade() {
		return ramoAtividade;
	}

	public void setRamoAtividade(String ramoAtividade) {
		this.ramoAtividade = ramoAtividade;
	}
	
	public double getValorBasico() {
		if (this.getDataInstalacao().isBefore(dataBase)) {
			return 25;
		}
		else {
			return 37.50;
		}
	}
	
	public String exibir() {
		String str = "Comercial:"+super.exibir()
					+"\nRamo de atividade:"+this.ramoAtividade;
		return str;
	}
}
