import java.time.LocalDate;
public class AlunoUniversitario extends Aluno {
    private char formaIngresso;
    private Curso curso;
    
    public AlunoUniversitario(String nome, LocalDate dataNascimento, 
    							char ingresso, Curso curso) {
        super(nome, dataNascimento);
        this.setFormaIngresso(ingresso);
        this.setCurso(curso);
    }
    // destrutor
    @Override
    protected void finalize() throws Throwable {
        System.out.println("Destrutor de AlunoUniversitario em acao" + this.getNome());
        super.finalize();
    }
    public char getFormaIngresso() {
        return formaIngresso;
    }
    public String getFormaIngressoExtenso() {
        switch (this.formaIngresso) {
        case 'V':
            return "Vestibular";
        case 'E':
            return "Enem";
        case 'S':
            return "Seletivo Especial";
        case 'T':
            return "Transf.Ex";
        case 'I':
            return "Transf.In";
        default:
            return "invalido";
        }
    }
    public void setFormaIngresso(char formaIngresso) {
        if (formaIngresso == 'V' || formaIngresso == 'E' || formaIngresso == 'S' || formaIngresso == 'T'
                || formaIngresso == 'I') {
            this.formaIngresso = formaIngresso;
        } else {
            throw new IllegalArgumentException("Forma de ingresso invalida");
        }
    }
    public Curso getCurso() {
        return curso;
    }
    public void setCurso(Curso curso) {
        if (curso != null) {
            this.curso = curso;
        } else {
            throw new IllegalArgumentException("Aluno deve estar matriculado em algum curso");
        }
    }
    @Override
    public String mostra() {
        return this.getNome() + "é aluno universitario do curso de " + this.curso.getSigla() + "-_-"
                + this.curso.getNome() + "ingressando por" + this.getFormaIngressoExtenso();
    }
}