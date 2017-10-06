package br.ufjf.dcc171;

import java.util.ArrayList;
import java.util.List;
import javax.swing.JFrame;

public class Ufjf_dcc171_2017_3_trb1_JoaoPedroSJCosta {

    public static void main(String[] args) {
        
        janelaTrabalho janela = new janelaTrabalho(getSampleData(), 2);
        janela.setSize(500, 300);
        janela.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        janela.setLocationRelativeTo(null);
        janela.setVisible(true);
        
    }

    private static List<Tipo> getSampleData() {
        
        Comida a1 = new Comida("pizza1", "22.22","pizza01.jpg");
        Comida a2 = new Comida("pizza2", "22.22","pizza02.jpg");

        Comida a3 = new Comida("salgado01", "22.22","salgado01.jpg");
        Comida a4 = new Comida("salgado02", "22.22","salgado02.jpg");
        
        Comida a5 = new Comida("bebida01", "22.22","bebida01.jpg");
        Comida a6 = new Comida("bebida02", "22.22","bebida02.jpg");
                
        Tipo t1 = new Tipo("Pizzas","pcala.jpg");
        Tipo t2 = new Tipo("Salgados","salgados.jpg");
        Tipo t3 = new Tipo("Bebidas","bebidas.jpg");
        
        t1.getComidas().add(a1);
        t1.getComidas().add(a2);
        
        t2.getComidas().add(a3);
        t2.getComidas().add(a4);
        
        t3.getComidas().add(a5);
        t3.getComidas().add(a6);

        
        List<Tipo> tiposComida = new ArrayList<>();
        tiposComida.add(t1);
        tiposComida.add(t2);
        tiposComida.add(t3);
        
        return tiposComida;
    }
    
}
