import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class Evento
{
	private String titulo;
	private float valor;
	private LocalDate data;
	private Avaliacao avaliacao;

	protected static DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");

	public Evento(String titulo, float valor, LocalDate data)
	{
		setTitulo(titulo);
		setValor(valor);
		setData(data);
	}

	public String getTitulo()
	{
		return titulo;
	}

	public void setTitulo(String titulo)
	{
		if (titulo == null || titulo.length() < 5)
			throw new RuntimeException("T�tulo inv�lido");
		
		this.titulo = titulo;
	}

	public float getValor()
	{
		return valor;
	}

	public void setValor(float valor)
	{
		if (valor < 0f)
			throw new RuntimeException("Valor inv�lido");
		
		this.valor = valor;
	}

	public LocalDate getData()
	{
		return data;
	}

	public void setData(LocalDate data)
	{
		if (data == null)
			throw new RuntimeException("Data inv�lida");
		
		this.data = data;
	}

	public Avaliacao getAvaliacao()
	{
		return avaliacao;
	}

	public void setAvaliacao(Avaliacao avaliacao)
	{
		if (avaliacao == null)
			throw new RuntimeException("Avalia��o n�o pode ser null");
			
		this.avaliacao = avaliacao;
	}

	public String exibir()
	{
		if (possuiAvaliacao())
			return "Evento: " + getTitulo() + ", no dia " + getData().format(formatter) + ", ingressos a R$ "
					+ String.format("%.2f", getValor()) + ", teve " + getAvaliacao().getQtdPagantes()
					+ " pagantes que acharam o evento " + getAvaliacao().getOpiniaoGeral() + ".";

		return "Evento: " + getTitulo() + ", no dia " + getData().format(formatter) + ", ingressos a R$ "
				+ String.format("%.2f", getValor()) + ". Ainda n�o avaliado.";
	}

	public boolean possuiAvaliacao()
	{
		return getAvaliacao() != null;
	}
}
