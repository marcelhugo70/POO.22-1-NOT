// contribuição Mauricio Mafra Monnerat

public class Cidade
{
    private String nome;
    private String uf;
    private int popMasculina;
    private int popFeminina;
    private boolean calculado;

    public Cidade(String nome, int popMasculina, int popFeminina){
        this.setNome(nome);
        this.setPopulacaoMasculina(popMasculina);
        this.setPopulacaoFeminina(popFeminina);
    }

    public Cidade(){

    }

    public void setNome(String nome){
        this.nome = nome;
    }

    public void setUF(String uf){
        this.uf = uf;
    }

    public void setPopulacaoMasculina(int popMasculina){
        this.popMasculina = popMasculina;
    }

    public void setPopulacaoFeminina(int popFeminina){
        this.popFeminina = popFeminina;
    }

    public void setCalculado(boolean calculado){
        this.calculado = calculado;
    }
}