
public class Vereador { // contribui��o do Felipe
    private String nome;
    private Partido partido;
    private int projetos;
    private int projetosAprovados;
    
    public double getindiceTrabalho() {
        if (this.projetos == 0) {
            return 0.0;
        } else if (this.projetos <= 5) {
            return 0.8;
        } else if (this.projetos <= 10) {
            return 1.0;
        } else if (this.projetos <= 17) {
            return 1.00;
        } else {
            return 1.22;
        }
    }
    public double getDesempenho() {
        if (this.projetos == 0) {
            return 0;
        }
        return (this.projetosAprovados / (double) this.projetos) * getindiceTrabalho();
    }
    public String getNome() {
        return nome;
    }
    public void setNome(String nome) {
        this.nome = nome;
    }
    public Partido getPartido() {
        return partido;
    }
    public void setPartido(Partido partido) {
        this.partido = partido;
    }
    public int getProjetos() {
        return projetos;
    }
    public void setProjetos(int projetos) {
        if (projetos >= 0) {
            this.projetos = projetos;
        }
    }
    public int getProjetosAprovados() {
        return projetosAprovados;
    }
    public void setProjetosAprovados(int projetos) {
        if (projetos >= 0) {
            this.projetosAprovados = projetos;
        }
    }
}
