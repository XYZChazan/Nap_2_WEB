package br.com.ufra.Model;

import java.util.ArrayList;

public class LivroModel{
    private int id;
    private String linkImagem;
    private String nomeLivro;
    private float preco;
    private String detalhe;
    private String marca;
    private String asin;
    private String edicao;
    private String idioma;
    private int numeroPagina;
    private String isbnTen;
    private String isbnThirteen;
    private String dimensao;

    public LivroModel() {
    }

    public LivroModel(int id, String linkImagem, String nomeLivro, float preco, String detalhe, String marca, String asin, String edicao, String idioma, int numeroPagina, String isbnTen, String isbnThirteen, String dimensao) {
        this.id = id;
        this.linkImagem = linkImagem;
        this.nomeLivro = nomeLivro;
        this.preco = preco;
        this.detalhe = detalhe;
        this.marca = marca;
        this.asin = asin;
        this.edicao = edicao;
        this.idioma = idioma;
        this.numeroPagina = numeroPagina;
        this.isbnTen = isbnTen;
        this.isbnThirteen = isbnThirteen;
        this.dimensao = dimensao;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getLinkImagem() {
        return linkImagem;
    }

    public void setLinkImagem(String linkImagem) {
        this.linkImagem = linkImagem;
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

    public String getDetalhe() {
        return detalhe;
    }

    public void setDetalhe(String detalhe) {
        this.detalhe = detalhe;
    }

    public String getMarca() {
        return marca;
    }

    public void setMarca(String marca) {
        this.marca = marca;
    }

    public String getAsin() {
        return asin;
    }

    public void setAsin(String asin) {
        this.asin = asin;
    }

    public String getEdicao() {
        return edicao;
    }

    public void setEdicao(String edicao) {
        this.edicao = edicao;
    }

    public String getIdioma() {
        return idioma;
    }

    public void setIdioma(String idioma) {
        this.idioma = idioma;
    }

    public int getNumeroPagina() {
        return numeroPagina;
    }

    public void setNumeroPagina(int numeroPagina) {
        this.numeroPagina = numeroPagina;
    }

    public String getIsbnTen() {
        return isbnTen;
    }

    public void setIsbnTen(String isbnTen) {
        this.isbnTen = isbnTen;
    }

    public String getIsbnThirteen() {
        return isbnThirteen;
    }

    public void setIsbnThirteen(String isbnThirteen) {
        this.isbnThirteen = isbnThirteen;
    }

    public String getDimensao() {
        return dimensao;
    }

    public void setDimensao(String dimensao) {
        this.dimensao = dimensao;
    }

    public ArrayList<LivroModel> geraLista(){

        ArrayList<LivroModel> livros = new ArrayList<LivroModel>();
        livros.add(new LivroModel(1, "https://m.media-amazon.com/images/I/51UGhSv+F+L._SY344_BO1,204,203,200_.jpg", "1984", 45.99f, "Clássico da literatura distópica", "Companhia das Letras", "8571642364", "1ª edição (2019)", "Português", 416, "8535914847", "9788535914849", "13,5 x 2,2 x 21 cm"));
        livros.add(new LivroModel(2, "https://m.media-amazon.com/images/I/51lcM94V5jL._SY344_BO1,204,203,200_QL70_ML2_.jpg", "A revolução dos bichos", 24.99f, "Conto sobre uma revolução dos animais de uma fazenda", "Companhia das Letras", "8535909556", "1ª edição (2007)", "Português", 152, "8535909556", "9788535909555", "13,4 x 1 x 20,8 cm"));
        livros.add( new LivroModel(3, "https://m.media-amazon.com/images/I/51X40Du9otL._SY344_BO1,204,203,200_QL70_ML2_.jpg", "O conto da aia", 42.77f, "Romance de ficção científica", "Rocco", "8532523373", "1ª edição (2017)", "Português", 368, "8532531433", "9788532531439", "16 x 2,4 x 23 cm"));
        livros.add(new LivroModel(4, "https://m.media-amazon.com/images/I/51y-bUK0QML.jpg", "As vantagens de ser invisível", 24.90f, "Livro de formação sobre um adolescente com dificuldades sociais", "Rocco Jovens Leitores", "8532525902", "1ª edição (2012)", "Português", 224, "8532525902", "9788532525902", "14 x 1,5 x 21 cm"));
        livros.add( new LivroModel(5, "https://m.media-amazon.com/images/I/61QHzVV4T5L._SX424_BO1,204,203,200_.jpg", "Harry Potter e a pedra filosofal", 39.99f, "Primeiro livro da série Harry Potter", "Rocco", "8532530275", "1ª edição (2000)", "Português", 208, "8532530275", "9788532530272", "15,8 x 2 x 23 cm"));
        livros.add(new LivroModel(6, "https://m.media-amazon.com/images/I/41fQpp33yUL._SY344_BO1,204,203,200_QL70_ML2_.jpg", "Torto Arado", 47.12f, "Vencedor do prêmio Leya 2018", "Todavia", "8532530287", "1ª edição (7 agosto 2019)", "Português", 264, "6580309318", "978-6580309313", "14 x 1.7 x 21 cm"));

        return livros;
    }


    @Override
    public String toString() {
        return "LivroModel{" +
                "id=" + id +
                ", linkImagem='" + linkImagem + '\'' +
                ", nomeLivro='" + nomeLivro + '\'' +
                ", preco=" + preco +
                ", detalhe='" + detalhe + '\'' +
                ", marca='" + marca + '\'' +
                ", asin=" + asin +
                ", edicao='" + edicao + '\'' +
                ", idioma='" + idioma + '\'' +
                ", numeroPagina=" + numeroPagina +
                ", isbnTen=" + isbnTen +
                ", isbnThirteen='" + isbnThirteen + '\'' +
                ", dimensao='" + dimensao + '\'' +
                '}';
    }
}
