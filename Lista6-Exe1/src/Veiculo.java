import java.util.Objects;

public class Veiculo implements Comparable<Veiculo>{
	private String placa;
	private String modelo;
	private int ano;
	private String proprietario;

	public Veiculo(String placa, String modelo, int ano, String proprietario) {
		this.setAno(ano);
		this.setModelo(modelo);
		this.setPlaca(placa);
		this.setProprietario(proprietario);
	}

	public String getPlaca() {
		return placa;
	}

	public void setPlaca(String placa) {
		this.placa = placa;
	}

	public String getModelo() {
		return modelo;
	}

	public void setModelo(String modelo) {
		this.modelo = modelo;
	}

	public int getAno() {
		return ano;
	}

	public void setAno(int ano) {
		this.ano = ano;
	}

	public String getProprietario() {
		return proprietario;
	}

	public void setProprietario(String proprietario) {
		this.proprietario = proprietario;
	}

	@Override
	public String toString() {
		return "Veiculo " + this.getModelo() + ", placa " + this.getPlaca() + ", ano " + this.getAno() + ", de "
				+ this.getProprietario() + "\n";
	}

	@Override
	public int compareTo(Veiculo outro) {
		return this.getPlaca().compareTo(outro.getPlaca());
	}

	@Override
	public int hashCode() {
		return Objects.hash(placa);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Veiculo other = (Veiculo) obj;
		return Objects.equals(placa, other.placa);
	}
	
	
}