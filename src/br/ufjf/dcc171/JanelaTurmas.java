package br.ufjf.dcc171;

import java.awt.BorderLayout;
import java.util.List;
import javax.swing.DefaultListModel;
import javax.swing.JFrame;
import javax.swing.JList;
import javax.swing.JScrollPane;
import javax.swing.ListSelectionModel;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;

public class JanelaTurmas extends JFrame {
    
    private final List<Turma> turmas;
    private final JList<Turma> lstTurmas = new JList<>(new DefaultListModel<>());
    private final JList<Aluno> lstAlunos = new JList<>(new DefaultListModel<>());

    public JanelaTurmas(List<Turma> sampleData) {
        super("Turmas");
        this.turmas = sampleData;
        lstTurmas.setModel(new TurmasListModel(turmas));
        add(new JScrollPane(lstTurmas), BorderLayout.WEST);
        add(new JScrollPane(lstAlunos), BorderLayout.CENTER);
        lstTurmas.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
        lstTurmas.addListSelectionListener(new ListSelectionListener() {
            @Override
            public void valueChanged(ListSelectionEvent e) {
                Turma selecionada = lstTurmas.getSelectedValue();
                if (selecionada != null) {
                    System.out.println(selecionada);
                    lstAlunos.setModel(new AlunosListModel(selecionada.getAlunos()));
                } else {
                    lstAlunos.setModel(new DefaultListModel<>());
                }
            }
        });
        
    }
    
}
