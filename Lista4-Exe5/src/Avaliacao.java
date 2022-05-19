public class Avaliacao
{
	private int qtdPagantes;
	private String opiniaoGeral;
	
	public Avaliacao(int qtdPagantes, String opiniaoGeral)
	{
		setQtdPagantes(qtdPagantes);
		setOpiniaoGeral(opiniaoGeral);
	}

	public int getQtdPagantes()
	{
		return qtdPagantes;
	}

	public void setQtdPagantes(int qtdPagantes)
	{
		if (qtdPagantes < 0)
			throw new RuntimeException("Quantidade de pagantes inv�lida");
		
		this.qtdPagantes = qtdPagantes;
	}

	public String getOpiniaoGeral()
	{
		return opiniaoGeral;
	}

	public void setOpiniaoGeral(String opiniaoGeral)
	{
		if (opiniaoGeral == null || opiniaoGeral.length() < 3)
			throw new RuntimeException("Opini�o geral inv�lida");
		
		this.opiniaoGeral = opiniaoGeral;
	}
}
