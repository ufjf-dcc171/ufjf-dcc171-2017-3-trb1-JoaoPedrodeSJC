package br.ufjf.dcc171;

import java.util.ArrayList;
import java.util.List;
import javax.swing.ListModel;
import javax.swing.event.ListDataListener;

public class TurmasListModel implements ListModel<Turma> {

    private final List<Turma> turmas;
    private final List<ListDataListener> dataListeners;

    public TurmasListModel(List<Turma> turmas) {
        this.turmas = turmas;
        this.dataListeners =  new ArrayList<>();
    }

    @Override
    public int getSize() {
        return turmas.size();
    }

    @Override
    public Turma getElementAt(int index) {
        return turmas.get(index);
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
