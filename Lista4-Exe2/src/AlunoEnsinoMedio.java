import java.time.LocalDate;

public class AlunoEnsinoMedio extends Aluno {
    private int ano;
    public AlunoEnsinoMedio(String nome, LocalDate dataNascimento, int ano) {
        super(nome, dataNascimento);
        this.setAno(ano);
    }
    // destrutor
    @Override
    protected void finalize() throws Throwable {
        System.out.println("destrutor de AlunoEnsinoMedio em ação" + this.getNome());
    }
    public int getAno() {
        return ano;
    }
    public void setAno(int ano) {
        if (ano > 0 && ano < 4) {
            this.ano = ano;
        } else {
            throw new IllegalArgumentException("Ano invalido deve estar entre 1 e 3");
        }
    }
    @Override
    public String mostra() {
        return this.getNome() + " está cursando o " + this.ano + "o ano do ensino medio e tem " + this.getIdade()
                + "anos";
    }
}