package br.com.ufra.Model;

public class CarrinhoModel {


    private int id;
    private String nomeLivro;
    private float preco;
    private int quantidade;

    public CarrinhoModel() {
    }

    public CarrinhoModel(int id, String nomeLivro, float preco, int quantidade) {
        this.id = id;
        this.nomeLivro = nomeLivro;
        this.preco = preco;
        this.quantidade = quantidade;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNomeLivro() {
        return nomeLivro;
    }

    public void setNomeLivro(String nomeLivro) {
        this.nomeLivro = nomeLivro;
    }

    public float getPreco() {
        return preco;
    }

    public void setPreco(float preco) {
        this.preco = preco;
    }

    public int getQuantidade() {
        return quantidade;
    }

    public void setQuantidade(int quantidade) {
        this.quantidade = quantidade;
    }

    @Override
    public String toString() {
        return "CarrinhoModel{" +
                "id=" + id +
                ", nomeLivro='" + nomeLivro + '\'' +
                ", preco=" + preco +
                ", quantidade=" + quantidade +
                '}';
    }
}
