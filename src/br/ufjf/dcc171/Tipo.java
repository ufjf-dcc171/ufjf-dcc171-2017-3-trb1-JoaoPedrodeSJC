package br.ufjf.dcc171;

import java.util.ArrayList;
import java.util.List;

public class Tipo {
    
    private String tipo,imagem;
    private List<Comida> comida; 
            
    public Tipo(String tipo, String imagem) {
        this.tipo = tipo;
        this.imagem = imagem;
        comida = new ArrayList<>();
    }

    public void setImagem(String imagem) {
        this.imagem = imagem;
    }

    public String getImagem() {
        return imagem;
    }
    
    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public List<Comida> getComidas() {
        return comida;
    }

    public void setComidas(List<Comida> alunos) {
        this.comida = alunos;
    }

    @Override
    public String toString() {
        String preencher = "_";
        for (int i = 0; i < (17 - this.tipo.length()); i++) {
            preencher = preencher + "_";
        }
        return this.tipo+preencher;
    }
    
    
    
}
