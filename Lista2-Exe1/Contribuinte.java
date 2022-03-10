
/**
 * Escreva uma descrição da classe Contribuinte aqui.
 * 
 * @author (seu nome) 
 * @version (um número da versão ou uma data)
 */
public class Contribuinte
{
    // atributos
    private String nome;
    private String cpf;
    private String uf;
    private double rendaAnual;

    /**
     * Construtor para objetos da classe Contribuinte
     */
    public Contribuinte(String nome, String cpf, String uf, double renda){
        this.setNome(nome);
        this.setCpf(cpf);
        this.setUf(uf);
        this.setRendaAnual(renda);
    }

    public void setNome(String nome){
        this.nome = nome;
    }

    public String getNome(){
        return this.nome;
    }

    public void setCpf(String cpf){
        this.cpf = cpf;
    }

    public String getCpf(){
        return this.cpf;
    }

    public void setUf(String uf){
        if (uf.equals("SC") 
        || uf.equals("PR")
        || uf.equals("RS")) {
            this.uf = uf;
        }
    }

    public String getUf(){
        return this.uf;
    }

    public void setRendaAnual(double renda){
        if (renda >= 0){
            this.rendaAnual = renda;
        }
    }

    public double getRendaAnual(){
        return this.rendaAnual;
    }

    public double calcularImposto(){
        return this.rendaAnual * this.getAliquota();
    }
    
    public double getAliquota(){
        double aliquota = 0;
        if (this.rendaAnual <= 4000)
            aliquota = 0;
        else if (this.rendaAnual <=9000)
            aliquota = 0.058; // 5,8%
        else if (this.rendaAnual < 25000) 
            aliquota = 0.15; // 15%
        else if (this.rendaAnual <= 35000)
            aliquota = 0.275; //27,5%
        else 
            aliquota = 0.3; // 30%
        return aliquota;
    }
}
