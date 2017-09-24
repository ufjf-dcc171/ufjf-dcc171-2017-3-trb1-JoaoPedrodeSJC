package br.ufjf.dcc171;

public class Comida {
    private String preco;
    private String nome,imagem;

    public String getImagem() {
        return imagem;
    }
    
    public void setPreco(String preco) {
        this.preco = preco;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public void setImagem(String imagem) {
        this.imagem = imagem;
    }
    
    public Comida(String nome, String preco, String imagem) {
        this.preco = preco;
        this.nome = nome;
        this.imagem = imagem;
    }
    
    public String getPreco() {
        return preco;
    }

    public String getNome() {
        return nome;
    }

    @Override
    public String toString() {
        String preencher = "_";
        for (int i = 0; i < (18 - (this.nome.length()+this.preco.length())); i++) {
            preencher = preencher + "_";
        }
        return nome + preencher +"$"+ preco;
    }
    
}
