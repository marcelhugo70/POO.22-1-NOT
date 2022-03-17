
public class Frase {
	private String texto;

	public String getTexto() {
		return texto;
	}

	public void setTexto(String texto) {
		this.texto = texto;
	}
	
	public String[] separar() {
		return this.texto.split(" ");
	}
}
