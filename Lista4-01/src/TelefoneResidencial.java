import java.time.LocalDate;

public class TelefoneResidencial extends Telefone {
	private boolean conexaoInternet;

	public TelefoneResidencial(String numeroTelefone, String nomeUsuario, 
						String enderecoInstalacao, LocalDate dataInstalacao,
						boolean internet) {
		super(numeroTelefone, nomeUsuario, enderecoInstalacao, dataInstalacao);
		this.setConexaoInternet(internet);
	}
	
	public boolean isConexaoInternet() {
		return conexaoInternet;
	}

	public void setConexaoInternet(boolean conexaoInternet) {
		this.conexaoInternet = conexaoInternet;
	}
	
	public double getValorBasico() {
		return 15;
	}
	
	public String exibir() { // sobrescrita de método (override)
		String str = "Residencial "+ super.exibir()
					+"\nConexão Internet:"+(this.isConexaoInternet()?"Sim":"Não");
		return str;
	}
}
