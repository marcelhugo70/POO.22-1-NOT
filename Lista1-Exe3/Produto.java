// contribuição do Mauro Fialho Luz e Souza
public class Produto
{    
    private String nome;
    private String descricao;
    private double preco;
    private int desconto;
    
    public Produto(String nome, String descricao, double preco, int desconto)
    {
        this.setNome(nome);
        this.setDescricao(descricao);
        this.setPreco(preco);
        this.setDesconto(desconto);
    }
    
    public void setNome(String nome)
    {
        this.nome = nome;
    }
    
    public void setDescricao(String descricao)
    {
        this.descricao = descricao;
    }
    
    public void setPreco(double preco)
    {
        this.preco = preco;
    }
    
    public void setDesconto(int desconto)
    {
        this.desconto = desconto;
    }
    
    public int getDesconto()
    {
        return this.desconto;
    }
    
    public double getPreco()
    {
        return this.preco;
    }
    
    public String getNome()
    {
        return this.nome;
    }
    
    public String getDescricao()
    {
        return this.descricao;
    }
}

