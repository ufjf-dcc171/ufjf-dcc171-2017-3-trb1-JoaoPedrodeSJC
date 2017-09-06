package br.ufjf.dcc171;

import java.util.ArrayList;
import java.util.List;
import javax.swing.ListModel;
import javax.swing.event.ListDataListener;

public class AlunosListModel implements ListModel<Aluno> {

    private final List<Aluno> alunos;
    private final List<ListDataListener> dataListeners;

    public AlunosListModel(List<Aluno> alunos) {
        this.alunos = alunos;
        this.dataListeners =  new ArrayList<>();
    }

    @Override
    public int getSize() {
        return alunos.size();
    }

    @Override
    public Aluno getElementAt(int index) {
        return alunos.get(index);
    }

    @Override
    public void addListDataListener(ListDataListener l) {
        this.dataListeners.add(l);
    }

    @Override
    public void removeListDataListener(ListDataListener l) {
        this.dataListeners.remove(l);
    }
    
}
