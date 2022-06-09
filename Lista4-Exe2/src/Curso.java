import java.io.Serializable;

public class Curso implements Serializable {
    private String sigla;
    private String nome;
    public Curso(String sigla, String nome) {
        super();
        this.setSigla(sigla);
        this.setNome(nome);
    }
    @Override
    protected void finalize() throws Throwable {
        System.out.println("Destruindo o curso" + this.sigla);
    }
    public String getSigla() {
        return sigla;
    }
    public void setSigla(String sigla) {
        if (sigla.length() == 3) {
            this.sigla = sigla;
        } else {
            throw new IllegalArgumentException("Sigla invalida, deve ter 3 caracteres");
        }
    }
    public String getNome() {
        return nome;
    }
    public void setNome(String nome) {
        if (nome.length() >= 5) {
            this.nome = nome;
        } else {
            throw new IllegalArgumentException("Nome invalido deve ter 5 no minimo 5 caracteres");
        }
    }
    
    public String toString() {
    	return this.sigla+"-"+this.nome;
    }
}
