package br.ufjf.dcc171;

import java.util.ArrayList;
import java.util.List;
import javax.swing.JFrame;

public class Aula08Exemplo01 {

    public static void main(String[] args) {
        
        JanelaTurmas janela = new JanelaTurmas(getSampleData());
        janela.setSize(400, 300);
        janela.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        janela.setLocationRelativeTo(null);
        janela.setVisible(true);
        
    }

    private static List<Turma> getSampleData() {
        Aluno a1 = new Aluno("201365123", "Huguinho");
        Aluno a2 = new Aluno("201365124", "Zezinho");
        Aluno a3 = new Aluno("200565124", "Luizinho");
        
        Turma t1 = new Turma("DCC171");
        Turma t2 = new Turma("DCC021");
        
        t1.getAlunos().add(a1);
        t1.getAlunos().add(a3);
        t2.getAlunos().add(a1);
        t2.getAlunos().add(a2);
        t2.getAlunos().add(a3);
        List<Turma> turmas = new ArrayList<>();
        turmas.add(t1);
        turmas.add(t2);
        return turmas;
    }
    
}
