import java.time.LocalDate;

public class ShowMusical extends Evento
{
	private String nomeBanda;
	private String estiloMusical;

	public ShowMusical(String titulo, float valor, LocalDate data, String nomeBanda, String estiloMusical)
	{
		super(titulo, valor, data);
		setNomeBanda(nomeBanda);
		setEstiloMusical(estiloMusical);
	}

	public String getNomeBanda()
	{
		return nomeBanda;
	}

	public void setNomeBanda(String nomeBanda)
	{
		if (nomeBanda == null || nomeBanda.length() < 5)
			throw new RuntimeException("Nome da banda inválido");

		this.nomeBanda = nomeBanda;
	}

	public String getEstiloMusical()
	{
		return estiloMusical;
	}

	public void setEstiloMusical(String estiloMusical)
	{
		if (estiloMusical == null || estiloMusical.length() < 5)
			throw new RuntimeException("Estilo musical inválido");

		this.estiloMusical = estiloMusical;
	}

	public String exibir()
	{
		if (possuiAvaliacao())
			return "Show Musical " + getTitulo() + " de " + getEstiloMusical() + " de " + getNomeBanda()
					+ " com ingressos a R$ " + String.format("%.2f", getValor()) + ", contou com "
					+ getAvaliacao().getQtdPagantes() + " pagantes no dia " + getData().format(formatter)
					+ ". Opinião: " + getAvaliacao().getOpiniaoGeral() + ".";

		return "Show Musical " + getTitulo() + " de " + getEstiloMusical() + " de " + getNomeBanda()
				+ " com ingressos a R$ " + String.format("%.2f", getValor()) + ", dia " + getData().format(formatter)
				+ ". Ainda não avaliado.";
	}
}
