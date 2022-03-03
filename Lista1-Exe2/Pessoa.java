
/**
 * Escreva uma descrição da classe Pessoa aqui.
 * 
 * @author (seu nome) 
 * @version (um número da versão ou uma data)
 */
public class Pessoa
{
    // variáveis de instância - substitua o exemplo abaixo pelo seu próprio
    private String nome;
    private char sexo;
    private String dataNascimento;
    private String estadoCivil = "Solteiro";// 1a opção para inicializar um atributo

    /**
     * Construtor para objetos da classe Pessoa
     */
    public Pessoa(String nome, char sexo, String data)
    {
        this.setNome(nome);
        this.setSexo(sexo);
        this.setDataNascimento(data);
        this.estadoCivil = "Solteiro"; // 2a opção para inicializar um atributo
    }

    public String getNome(){
        return this.nome;
    }

    public char getSexo(){
        return this.sexo;
    }

    public String getDataNascimento(){
        return this.dataNascimento;
    }

    public String getEstadoCivil(){
        return this.estadoCivil;
    }

    public void setNome(String nome){
        this.nome = nome;
    }

    public void setSexo(char sexo){
        if (sexo == 'F' || sexo == 'M'|| sexo == 'X') {
            this.sexo = sexo;
        }
    }

    public void setDataNascimento(String data){
        this.dataNascimento = data;
    }

    public void setEstadoCivil(String estadoCivil){
        this.estadoCivil = estadoCivil;
    }
}
