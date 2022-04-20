import java.util.ArrayList;
import java.time.LocalDate;


/**
 *
 * @author marcel
 */
public class Veiculo {
    private String placa;
    private String modelo;
    private LocalDate dataAquis;
    private ArrayList<Manutencao> consertos = new ArrayList();

    
    public void addManutencao(Manutencao m){
        this.consertos.add(m);
    }
    
    public int getQtdServicos(String descricao){
        int total = 0;
        for (Manutencao m: this.consertos){
            if (m.getDescricao().equals(descricao)){
                total++;
            }
        }
        return total;
    }
    
    public float getIndiceSucateamento(){
        int tempoParado = this.getQtdDiasParado();
        if (tempoParado < 21){
            return 0;
        }
        if (tempoParado < 51){
            return 0.5f;
        }
        if (tempoParado < 81){
            return 1;
        }
        if (tempoParado < 121){
            return 1.5f;
        }
        return 2;
    }
    
    public int getQtdDiasParado(){
        int total = 0;
        for (Manutencao m: this.consertos){
            total += m.getTempo();
        }
        return total;        
    }
    
    public float getCustoMedio(){
        float soma = 0;
        for (Manutencao m: this.consertos){
            soma += m.getCusto();
        }
        return soma/this.consertos.size();          
    }
    
    public int comparaCom(Veiculo outro){
        float indThis = this.getIndiceSucateamento();
        float indOutro = outro.getIndiceSucateamento();
        if (indThis > indOutro){
            return 10;
        }
        if (indThis == indOutro){
            return 0;
        }
        return -10;
    }
    
    public String getPlaca() {
        return placa;
    }

    public void setPlaca(String placa) {
        if (placa.length() != 8){
            throw new IllegalArgumentException("Placa inválida");
        }
        this.placa = placa;
    }

    public String getModelo() {
        return modelo;
    }

    public void setModelo(String modelo) {
        this.modelo = modelo;
    }

    public LocalDate getDataAquis() {
        return dataAquis;
    }

    public void setDataAquis(LocalDate dataAquis) {
        this.dataAquis = dataAquis;
    }
    
    
}
