import java.util.ArrayList;
import java.util.Collection;

public class Partido {
    private String nome;
    private int numero;
    private ArrayList<Vereador> vereadores = new ArrayList<Vereador>();
    
    public Partido(int numero, String nome) {
		super();
		this.setNome(nome);
		this.setNumero(numero);
	}
    
	public String getNome() {
        return nome;
    }
    public void setNome(String nome) {
        this.nome = nome;
    }
    public int getNumero() {
        return numero;
    }
    public void setNumero(int numero) {
        if (numero >= 10 && numero < 100) {
            this.numero = numero;
        }
    }
    
    public ArrayList<Vereador> getVereadores(){
    	return this.vereadores;   // cuidado com isso
    }
    
    public void addVereador(Vereador v) {
    	this.vereadores.add(v);
    	v.setPartido(this);
    }
    
    public Vereador getVereadorMaisProjAprovados() {
    	if (this.vereadores.size() == 0) {
    		return null;
    	}
    	Vereador verMais = this.vereadores.get(0);  // assumindo que o primeiro é o maior
    	for (Vereador v: this.vereadores) {  // for-each
            if (v.getProjetosAprovados() > verMais.getProjetosAprovados()) {
            	verMais = v;
            }
        }    	
    	return verMais;
    }
    
    public double getMediaDesempenho() {
        double soma = 0;
        for (int i = 0; i < this.vereadores.size(); i++)
            soma += this.vereadores.get(i).getDesempenho();
        return soma / this.vereadores.size();
    }
    
    public int getTotalProjetosApresentados() {
        int total = 0;
        for (Vereador v: this.vereadores) {  // for-each
            total += v.getProjetos();
        }
        return total;
    }
    
    public int getTotalProjetosAprovados() {
        int total = 0;
        for (Vereador v: this.vereadores) {  // for-each
            total += v.getProjetosAprovados();
        }
        return total;
    }
    
    public int getQtdeVereadores() {
    	return this.vereadores.size();
    }

	public ArrayList<Vereador> getVereadoresDesempAcima(double valor) {
		ArrayList<Vereador> retorno = new ArrayList<>();
		for (Vereador v: this.vereadores) {
			if (v.getDesempenho() > valor) {
				retorno.add(v);
			}
		}
		return retorno;
	}
}
