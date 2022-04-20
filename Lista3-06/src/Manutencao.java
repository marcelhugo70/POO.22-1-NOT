/**
 *
 * @author marcel
 */
public class Manutencao {
    private int numero;
    private String descricao;
    private float custo;
    private int tempo;

    public int getNumero() {
        return numero;
    }

    public void setNumero(int numero) {
        if (numero <= 0){
            throw new IllegalArgumentException("N�mero da manuten��o inv�lido. Deve ser maior que zero");
        }
        this.numero = numero;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public float getCusto() {
        return custo;
    }

    public void setCusto(float custo) {
        if (custo < 0 ){
            throw new IllegalArgumentException("Custo n�o pode ser negativo.");
        }
        this.custo = custo;
    }

    public int getTempo() {
        return tempo;
    }

    public void setTempo(int tempo) {
        if (tempo <= 0){
            throw new IllegalArgumentException("Tempo n�o pode ser menor que 1");
        }
        this.tempo = tempo;
    }
    
    public float getCustoMedioDiario(){
        return (this.custo / this.tempo);
    }
    
}
